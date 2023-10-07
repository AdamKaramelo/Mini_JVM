package Instructions;


import Visitors.AsmVisitor;

public class Sts extends Instruction {

	public Sts(int immediate) {
		super(immediate);
	}

	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
