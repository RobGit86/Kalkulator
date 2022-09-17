package kalkulator;

import java.util.Scanner;

public class Kalkulator {

    public static void main(String[] args) {
    
    String a = "b";
        
    while(!a.equals("a")){    
        Expression ex = new Expression();
        Stack stos1 = new Stack();        
        ex.ShowExpression();        
        Onp onp = new Onp(ex, stos1);
        
        onp.showOnpExpression();
        stos1.showStack();
        onp.showResult();
        
        System.out.println();
        System.out.println("Jeśli chcesz wyjść, wciśnij a");
        
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine();
        
      }
    }
    
}

