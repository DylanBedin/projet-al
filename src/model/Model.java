package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Stack;

import com.sun.org.apache.xpath.internal.operations.String;

public class Model extends Observable{
	private Toolbar toolbar;
	private Whiteboard whiteboard;
	private static Model instance = null;
	private final double LAYOUT_X_GROUP2 = 5;
	private final double LAYOUT_Y_GROUP2 = 50;
	
	private Stack<Memento> undoStack;
	
	public Model(){
		this.toolbar = new Toolbar();
		this.whiteboard = new Whiteboard();
		this.undoStack = new Stack<Memento>();
	}
	
	public void changeState(Model state){
		this.toolbar = state.returnToolbar();
		this.whiteboard = state.returnWhiteboard();
	}
	
	public Stack<Memento> getMementoStack(){
		return this.undoStack;
	}
	
	public void addMemento(Memento state){
		this.undoStack.add(state);
	}
	
	public Memento getMemento(){
		return this.undoStack.pop();
	}
	
	public void notifyObservers(Object arg, boolean memento){
		if(memento){
		}
		super.notifyObservers(arg);
	}
	
	public Toolbar returnToolbar(){
		return this.toolbar;
	}
	
	public Whiteboard returnWhiteboard(){
		return this.whiteboard;
	}
	
	public void getToolbar(){
		setChanged();
		this.notifyObservers(this.toolbar, false);
	}
	
	public void getWhiteboard(){
		setChanged();
		this.notifyObservers(this.whiteboard, false);

		MementoOriginator.getInstance().setState(this);
		this.undoStack.add(MementoOriginator.getInstance().saveStateToMemento());
	}
	
	public void notifyChangeShape(IShape s, boolean undoable){
		setChanged();
		this.notifyObservers(s, undoable);
	}
	
	public void notifyChangeListShapes(List<IShape> listShapes){
		setChanged();
		this.notifyObservers(listShapes, true);
	}
	
	public void notifyUndo(){
		this.changeState(this.getMemento().getState());
		setChanged();
		this.notifyObservers(new UndoClass(), false);
	}
	
	public double getLayoutGroup2X(){
		return this.LAYOUT_X_GROUP2;
	}
	
	public double getLayoutGroup2Y(){
		return this.LAYOUT_Y_GROUP2;
	}
	
}
