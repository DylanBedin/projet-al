package model;

public class ShapeFactory implements IShapeFactory {

	public IShape createNewRectangle() {
		return new Rectangle();
	}

	public IShape createNewRegularPolygon() {
		return new RegularPolygon();
	}

}
