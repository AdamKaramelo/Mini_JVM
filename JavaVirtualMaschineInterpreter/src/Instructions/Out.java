package Instructions;

import Visitors.AsmVisitor;

public class Out extends Instruction{
	
	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
