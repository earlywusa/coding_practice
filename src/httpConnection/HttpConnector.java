package httpConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpConnector {

	public HttpConnector(){
		
	}
	
//	public HttpURLConnection getConnector(URL url){
//		
//		HttpURLConnection connector = new HttpURLConnection(url){
//
//			@Override
//			public void disconnect() {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public boolean usingProxy() {
//				// TODO Auto-generated method stub
//				return false;
//			}
//
//			@Override
//			public void connect() throws IOException {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		}
//	}
	public String makeRequest(URL url){
		StringBuilder sb = new StringBuilder();
		try{
			URLConnection connection = url.openConnection();
			connection.connect();
			BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String line;
			while((line = r.readLine()) != null){
				sb.append(line);
			}
			r.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return sb.toString();
		
	}
	
	public String makeLocalhostRequest(){
		URL localhost ;
		try {
			localhost = new URL("http://127.0.0.1:4200");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
		return makeRequest(localhost);
		
	}
	

}
