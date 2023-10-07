package Instructions;

import Visitors.AsmVisitor;

public abstract class Instruction {
private int immediate;	

	public Instruction() {
		super();
	}

	public Instruction(int immediate) {
		super();
		this.immediate = immediate;
	}
	
	public int getImmediate() {
		return immediate;
	}
	
	public abstract void accept(AsmVisitor Asmvisitor);
	

}
