package model;

import java.awt.Color;
import java.awt.geom.Point2D;

public interface IShape extends Cloneable{
	
	public void setPosition(double x, double y);
	public Point2D getPosition();
	
	public void setColor(Color c);
	public Color getColor();
	
	public void setRotation(double rotat);
	public double getRotation();
	
	public void setRotationCenter(double rotatCenter);
	public double getRotationCenter();
	
	public void setTranslation(double translate);
	public double getTranslation();
	
	public Object clone() throws CloneNotSupportedException;
}
