package oop.ex45;


public class EvaluateVisitor implements Visitor {
  private Value v;

  public Value evaluate(Expression e) {
    e.accept(this);
    return v;
  }

  @Override
  public void visit(Number e){
    this.v = new Number(e.getValue());
  }

  @Override
  public void visit(Bool e){
    this.v = new Bool(e.getBool());
  }

  @Override
  public void visit(Addition e){
    this.v = new Number(e.getLeftExpression().evaluate().getNumber() + e.getRightExpression().evaluate().getNumber());
  }

  @Override
  public void visit(LessThan e){
    this.v = new Bool(e.getLeftExpression().evaluate().getNumber() < e.getRightExpression().evaluate().getNumber());
  }

  @Override
  public void visit(IfThenElse e){
    this.v = e.getConditional().evaluate().getBool() ? e.getThenPart().evaluate() : e.getElsePart().evaluate();
  }
}