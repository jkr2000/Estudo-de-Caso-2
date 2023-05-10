package CaixaPOO;
import java.util.Scanner;


public class Terminal {
    private Caixa meuCaixa;
    private int modoAtual;
    
public Terminal(CadastroContas bd) {
this.meuCaixa = new Caixa(this, bd);
}
    
public void iniciaOperacao() {
int opcao;
    
opcao = this.getOpcao();
while (opcao != 4) {

    switch (opcao) {

    case 1: double saldo = this.meuCaixa.consultaSaldo(getInt("Numero da Conta"), getInt("Senha"));

    if (saldo != -1) {
System.out.println("Saldo Atual: " + saldo);
} 
    else {
System.out.println("Conta/senha inválida");
}
break;
            
case 2: boolean b = this.meuCaixa.efetuaSaque(getInt("Numero da Conta"), (double) getInt("Valor"),getInt("Senha"));
               
    if (b) {
System.out.println("Retire o dinheiro");
} 
    else {
System.out.println("Pedido de saque recusado");
}
break;
            
case 3: this.meuCaixa.recarrega();
break;

case 5: System.out.println("Entre com Opcao 1-Depósito em dinheiro, 2-Depósito em cheque");
    getInt("opção");
            
boolean bo = this.meuCaixa.deposito(getInt("Numero da Conta"), getInt("Valor") * 1.0, getInt("Senha"));
                    
 if(bo) { 
    System.out.println("Depósito feito!");
}
 else{
    System.out.println("Depósito recusado");
}

break;

case 6: 
   boolean d = this.meuCaixa.transferencia(getInt("Numero da Conta"), getInt("Valor") * 1.0, getInt("Senha"), getInt("Numero da Conta"), getInt("Senha"));        
  if(d){
      System.out.println("Transferência conluída!");
  }
    else{
    System.out.println("Transferência recusada");
 }   
   break;

        case 7:

       this.meuCaixa.Extratof(getInt("Numero da Conta"), getInt("Senha"));     
            
    break;
            
}
    
opcao = getOpcao();
 }
}

public void setModo(int modo) {
if (modo == 0 || modo == 1) {
this.modoAtual = modo;
 }
}
    
private int getOpcao() {
int opcao;
    
do {
 if (this.modoAtual == 1) {
opcao = getInt("Opcao: 1 - Consulta Saldo, 2 - Saque, 4 - Sair, 5 - Depósito, 6 - Transferência, 7 - Consultar extrato");

if (opcao != 1 & opcao != 2  & opcao != 5 & opcao != 4 & opcao != 6 & opcao != 7) {
    opcao = 0;
}
    
} else {
opcao = getInt("Opcao: 3 - Recarrega, 4 - Sair");

if (opcao != 3 & opcao != 4) {
opcao = 0;
}
    
}
    
} while (opcao == 0);
    
return opcao;
}
    
private int getInt(String string) {
Scanner r = new Scanner(System.in);
System.out.println("Entre com " + string);
if (r.hasNextInt()) {
return r.nextInt();
}
    
String st = r.next();
System.out.println("Erro na Leitura de Dados");
return 0;
}

}
