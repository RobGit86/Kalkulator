package kalkulator;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Arrays;

public class Onp {
    private final ArrayList<String> onpexpression;
    
    public Onp (Expression ex, Stack st){
        onpexpression = new ArrayList();
        
        for (int i=0; i< ex.getExpression().size(); i++){
            if(Character.isDigit(ex.getExpression().get(i).charAt(0)))
                onpexpression.add(ex.getExpression().get(i));
            if (st.isEmpty() && Operators.isOperator(ex.getExpression().get(i).charAt(0)))
                st.push(ex.getExpression().get(i));
            else if (Operators.isOperator(ex.getExpression().get(i).charAt(0)) 
                  && Operators.getPriority(ex.getExpression().get(i))> Operators.getPriority(st.getLastItem()))
                st.push(ex.getExpression().get(i));
            else if (Operators.isOperator(ex.getExpression().get(i).charAt(0)) 
                  && Operators.getPriority(ex.getExpression().get(i)) <= Operators.getPriority(st.getLastItem())){
                while (!st.isEmpty() && Operators.getPriority(ex.getExpression().get(i)) <= Operators.getPriority(st.getLastItem()))
                    onpexpression.add(st.pop());
                st.push(ex.getExpression().get(i));
            }
            else if (Operators.isBracketLeft(ex.getExpression().get(i).charAt(0)))
                st.push(ex.getExpression().get(i));
            else if (Operators.isBracketRight(ex.getExpression().get(i).charAt(0))){
                while (!st.getLastItem().equals("("))
                    onpexpression.add(st.pop());
                st.pop();
            }
        }
        while (!st.isEmpty())
            onpexpression.add(st.pop());
    }
    
    public double Calculate(){
        ArrayList<String> temp = new ArrayList();
        double b;
        
        
        for(int i=0,k=0; k<onpexpression.size(); k++){
            if(Character.isDigit(onpexpression.get(k).charAt(0))){
                temp.add(i, onpexpression.get(k));
                i++;       
            }
            else {
                if(onpexpression.get(k).equals("+")){
                b = Double.parseDouble(temp.get(i-2))+Double.parseDouble(temp.get(i-1));
                temp.set(i-2,Double.toString(b));
                i--;
                }
                if(onpexpression.get(k).equals("-")){
                b = Double.parseDouble(temp.get(i-2))-Double.parseDouble(temp.get(i-1));
                temp.set(i-2,Double.toString(b));
                i--;
                }
                if(onpexpression.get(k).equals("*")){
                b = Double.parseDouble(temp.get(i-2))*Double.parseDouble(temp.get(i-1));
                temp.set(i-2,Double.toString(b));
                i--;
                }
                if(onpexpression.get(k).equals("/")){
                b = Double.parseDouble(temp.get(i-2))/Double.parseDouble(temp.get(i-1));
                temp.set(i-2,Double.toString(b));
                i--;
                }
                if(onpexpression.get(k).equals("^")){
                b = pow(Double.parseDouble(temp.get(i-2)),Double.parseDouble(temp.get(i-1)));
                temp.set(i-2,Double.toString(b));
                i--;
                }
                if(onpexpression.get(k).equals("s")){
                b = sqrt(Double.parseDouble(temp.get(i-1)));
                temp.set(i-1,Double.toString(b));

                }            
            }
        }         
        return Double.parseDouble(temp.get(0));
        
    }
    
    
    
    public void showOnpExpression(){
        System.out.println("Wyrażenie ONP: "+Arrays.toString(onpexpression.toArray()));       
    }
    
    public void showResult(){
        System.out.println("Wynik: "+Calculate());
    }
}
