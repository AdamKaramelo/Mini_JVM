package Instructions;

import Visitors.AsmVisitor;

public class Call extends Instruction{
	
	public Call(int immediate) {
		super(immediate);
	}

	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
