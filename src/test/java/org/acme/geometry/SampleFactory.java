package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class SampleFactory {

	
	public static Point createPoint0() {
		return new Point();
	}
	
	public static Point createPointM() {
		return new Point(new Coordinate(1.0, -2.5));
	}
	
	public static LineString createLineString() {
		List<Point> points = new ArrayList<Point>();
		points.add(createPointM());
		points.add(createPoint0());
		return new LineString(points);
	}
}
