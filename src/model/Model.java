package model;

import java.util.List;
import java.util.Observable;

public class Model extends Observable{
	private Toolbar toolbar;
	private Whiteboard whiteboard;
	private static Model instance = null;
	
	private Model(){
		this.toolbar = Toolbar.getInstance();
		this.whiteboard = Whiteboard.getInstance();
	}
	
	public static Model getInstance(){
		if(instance == null){
			synchronized (Model.class) {
				if(instance == null){
					instance = new Model();
				}
			}
		}
		return instance;
	}
	
	public void getToolbar(){
		setChanged();
		notifyObservers(this.toolbar);
	}
	
	public void getWhiteboard(){
		setChanged();
		notifyObservers(this.whiteboard);
	}
	
	public void notifyChangeShape(IShape s){
		setChanged();
		notifyObservers(s);
	}
	
	public void notifyChangeListShapes(List<IShape> listShapes){
		setChanged();
		notifyObservers(listShapes);
	}
	
}
