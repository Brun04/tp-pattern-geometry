package org.acme.geometry;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GeometryCollectionTest {

	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		GeometryCollection geomC = new GeometryCollection();
		Assert.assertTrue(geomC.isEmpty());
		Assert.assertEquals(0, geomC.getNumGeometries());
	}
	
	@Test
	public void testConstructor() {
		GeometryCollection geomC = SampleFactory.createGeometryColl();
		Assert.assertEquals(3, geomC.getNumGeometries());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testNullConstructor() {
		thrown.expect(AssertionError.class);
		new GeometryCollection(null);
	}
	
	@Test
	public void testGetGeometryN() {
		GeometryCollection geomC = SampleFactory.createGeometryColl();
		AbstractGeometry g = (AbstractGeometry)geomC.getGeometryN(1);
		Assert.assertEquals("POINT(1.0 2.0)", g.asText());
	}
	
	@Test
	public void testGetGeometryNOutOfSize() {
		GeometryCollection geomC = SampleFactory.createGeometryColl();
		AbstractGeometry g = (AbstractGeometry)geomC.getGeometryN(5);
		Assert.assertNull(g);
	}
	
	@Test
	public void testType() {
		GeometryCollection geomC = SampleFactory.createGeometryColl();
		Assert.assertEquals("GeometryCollection", geomC.getType());
	}
	
	@Test
	public void testTranslate() {
		GeometryCollection geomC = SampleFactory.createGeometryColl();
		geomC.translate(1.0, 5.0);
		Assert.assertEquals("GEOMETRYCOLLECTION(LINESTRING(2.0 2.5,1.0 8.0),POINT(2.0 7.0),POINT(1.5 6.0))", ((AbstractGeometry)geomC).asText());
	}
	
	@Test
	public void testGetEnvelope() {
		AbstractGeometry geomC = (AbstractGeometry)SampleFactory.createGeometryColl();
		Envelope e = geomC.getEnvelope();
		Assert.assertEquals(0.0, e.getXmin(), EPSILON);
		Assert.assertEquals(-2.5, e.getYmin(), EPSILON);
		Assert.assertEquals(1.0, e.getXmax(), EPSILON);
		Assert.assertEquals(3.0, e.getYmax(), EPSILON);
	}
	
	@Test
	public void testClone() {
		GeometryCollection geomC = SampleFactory.createGeometryColl();
		Geometry copy = geomC.clone();
		copy.translate(1.0, 3.0);
		Assert.assertEquals(1.0,  ((Point)geomC.getGeometryN(1)).getCoordinate().getX(),EPSILON);
		Assert.assertEquals(2.0,  ((Point)geomC.getGeometryN(1)).getCoordinate().getY(),EPSILON);
	}
}
