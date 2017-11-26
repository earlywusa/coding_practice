package jackson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.databind.SerializationFeature;

public class TestDriver {

	public static ObjectMapper mapper = new ObjectMapper();
	public static void main(String[] args) {
		
//		mapper.enableDefaultTyping();
//		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		
		Car car = new Car("Mercedes-Benz", "S500", 5, 250.0);
		Truck truck = new Truck("Isuzu", "NQR", 7500.0);
		 
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(car);
		vehicles.add(truck);
		 
		Fleet serializedFleet = new Fleet();
		serializedFleet.setVehicles(vehicles);
		
		try {
			String carString = mapper.writeValueAsString(car);
			System.out.println("car string: " + carString);
			Car carObj = mapper.readValue(carString, Car.class);
			System.out.println("car: " + carObj + " make: " + carObj.getMake());
			
			String jsonDataString = mapper.writeValueAsString(serializedFleet);
			System.out.println("Data String: " + jsonDataString);
			Fleet deserializedFleet = mapper.readValue(jsonDataString, Fleet.class);
			System.out.println("fleet: " + deserializedFleet);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
