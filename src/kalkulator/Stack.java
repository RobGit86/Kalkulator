package kalkulator;

public class Stack {
    private final String[] stack;
    private int top;
    
    public Stack(){
        stack = new String[20];
        top = 0;
    }
    
    public boolean isEmpty(){
        return (top == 0);
    }
    
    public void push(String s){
        stack[top] = s;
        top++;
    }
    
    public String pop(){
        if (top > 0){
            String temp = stack[top-1];
            top--;
            return temp;
        }
        else
            return "Chuja warte";
    }
    
    public String getLastItem(){
        return stack[top-1];
    }
    public void showStack(){
        for (int i=0; i<top; i++)
            System.out.println((i+1)+". "+stack[i]+" ");
        System.out.println();
    }
}
