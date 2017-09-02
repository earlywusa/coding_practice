package string;

public class Tests {
	public static void main(String[] args) {
		String a = "ab";
		String b = "ad";

		int result = String.CASE_INSENSITIVE_ORDER.compare(a, b);
		System.out.println("result: " + result);
	}
}
