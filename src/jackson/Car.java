package jackson;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true)
public class Car extends Vehicle{
	private int seatingCapacity;
    private double topSpeed;
    public Car() {
    		super();
    }
//    public Car(Vehicle v, int seatingCapacity, double topSpeed) {
//    		super(v.getMake(), v.getModel());
//    }
    public Car(String make, String model, int seatingCapacity, double topSpeed) {
        super(make, model);
        this.seatingCapacity = seatingCapacity;
        this.topSpeed = topSpeed;
    }
}
