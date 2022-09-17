package kalkulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Expression {
    private final ArrayList<String> expression;
    
    public Expression(){
        Scanner sc = new Scanner(System.in);
        String buffer;
        String buffer2 = "";
        
        System.out.print("Podaj wyrażenie: ");
        buffer = sc.nextLine();
        expression = new ArrayList<>();
        
        for(int i=0; i<buffer.length(); i++){
            if (Character.isDigit(buffer.charAt(i))){
                buffer2 += buffer.charAt(i);
            }     
            else if (Operators.isOperator(buffer.charAt(i)) || Operators.isBracketLeft(buffer.charAt(i)) || Operators.isBracketRight(buffer.charAt(i))){
                if (!buffer2.equals(""))
                    expression.add(buffer2);            
                buffer2 = "";
                expression.add(Character.toString(buffer.charAt(i)));
            }
        }
        if (!buffer2.equals(""))
            expression.add(buffer2);
    }
    
    public ArrayList<String> getExpression(){
        return expression;
    }
    
    public void ShowExpression(){
        System.out.println("Wyrażenie: "+Arrays.toString(expression.toArray()));
    }
}
