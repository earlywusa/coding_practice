package string;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("A*|(A*BA*BA*)*");
		Matcher m = p.matcher("A");
		boolean b = m.matches();
//		b = Pattern.matches("[^A|^B]C", "CC");
//		b = Pattern.matches("^A*", "AC");
//		b = Pattern.matches("a{3,6}", "aaaaaaaaa");
//		
//		b = Pattern.matches("(A{4})+", "AAAA");
//		
//		b = Pattern.matches("(dog){3}", "dogdogdog");
//		b = Pattern.matches("[dog]{3}", "ddg"); // [dog] == d|o|g
//		
//		b = Pattern.matches("a.*a|a", "aa"); // [dog] == d|o|g
//		b = Pattern.matches("[dog]{3}", "dd");
//		System.out.println("matches "+b);
//		
//		b = Pattern.matches("([01]?\\d\\d?)", "182"); 
//		System.out.println("matches "+b);
		
//		b = Pattern.matches("([0-9]+)(?:st|nd|rd|th)", "1112rd"); 
//		System.out.println("matches "+b);
		
//		b = Pattern.matches("(?:24[0-5]|24)\\.", "243."); 
//		System.out.println("matches "+b);
//		
//		String pstr = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
//		
//		pstr = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){2}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
//		Pattern ipp = Pattern.compile(pstr);
//		
//		
//		String target1 = "172.25.128.288";
//		b = ipp.matcher(target1).matches();
//		System.out.println(target1 + " matches "+b);
//		
//		target1 = "172.25.128.11";
//		b = ipp.matcher(target1).matches();
//		System.out.println(target1 + " matches "+b);
//		
//		target1 = "0.0.0.0";
//		b = ipp.matcher(target1).matches();
//		System.out.println(target1 + " matches "+b);
//		
//		target1 = "0.0.0";
//		b = ipp.matcher(target1).matches();
//		System.out.println(target1 + " matches "+b);
		
//		String pstr = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){2}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
//		validate(pstr, getValidIp());
//		validate(pstr, getInvalidIp());
		String testStr = "abc";
		System.out.println(testStr.substring(0,1));
		
	
	}
	public static void validate(String pattern, List<String> candidates){
		Pattern p = Pattern.compile(pattern);
		
		for(String item : candidates){
			System.out.println(item + " : " + p.matcher(item).matches());
		}
	}
	
	public Object[][] ValidIPAddressProvider() {
		return new Object[][]{
		   new Object[] {"1.1.1.1"},new Object[] {"255.255.255.255"},
                   new Object[] {"192.168.1.1"},new Object[] {"10.10.1.1"},
                   new Object[] {"132.254.111.10"},new Object[] {"26.10.2.10"},
		   new Object[] {"127.0.0.1"}
		};
	}
      
	public static List<String> getValidIp(){
		List<String> ret = new ArrayList<String>();
		ret.add("1.1.1.1");
		ret.add("255.255.255.255");
		ret.add("192.168.1.1");
		ret.add("10.10.1.1");
		ret.add("132.254.111.10");
		ret.add("26.10.2.10");
		ret.add("127.0.0.1");
		return ret;
	}
	public Object[][] InvalidIPAddressProvider() {
		return new Object[][]{
		   new Object[] {"10.10.10"},new Object[] {"10.10"},
                   new Object[] {"10"},new Object[] {"a.a.a.a"},
                   new Object[] {"10.0.0.a"},new Object[] {"10.10.10.256"},
		   new Object[] {"222.222.2.999"},new Object[] {"999.10.10.20"},
                   new Object[] {"2222.22.22.22"},new Object[] {"22.2222.22.2"},
                   new Object[] {"10.10.10"},new Object[] {"10.10.10"},
		};
	}                      
	public static List<String> getInvalidIp(){
		List<String> ret = new ArrayList<String>();
		ret.add("10.10.10");
		ret.add("10.10");
		ret.add("10");
		ret.add("a.a.a.a");
		ret.add("10.0.0.a");
		ret.add("10.10.10.256");
		ret.add("222.222.2.999");
		ret.add("999.10.10.20");
		ret.add("2222.22.22.22");
		ret.add("22.2222.22.2");
		ret.add("172.25.388.21");

		return ret;
	}

}
