package org.acme.geometry;

public class LogGeometryVisitor implements GeometryVisitor{

	public void visit(Point point) {
		System.out.println("I'am a "+point.getType()+" with x="+
				Double.toString(point.getCoordinate().getX())+" and y="+
				Double.toString(point.getCoordinate().getY()));
	}
	
	public void visit(LineString lineString) {
		System.out.println("I'am a "+lineString.getType()+" defined by "+
				Integer.toString(lineString.getNumPoints())+" point(s)");
	}
}
