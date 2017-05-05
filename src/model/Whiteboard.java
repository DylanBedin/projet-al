package model;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.geom.Point2D;

public class Whiteboard extends ShapeRectangle{
	private ArrayList<IShape> listShapes;
	
	private double height, width;
	private Point2D upLeftCorner;
	
	private final double LAYOUT_X_WHITEBOARD = 85;
	private final double LAYOUT_Y_WHITEBOARD = 20;
	private final double WIDTH = 400, HEIGHT = 510;
	
	public Whiteboard(){
		this.listShapes = new ArrayList<IShape>();
		this.setPosition(LAYOUT_X_WHITEBOARD, LAYOUT_Y_WHITEBOARD);
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);
		this.setFill(Color.WHITE);
		this.setStroke(Color.BLACK);
		this.setArcHeight(0);
		this.setArcWidth(0);
	}
	
	
	public void add(IShape shape){
		this.listShapes.add(shape);
	}
	
	public void remove(IShape shape){
		if(this.listShapes.contains(shape)){
			this.listShapes.remove(shape);
		}
	}
	
	public List<IShape> getListShapes(){
		return this.listShapes;
	}
	
	public boolean containsShape(IShape s){
		return this.listShapes.contains(s);
	}
	
	public boolean isShapeIn(IShape s){
		double x = s.getPosition().getX();
		double y = s.getPosition().getY();
		return x >= this.LAYOUT_X_WHITEBOARD && x <= this.LAYOUT_X_WHITEBOARD + this.WIDTH - ((ShapeRectangle) s).getHeight()
				&& y >= this.LAYOUT_X_WHITEBOARD && y <= this.LAYOUT_Y_WHITEBOARD + this.HEIGHT - ((ShapeRectangle) s).getWidth();
	}
	
	public void getShapeBackInTheWhiteboard(IShape s){
		if (s instanceof ShapeRectangle){
			double x = s.getPosition().getX();
			double y = s.getPosition().getY();
			if( x < this.LAYOUT_X_WHITEBOARD ){
				s.setPosition(LAYOUT_X_WHITEBOARD,y);
			}
			if( y < this.LAYOUT_Y_WHITEBOARD ){
				s.setPosition(x, LAYOUT_Y_WHITEBOARD);
			}
			if( x + ((ShapeRectangle) s).getWidth() > this.LAYOUT_X_WHITEBOARD + this.WIDTH ){
				s.setPosition(this.LAYOUT_X_WHITEBOARD + this.WIDTH - ((ShapeRectangle) s).getWidth() , y);
			}
			if( y + ((ShapeRectangle) s).getHeight() > this.LAYOUT_Y_WHITEBOARD + this.HEIGHT ){
				s.setPosition(x, this.LAYOUT_Y_WHITEBOARD + this.HEIGHT - ((ShapeRectangle) s).getHeight());
			}
			
		}
	}	
}
