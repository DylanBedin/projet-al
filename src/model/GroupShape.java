package model;

import java.awt.Color;
import java.util.ArrayList;

import java.awt.geom.Point2D;

public class GroupShape implements IShape {
	private ArrayList<IShape> listShapes;
	private double rotat, rotatCenter;
	
	public GroupShape(ArrayList<IShape> listShapes){
		this.listShapes = new ArrayList<IShape>(listShapes);
	}
	
	public void addShape(IShape s){
		this.listShapes.add(s);
	}
	

	public void setPosition(double x, double y) {
		/*
		 * On cherche l'écart entre ce point et la coordonnée souhaitée et on l'applique sur toutes les shapes
		 */
		double gapX = this.getPosition().getX() - x;
		double gapY = this.getPosition().getY() - y;
		for(IShape s:this.listShapes){
			s.setPosition(s.getPosition().getX() - gapX, s.getPosition().getY() - gapY);
		}
	}

	public Point2D getPosition() {
		if(this.listShapes.isEmpty()){
			throw new IllegalStateException();
		}
		/*
		 * On cherche les coordonnées de la shape la plus en haut à gauche
		 */
		double minX = this.listShapes.get(0).getPosition().getX();
		double minY = this.listShapes.get(0).getPosition().getY();
		for(IShape s:this.listShapes){
			if(s.getPosition().getX() < minX){
				minX = s.getPosition().getX();
			}
			if(s.getPosition().getY() < minY){
				minY = s.getPosition().getY();
			}
		}
		return new Point2D.Double(minX, minY);
	}

	public void setColor(Color c) {
		for(IShape s:this.listShapes){
			s.setColor(c);
		}
	}

	public Color getColor() {
		if(this.listShapes.isEmpty()){
			throw new IllegalStateException();
		}
		Color c = this.listShapes.get(0).getColor();
		for(IShape s:this.listShapes){
			if(s.getColor() != c){
				throw new IllegalStateException();
			}
		}
		return c;
	}

	public void setRotation(double rotat) {
		this.rotat = rotat;
		for(IShape s:this.listShapes){
			s.setRotation(s.getRotation() + this.rotat);
		}
	}

	public double getRotation() {
		return this.rotat;
	}

	public void setRotationCenter(double rotatCenter) {
		this.rotatCenter = rotatCenter;
	}

	public double getRotationCenter() {
		return this.rotatCenter;
	}

	public void setTranslation(double translate) {
		for(IShape s:this.listShapes){
			s.setTranslation(translate);
		}
	}

	public double getTranslation() {
		throw new UnsupportedOperationException();
	}

	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

}
