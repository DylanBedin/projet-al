package model;

import java.util.ArrayList;

public class Toolbar {
	private ArrayList<IShape> listShapes;
	private IShapeFactory shapeFactory;
	
	public Toolbar(){
		this.shapeFactory = new ShapeFactory();
		this.listShapes = new ArrayList<IShape>();
	}
	
	public IShape getShape(int index){
		return this.listShapes.get(index);
	}
	
	public void addShape(IShape shape){
		this.listShapes.add(shape);
	}

	public void removeShape(int index) throws IndexForbiddenException{
		if(index == 0 || index == 1){
			throw new IndexForbiddenException();
		}
		this.listShapes.remove(index);
	}

}