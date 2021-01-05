package org.acme.geometry;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EnvelopeTest {

	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		Envelope result = builder.build();
		Assert.assertTrue(result.isEmpty());
	}
	
	@Rule
	public ExpectedException nullExpected = ExpectedException.none();
	
	@Test
	public void testNullCoordinateConstructor() {
		nullExpected.expect(AssertionError.class);
		new Envelope(new Coordinate(1.0, 2.0), null);
	}
	
	@Test
	public void testInsertHappyCases() {
		Envelope e = SampleFactory.createEnvelope();
		Assert.assertEquals(-1.0, e.getXmin(), EPSILON);
		Assert.assertEquals(-0.5, e.getYmin(), EPSILON);
		Assert.assertEquals(5.0, e.getXmax(), EPSILON);
		Assert.assertEquals(6.0, e.getYmax(), EPSILON);	
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testNullInsertCases() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		thrown.expect(AssertionError.class);
		builder.insert(null);	
	}

}
