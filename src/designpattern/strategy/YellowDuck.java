package designpattern.strategy;

public class YellowDuck extends Duck{
	public YellowDuck() {
		super.flyInterface = new FlyBehavior.FlyHigh();
	}
}
