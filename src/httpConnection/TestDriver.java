package httpConnection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL target = new URL("http://172.25.128.7:6688");
			String content = (new HttpConnector()).makeRequest(target);
			System.out.println(content);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
