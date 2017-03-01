package io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import bitwise.Hex;

public class BinaryFileReader {

	public static void main(String[] args) {
//		BinaryFileReader r = new BinaryFileReader();
//		ShoppingCartItems sc_coffee = new ShoppingCartItems(1.33, 20, "coffee");
//		ShoppingCartItems sc_bagel = new ShoppingCartItems(2.00, 10, "bagel");
//		String file_name = "shoppingCart.data";
//		try {
//			writeBinaryToFile(file_name, sc_coffee, sc_bagel);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			readBinaryFile(file_name);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String fileName = "BitwiseOpDriver.class";
		readBinaryClass(fileName);
	}
	
	public static void readBinaryClass(String filePath){
		File f = new File(filePath);
		DataInputStream di = null;
		try {
			FileInputStream fs = new FileInputStream(f);
			di = new DataInputStream(fs);
			int count = 0;
			while(true && count++ < 4){
				byte b = di.readByte();
				System.out.println(new Hex(b));	
				//count++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		}
		finally{
			try {
				if(di!= null)
				di.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public static void writeBinaryToFile( String filePath,ShoppingCartItems... items) throws IOException{
		File f = new File(filePath);
		FileOutputStream fs = new FileOutputStream(f);
		ObjectOutputStream out = new ObjectOutputStream(fs);
		
		for(ShoppingCartItems item : items)
		out.writeObject(item);
		out.close();
		fs.close();
		
	}
	
	public static void readBinaryFile(String filePath ) throws IOException {
		File f =null;
		FileInputStream fs = null;
		DataInputStream is = null;
		try{
			f = new File(filePath);
			fs = new FileInputStream(f);
			is = new DataInputStream(fs);
			is = new DataInputStream(new BufferedInputStream(new FileInputStream(f)));
			
			while(true)
			{
				System.out.println(is.readDouble());
				System.out.println(is.readInt());
				System.out.println(is.readUTF());
			}
		}
		catch(IOException ioe){
			
		}
		finally{
			if(is != null)
			is.close();
			if(is != null)
			fs.close();
		}
		
	}
	
}
