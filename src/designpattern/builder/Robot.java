package designpattern.builder;

public class Robot implements RobotPlan{

	private String robotHead;
	private String robotTorso;
	private String robotArms;
	private String robotLegs;
	
	@Override
	public void setRobotHead(String head) {
		robotHead = head;
	}

	@Override
	public void setRobotTorso(String torso) {
		// TODO Auto-generated method stub
		robotTorso = torso;
	}

	@Override
	public void setRobotArms(String arms) {
		// TODO Auto-generated method stub
		robotArms = arms;
	}

	@Override
	public void setRobotLegs(String legs) {
		// TODO Auto-generated method stub
		robotLegs = legs;
	}
	
	public String getRobotHead(){
		return robotHead;
	}
	
	public String getRobotTorso(){
		return robotTorso;
	}
	
	public String getRobotArms(){
		return robotArms;
	}
	
	public String getRobotLegs(){
		return robotLegs;
	}

	
}
