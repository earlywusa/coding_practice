package reflect;

public class AbstClass {
	
	@StorageEntity("FIELD_1")
	private String field1 = null;
	
	@StorageEntity("FIELD_2")
	private AbstClass field2 = null;
	public AbstClass(){
		field1 = "IamField1";
	}
	
	public String getField1(){
		return field1;
	}
	
	public AbstClass getField2(){
		return field2;
	}
	
	public void onResult(boolean result){
		System.out.println("called onResult in AbsClass: " + result);
	}
}
