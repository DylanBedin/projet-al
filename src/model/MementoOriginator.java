package model;

public class MementoOriginator {
	private Model state;

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
