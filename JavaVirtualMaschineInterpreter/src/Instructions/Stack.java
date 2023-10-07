package Instructions;

public class Stack {
	private int [] stack;
	private int SP;
	
	public Stack(int size) {
		stack = new int [size];
		SP = 0;
	}
	 public int pop() {
		 SP--;
		 int result = stack[SP];
		 return result;
	 }
	 
	 public void push(int value) {
		 stack[SP] = value;
		 SP++;
	 }
	 
	 public int peek(int index) {
		 return stack[index];
	 }
	 
	 public void set(int index, int value) {
		 stack[index] = value;
	 }
	 
	 public void shift(int startIndex, int numSpaces) {
		 for (int i = SP-1; i >= startIndex; i--) {
			 stack[i+numSpaces] = stack[i];
			 stack[i] = 0;
		 }
		 SP += numSpaces;
	 }
	 
	 public int getNumElements() {
		 return SP;
	 }
	 
	 public void removeSlice(int startIndex, int numElements) {
		 for (int i = startIndex; i < startIndex + numElements; i++) {
			 int newElementIndex = i + numElements;
			 if (newElementIndex < this.getNumElements()) {
				 stack[i] = stack[newElementIndex];
				 stack[newElementIndex] = 0;
			 } else {
				 stack[i] = 0;
			 }
		 }
		 SP -= numElements;
	 }

}
