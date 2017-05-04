package model;

import java.awt.Color;
import java.awt.geom.Point2D;

public interface IShape extends Cloneable{
	
	public void setPosition(double x, double y);
	public Point2D getPosition();
	
	public void setFill(Color c);
	public Color getFill();
	
	public void setStroke(Color c);
	public Color getStroke();
	
	public void setRotation(double rotat);
	public double getRotation();
	
	public void setRotationCenter(double rotatCenterX, double rotatCenterY);
	public double getRotationCenterX();
	public double getRotationCenterY();
	
	public void setTranslation(double translateX, double translateY);
	public double getTranslationX();
	public double getTranslationY();
	
	public boolean isOriginalShape();
	public void setOriginalShape(boolean orig);
	
	public Object clone() throws CloneNotSupportedException;
}
