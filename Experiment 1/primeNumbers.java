import java.util.*;
public class primeNumbers {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter a number:");
        int n=sc.nextInt();

        if(n==1){
            System.out.println("1 is not prime number");
        }

        else if(n==2){
            System.out.println(+n+ "is prime number");
        }else{
            boolean isprime=true;
            for(int i=2;i<=Math.sqrt(n);i++){
               if(n%i==0){
                isprime=false;
               }
            }
            if(isprime==true){
                System.out.println(+n+ " is prime number");
            }else{
                System.out.println(+n+ " is not prime number");
            }
        }
    }
}