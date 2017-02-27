package tools;

public class Tuple<T,E> {
	private T t = null;
	private E e = null;
	
	public Tuple(T it, E ie){
		setT(it);
		setE(ie);
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public E getE() {
		return e;
	}

	public void setE(E e) {
		this.e = e;
	}
	
	@Override
	public int hashCode(){
		return t.hashCode() ^ e.hashCode();
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Tuple)) return false;
		@SuppressWarnings("unchecked")
		Tuple<T, E> cur = (Tuple<T, E>)o;
		return this.t.equals(cur.getT()) && this.e.equals(cur.getE());
	}
	
}
