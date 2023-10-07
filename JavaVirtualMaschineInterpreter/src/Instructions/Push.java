package Instructions;

import Visitors.AsmVisitor;

public class Push extends Instruction{

	public Push(int immediate) {
		super(immediate);
	}

	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
