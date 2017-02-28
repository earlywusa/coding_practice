package xml.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class XmlParser {
	
	private File targetFile = null;
	
	public XmlParser(String path){
		setTargetFile(path);
		try {
			String content = loadFile(targetFile);
			parseString(content);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setTargetFile(String path){
		targetFile = new File(path);
		if(! targetFile.isFile() || ! targetFile.exists()){
			throw new IllegalArgumentException("Path:  " + path + " is NOT valid.");
		}
	}
	
	public File getFile(){
		return targetFile;
	}
	
	protected String loadFile(File f) throws FileNotFoundException{
		StringBuilder sb = new StringBuilder();
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		try{
		while((line = br.readLine()) != null){
			line = line.trim();
			if(!line.startsWith("#") && !line.startsWith("<?")){
				sb.append(line);
			}
		}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		return sb.toString();
	}
	
	protected eGraph parseString(String str){
		eGraph ret = null;
		Queue<String> cache = new LinkedList<>();
		int bracketStart=0;
		int contentStart=0;
		for(int i=0; i< str.length(); i++){
			if(str.charAt(i) == '<'){
				bracketStart = i;
				if(i>contentStart){
					String tagVal = str.substring(contentStart, i).trim();
					if(tagVal.length() > 0){
						//System.out.println("content: " + tagVal);
						cache.add(tagVal);
					}
				}
			}
			else if(str.charAt(i) == '>'){
				String elementTag = str.substring(bracketStart, i+1);
				//System.out.println("pushing: " + elementTag);
				cache.add(elementTag);
				contentStart=i+1;
				
			}
		}
		
		//debug information
		dumpStack(cache);
		System.out.println();
		System.out.println("Dump node tree");
		eNode root = processElementStack(cache);
		dumpNodePreOrder(root);
		return ret;
	}
	
	private eNode processElementStack(Queue<String> stk){

		if(!stk.isEmpty()){
			String token = stk.remove();
			if(token.startsWith("</")){
				System.out.println("should not reach here");
			}
			else if(token.startsWith("<")){
				eNode newNode = createBranchNode(token);
				while(!stk.peek().startsWith("</")){
					newNode.subNodes.add(processElementStack(stk));
				}
				stk.remove();
				return newNode;
			}
			else{
				return createLeafNode(token);
			}
		}
		return null;
	}
	
	private eNode createLeafNode(String str){
		eNode newNode = new eNode();
		newNode.element_raw_content = str;
		newNode.isLeaf = true;
		return newNode;
	}
	
	private eNode createBranchNode(String str){
		eNode newNode = new eNode();
		newNode.element_raw_content = str;
		
		
		return newNode;
	}
	
	private List<String> parseRawData(String str){
		List<String> list = new LinkedList<>();
		for(int i = 0; i<str.length(); i++){
			if(str.charAt(i) == '<'){
				for(int j = i; j<str.length();j++){
					
				}
			}
		}
	}
	
	
	
	private void dumpNodeBFS(eNode root){
		Stack<eNode> stk = new Stack<eNode>();
		stk.push(root);
		while(!stk.isEmpty()){
			eNode cur = stk.pop();
			dump(cur, stk);
		}
		
	}
	
	private void dumpNodePreOrder(eNode root){
		System.out.println(root.element_raw_content);
		for(eNode i : root.subNodes){
			dumpNodePreOrder(i);
		}
	}
	
	private void dump(eNode node, Stack<eNode> stk){
		System.out.println(node.element_raw_content);
		for(int i = 0 ; i< node.subNodes.size(); i++){
			stk.push(node.subNodes.get(i));
		}
	}
	
	private void dumpStack(Collection<String> cache){
		Iterator<String> itr = cache.iterator();
		while(itr.hasNext()){
			String item = itr.next();
			System.out.println(""+item+"");
		}
	}
	
//	private String parseOpenElement(String str){
//		
//	}
//	
//	private String parseCloseElment(String str){
//		
//	}
	
	
	
	protected class eNode{
		public boolean isLeaf = false;
		public String element_raw_content = null;
		public HashMap<String, String> attributeMap = null;
		public String attr_name = null;
		public String attr_val = null;
		public List<eNode> subNodes = null;
		
		public eNode(){
			_init();
		}
		public eNode(String attr_name, String attr_val){
			_init();
			this.attr_name = attr_name;
			this.attr_val = attr_val;
		}
		
		private void _init(){
			attributeMap = new HashMap<>();
			subNodes = new LinkedList<>();
		}
	}
	
	protected class eGraph{
		public eNode root = null;
		
		public eGraph(eNode root){
			this.root = root;
		}
	}

}
