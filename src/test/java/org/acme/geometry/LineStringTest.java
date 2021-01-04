package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {

	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor(){
		LineString l = new LineString();
		Assert.assertEquals(0, l.getNumPoints());
	}
	
	@Test
	public void testConstructor(){
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(new Coordinate(1.0, -2.5)));
		points.add(new Point());
		LineString l = new LineString(points);
		Assert.assertEquals(2, l.getNumPoints());
		// contents
		Assert.assertEquals(1.0, l.getPointN(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(-2.5, l.getPointN(0).getCoordinate().getY(), EPSILON);
		Assert.assertTrue(l.getPointN(1).isEmpty());
	}
	
	@Test
	public void testType() {
		LineString l = new LineString();
		Assert.assertEquals("linestring", l.getType());
	}
}
