import exceptions.notation.*;
/**
 * @author Diego Mendez
 */
public class Notation {
	
	
	/**
	 * evaulats the postfix expression
	 * @param postfixExpr postfix experssion to be evaulated 
	 * @return value of postfix expression
	 * @throws InvalidNotationFormatException if postfix format is incorrect
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		
		MyStack<Double> stack = new MyStack<Double>(postfixExpr.length());
		
		String operators = "+*/-";
		String operands = "1234567890";
		Double val2 = 0.0;
		Double val1 = 0.0;
		Double temp = 0.0;

		
		for(int i = 0; i < postfixExpr.length();i++) {
			String currChar = postfixExpr.substring(i,i+1);
			if(operands.indexOf(currChar) != -1) {
				stack.push(Double.valueOf(currChar));
			} else if(operators.indexOf(currChar) != -1) {
				if(!stack.isEmpty() && operators.indexOf(String.valueOf(stack.top())) == -1)
				 	val1 = stack.pop();
				else
					throw new InvalidNotationFormatException();
				if(!stack.isEmpty() && operators.indexOf(String.valueOf(stack.top())) == -1)
					 val2 = stack.pop();
				else 
					throw new InvalidNotationFormatException();
				
				switch(currChar){
				case "+":
					temp = Double.valueOf(val2) + Double.valueOf(val1);
					stack.push(temp);
					break;
				case "-":
					temp = Double.valueOf(val2) - Double.valueOf(val1);
					stack.push(temp);
					break;
				case "*":
					temp = Double.valueOf(val2) * Double.valueOf(val1);
					stack.push(temp);
					break;
				case "/":
					temp = Double.valueOf(val2) / Double.valueOf(val1);
					stack.push(temp);
					break;
					
				}
				
			}
		}
		
		return stack.pop();

		
		
	}
	
	
	
	
	/**
	 * converts postfix to infix
	 * @param postfix to be converted to infix
	 * @return infix that was converted from postfix 
	 * @throws InvalidNotationFormatException if postfix format is wrong
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		
		MyStack<String> stack = new MyStack<String>(postfix.length());
		
		String operators = "+*/-";
		String operands = "1234567890";
		String val2 = "";
		String val1 = "";
		String temp = "";



		for(int i = 0; i < postfix.length();i++) {
			String currChar = postfix.substring(i,i+1);
			if(operands.indexOf(currChar) != -1) {
				stack.push(currChar);
			} else if(operators.indexOf(currChar) != -1) {
				if(!stack.isEmpty() && operators.indexOf(stack.top()) == -1)
				 	val1 = stack.pop();
				else
					throw new InvalidNotationFormatException();
				if(!stack.isEmpty() && operators.indexOf(stack.top()) == -1)
					 val2 = stack.pop();
				else 
					throw new InvalidNotationFormatException();
				temp = "(" + val2 + currChar + val1 + ")";
				stack.push(temp);
			}
		}
		
		
		return stack.toString();
		
	}
	
	
	/**
	 * converts infix to postfix 
	 * @param String infix that is to be converted into postfix
	 * @return String postfix that was converted from infix
	 * @throws InvalidNotationFormatException if infix is in invalid format
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		
		String operators = "+*/-";
		
		MyStack<String> stack = new MyStack<String>(infix.length());
		MyQueue<String> queue = new MyQueue<String>(infix.length());
		
		String digits = "1234567890";
		for(int i = 0; i < infix.length();i++) {
			char currChar = infix.charAt(i);
			switch(currChar) {
			case '0':
				queue.enqueue("0");
				break;
			case '1':
				queue.enqueue("1");
				break;
			case '2':
				queue.enqueue("2");
				break;
			case '3':
				queue.enqueue("3");
				break;
			case '4':
				queue.enqueue("4");
				break;
			case '5':
				queue.enqueue("5");
				break;
			case '6':
				queue.enqueue("6");
				break;
			case '7':
				queue.enqueue("7");
				break;
			case '8':
				queue.enqueue("8");
				break;
			case '9':
				queue.enqueue("9");
				break;
			case '(':
				stack.push("(");
				break;
			case'+':
				if(!stack.isEmpty() ) {
					if(stack.top().equals("*")|| stack.top().equals("/") || stack.top().equals("+")|| stack.top().equals("-") ) {
						queue.enqueue(stack.pop());
						stack.push("+");
						break;
					} else {
						stack.push("+");
						break;
					}
				} 
				stack.push("+");
				break;

				
			case'-':
			
				if(!stack.isEmpty() ) {
					if(stack.top().equals("*")|| stack.top().equals("/") || stack.top().equals("+")|| stack.top().equals("-") ) {
						queue.enqueue(stack.pop());
						stack.push("-");
						break;
					} else {
						stack.push("-");
						break;
					}
				} 
				stack.push("-");
				break;
				
			case'*':
				if(!stack.isEmpty() ) {
					if(stack.top().equals("*")|| stack.top().equals("/") ) {
						queue.enqueue(stack.pop());
						stack.push("*");
						break;
					} else {
						stack.push("*");
						break;
					}
				} 
	
				stack.push("*");
				break;
				
			case'/':
				if(!stack.isEmpty() ) {
					if(stack.top().equals("*")|| stack.top().equals("/") ) {
						queue.enqueue(stack.pop());
						stack.push("/");
						break;
					} else {
						stack.push("/");
						break;
					}
				}
				stack.push("/");
				break;
			case')':
				while(!stack.isEmpty() && operators.indexOf((String)stack.top()) != -1 ) 
					queue.enqueue(stack.pop());
				
				if(stack.isEmpty()) {
					throw new InvalidNotationFormatException();
				} else {
					stack.pop();
				}
				
				break;
			}	
		}
		
		if(!stack.isEmpty()) 
			for(int i = 0; i < stack.size();i++) 
				queue.enqueue(stack.pop());
		
			
		return queue.toString();
	}
	
	
}
