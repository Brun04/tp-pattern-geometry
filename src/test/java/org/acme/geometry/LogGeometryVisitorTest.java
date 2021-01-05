package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class LogGeometryVisitorTest {
	
	@Test
	public void testVisitPoint() {
		String wanted = "I am a point with x=3.0 and y=4.0";
		ByteArrayOutputStream outStr = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outStr);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		geometry.accept(visitor);
		Assert.assertEquals(wanted, outStr.toString());
	}
	
	@Test
	public void testVisitLineString() {
		String wanted = "I am a linestring defined by 3 point(s)"; 
		ByteArrayOutputStream outStr = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outStr);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		Geometry geometry = SampleFactory.createLineStringM0N();
		geometry.accept(visitor);
		Assert.assertEquals(wanted, outStr.toString());
	}
}
