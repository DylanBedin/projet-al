package model;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Observable;
import java.util.Stack;

@SuppressWarnings("serial")
public class Model extends Observable implements Serializable{
	private Toolbar toolbar;
	private Whiteboard whiteboard;
	private final double LAYOUT_X_GROUP2 = 5;
	private final double LAYOUT_Y_GROUP2 = 50;
		
	private transient Stack<Memento> undoStack, redoStack;
	
	public Model(){
		this.toolbar = new Toolbar();
		this.whiteboard = new Whiteboard();
		this.undoStack = new Stack<Memento>();
		this.redoStack = new Stack<Memento>();
	}
	
	private Model(Toolbar toolbar, Whiteboard wb, Stack<Memento> undoStack){
		this.toolbar = toolbar;
		this.whiteboard = wb;
		this.undoStack = undoStack;
	}
	
	public void changeState(Model state){
		this.toolbar = state.returnToolbar();
		this.whiteboard = state.returnWhiteboard();
	}
	
	public void addMemento(Memento state){
		this.undoStack.push(state);
		this.redoStack.clear();
	}
	
	
	
	public Memento getMementoUndo(){
		try{
			return this.redoStack.push(this.undoStack.pop());
		}
		catch(EmptyStackException e){}
		return null;
	}
	
	public Memento getMementoRedo(){
		try{
			return this.undoStack.push(this.redoStack.pop());
		}
		catch(EmptyStackException e){}
		return null;
	}
	
	public void saveMemento(){
		MementoOriginator mementoOrig = new MementoOriginator();
		mementoOrig.setState(this);
		this.undoStack.add(mementoOrig.saveStateToMemento());
	}
	
	public void notifyObservers(Object arg, boolean memento){
		if(memento){
			saveMemento();
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
	}
	
	public void notifyChangeShape(IShape s, boolean undoable){
		setChanged();
		this.notifyObservers(s, undoable);
	}
	
	public void notifyChangeListShapes(List<IShape> listShapes){
		setChanged();
		this.notifyObservers(listShapes, false);
	}
	
	public void notifyUndo(){
		Memento m = this.getMementoUndo();
		setChanged();
		this.notifyObservers(m, false);
	}
	
	public void notifyRedo(){
		Memento m = this.getMementoRedo();
		setChanged();
		this.notifyObservers(m, false);
	}
	
	public double getLayoutGroup2X(){
		return this.LAYOUT_X_GROUP2;
	}
	
	public double getLayoutGroup2Y(){
		return this.LAYOUT_Y_GROUP2;
	}
	
	@SuppressWarnings("unchecked")
	public Model clone(){
		try {
			return new Model((Toolbar) this.toolbar.clone(), (Whiteboard) this.whiteboard.clone(), 
					(Stack<Memento>) this.undoStack.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
