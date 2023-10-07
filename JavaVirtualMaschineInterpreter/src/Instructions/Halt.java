package Instructions;

import Visitors.AsmVisitor;

public class Halt extends Instruction{
	
	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
