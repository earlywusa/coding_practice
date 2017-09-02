package jackson;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Fleet {
	private List<Vehicle> vehicles;
    public Fleet() {
    	vehicles = new ArrayList<>();
    }
    // getters and setters
    public void setVehicles(List v) {
    	this.vehicles = v;
    }
}
