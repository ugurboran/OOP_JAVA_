public class Input1 {
public static void main(String[] args) {
/* Prompt the input */
java.util.Scanner input = new java.util.Scanner(System.in);
System.out.print(" Enter a number in pounds: ");
double pounds = input.nextDouble();
double kilograms = pounds * 0.454;
} /* this is a wrong parenthesis */
System.out.println(pounds + " pounds is " + kilograms + " kilograms");
/* Too many parentheses */
int a = (((((8)))));
}