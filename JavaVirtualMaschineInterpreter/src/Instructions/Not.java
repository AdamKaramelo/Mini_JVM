package Instructions;

import Visitors.AsmVisitor;

public class Not extends Instruction{
	
	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
