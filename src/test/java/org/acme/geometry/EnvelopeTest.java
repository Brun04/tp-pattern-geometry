package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {

	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testBuilder() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(new Coordinate(0.0,1.0));
		builder.insert(new Coordinate(2.0,0.0));
		builder.insert(new Coordinate(1.0,3.0));
		Envelope result = builder.build();
		
		Assert.assertEquals(0.0, result.getXmin(), EPSILON);
		Assert.assertEquals(0.0, result.getYmin(), EPSILON);
		Assert.assertEquals(2.0, result.getXmax(), EPSILON);
		Assert.assertEquals(3.0, result.getYmax(), EPSILON);	
	}

}
