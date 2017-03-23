package model;

import java.awt.Color;
import java.awt.geom.Point2D;

public abstract class AbstractShape implements Shape {
	protected Point2D.Double coord;
	protected double rotat;
	protected double rotatCenter;
	protected double translate;
	protected Color color;
}
