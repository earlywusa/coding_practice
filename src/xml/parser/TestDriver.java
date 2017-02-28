package xml.parser;

public class TestDriver {

	public static void main(String[] args) {
		XmlParser testParser = new XmlParser("src/xml/input.xml");
		try{
			testParser.loadFile(testParser.getFile());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
