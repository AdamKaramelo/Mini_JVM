package Visitor;

import Condition.Comparison;
import Condition.BinaryCondition;
import Condition.Condition;
import Condition.False;
import Condition.True;
import Condition.UnaryCondition;
import Declaration.Declaration;
import Expression.Binary;
import Expression.Call;
import Expression.Expression;
import Expression.Variable;
import Expression.Write;
import Expression.Number;
import Expression.Read;
import Expression.Unary;
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

public interface Visitor {

	void visit(Program program);

	void visit(Function function);

	void visit(Declaration declaration);

	// Conditions
	void visit(BinaryCondition binaryCondition);
	void visit(Comparison comparison);
	void visit(False false1);
	void visit(True true1);
	void visit(UnaryCondition unaryCondition);

	// Statements
	void visit(IfThenElse ifThenElse);
	void visit(IfThen ifThen);
	void visit(ExpressionStatement expressionStatement);
	void visit(Composite composite);
	void visit(Assignment assignment);
	void visit(While while1);
	void visit(Return returned);

	// Expressions
	void visit(Binary binary);
	void visit(Unary unary);
	void visit(Read read);
	void visit(Call call);
	void visit(Number number);
	void visit(Write write);
	void visit(Variable variable);

}
