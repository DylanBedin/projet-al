package model;

import java.awt.Color;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Toolbar extends ShapeRectangle{
	public ArrayList<IShape> listShapes;
	private double WIDTH = 70, HEIGHT = 215;
	private double WIDTH_ORIGIN = 50, HEIGHT_ORIGIN = 40, RAY_ORIGIN = 30;
	private int EDGES_ORIGIN = 6;
	
	/**TRASHCAN**/
	private int TRASHCAN_X = 20, TRASHCAN_Y = 490;
	private double TRASHCAN_HEIGHT = 22, TRASHCAN_WIDTH = 22;
	private double TOOLBAR_POS_X = 5, TOOLBAR_POS_Y = 20;
	
	public Toolbar(){
		this.setPosition(TOOLBAR_POS_X, TOOLBAR_POS_Y);
		this.setWidth(70);
		this.setHeight(515);
		this.setArcHeight(20);
		this.setArcWidth(20);
		this.setFill(Color.WHITE);
		this.setStroke(Color.BLACK);
		this.listShapes = new ArrayList<IShape>();

		ShapeRectangle rectOrg = new ShapeRectangle(WIDTH_ORIGIN, HEIGHT_ORIGIN);
		rectOrg.setPosition(rectOrg.getPosition().getX() + 10, rectOrg.getPosition().getY() + 10);
		rectOrg.setOriginalShape(true);
		
		this.listShapes.add(rectOrg);


		ShapeRegularPolygon polyOrg = new ShapeRegularPolygon(EDGES_ORIGIN, RAY_ORIGIN);
		polyOrg.setPosition(polyOrg.getPosition().getX() + 40 , polyOrg.getPosition().getY() + 110);
		polyOrg.setOriginalShape(true);
		
		this.listShapes.add(polyOrg);			
	}
	
	public IShape getShape(int index){
		if(index < this.listShapes.size()){
			return this.listShapes.get(index);
		}
		else{
			return null;
		}
	}

	
	public boolean isShapeIn(IShape s){
		double x = s.getPosition().getX();
		double y = s.getPosition().getY();
		return x >= this.TOOLBAR_POS_X && x <= this.TOOLBAR_POS_X + this.WIDTH
				&& y >= this.TOOLBAR_POS_Y && y <= this.TOOLBAR_POS_Y + this.HEIGHT;
	}
	
	public int getTrashcanX(){
		return this.TRASHCAN_X;
	}
	
	public int getTrashcanY(){
		return this.TRASHCAN_Y;
	}
	
	public double getTrashcanHeight(){
		return this.TRASHCAN_HEIGHT;
	}
	
	public double getTrashcanWidth(){
		return this.TRASHCAN_WIDTH;
	}
	
	public boolean isInTrashcan(IShape shape){
		double x = 0;
		double y = 0;
		if(shape instanceof ShapeRectangle){
			x = shape.getPosition().getX() + ((ShapeRectangle) shape).getWidth()/2;
			y = shape.getPosition().getY() + ((ShapeRectangle) shape).getHeight()/2;
		}
		else if (shape instanceof ShapeRegularPolygon){
			x = shape.getPosition().getX() ;
			y = shape.getPosition().getY() ;
		}
		return x >= this.getTrashcanX()  && x <= this.getTrashcanX() + this.getTrashcanWidth()  &&
				y >= this.getTrashcanY()  && y <= this.getTrashcanY() + this.getTrashcanHeight() ;
	}
	public void setListShapes(ArrayList<IShape> listShapes){
		this.listShapes = listShapes;
	}
	
	public Toolbar clone() throws CloneNotSupportedException{
		Toolbar toolbar = new Toolbar();
		ArrayList<IShape> listShapes = new ArrayList<IShape>();
		for(IShape ishape:this.listShapes){
			listShapes.add((IShape) ishape.clone());
		}
		this.setListShapes(listShapes);
		return toolbar;
	}
}
