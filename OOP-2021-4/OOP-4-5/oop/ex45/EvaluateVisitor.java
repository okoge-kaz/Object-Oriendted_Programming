package oop.ex45;


public class EvaluateVisitor implements Visitor {
  private Value v;

  public Value evaluate(Expression e) {
    e.accept(this);
    return v;
  }

  @Override
  public void visit(Number e){
    this.v = new Number(e.getNumber());
  }

  @Override
  public void visit(Bool e){
    this.v = new Bool(e.getBool());
  }

  @Override
  public void visit(Addition e){
    this.v = new Number(this.evaluate(e.getLeftExpression()).getNumber() + this.evaluate(e.getRightExpression()).getNumber());
  }

  @Override
  public void visit(LessThan e){
    this.v = new Bool(this.evaluate(e.getLeftExpression()).getNumber() < this.evaluate(e.getRightExpression()).getNumber());
  }

  @Override
  public void visit(IfThenElse e){
    this.v = (this.evaluate(e.getConditional()).getBool()) ? this.evaluate(e.getThenPart()) : this.evaluate(e.getElsePart());
  }
}