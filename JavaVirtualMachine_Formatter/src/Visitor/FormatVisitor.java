package Visitor;

import Condition.BinaryCondition;
import Condition.Comparison;
import Condition.Condition;
import Condition.False;
import Condition.True;
import Condition.UnaryCondition;
import Declaration.Declaration;
import Expression.Binary;
import Expression.Call;
import Expression.Expression;
import Expression.Number;
import Expression.Read;
import Expression.Unary;
import Expression.Variable;
import Expression.Write;
import Funktion.Function;
import Program.Program;
import Statement.Assignment;
import Statement.Composite;
import Statement.ExpressionStatement;
import Statement.IfThen;
import Statement.IfThenElse;
import Statement.Return;
import Statement.Statement;
import Statement.While;
import codegen.Bbinop;
import codegen.Binop;
import codegen.Bunop;
import codegen.Comp;
import codegen.Unop;

public class FormatVisitor implements Visitor {
	private String formattedCode= "";
	private int indent = 0;
	
	private void indentCode() {
		for (int i=0; i < indent; i++) {
			formattedCode += "\t";
		}
	}

	public String getFormattedCode() {
//	  calculateFormattedCode();
		return formattedCode;
	}

	@Override
	public void visit(Program program) {
		for(Function i: program.getFunctions()) {
			i.accept(this);
		}
	}

	@Override
	public void visit(Function function) {
		indentCode();
		formattedCode+="int "+ function.getName() + " (";
		for(String i: function.getParameters())
			formattedCode= formattedCode+"int "+ i +"," ;

	    if (formattedCode.endsWith(","))
	    	formattedCode=formattedCode.substring(0,formattedCode.length()-1);
	    formattedCode=formattedCode+") {\n";
	    indent += 1;
	    for(Declaration i: function.getDeclarations()) {
	    	indentCode();
	    	i.accept(this);
			formattedCode+= ";\n";
	    }
	    for(Statement i: function.getStatements()) {
	    	i.accept(this);
	    }
	    formattedCode+="\n";
	    indent -= 1;
	    indentCode();
	    formattedCode += "}\n";

	}

	@Override
	public void visit(Declaration declaration) {
		for(String i: declaration.getNames())
		formattedCode+="int "+i;
	}


	@Override
	public void visit(Return returned) {
		indentCode();
		formattedCode+="return ";
		returned.getExpression().accept(this);
		formattedCode+=";";

	}
	public void visit(Binary binary) {
		binary.getLhs().accept(this);
		if(binary.getOperator()==Binop.Plus)
			formattedCode+= "+ ";
		else if(binary.getOperator()==Binop.Minus)
			formattedCode+= "- ";
		else if(binary.getOperator()==Binop.MultiplicationOperator)
			formattedCode+= "* ";
		else if(binary.getOperator()==Binop.DivisionOperator)
			formattedCode+= "/ ";
		else
			formattedCode+= "% ";
		binary.getRhs().accept(this);

	}
	public void visit(Variable variable) {
		formattedCode+= variable.getName() + " ";

	}

	public void visit(Write write) {
		formattedCode+= "write(";
		write.getExpression().accept(this);
		formattedCode += ")";
	}


	@Override
	public void visit(IfThenElse ifThenElse) {
		indentCode();
		formattedCode+="if (";
		ifThenElse.getCond().accept(this);
		formattedCode+=") {\n";
		indent++;
		ifThenElse.getThenBranch().accept(this);
		//formattedCode+="\n} else {\n";
		formattedCode+="\n";
		indent--;
		indentCode();
		formattedCode+="} else {\n";
		indent++;
		ifThenElse.getElseBranch().accept(this);
		indent--;
		indentCode();
		formattedCode+="}\n";


	}

	@Override
	public void visit(IfThen ifThen) {
		indentCode();
		formattedCode+="if(";
		ifThen.getCond().accept(this);
		formattedCode+=") {\n";
		indent++;
		ifThen.getThenBranch().accept(this);
		indent--;
		indentCode();
		formattedCode+="}\n";

	}

	@Override
	public void visit(ExpressionStatement expressionStatement) {
		indentCode();
		expressionStatement.getExpression().accept(this);
		formattedCode+=";\n";

	}

	@Override
	public void visit(Composite composite) {
		for(Statement i: composite.getStatements()) {
			i.accept(this);
			formattedCode+="\n";
		}
	}

	@Override
	public void visit(Assignment assignment) {
		indentCode();
		formattedCode+=assignment.getName()+"=";
		assignment.getExpression().accept(this);
		formattedCode+=";";

	}

	@Override
	public void visit(While while1) {
		indentCode();
		if(while1.isDoWhile()) {
			formattedCode+="do {\n";
			indent++;
			while1.getBody().accept(this);
			formattedCode += "\n";
			indent--;
			indentCode();
			formattedCode+= "} while (";
			while1.getCond().accept(this);
			formattedCode+=");";
		}else {
			formattedCode+= "while (";
			while1.getCond().accept(this);
			formattedCode+=") {\n";
			indent++;
			while1.getBody().accept(this);
			indent--;
			indentCode();
			formattedCode+="}\n";
		}
	}

	@Override
	public void visit(Unary unary) {
		if(unary.getOperator()==Unop.Minus)
			formattedCode+= "-";
		unary.getOperand().accept(this);
	}

	@Override
	public void visit(Read read) {
		formattedCode+= "read()";

	}

	@Override
	public void visit(Call call) {
		formattedCode+= call.getFunctionName() + "(";
		for(Expression i: call.getArguments()) {
		  i.accept(this);
		  formattedCode+=",";
		}
		if (formattedCode.endsWith(","))
	    	formattedCode=formattedCode.substring(0,formattedCode.length()-1);

		formattedCode+=")";

	}

	@Override
	public void visit(Number number) {
		formattedCode+= number.getValue();

	}

	@Override
	public void visit(BinaryCondition binaryCondition) {
		binaryCondition.getLhs().accept(this);
		if(binaryCondition.getOperator()==Bbinop.And)
			formattedCode+=" && ";
		else
			formattedCode+=" || ";
		binaryCondition.getRhs().accept(this);

	}

@Override
	public void visit(UnaryCondition unaryCondition) {
	if(unaryCondition.getOperator()==Bunop.Not)
		formattedCode+="!";
	unaryCondition.getOperand().accept(this);
	}

	@Override
	public void visit(Comparison comparison) {
		comparison.getLhs().accept(this);
		if(comparison.getOperator()==Comp.Equals)
			formattedCode+=" == ";
		else if(comparison.getOperator()==Comp.NotEquals)
		formattedCode+=" != ";
		else if(comparison.getOperator()==Comp.LessEqual)
			formattedCode+=" <= ";
		else if(comparison.getOperator()==Comp.Less)
			formattedCode+=" < ";
		else if(comparison.getOperator()==Comp.GreaterEqual)
			formattedCode+=" >= ";
		else
			formattedCode+=" > ";
		comparison.getRhs().accept(this);
	}


	@Override
	public void visit(False false1) {
		formattedCode+="false";

	}

	@Override
	public void visit(True true1) {
		formattedCode+="true";

	}



}
