package model;

public class MementoOriginator {
	private Model state;
	private static volatile MementoOriginator instance = null;	

	public static MementoOriginator getInstance(){
		if(instance == null){
			synchronized (Toolbar.class) {
				if(instance == null){
					instance = new MementoOriginator();
				}
			}
		}
		return instance;
	}
	
	public void setState(Model m){
		this.state = m;
	}
	
	public Model getState(){
		return this.state;
	}
	
	public Memento saveStateToMemento(){
		return new Memento(this.state);
	}
	
	public void getStateFromMemento(Memento memento){
		this.state = memento.getState();
	}

}
