package designpattern.strategy;

public abstract class Duck {

	protected FlyBehavior flyInterface;
	
	public void swim() {
		System.out.println("swim happily..");
	}
	
	public void setFlyBehavior(FlyBehavior flyMethod) {
		this.flyInterface = flyMethod;
	}
	
	public void fly() {
		this.flyInterface.fly();
	}
}
