package Instructions;

import Visitors.AsmVisitor;

public class In extends Instruction{
	
	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
