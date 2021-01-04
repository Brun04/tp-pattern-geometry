package org.acme.geometry;

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
		LineString l = SampleFactory.createLineString();
		Assert.assertEquals(2, l.getNumPoints());
		Assert.assertEquals(1.0, l.getPointN(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(-2.5, l.getPointN(0).getCoordinate().getY(), EPSILON);
		Assert.assertTrue(l.getPointN(1).isEmpty());
	}
	
	@Test
	public void testType() {
		LineString l = new LineString();
		Assert.assertEquals("linestring", l.getType());
	}
	
	
	@Test
	public void testClone() {
		LineString l = SampleFactory.createLineString();
		Geometry copy = l.clone();
		copy.translate(-0.7, 10.0);
		Assert.assertEquals(1.0, l.getPointN(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(-2.5, l.getPointN(0).getCoordinate().getY(), EPSILON);
	}
}
