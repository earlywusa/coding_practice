package jackson;

import lombok.Data;

@Data
//@JsonTypeInfo(  
//	    use = JsonTypeInfo.Id.NAME,  
//	    include = JsonTypeInfo.As.PROPERTY,  
//	    property = "type")  
//	@JsonSubTypes({  
//	    @Type(value = A.class, name = "a"),  
//	    @Type(value = B.class, name = "b"),  
//	    @Type(value = C.class, name = "c") }) 
public abstract class Vehicle {
	 private String make;
	    private String model;
	    public Vehicle() {
	    		this.make = "unknown";
	    		this.model = "unknown";
	    }
	    protected Vehicle(String make, String model) {
	        this.make = make;
	        this.model = model;
	    }
}
