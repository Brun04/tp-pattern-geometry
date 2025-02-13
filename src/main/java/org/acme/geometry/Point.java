package org.acme.geometry;

public class Point extends AbstractGeometry{
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
		return "Point";
	}
	
	public boolean isEmpty() {
		return this.coordinate.isEmpty();
	}
	
	public void translate(double dx, double dy) {
		this.coordinate = new Coordinate(this.coordinate.getX() + dx, this.coordinate.getY() + dy);
		this.triggerChange();
	}
	
	@Override
	public Geometry clone() {
		return new Point(this.coordinate);
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
}
