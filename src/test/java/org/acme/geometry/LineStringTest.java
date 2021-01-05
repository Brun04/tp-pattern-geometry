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
		LineString l = SampleFactory.createLineString0M();
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
	public void testIsEmpty() {
		LineString l = new LineString();
		Assert.assertTrue(l.isEmpty());
		Assert.assertFalse(SampleFactory.createLineStringM0N().isEmpty());
	}
	
	
	@Test
	public void testClone() {
		LineString l = SampleFactory.createLineString0M();
		Geometry copy = l.clone();
		copy.translate(-0.7, 10.0);
		Assert.assertEquals(1.0, l.getPointN(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(-2.5, l.getPointN(0).getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testGetEnvelope() {
		LineString l = SampleFactory.createLineStringM0N();
		Envelope e = l.getEnvelope();
		Assert.assertEquals(0.0, e.getXmin(), EPSILON);
		Assert.assertEquals(-2.5, e.getYmin(), EPSILON);
		Assert.assertEquals(1.0, e.getXmax(), EPSILON);
		Assert.assertEquals(3.0, e.getYmax(), EPSILON);
	}
}
