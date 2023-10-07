package Instructions;

import Visitors.AsmVisitor;

public class Mod extends Instruction{
	
	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
