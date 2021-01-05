package org.acme.geometry;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GeometryWriterTest {
	
	@Test
	public void testWktWriterWithFactory() {
		Geometry g = new Point(new Coordinate(3.0,4.0));
		GeometryWriterFactory writerFactory = new GeometryWriterFactory();
		String formatName = "WKT";
		GeometryWriter writer = writerFactory.createGeometryWriter(formatName);
		Assert.assertEquals("POINT(3.0 4.0)", writer.write(g));
	}
	
	@Test
	public void testGeoJSONWriterWithFactory() {
		Geometry g = new Point(new Coordinate(3.0,4.0));
		GeometryWriterFactory writerFactory = new GeometryWriterFactory();
		String formatName = "GeoJSON";
		GeometryWriter writer = writerFactory.createGeometryWriter(formatName);
		Assert.assertEquals("{\"type\": \"FeatureCollection\", \"features\": [{\"type\": \"Feature\",\"geometry\": { \"type\": "
				+ "\"Point\", \"coordinates\": [3.0, 4.0]}}]}", writer.write(g));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testUnsupportedFormat() {
		GeometryWriterFactory writerFactory = new GeometryWriterFactory();
		String formatName = "SHP";
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Format not supported");
		writerFactory.createGeometryWriter(formatName);
	}
}
