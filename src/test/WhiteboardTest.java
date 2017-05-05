package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.IShape;
import model.ShapeRectangle;
import model.ShapeRegularPolygon;
import model.Whiteboard;

public class WhiteboardTest {
	Whiteboard wb;
	IShape is1, is2;
	

	@Before
	public void setUp() throws Exception {
		wb = new Whiteboard();
		is1 = new ShapeRectangle();
		is2 = new ShapeRegularPolygon(5, 10);
	}

	@Test
	public void testAdd() {
		wb.add(is1);
		assertTrue(wb.containsShape(is1));
		assertEquals(wb.getListShapes().size(), 1);
		wb.add(is2);
		assertTrue(wb.containsShape(is2));
		assertEquals(wb.getListShapes().size(), 2);
	}

	@Test
	public void testRemove() {
		int size = wb.getListShapes().size();
		wb.remove(is1);
		assertEquals(wb.getListShapes().size(), size);
		wb.add(is1);
		wb.add(is2);
		wb.remove(is1);
		assertEquals(wb.getListShapes().size(), 1);
		wb.remove(is1);
		assertEquals(wb.getListShapes().size(), 1);
	}

	@Test
	public void testGetListShapes() {
		assertTrue( wb.getListShapes() instanceof List);
		assertTrue(wb.getListShapes().size() == 0);
	}

	@Test
	public void testContainsShape() {
		assertTrue(!wb.containsShape(is1));
		wb.add(is1);
		assertTrue(wb.containsShape(is1));
	}

	@Test
	public void testIsShapeIn() {
		is1.setPosition(5000, 5000);
		assertTrue(!wb.isShapeIn(is1));
		is1.setPosition(150, 150);
		assertTrue(wb.isShapeIn(is1));
	}

	@Test
	public void testGetShapeBackInTheWhiteboard() {
		is1.setPosition(5000, 5000);
		wb.getShapeBackInTheWhiteboard(is1);
		assertTrue(wb.isShapeIn(is1));
		is1.setPosition(-2000, -2000);
		wb.getShapeBackInTheWhiteboard(is1);
		is1.setPosition(-2000, -2000);
	}

}
