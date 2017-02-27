package reflect;

public class Driver {

	public static void main(String[] args) {
		AbstClass abstractClass = new AbstClass();
		CallAbsClass caller = new CallAbsClass();
		caller.doCall(abstractClass);
	}

}
