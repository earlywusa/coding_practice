package designpattern.strategy;

public interface FlyBehavior {
	public void fly();
	
	public class FlyHigh implements FlyBehavior{

		@Override
		public void fly() {
			System.out.println("Fly up high~");
		}
		
	}
	
	public class CannotFly implements FlyBehavior{

		@Override
		public void fly() {
			System.out.println("Cannot fly");
		}
		
	}
}

