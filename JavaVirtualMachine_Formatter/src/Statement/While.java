package Statement;
import Condition.Condition;
import Visitor.Visitor;

public class While extends Statement {
	public While(Condition cond, Statement body, boolean isDoWhile) {
		super();
		this.cond = cond;
		this.body = body;
		this.isDoWhile = isDoWhile;
	}

	private Condition cond;
	private Statement body;
	private boolean isDoWhile;
	
	public Condition getCond() {
		return cond;
	}

	public Statement getBody() {
		return body;
	}

	public boolean isDoWhile() {
		return isDoWhile;
	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	

}
