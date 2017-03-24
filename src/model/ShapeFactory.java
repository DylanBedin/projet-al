package model;

import java.awt.Color;
import java.awt.geom.Point2D;

public class ShapeFactory implements IShapeFactory {

	public IShape createNewRectangle(double width, double height, double round, double roundedEdges, double rotat,
			double rotatCenter, double translate, Color color, double size, Point2D position) {
		return new ShapeRectangle(width, height, round, roundedEdges, rotat, rotatCenter, translate, color, size, position);
	}

	public IShape createNewRegularPolygon(int edgeLength, int nbEdges, double rotat, double rotatCenter,
			double translate, Color color, double size, Point2D position) {
		return new ShapeRegularPolygon(edgeLength, nbEdges, rotat, rotatCenter, translate, color, size, position);
	}

	



}
