package model;

public class Memento {
	private Model state;
	
	public Memento(Model m){
		this.state = m.clone();
	}

	public Model getState(){
		return this.state;
	}
	
}
