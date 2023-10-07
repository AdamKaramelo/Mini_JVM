package Statement;
import Condition.Condition;
import Visitor.Visitor;

public class IfThenElse extends Statement {
	public IfThenElse(Condition cond, Statement branch, Statement elseBranch) {
		super();
		this.cond = cond;
		this.branch = branch;
		this.elseBranch = elseBranch;
	}

	private Condition cond;
	private Statement branch;
    private Statement elseBranch;
	public Condition getCond() {
		return cond;
	}

	public Statement getThenBranch() {
		return branch;
	}
	
	public Statement getElseBranch () {
		return elseBranch;
	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
