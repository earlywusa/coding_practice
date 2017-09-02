package designpattern.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjservableImpl implements Observable {

	List<Observer> followers = new ArrayList<>();
	@Override
	public void register(Observer obsr) {
		if(!followers.contains(obsr)) {
			followers.add(obsr);
		}
	}

	@Override
	public void broadcast() {
		String timeData = new Date().toString();
		for (Observer obsr : followers) {
			obsr.updateData(timeData);
		}
	}

}
