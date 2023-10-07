package Funktion;

import Declaration.Declaration;
import Statement.Statement;
import Visitor.Visitor;

public class Function {
	
	private String name;
	private String [] parameters;
	private Declaration [] declaration;
	private Statement [] statement;
	
	public String getName () {
		return name;
	}
		public String [] getParameters () {
			return parameters;
		}
		public Declaration [] getDeclarations () {
			return declaration;
		}
		public Statement [] getStatements () {
			return statement;
		}
   public Function(String name, String[] parameters, Declaration[] declaration, Statement[] statement){
	   this.name= name;
	   this.parameters=parameters;
	   this.declaration=declaration;
	   this.statement=statement;
	   
	}
   public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
