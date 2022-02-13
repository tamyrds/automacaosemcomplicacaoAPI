package transferencia;

public class Conta {
    // agencia, numeroConta, saldo, proprietario

    private String agencia;
    private  String numeroConta;
    private Double saldo;
    private  Cliente proprietario;

    public Conta(String agencia, String numeroConta, Double saldo, Cliente proprietario) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.proprietario = proprietario;
    }

    public String getAgencia(String agencia) {
        return this.agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void realizarDeposito(double valor){
        saldo +=  valor;
    }

    public boolean realizarSaque(double valor){
        if(valor > saldo){
            return false;
        }
            saldo -= valor;
            return true;
        }
    public boolean realizaTransferencia(double valor, Conta destino) {

        if (realizarSaque(valor)){
            destino.realizarDeposito(valor);
            return true;
    }
            return false;
    }


}
