package controller;

import java.util.ArrayList;
import model.IShape;
import javafx.scene.shape.Shape;

public class ShapeModelAndShapeView {
	private ArrayList<Shape> shapeViewList;
	private ArrayList<IShape> shapeModelList;
	
	public ShapeModelAndShapeView(){
		this.shapeViewList = new ArrayList<Shape>();
		this.shapeModelList = new ArrayList<IShape>();
	}
	
	public void addShape(IShape ishape, Shape shape){
		this.shapeModelList.add(ishape);
		this.shapeViewList.add(shape);
	}
	
	public IShape getIShape(Shape shape){
		int index = 0;
		for(int i = 0; i < shapeViewList.size(); i++){
			if(shape == shapeViewList.get(i)){
				index = i;
			}
		}
		return this.shapeModelList.get(index);
	}
	
	public Shape getShape(IShape ishape){
		int index = 0;
		for(int i = 0; i < shapeViewList.size(); i++){
			if(ishape == shapeViewList.get(i)){
				index = i;
			}
		}
		return this.shapeViewList.get(index);
	}
	
}
