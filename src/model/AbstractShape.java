package model;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public abstract class AbstractShape implements IShape {
	protected double translateX, translateY;
	protected Color fill, stroke;
	protected Point2D position;
	protected ArrayList<Memento> mementoList;
	protected double rotat;
	protected double rotatCenterX, rotatCenterY;
	
	private boolean originalShape = false;
	
	private final static double TRANSLATEX = 0, TRANSLATEY = 0;
	
	public AbstractShape(
			double rotat,
			double rotatCenterX, double rotatCenterY,
			double translateX, double translateY, 
			Color fill, Color stroke, 
			Point2D.Double position){
		this.rotat = rotat;
		this.rotatCenterX = rotatCenterX;
		this.rotatCenterY = rotatCenterY;
		this.translateX = translateX;
		this.translateY = translateY;
		this.fill = fill;
		this.stroke = stroke;
		this.position = (Point2D) position.clone();
		this.mementoList = new ArrayList<Memento>();
	}
	
	public boolean isOriginalShape(){
		return this.originalShape;
	}
	
	public void setOriginalShape(boolean orig){
		this.originalShape = orig;
	}
	
	private Point2D.Double POSITION = new Point2D.Double(5, 20);
	private Color FILL = Color.BLUE, STROKE = Color.BLACK;
	public AbstractShape(){
		this.translateX = TRANSLATEX;
		this.translateY = TRANSLATEY;
		this.fill = FILL;
		this.stroke = STROKE;
		this.position = POSITION;
		this.mementoList = new ArrayList<Memento>();
	}
	
	public void addMemento(Memento state){
		this.mementoList.add(state);
	}
	
	public void setPosition(double x, double y) {
		this.position = new Point2D.Double(x, y);
	}

	public Point2D getPosition() {
		return this.position;
	}
	
	public void setFill(Color c){
		this.fill = c;
	}
	
	public Color getFill(){
		return this.fill;
	}

	public void setStroke(Color c){
		this.stroke = c;
	}
	
	public Color getStroke(){
		return this.stroke;
	}
	
	public void setRotation(double rotat){
		this.rotat = rotat;
	}
	public double getRotation(){
		return this.rotat;
	}

	public void setRotationCenter(double rotatCenterX, double rotatCenterY){
		this.rotatCenterX = rotatCenterX;
		this.rotatCenterY = rotatCenterY;
	}

	public double getRotationCenterX(){
		return this.rotatCenterX;
	}

	public double getRotationCenterY(){
		return this.rotatCenterY;
	}
	
	public void setTranslation(double translateX, double translateY){
		this.translateX = translateX;
		this.translateY = translateY;
	}
	
	public double getTranslationX(){
		return this.translateX;
	}
	
	public double getTranslationY(){
		return this.translateY;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
