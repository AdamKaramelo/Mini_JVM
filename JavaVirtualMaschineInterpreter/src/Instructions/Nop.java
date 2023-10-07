package Instructions;

import Visitors.AsmVisitor;

public class Nop extends Instruction{
	
	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
