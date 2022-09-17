package kalkulator;

public class Operators {
    public static boolean isOperator(char c){
        return (c == '+' ||
                c == '-' ||
                c == '*' ||
                c == '/' ||
                c == '^' ||
                c == 's');              
    }
  
    public static boolean isBracketLeft(char c){
        return (c == '(');               
    }    
    
    public static boolean isBracketRight(char c){
        return (c == ')');               
    }    
    
    public static boolean isOperatorUnary(char c){
        return (c == '^' ||
                c == 's');
    }
    
    public static int getPriority(String s){
        if (s.equals("("))
            return 0;
        else if (s.equals("+") || s.equals("-") || s.equals(")"))
            return 1;
        else if (s.equals("*") || s.equals("/"))
            return 2;
        else if (s.equals("s") || s.equals("^"))
            return 3;       
        return 0;
    }
}
