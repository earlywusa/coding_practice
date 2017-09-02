package designpattern.observer;

public interface Observable {
	public void register(Observer obsr);
	public void broadcast();
}
