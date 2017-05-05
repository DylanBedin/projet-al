package model;

import java.io.Serializable;
import java.util.List;
import java.util.Observable;

public class Model extends Observable implements Serializable{
	private Toolbar toolbar;
	private Whiteboard whiteboard;
	private static Model instance = null;
	private final double LAYOUT_X_GROUP2 = 5;
	private final double LAYOUT_Y_GROUP2 = 50;
	
	
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
	
	public double getLayoutGroup2X(){
		return this.LAYOUT_X_GROUP2;
	}
	
	public double getLayoutGroup2Y(){
		return this.LAYOUT_Y_GROUP2;
	}
	
}
