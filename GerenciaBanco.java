
package com.mycompany.gerenciabanco;
import java.util.Scanner;

/**
 *
 * @author roger
 */
public class GerenciaBanco {
    
    public class Conta {
        private double saldo=0;
        private int conta;
        private boolean status;
        
        public double getSaldo(){
            return this.saldo;
        }
        public void setSaldo(double saldo){
            this.saldo = saldo;
        }
        public int getConta(){
            return this.conta;
        }
        public void setConta(int n){
            this.conta = n;
        }
        public boolean getStatus(){
            return this.status;
        }
        public void setStatus(boolean status){
            this.status = true;
        }
  
        public void abrirConta(int num){
            this.setStatus(true);
            this.setConta(num);
            System.out.println("Conta do cliente aberta com sucesso!");
        }
        public void encerrarConta(){
            if(this.getStatus() == true){
                if(this.saldo > 0){
                System.out.println("Você ainda tem saldo de R$"+  this.getSaldo() + " reais");
            } else if(this.saldo < 0){
                System.out.println("Você tem débitos de R$" + this.getSaldo() + " reais.");
            } else{
                System.out.println("Conta encerrada!");
                this.setStatus(false);
            }
            }
            
        }
        public void consultarSaldo(){
            if (this.getStatus() == true){
                System.out.println("Saldo atual de R$" + this.getSaldo());
                
            } else{
                System.out.println("Conta inexistente.");
            }
            
        }
        public void depositar(double valor){
            if (this.getStatus() == true){
                this.setSaldo(valor);
                System.out.println("Deposito de R$" + valor + " realizado com sucesso!");
            } else{
                System.out.println("Conta inexistente.");
            }
            
        }
        public void sacar(double valor){
            if(this.getSaldo() - valor >= 0){
                this.setSaldo(this.getSaldo()-valor);
                System.out.println("Saque de " + valor + "realizado com sucesso.");
            }else{
                System.out.println("Saldo insuficiente.");
            }
        }
    }
    public class Cliente extends Conta{
        private String nome;
        private String sobrenome;
        private String cpf;
        
        public String getNome(){
            return this.nome;
        }
        public void setNome(String nome){
            this.nome = nome;
        }
        public String getSobrenome(){
            return this.sobrenome;
        }
        public void setSobrenome(String sobrenome){
            this.sobrenome = sobrenome;
        }
        public String getCpf(){
            return this.cpf;
        }
        public void setCpf(String cpf){
            this.cpf = cpf;
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        
        
        try{
            GerenciaBanco obj = new GerenciaBanco();
            obj.run(args);
            
        } catch(Exception e){
            e.printStackTrace();
        }

    }
    public void run (String[] args) throws Exception{
        int menu = 0;
        int c = 0;
        Scanner scan = new Scanner(System.in);
        Cliente cliente = new Cliente();
        System.out.println("Qual seu nome? ");
        cliente.setNome(scan.next());
        System.out.println("Seu Sobrenome: ");
        cliente.setSobrenome(scan.next());
        System.out.println("Seu CPF: ");
        cliente.setCpf(scan.next());

        while(menu != 6){
            c = 0;
            System.out.println("");
            System.out.println("------------------------");
            System.out.println("----------MENU----------");
            System.out.println("------------------------");
            System.out.println("[1]ABRIR CONTA");
            System.out.println("[2]DEPOSITAR");
            System.out.println("[3]CONSULTAR SALDO");
            System.out.println("[4]SACAR");
            System.out.println("[5]FECHAR CONTA");
            System.out.println("[6]ENCERRAR PROGRAMA");
            System.out.println("------------------------");
            System.out.println("");
            menu = scan.nextInt();
            
            if(menu == 1){
                System.out.println("Qual o número da conta requerido? ");
                c = scan.nextInt();
                cliente.abrirConta(c);
            } else if(menu == 2){
                System.out.println("Quanto quer depositar? ");
                c = scan.nextInt();
                cliente.depositar(c);
            } else if(menu == 3){
                cliente.consultarSaldo();
            } else if (menu == 4){
                System.out.println("Quanto quer sacar? ");
                c = scan.nextInt();
                cliente.sacar(c);
            } else if(menu == 5){
                cliente.encerrarConta();
            }
            

        }
        System.out.println("Até mais!");
    }
}


