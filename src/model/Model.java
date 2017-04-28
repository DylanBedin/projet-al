package model;

import java.util.Observable;

public class Model extends Observable{
	private Toolbar toolbar;
	private Whiteboard whiteboard;
	
	public Model(){
		this.toolbar = new Toolbar();
		this.whiteboard = new Whiteboard();
	}
	
	public void getToolbar(){
		setChanged();
		notifyObservers(this.toolbar);
	}
	
	public void getWhiteboard(){
		setChanged();
		notifyObservers(this.whiteboard);
	}
}
