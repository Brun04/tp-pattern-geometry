package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor(){
		Coordinate c = new Coordinate();
		Assert.assertTrue(c.isEmpty());
	}
	
	@Test
	public void testConstructor(){
		Coordinate c = new Coordinate(1.0, -5.2);
		Assert.assertEquals(1.0, c.getX(), EPSILON);
		Assert.assertEquals(-5.2, c.getY(), EPSILON);
	}

}
