package oop.ex45;

public class Addition extends BinaryOperator {
  @Override
  public void parse(Context con) {
    if(con.currentToken().equals("+")) {
      con.nextToken();
      parseOperands(con);
    }
    else {
      throw new RuntimeException("Not addition");
    }
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }

  @Override
  public String toString() {
    return "+ " + getLeftExpression() + " " + getRightExpression();
  }

  @Override
  public Value evaluate() {
    return new Number(getLeftExpression().evaluate().getNumber() + getRightExpression().evaluate().getNumber());
  }
}