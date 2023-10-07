package Instructions;

import Visitors.AsmVisitor;

public class Div extends Instruction{
	
	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
