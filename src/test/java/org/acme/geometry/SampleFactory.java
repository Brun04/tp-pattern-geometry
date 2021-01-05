package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class SampleFactory {

	private SampleFactory() {
		
	}
	
	public static Point createPoint0() {
		return new Point();
	}
	
	public static Point createPointM() {
		return new Point(new Coordinate(1.0, -2.5));
	}
	
	public static Point createPointN() {
		return new Point(new Coordinate(0.0, 3.0));
	}
	
	public static LineString createLineString0M() {
		List<Point> points = new ArrayList<Point>();
		points.add(createPointM());
		points.add(createPoint0());
		return new LineString(points);
	}
	
	public static LineString createLineStringM0N() {
		List<Point> points = new ArrayList<Point>();
		points.add(createPointM());
		points.add(createPoint0());
		points.add(createPointN());
		return new LineString(points);
	}
	
	public static LineString createLineStringMN() {
		List<Point> points = new ArrayList<Point>();
		points.add(createPointM());
		points.add(createPointN());
		return new LineString(points);
	}
	
	
	public static Envelope createEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(new Coordinate(0.0, 1.0));
		builder.insert(new Coordinate(2.0, 0.0));
		builder.insert(new Coordinate(1.0, 3.0));
		builder.insert(new Coordinate(1.0, 4.0));
		builder.insert(new Coordinate(2.0, 2.0));
		builder.insert(new Coordinate(-1.0, -0.5));
		builder.insert(new Coordinate(5.0, 6.0));
		return builder.build();
	}
	
	
	public static GeometryCollection createGeometryColl() {
		List<Geometry> geom = new ArrayList<>();
		geom.add(createLineStringMN());
		geom.add(new Point(new Coordinate(1.0, 2.0)));
		geom.add(new Point(new Coordinate(0.5, 1.0)));
		return new GeometryCollection(geom);
	}
}
