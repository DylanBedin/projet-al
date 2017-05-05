package test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.geom.Point2D;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.ShapeRectangle;

public class ShapeRectangleTest {

	private static ShapeRectangle shapeRect1;
	private static ShapeRectangle shapeRect2;
	private static ShapeRectangle shapeRect3;
	


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@Before
	public void setUp() throws Exception {
		Point2D.Double point = new Point2D.Double();
		point.setLocation(40, 40);
		
		shapeRect1 = new ShapeRectangle();
		shapeRect2 = new ShapeRectangle(50.0,50.0);
		shapeRect3 = new ShapeRectangle(50.0, 50.0, 10.0,
				10.0, 20.0, 
				20.0, 20.0, 
				30.0, 30.0, 
				Color.BLACK, Color.BLACK, point);
	}
	

	@Test
	public void testGetWidth() {
		assertEquals(shapeRect1.getWidth(), 0, 0);
		assertEquals(shapeRect2.getWidth(), 50, 2);
		assertEquals(shapeRect3.getWidth(), 50, 1);
	}
	
	@Test
	public void testSetWidth() {
		shapeRect1.setWidth(19);
		assertEquals(shapeRect1.getWidth(), 19,0);
	}

	@Test
	public void testGetHeight() {
		assertEquals(shapeRect1.getHeight(), 0, 0);
		assertEquals(shapeRect2.getHeight(), 50, 0);
		assertEquals(shapeRect3.getHeight(), 50, 0);
	}
	
	@Test
	public void testSetHeight() {
		shapeRect1.setHeight(12);
		assertEquals(shapeRect1.getHeight(), 12, 0);
	}

	@Test
	public void testGetArcWidth() {
		assertEquals(shapeRect1.getArcWidth(), 0, 0);
		assertEquals(shapeRect2.getArcWidth(), 00, 0);
		assertEquals(shapeRect3.getArcWidth(), 10, 0);
	}

	public void testSetArcWidth() {
		shapeRect1.setArcWidth(15);
		assertEquals(shapeRect1.getArcWidth(), 15, 0);
	}
	


	@Test
	public void testGetArcHeight() {
		assertEquals(shapeRect1.getArcHeight(), 0, 0);
		assertEquals(shapeRect2.getArcHeight(), 0, 0);
		assertEquals(shapeRect3.getArcHeight(), 10, 0);
	}
	
	@Test
	public void testSetArcHeight() {
		shapeRect1.setArcHeight(15);
		assertEquals(shapeRect1.getArcHeight(), 15, 0);
	}

	@Test
	public void testIsOriginalShape() {
		assertTrue(!shapeRect1.isOriginalShape());
		assertTrue(!shapeRect2.isOriginalShape());
		assertTrue(!shapeRect3.isOriginalShape());
	}

	@Test
	public void testGetPosition() {
		assertEquals(shapeRect1.getPosition().getX(), 5, 0);
		assertEquals(shapeRect1.getPosition().getY(), 20, 0);
		assertEquals(shapeRect2.getPosition().getX(), 5, 0);
		assertEquals(shapeRect2.getPosition().getY(), 20, 0);
		assertEquals(shapeRect3.getPosition().getX(), 40, 0);
		assertEquals(shapeRect3.getPosition().getY(), 40, 0);
		
	}
	
	@Test
	public void testSetPosition() {
		Point2D.Double point = new Point2D.Double(15, 30);
		shapeRect1.setPosition(point.getX(), point.getY());
		assertEquals(shapeRect1.getPosition().getX(), 15, 0);
		assertEquals(shapeRect1.getPosition().getY(), 30, 0);
	}

	@Test
	public void testGetFill() {
		assertEquals(shapeRect1.getFill().getRGB(), Color.BLUE.getRGB());
		assertEquals(shapeRect2.getFill().getRGB(), Color.BLUE.getRGB());
		assertEquals(shapeRect3.getFill().getRGB(), Color.BLACK.getRGB());
	}
	
	@Test
	public void testSetFill() {
		shapeRect1.setFill(Color.BLACK);
		assertEquals(shapeRect1.getFill().getRGB(), Color.BLACK.getRGB());
	}

	@Test
	public void testGetStroke() {
		assertEquals(shapeRect1.getStroke().getRGB(), Color.BLACK.getRGB());
		assertEquals(shapeRect2.getStroke().getRGB(), Color.BLACK.getRGB());
		assertEquals(shapeRect3.getStroke().getRGB(), Color.BLACK.getRGB());
	}
	
	@Test
	public void testSetStroke() {
		shapeRect1.setStroke(Color.WHITE);
		assertEquals(shapeRect1.getStroke().getRGB(), Color.WHITE.getRGB());
	}
	

	@Test
	public void testGetRotation() {
		assertEquals(shapeRect1.getRotation(), 0, 0);
		assertEquals(shapeRect2.getRotation(), 0, 0);
		assertEquals(shapeRect3.getRotation(), 20, 0);
	}
	
	@Test
	public void testSetRotation() {
		shapeRect1.setRotation(10);
		assertEquals(shapeRect1.getRotation(), 10 , 0);
	}

	@Test
	public void testGetRotationCenterX() {
		assertEquals(shapeRect1.getRotationCenterX(), 0, 0);
		assertEquals(shapeRect2.getRotationCenterX(), 0, 0);
		assertEquals(shapeRect3.getRotationCenterX(), 20, 0);
	}
	
	@Test
	public void testSetRotationCenterX() {
		shapeRect1.setRotationCenter(10, 10);
		assertEquals(shapeRect1.getRotationCenterX(), 10, 0);
	}

	@Test
	public void testGetRotationCenterY() {
		assertEquals(shapeRect1.getRotationCenterY(), 0, 0);
		assertEquals(shapeRect2.getRotationCenterY(), 0, 0);
		assertEquals(shapeRect3.getRotationCenterY(), 20, 0);
	}
	
	@Test
	public void testSetRotationCenterY() {
		shapeRect1.setRotationCenter(10, 10);
		assertEquals(shapeRect1.getRotationCenterY(), 10, 0);
	}

	@Test
	public void testGetTranslationX() {
		assertEquals(shapeRect1.getTranslationX(), 0, 0);
		assertEquals(shapeRect2.getTranslationX(), 0, 0);
		assertEquals(shapeRect3.getTranslationX(), 30, 0);
		}
	

	@Test
	public void testSetTranslationX() {
		shapeRect1.setTranslation(10, 10);
		assertEquals(shapeRect1.getTranslationX(), 10, 0);
	}
	

	@Test
	public void testGetTranslationY() {
		assertEquals(shapeRect1.getTranslationY(), 0, 0);
		assertEquals(shapeRect2.getTranslationY(), 0, 0);
		assertEquals(shapeRect3.getTranslationY(), 30, 0);
		}
	
	@Test
	public void testSetTranslationY() {
		shapeRect1.setTranslation(10, 10);
		assertEquals(shapeRect1.getTranslationY(), 10, 0);
	}
	
	
}
