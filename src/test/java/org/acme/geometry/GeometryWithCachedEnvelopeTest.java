package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;


public class GeometryWithCachedEnvelopeTest {
	
	@Test
	public void testGetEnvelope() {
		Geometry g = SampleFactory.createPointM();
		g = new GeometryWithCachedEnvelope(g);
		Envelope a = g.getEnvelope();
		Envelope b = g.getEnvelope();
		Assert.assertSame(a, b);
	}
	
	@Test
	public void testType() {
		Geometry g = SampleFactory.createPointM();
		g = new GeometryWithCachedEnvelope(g);
		Assert.assertEquals("point", g.getType());
	}
	
	@Test
	public void testIsEmpty() {
		Geometry g = SampleFactory.createPoint0();
		g = new GeometryWithCachedEnvelope(g);
		Assert.assertTrue(g.isEmpty());
	}
}
