package Instructions;

import Visitors.AsmVisitor;

public class Decl extends Instruction{

	
	public Decl(int immediate) {
		super(immediate);
	}

	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
