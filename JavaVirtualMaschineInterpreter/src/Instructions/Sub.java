package Instructions;

import Visitors.AsmVisitor;

public class Sub extends Instruction{
	
	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
