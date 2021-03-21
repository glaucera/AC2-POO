
import java.util.Random;

public class BankAccount {

    private static int lastAccountNumber = 1000; // Último número utilizado de conta
    private String owner;
    private int accountNumber; // número da conta
    private double balance; // saldo da conta
    private String password; // Senha da Conta
    private double cpmf;
    
    public BankAccount(String owner) {// chama outro construtor dessa classe com os valores owner e 0, para saldo
        this(owner, 0);
    }

    public BankAccount(String owner, double balance) {
        accountNumber = lastAccountNumber++;
        this.balance = balance;
        this.owner = owner;
        this.password = makePassword();
        this.cpmf = 0.0025;
    }

    public void deposit(double amount) {
        double newBalance = balance + amount;
        balance = newBalance;
    }

    public void withDraw(double amount) {
        double newBalance = balance - amount -(amount *cpmf);
        balance = newBalance;
    }

    public void trasfer(double valor, BankAccount target) {
        this.withDraw(valor);
        target.deposit(valor);
    }

    public double getBalance() {
        return balance;
    }
    

    public int getAccountNumber() {
        return accountNumber;
    }

    public String toString() {
        return "Conta de " + owner + " - Saldo de R$ " + balance+ " - Password: "+password;
    }

    private static String checkName(String owner) {
        boolean verificaNome = owner.matches("\\\\w+[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]*");
        if (!verificaNome) {
            return owner;
        } else {
            System.exit(0);
            return null;
        }
    }

    private static String makePassword() {
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        Random gerarSenha = new Random();
        String senha = "";
        for (int i = 0; i < 6; i++) {
            int n1 = gerarSenha.nextInt(10);
            senha+= alfabeto.charAt(n1);
        }
        for (int i = 0; i < 4; i++) {
            int n1 =gerarSenha.nextInt(10);
            senha+=n1;
        }
        return senha;
    }
     public double getCpmf() {
        return cpmf;
    }

    public void setCpmf(double cpmf) {
        this.cpmf = cpmf;
    }
    
}
