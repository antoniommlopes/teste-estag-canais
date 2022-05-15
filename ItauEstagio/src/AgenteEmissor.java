public class AgenteEmissor implements Builder {
    private String nomeEmissor;
    private int agenciaEmissor;
    private int contaEmissor;
    private String cpfEmissor;
    private double saldo;

    //Sets
    public void setNome (String nomeEmissor){
        this.nomeEmissor = nomeEmissor;
    }
    public void setAgencia (int agencia){
        this.agenciaEmissor = agencia;
    }
    public void setConta (int conta){
        this.contaEmissor = conta;
    }
    public void setCpf (String cpf){
        this.cpfEmissor = cpf;
    }
    public void setSaldo (double saldo){
        this.saldo = saldo;
    }

    //gets
    public String getNome(){
        return nomeEmissor;
    }
    public int getAgencia(){
        return agenciaEmissor;
    }
    public int getConta(){
        return contaEmissor;
    }
    public String getCpf(){
        return cpfEmissor;
    }
    public double getSaldo() {
        return saldo;
    }


    public void imprimirDados(){
        System.out.println("Emissor (de): " + getNome() + "\nCPF: " + getCpf() + "\nAg: " + getAgencia() + " | CC: " + getConta() + "\n");
    }
}
