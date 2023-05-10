package CaixaPOO.TesteCaixa;
import CaixaPOO.CadastroContas;
import CaixaPOO.Cliente;
import CaixaPOO.Terminal;
import CaixaPOO.Conta;


public class Main {
    public static void main(String[] args){

  
        Cliente p1 = new Cliente("111", "João");
        Cliente p2 = new Cliente("222", "Maria");
        Cliente p3 = new Cliente("333", "José");
        Cliente p4 = new Cliente("444", "Lucas");
  
        
        Conta c1 = new Conta(333, p1, 433, 1000.0);
        Conta c2 = new Conta(157, p2, 757, 7000.0);
        Conta c3 = new Conta(444, p3, 747, 6000.0);
        Conta c4 = new Conta(555, p4, 737, 800.0);
        
        
        CadastroContas cadastro = new CadastroContas(4);
              
          cadastro.adicionaConta(c1);
          cadastro.adicionaConta(c2);
          cadastro.adicionaConta(c3);
          cadastro.adicionaConta(c4);
  
       Terminal bb = new Terminal(cadastro);
        
          bb.iniciaOperacao();
        
    }
}
