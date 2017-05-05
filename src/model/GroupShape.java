package model;

import java.awt.Color;
import java.util.ArrayList;

import java.awt.geom.Point2D;

public class GroupShape implements IShape {
	private ArrayList<IShape> listShapes;
	private double rotat, rotatCenterX, rotatCenterY;
	private boolean originalShape = false;

	public GroupShape(ArrayList<IShape> listShapes){
		this.listShapes = new ArrayList<IShape>(listShapes);
	}
	
	public void addShape(IShape s){
		this.listShapes.add(s);
	}
	
	public IShape removeShape(IShape s){
		this.listShapes.remove(s);
		return s;
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

	public void setRotation(double rotat) {
		this.rotat = rotat;
		for(IShape s:this.listShapes){
			s.setRotation(s.getRotation() + this.rotat);
		}
	}

	public double getRotation() {
		return this.rotat;
	}

	public double getTranslation() {
		throw new UnsupportedOperationException();
	}

	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

	@Override
	public void setRotationCenter(double rotatCenterX, double rotatCenterY) {
		this.rotatCenterX = rotatCenterX;
		this.rotatCenterY = rotatCenterY;
	}

	@Override
	public double getRotationCenterX() {
		return this.rotatCenterX;
	}

	@Override
	public double getRotationCenterY() {
		return this.rotatCenterY;
	}

	@Override
	public void setTranslation(double translateX, double translateY) {
		for(IShape s:this.listShapes){
			s.setTranslation(translateX, translateY);
		}
	}

	@Override
	public double getTranslationX() {
		for(IShape s:this.listShapes){
			return s.getTranslationX();
		}
		return 0;
	}

	@Override
	public double getTranslationY() {
		for(IShape s:this.listShapes){
			return s.getTranslationY();
		}
		return 0;
	}

	@Override
	public void setFill(Color c) {
		for(IShape ishape:this.listShapes){
			ishape.setFill(c);
		}
	}

	@Override
	public Color getFill() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setStroke(Color c) {
		for(IShape ishape:this.listShapes){
			ishape.setStroke(c);
		}
	}

	@Override
	public Color getStroke() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isOriginalShape() {
		return this.originalShape;
	}

	@Override
	public void setOriginalShape(boolean orig) {
		this.originalShape = orig;
	}

}
