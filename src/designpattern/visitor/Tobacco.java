package designpattern.visitor;

public class Tobacco implements Visitable{
	public double price = 9.99;

	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
