
class ATM{
    synchronized public void checkBalance( String Name){
        //code to check balance
   // synchronized(this){
        System.out.print(" "+Name +" is Checking ");
        try{Thread.sleep(1000);}catch(Exception e){}
        System.out.println("Balance ");
   // }
    }
    synchronized public void withDraw(String name,int amount){
      //  synchronized(this){
        System.out.print(" "+name+" is Withdrawing money: ");
        try{Thread.sleep(1000);}catch(Exception e){}
        System.out.println(amount+" ");
       // }
    }
}
class Customer extends Thread {
    ATM atm;
    String name;
    int amount;

    void useATM(ATM atm){
        atm.checkBalance(name);
        atm.withDraw(name,amount);
    }
    Customer(String name,int amount,ATM atm){
        this.name=name;
        this.amount=amount;
        this.atm=atm;
    }
    public void run(){
        useATM(atm);
    }
}

public class SyncronizedATM {
    public static void main(String[] args) {
    ATM atm=new ATM();
    Customer c1=new Customer("REX",7000,atm);
    Customer c2=new Customer("BEN",1000,atm);
    c1.start();
    c2.start();
    }
    
    
}
