package designpattern.visitor;

public interface Visitor {
	public double visit(Liquor liquor);
	public double visit(Tobacco tobacco);
}
