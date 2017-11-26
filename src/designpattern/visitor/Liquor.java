package designpattern.visitor;

public class Liquor implements Visitable{
	public double price = 19.99;

	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
