package Instructions;

import Visitors.AsmVisitor;

public class Or extends Instruction{
	
	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
