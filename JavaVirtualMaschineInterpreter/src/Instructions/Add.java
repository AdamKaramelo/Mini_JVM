package Instructions;

import Visitors.AsmVisitor;

public class Add extends Instruction{
	
	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
