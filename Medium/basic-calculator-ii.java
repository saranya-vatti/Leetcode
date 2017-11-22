
import java.io.*;
import java.util.*;
public class Main {

    public static int calculate(String s) {
        s=s.replaceAll("\\s+","");;
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for(int i=0;i<s.length();) {
            System.out.println(i);
            switch(s.charAt(i)) {
                case '+':
                    operator.push('+');
                    i++;
                    break;
                case '-':
                    String str = "";
                    i++;
                    while(i<s.length() && '0'<=s.charAt(i) && s.charAt(i) <= '9') {
                        str+=s.charAt(i);
                        i++;
                    }
                    str = "-" + str;
                    operand.push(Integer.parseInt(str));
                    operator.push('+');
                    break;
                case '*':
                    str = "";
                    i++;
                    while(i<s.length() && '0'<=s.charAt(i) && s.charAt(i) <= '9') {
                        str+=s.charAt(i);
                        i++;
                    }
                    operand.push(Integer.parseInt(str) * operand.pop());
                    break;
                case '/':
                    str = "";
                    i++;
                    while(i<s.length() && '0'<=s.charAt(i) && s.charAt(i) <= '9') {
                        str+=s.charAt(i);
                        i++;
                    }
                    operand.push(operand.pop()/ Integer.parseInt(str));
                    break;
                default:
                    str = "";
                    while(i<s.length() && '0'<=s.charAt(i) && s.charAt(i) <= '9') {
                        str+=s.charAt(i);
                        i++;
                    }
                    operand.push(Integer.parseInt(str));
                    break;
            }
            System.out.println(Arrays.toString(operand.toArray()));
            System.out.println(Arrays.toString(operator.toArray()));
            System.out.println();
        }
        while(!operator.isEmpty()) {
            char opr =operator.pop();
            switch(opr) {
                case '+':
                    operand.push(operand.pop() + operand.pop());
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }
        return operand.pop();
    }
    public static void main(String[] args) throws IOException {

        System.out.println(calculate("1-1+1"));
    }
}
