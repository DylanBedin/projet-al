package test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.geom.Point2D;

import org.junit.Before;
import org.junit.Test;

import model.IShape;
import model.ShapeRegularPolygon;

public class ShapeRegularPolygonTest {

	private static ShapeRegularPolygon shapePoly;
	
	@Before
	public void setUp() throws Exception {
		shapePoly = new ShapeRegularPolygon(6,10);
	}

	@Test
	public void testSetPosition() {
		shapePoly.setPosition(50, 40);
		assertEquals(shapePoly.getPosition().getX(), 50, 0);
		assertEquals(shapePoly.getPosition().getY(), 40, 0);
	}

	@Test
	public void testGetPosition() {
		assertEquals(shapePoly.getPosition().getX(), 0, 0);
		assertEquals(shapePoly.getPosition().getY(), 0, 0);
	}

	@Test
	public void testShapeRegularPolygon() {
		assertTrue(shapePoly instanceof ShapeRegularPolygon);
		assertTrue(shapePoly instanceof IShape);
	}

	@Test
	public void testBarycentreX() {
		Double tab [] = new Double[] {
			  5.0 , 6.0 ,
			  7.0 , 3.0 ,
			  0.0 , 6.0 
		};
		assertEquals( ShapeRegularPolygon.barycentreX(tab), 4, 0);
	}

	@Test
	public void testBarycentreY() {
		Double tab [] = new Double[] {
				  5.0 , 6.0 ,
				  7.0 , 3.0 ,
				  0.0 , 6.0 
			};
		assertEquals( ShapeRegularPolygon.barycentreY(tab), 5, 0);
	}

	@Test
	public void testGetRay() {
		assertEquals(shapePoly.getRay(), 10, 0);
	}

	@Test
	public void testSetRay() {
		int ray = 4;
		Double [] tab = ShapeRegularPolygon.createTab(ray,shapePoly.getNbEdges());
		shapePoly.setRay(ray);
		Double [] tabPoly = shapePoly.getTab();
		assertEquals(shapePoly.getRay(), 4, 0);
		for(int i = 0; i < tab.length; i++)
			assertEquals(tabPoly[i], tab[i], 0);
	}

	@Test
	public void testGetNbEdges() {
		assertEquals(shapePoly.getNbEdges(), 6, 0);
	}

	@Test
	public void testSetNbEdges() {
		int nbEdges = 4;
		Double [] tab = ShapeRegularPolygon.createTab(shapePoly.getRay(), nbEdges);
		shapePoly.setNbEdges(nbEdges);
		Double [] tabPoly = shapePoly.getTab();
		assertEquals(shapePoly.getNbEdges(), nbEdges, 0);
		for(int i = 0; i < tab.length; i++)
			assertEquals(tabPoly[i], tab[i], 0);
		
	}

	@Test
	public void testGetTab() {
		Double tab [] = ShapeRegularPolygon.createTab(10,6);
		Double[] tabPoly = shapePoly.getTab();
		for(int i =0; i < shapePoly.getTab().length; i++){
			assertEquals(tabPoly[i], tab[i], 0);
		}
	}

	@Test
	public void testSetTab() {
		Double tab1 [] = new Double[] {
				  5.0 , 6.0 ,
				  7.0 , 3.0 ,
				  0.0 , 6.0 
			};
		shapePoly.setTab(tab1);
		Double[] tab2 = shapePoly.getTab();
		for(int i =0; i < shapePoly.getTab().length; i++){
			assertEquals(tab1[i], tab2[i], 0);
		}
	}

	@Test
	public void testSetPositionPoint2D() {
		shapePoly.setPosition(new Point2D.Double(50,40));
		assertEquals(shapePoly.getPosition().getX(), 50, 0);
		assertEquals(shapePoly.getPosition().getY(), 40, 0);
	}

	@Test
	public void testIsOriginalShape() {
		assertTrue(shapePoly.isOriginalShape() == false);
	}

	@Test
	public void testSetOriginalShape() {
		shapePoly.setOriginalShape(true);
		assertTrue(!shapePoly.isOriginalShape() == false);
	}

	@Test
	public void testSetFill() {
		shapePoly.setFill(Color.BLACK);
		assertEquals(shapePoly.getFill().getRGB(), Color.BLACK.getRGB());
	}

	@Test
	public void testGetFill() {
		assertEquals(shapePoly.getFill().getRGB(), Color.BLUE.getRGB());
	}

	@Test
	public void testSetStroke() {
		shapePoly.setStroke(Color.WHITE);
		assertEquals(shapePoly.getStroke().getRGB(), Color.WHITE.getRGB());
	}

	@Test
	public void testGetStroke() {
		assertEquals(shapePoly.getStroke().getRGB(), Color.BLACK.getRGB());
	}

	@Test
	public void testSetRotation() {
		shapePoly.setRotation(10);
		assertEquals(shapePoly.getRotation(), 10 , 0);
	}

	@Test
	public void testGetRotation() {
		assertEquals(shapePoly.getRotation(), 0, 0);
	}

	@Test
	public void testSetRotationCenter() {
		shapePoly.setRotationCenter(10, 15);
		assertEquals(shapePoly.getRotationCenterX(), 10, 0);
		assertEquals(shapePoly.getRotationCenterY(), 15, 0);
	}

	@Test
	public void testGetRotationCenterX() {
		assertEquals(shapePoly.getRotationCenterX(), 0, 0);
	}

	@Test
	public void testGetRotationCenterY() {
		assertEquals(shapePoly.getRotationCenterY(), 0, 0);
	}

	@Test
	public void testSetTranslation() {
		shapePoly.setTranslation(12, 15);
		assertEquals(shapePoly.getTranslationX(), 12, 0);
		assertEquals(shapePoly.getTranslationY(), 15, 0);
	}

	@Test
	public void testGetTranslationX() {
		assertEquals(shapePoly.getTranslationX(), 0, 0);
	}

	@Test
	public void testGetTranslationY() {
		assertEquals(shapePoly.getTranslationX(), 0, 0);
	}

}
