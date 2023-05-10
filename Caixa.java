package CaixaPOO;

public class Caixa {
    private Terminal meuTerminal;
    private CadastroContas bdContas;
    private double saldo;

    public Caixa(Terminal terminal, CadastroContas bd) {
        this.meuTerminal = terminal;
        this.bdContas = bd;
    }

    public double consultaSaldo(int numeroDaConta, int senha) {
        Conta conta;
        conta = this.bdContas.buscaConta(numeroDaConta);
        if (conta != null) {
            return conta.verificaSaldo(senha);
        }

        else {
            return -1;
        }

    }

    public boolean efetuaSaque(int numeroDaConta, double valor, int senha) {
        if (valor < 0 || (valor % 50) != 0 || valor > 500 || valor > this.saldo) {
            return false;
        }

        Conta conta = bdContas.buscaConta(numeroDaConta);
        if (conta == null || !conta.debitaValor(valor, senha, "Saque Automatico")) {
            return false;
        }

        this.liberaCedulas((int) (valor / 50));
        this.saldo -= valor;

        if (this.saldo < 500) {
            this.meuTerminal.setModo(0);
        }

        return true;
    }

    public void recarrega() {
        this.saldo = 2000;
        this.meuTerminal.setModo(1);
    }

    private void liberaCedulas(int quantidade) {
        while (quantidade-- > 0) {
            System.out.println("===/ R$50,00 /===");
        }
    }

    public boolean deposito(int numeroDaConta, double valor, int senha) {
        Conta conta = bdContas.buscaConta(numeroDaConta);
        if (conta == null || !conta.creditaValor(valor, "Depósito")) {
            return false;
        }
        this.saldo += valor;

        if (this.saldo < 500) {
            this.meuTerminal.setModo(0);
        }
        return true;
    }

    public boolean transferencia(int numeroDaConta1, double valor1, int s1,
            int numeroDaConta2, int senha2) {

        Conta conta1 = bdContas.buscaConta(numeroDaConta1);
        if (conta1 == null || !conta1.debitaValor(valor1, s1, "Transferência enviada")) {
            return false;
        }

        Conta conta2 = bdContas.buscaConta(numeroDaConta2);
        if (conta2 == null || !conta2.creditaValor(valor1, "Transferência recebida")) {
            return false;
        }

        if (this.saldo < 500) {
            this.meuTerminal.setModo(0);
        }
        return true;
    }

    public void Extratof(int numeroDaConta, int senha) {

        Conta conta = bdContas.buscaConta(numeroDaConta);

       if (conta != null){
            System.out.println(conta.getHistoricof());
        }
        
    }

}
