package org.acme.geometry;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PointTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor(){
		Point p = new Point();
		Assert.assertTrue(p.isEmpty());
		Assert.assertTrue(Double.isNaN(p.getCoordinate().getX()));
		Assert.assertTrue(Double.isNaN(p.getCoordinate().getY()));
	}
	
	@Test
	public void testConstructor(){
		Point p = SampleFactory.createPointM();
		Assert.assertEquals(1.0, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(-2.5, p.getCoordinate().getY(), EPSILON);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testNullConstructor(){
		thrown.expect(AssertionError.class);
		new Point(null);
	}
	
	@Test
	public void testType() {
		Point p = new Point();
		Assert.assertEquals("Point", p.getType());
	}
	
	@Test
	public void testIsEmpty() {
		Point p = SampleFactory.createPointM();
		Assert.assertFalse(p.isEmpty());
		p = SampleFactory.createPoint0();
		Assert.assertTrue(p.isEmpty());
	}
	
	@Test
	public void testTranslate() {
		Point p = SampleFactory.createPointM();
		p.translate(-0.7, 0.0);
		Assert.assertEquals(0.3, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(-2.5, p.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testEmptyTranslate() {
		Point p = SampleFactory.createPoint0();
		p.translate(-0.7, 0.0);
		Assert.assertTrue(p.isEmpty());
	}
	
	@Test
	public void testClone() {
		Point p = SampleFactory.createPointM();
		Geometry copy = p.clone();
		copy.translate(-0.7, 10.0);
		Assert.assertEquals(1.0, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(-2.5, p.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testGetEnvelope() {
		Point p = SampleFactory.createPointM();
		Envelope e = p.getEnvelope();
		Assert.assertEquals(1.0, e.getXmin(), EPSILON);
		Assert.assertEquals(-2.5, e.getYmin(), EPSILON);
		Assert.assertEquals(1.0, e.getXmax(), EPSILON);
		Assert.assertEquals(-2.5, e.getYmax(), EPSILON);
	}
}
