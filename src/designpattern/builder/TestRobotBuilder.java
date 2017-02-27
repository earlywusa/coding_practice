package designpattern.builder;

public class TestRobotBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RobotBuilder oldStyleRobot = new OldRobotBuilder();
		RobotEngineer engineer = new RobotEngineer(oldStyleRobot);
		engineer.makeRobot();
		
		Robot firstRobot = engineer.getRobot();
		
		System.out.println("Robot Built.");
		
		System.out.println("head: " + firstRobot.getRobotHead());
		
		
	}

}
