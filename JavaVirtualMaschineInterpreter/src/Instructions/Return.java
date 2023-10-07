package Instructions;

import Visitors.AsmVisitor;

public class Return extends Instruction{

	public Return(int immediate) {
		super(immediate);
	}

	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
