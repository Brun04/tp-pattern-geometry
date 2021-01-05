package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeoJSONWriterTest {

	@Test
	public void testGetName() {
		GeometryWriter gW = new GeoJSONWriter();
		Assert.assertEquals("GeoJSON", gW.getName());
	}
	
	@Test
	public void testWrite() {
		Geometry g = SampleFactory.createLineStringMN();
		GeometryWriter writer = new GeoJSONWriter();
		Assert.assertEquals("{\"type\": \"FeatureCollection\", \"features\": [{\"type\": \"Feature\",\"geometry\": { \"type\": "
				+ "\"LineString\", \"coordinates\": [[1.0, -2.5],[0.0, 3.0]]}}]}", writer.write(g));
	}
}
