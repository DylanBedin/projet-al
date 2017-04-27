package view;

import java.util.ArrayList;
import javafx.scene.shape.Shape;

public class ShapeComposite extends Shape {
	private ArrayList<Shape> listShapes;
	
	public ShapeComposite(){
		this.listShapes = new ArrayList<Shape>();
	}
	
	public void addShape(javafx.scene.shape.Shape shape){
		this.listShapes.add(shape);
	}
	
	public void removeShape(Shape s){
		this.listShapes.remove(s);
	}
	
	public boolean isEmpty(){
		return this.listShapes.isEmpty();
	}

	public ArrayList<Shape> getList(){
		return this.listShapes;
	}
	
	@Override
	@Deprecated
	public com.sun.javafx.geom.Shape impl_configShape() {
		// TODO Auto-generated method stub
		return null;
	}
}
