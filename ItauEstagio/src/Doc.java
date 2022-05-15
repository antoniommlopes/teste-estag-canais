public class Doc implements Strategy{
    private double limiteMinimo;

    private void setLimiteMinimo(){
        limiteMinimo = 10000.01;
    }

    public double getLimiteMinimo() {
        return limiteMinimo;
    }

    @Override
    public boolean validarMetodo(Transferencia transf) {
        setLimiteMinimo();
        if (transf.getValorTransferencia()>= getLimiteMinimo()){
            return true;
        }
        else {
            return false;
        }
    }
}
