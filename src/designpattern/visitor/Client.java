package designpattern.visitor;

public class Client {

	public static void main(String[] args) {
		Visitor taxVisitor = new TaxVisitor();
		Liquor liq = new Liquor();
		Tobacco toba = new Tobacco();
		System.out.println(liq.accept(taxVisitor));
		System.out.println(toba.accept(taxVisitor));

	}

}
