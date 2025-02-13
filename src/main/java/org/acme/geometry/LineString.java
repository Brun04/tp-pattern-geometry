package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry{
	private List<Point> points;
	
	public LineString() {
		this.points = new ArrayList<Point>();
	}
	
	public LineString(List<Point> points) {
		assert(points != null);
		this.points = points;
	}
	
	public int getNumPoints() {
		return this.points.size();
	}
	
	public Point getPointN(int n) {
		return this.points.get(n);
	}
	
	public String getType() {
		return "LineString";
	}
	
	public boolean isEmpty() {
		return this.points.size() == 0;
	}
	
	public void translate(double dx, double dy) {
		for(int i=0; i < this.points.size(); i++) {
			this.points.get(i).translate(dx, dy);
		}
	}
	
	@Override
	public Geometry clone() {
		List<Point> pointsC = new ArrayList<Point>();
		for(int i=0; i < this.points.size(); i++) {
			pointsC.add((Point)this.points.get(i).clone());
		}
		return new LineString(pointsC);
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
}
