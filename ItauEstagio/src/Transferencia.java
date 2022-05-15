import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Transferencia {
    private String idTransferencia;
    private double valorTransferencia;
    private String tipoTransferencia;

    private Date hora;


    public void setIdTransferencia (String id){
        this.idTransferencia = id;
    }
    public void setvalorTransferencia (double valor){
        this.valorTransferencia = valor;
    }
    public void setTipoTransferencia (String tipo){
        this.tipoTransferencia = tipo;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getIdTransferencia() {
        return idTransferencia;
    }
    public double getValorTransferencia() {
        return valorTransferencia;
    }
    public String getTipoTransferencia() {
        return tipoTransferencia;
    }

    public Date getHora() {
        return hora;
    }

    public Boolean validaTransferencia (AgenteEmissor emissor, AgenteReceptor receptor){
        if(emissor.getAgencia() == receptor.getAgencia() && emissor.getConta() == receptor.getConta()){
            return  false;
        }
        else{
            return true;
        }
    }
    public Boolean transferir(AgenteEmissor emissor, AgenteReceptor receptor) {
        emissor.setSaldo(emissor.getSaldo()- getValorTransferencia());
        receptor.setSaldo(receptor.getSaldo()+getValorTransferencia());
        Date hora = Calendar.getInstance().getTime();
        setHora(hora);
        return true;
    }

    public void imprimirDadosTransferencia(){

        System.out.println(" \n" + "IdTransferencia: " + getIdTransferencia()
                + "\nValor Transferencia: R$" + new DecimalFormat("#,##0.00").format(getValorTransferencia())
                + "\nModalidade: " +getTipoTransferencia() + "\n");
    }

}
