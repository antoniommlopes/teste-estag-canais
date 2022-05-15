public class Pix implements Strategy {

    private double limiteMinimo;
    private double limiteMaximo;
    private void setLimiteMinimo(){
        limiteMinimo = 0.01;
    }
    private void setLimiteMaximo (){
        limiteMaximo = 5000.00;
    }

    public double getLimiteMinimo() {
        return limiteMinimo;
    }

    public double getLimiteMaximo() {
        return limiteMaximo;
    }

    @Override
    public boolean validarMetodo(Transferencia transf) {
        setLimiteMinimo();
        setLimiteMaximo();
        if (transf.getValorTransferencia()>= getLimiteMinimo() && transf.getValorTransferencia() <= getLimiteMaximo()){
            return true;
        }
        else {
            return false;
        }
    }

}
