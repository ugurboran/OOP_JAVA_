/**
 * The {@code Paranthesis_checker} class takes a file from user,then check parantheses in the program.If parantheses match stack doubled or stack is empty,otherwise parantheses do not match and file is not correct.
 * 
 * @author Ugur Boran
 * @version 1.0
 * @since 29.10.2017
 * 
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ugur_Boran {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Here program takes the file from the user .
		 */
		System.out.println("Enter the input java file:");
		Scanner user_input = new Scanner(System.in);
		String file_name = user_input.nextLine();
		File file = new File(file_name);
		Scanner input_file = new Scanner(file);

		myStack<Character> stack = new myStack<Character>();

		while(input_file.hasNextLine()){
			String string=input_file.nextLine();

			for (int i = 0; i < string.length(); i++){
				char current_element = string.charAt(i);

				if (current_element == '{'){
					stack.push(current_element);// add '{'  character to stack
					System.out.printf("%s ",stack.peek().toString());
				}

				else if(current_element == '('){
					stack.push(current_element);// add '('  character to stack
					System.out.printf("%s ",stack.peek().toString());
				}

				if (current_element == '}' ){

					if(stack.isEmpty()){
						System.out.println("Parantheses do not match");
					}
					char last_element = stack.peek();// make last element variable equal with the last element of stack
					System.out.println("Parantheses do not match");
					
					if (last_element == '{'){
						stack.pop();// if current element and last element parantheses match with each other program does pop operation.
						System.out.printf("%s \n",stack.peek().toString());
					}
				}
				else if(current_element == ')'){

					if(stack.isEmpty()){
						System.out.println("Parantheses do not match");
					}
					char last_element = stack.peek();// make last element variable equal with the last element of stack

					if (last_element == '('){
						stack.pop();// if current element and last element parantheses match with each other program does pop operation.
						System.out.printf("%s \n",stack.peek().toString());
					}
				}
			}
		}
		/*
		 * Here after loop program checks the stack is empty or not.
		 */
		if(stack.isEmpty()){
			System.out.println("Stack is empty");
		}
		else if (!stack.isEmpty()){
			System.out.println("Parantheses do not match");
		}
	}
}




