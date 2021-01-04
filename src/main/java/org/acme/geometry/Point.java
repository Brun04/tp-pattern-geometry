package org.acme.geometry;

public class Point implements Geometry{
	private Coordinate coordinate;
	
	public Point() {
		this.coordinate = new Coordinate();
	}
	
	public Point(Coordinate coordinate) {
		assert(coordinate != null);
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}

	public String getType() {
		return "point";
	}
	
	public boolean isEmpty() {
		return this.coordinate.isEmpty();
	}
	
	public void translate(double dx, double dy) {
		this.coordinate = new Coordinate(this.coordinate.getX() + dx, this.coordinate.getY() + dy);
	}
	
	public Geometry clone() {
		return new Point(this.coordinate);
	}
	
	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(this.coordinate);
		return builder.build();
	}
}
