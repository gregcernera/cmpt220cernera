package week8;

public class TestMyStack {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack);
		System.out.println("Peek: " + stack.peek());
		stack.pop();
		stack.pop();
		System.out.println(stack);
		

	}
	

}
