import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class MyProgram {
    public static <validaRegraConta> void main(String[] args) throws IOException {
        //Ler Arquivo
        String linha = "";
        String cabecalho = "";
        String detalhes = "";
        try {
            FileReader arquivo = new FileReader("entrada.txt");
            BufferedReader lerArquivo = new BufferedReader(arquivo);

            while ((linha = lerArquivo.readLine()) != null) {
                if(linha.length() > 0) {
                    if (cabecalho.equals("")){
                        cabecalho = linha;
                    }
                    else if (detalhes.equals("")){
                        detalhes = linha;
                    }
                }
            }
            arquivo.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
            System.exit(0);
        }




        String [] detalhesArray = detalhes.split("\\|");



        Transferencia transf = new Transferencia();
        transf.setIdTransferencia(detalhesArray[0]);
        transf.setvalorTransferencia(Double.parseDouble(detalhesArray[1]));
        transf.setTipoTransferencia(detalhesArray[2]);

        AgenteEmissor emissor = new AgenteEmissor();
        emissor.setNome(detalhesArray[3]);
        emissor.setAgencia(Integer.parseInt(detalhesArray[4]));
        emissor.setConta(Integer.parseInt(detalhesArray[5]));
        emissor.setCpf(detalhesArray[6]);
        emissor.setSaldo((float) 0);

        AgenteReceptor receptor = new AgenteReceptor();
        receptor.setNome(detalhesArray[7]);
        receptor.setAgencia(Integer.parseInt(detalhesArray[8]));
        receptor.setConta(Integer.parseInt(detalhesArray[9]));
        receptor.setCpf(detalhesArray[10]);
        receptor.setSaldo((float) 0);

        //switch (sdf)
        transf.imprimirDadosTransferencia();
        emissor.imprimirDados();
        receptor.imprimirDados();

        boolean validaRegraConta  = transf.validaTransferencia(emissor, receptor);
        boolean validaValor = false;
        boolean validaTransferencia = false;
        if(validaRegraConta){
            switch (transf.getTipoTransferencia()) {
                case "PIX":
                    Pix transferirViaPix = new Pix();
                    validaValor = transferirViaPix.validarMetodo(transf);
                    if(!validaValor){
                        System.out.println("**Sua transferência não foi completada pois o valor não está entre os limites da modalidade *PIX* (R$" +new DecimalFormat("#,##0.00").format(transferirViaPix.getLimiteMinimo())+ " ~ R$" +new DecimalFormat("#,##0.00").format(transferirViaPix.getLimiteMaximo())   +")**");
                    }
                break;

                case "TED":
                    Ted transferirViaTed = new Ted();
                    validaValor = transferirViaTed.validarMetodo(transf);
                    if(!validaValor){
                        System.out.println("**Sua transferência não foi completada pois o valor não está entre os limites da modalidade *TED* (R$" +new DecimalFormat("#,##0.00").format(transferirViaTed.getLimiteMinimo())+ " ~ R$" +new DecimalFormat("#,##0.00").format(transferirViaTed.getLimiteMaximo())   +")**");
                    }
                break;

                case "DOC":
                    Doc transferirViaDoc = new Doc();
                    validaValor = transferirViaDoc.validarMetodo(transf);
                    if(!validaValor){
                        System.out.println("**Sua transferência não foi completada pois o valor não está entre os limites da modalidade *DOC* (Igual ou maior que R$" +new DecimalFormat("#,##0.00").format(transferirViaDoc.getLimiteMinimo())+ ")**");
                    }
                break;
            }
        }
        else{
            System.out.println("**Sua transferência não foi completada pois não são permitidas transferências para a mesma conta**");
        }

        if(validaValor){
            transf.transferir(emissor, receptor);

            System.out.println("**Sua transferência foi realizada com sucesso!<br> \n" +
                    "Saldo do emissor: R$ " + new DecimalFormat("#,##0.00").format(emissor.getSaldo()) + "\n" +
                    "Saldo do receptor: R$ " + new DecimalFormat("#,##0.00").format(receptor.getSaldo()) +
                    "**");
        }
    }
}