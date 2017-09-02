package designpattern.visitor;

public class TaxVisitor implements Visitor{

	@Override
	public double visit(Liquor liquor) {
		return liquor.price * 1.88;
	}

	@Override
	public double visit(Tobacco tobacco) {
		return tobacco.price * 1.30;
	}

}
