public interface Builder {
    public void setNome (String nome);
    public void setAgencia (int agencia);
    public void setConta (int conta);
    public void setCpf (String cpf);
    public void setSaldo (double saldo);

    public String getNome();
    public int getAgencia();
    public int getConta();
    public String getCpf();
    public double getSaldo();
    public void imprimirDados();
}


