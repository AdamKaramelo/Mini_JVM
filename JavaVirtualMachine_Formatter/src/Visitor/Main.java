package Visitor;
import Condition.BinaryCondition;
import Condition.Comparison;
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

public class Main {
	public static void main (String[] args) {
		Function nestedLoops = new Function("nestedLoops", new String[] {},
		        new Declaration[] { new Declaration(new String[] { "test" }) },
		        new Statement[] { new While(new True(), new IfThenElse(
		        new Comparison(new Number(5), Comp.Greater, new Number(10)),
		        new ExpressionStatement(new Call("doStuff", new Expression[] {})),
		        new IfThen(new BinaryCondition(new True(), Bbinop.And, new UnaryCondition(Bunop.Not, new False())),
		           new Composite(new Statement[] {
		                new ExpressionStatement(new Call("main", new Expression[] {})),
		                new ExpressionStatement(new Write(new Call("read", new Expression[] {}))),
		                new ExpressionStatement(new Call("test", new Expression[] { new Number(5), new Number(10) })),
				new While(new False(), new Assignment("test", new Number(60)),  true) }))), false), new Return(new Number(-1)) });
		
		
		Function main = new Function("main",
				 new String[] {},
				 new Declaration[] {},
				 new Statement[] {
				 new ExpressionStatement(new Write(new Call("sum", new Expression[]
				 { new Read(), new Read() }))),
				 new Return(new Number(0))
				 });
				
		Function sum = new Function("sum",
				 new String[] {"a"},
				 new Declaration[] {},
				 new Statement[] {
				 new Return(new Binary(new Variable("a"), Binop.Plus, new Variable("b")))});
				 

		Program prog = new Program(new Function[] {nestedLoops, main, sum});

		FormatVisitor fv = new FormatVisitor();
		prog.accept(fv);
		System.out.println(fv.getFormattedCode());
	}
}