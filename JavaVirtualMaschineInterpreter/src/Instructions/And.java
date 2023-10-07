package Instructions;

import Visitors.AsmVisitor;

public class And extends Instruction{
	
	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
