public class AgenteReceptor implements Builder{
    private String nomeReceptor;
    private int agenciaReceptor;
    private int contaReceptor;
    private String cpfReceptor;
    private double saldo;

    //Sets
    public void setNome (String nomeReceptor){
        this.nomeReceptor = nomeReceptor;
    }
    public void setAgencia (int agencia){
        this.agenciaReceptor = agencia;
    }
    public void setConta (int conta){
        this.contaReceptor = conta;
    }
    public void setCpf (String cpf){
        this.cpfReceptor = cpf;
    }
    public void setSaldo (double saldo){
        this.saldo = saldo;
    }

    //gets
    public String getNome(){
        return nomeReceptor;
    }
    public int getAgencia(){
        return agenciaReceptor;
    }
    public int getConta(){
        return contaReceptor;
    }
    public String getCpf(){
        return cpfReceptor;
    }
    public double getSaldo() {
        return saldo;
    }
    public void imprimirDados(){
        System.out.println("Receptor (para): " + getNome() + "\nCPF: " + getCpf() + "\nAg: " + getAgencia() + " | CC: " + getConta() + "\n");
    }
}
