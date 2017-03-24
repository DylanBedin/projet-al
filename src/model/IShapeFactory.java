package model;

import java.awt.Color;
import java.awt.geom.Point2D;

public interface IShapeFactory {
	public IShape createNewRectangle(double width, double height, double round, double roundedEdges,
			 double rotat, double rotatCenter, double translate, Color color, double size, Point2D position);
	public IShape createNewRegularPolygon(int edgeLength, int nbEdges, 
			  double rotat, double rotatCenter, double translate, Color color, double size, Point2D position);
}
