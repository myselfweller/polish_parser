import java.util.Scanner;

public class polishParser {
   public static void main(String[] args) {
       Scanner userinput = new Scanner(System.in);

      System.out.println(evaluate(userinput));
   }

   // Check: input contains a legal prefix expression
   // Processing the input and returning a result
   private static int evaluate(Scanner input) {
       if (input.hasNextInt()) {
           return input.nextInt();
       } else {
           String operator = input.next();
           int operand1 = evaluate(input);
           int operand2 = evaluate(input);
           return evaluate(operator, operand1, operand2);
       }
   }

   // Instructions on how each operand should interact with
   // its operands when called
   private static int evaluate(String operator, int operand1,
                                 int operand2) {
       if (operator.equals("+")) {
           return operand1 + operand2;
       } else if (operator.equals("-")) {
           return operand1 - operand2;
       } else if (operator.equals("x")) {
           return operand1 * operand2;
       }
       else {
           throw new RuntimeException("illegal operator " + operator);
       }
   }
}