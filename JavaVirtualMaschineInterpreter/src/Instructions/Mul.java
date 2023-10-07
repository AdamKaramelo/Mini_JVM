package Instructions;

import Visitors.AsmVisitor;

public class Mul extends Instruction{
	
	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
