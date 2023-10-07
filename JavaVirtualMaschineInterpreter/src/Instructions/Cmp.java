package Instructions;

import Visitors.AsmVisitor;

public class Cmp extends Instruction{

	public Cmp(int immediate) {
		super(immediate);
	}

	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
