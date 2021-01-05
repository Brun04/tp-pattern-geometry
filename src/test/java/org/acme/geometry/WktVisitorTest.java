package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {

	@Test
	public void testVisitPoint() {
		//WktVisitor visitor = new WktVisitor();
		AbstractGeometry g = new Point(new Coordinate(3.0,4.0));
		//g.accept(visitor);
		Assert.assertEquals("POINT(3.0 4.0)", g.asText());
	}
	
	@Test
	public void testVisitEmptyPoint() {
		AbstractGeometry g = new Point();
		Assert.assertEquals("POINT EMPTY", g.asText());
	}
	
	@Test
	public void testWriteLineString() {
		AbstractGeometry g = SampleFactory.createLineStringMN();
		Assert.assertEquals("LINESTRING(1.0 -2.5,0.0 3.0)", g.asText());
	}
	
	@Test
	public void testWriteEmptyLineString() {
		AbstractGeometry g = new LineString();
		Assert.assertEquals("LINESTRING EMPTY", g.asText());
	}
	
	@Test
	public void testWriteGeometryCollection() {
		AbstractGeometry g = SampleFactory.createGeometryColl();
		Assert.assertEquals("GEOMETRYCOLLECTION(LINESTRING(1.0 -2.5,0.0 3.0),POINT(1.0 2.0),POINT(0.5 1.0))", g.asText());
	}
	
	
	@Test
	public void testWriteEmptyGeometryCollection() {
		AbstractGeometry g = new GeometryCollection();
		Assert.assertEquals("GEOMETRYCOLLECTION EMPTY", g.asText());
	}
}
