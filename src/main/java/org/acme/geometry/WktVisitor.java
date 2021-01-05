package org.acme.geometry;

public class WktVisitor implements GeometryVisitor{
	private String bufferString;
	
	public void visit(Point point) {
		this.bufferString = point.getType().toUpperCase();
	    if(point.isEmpty()) {
	    	this.bufferString += " EMPTY";
	    }else {
	    	this.bufferString += "("+Double.toString(point.getCoordinate().getX()) +
	    			" "+Double.toString(point.getCoordinate().getY())+")";
	    }
	}
	
	public void visit(LineString lineString) {
		this.bufferString = lineString.getType().toUpperCase();
	    if(lineString.isEmpty()) {
	    	this.bufferString += " EMPTY";
	    }else {
	    	this.bufferString += "(";
	    	for(int i=0; i < lineString.getNumPoints(); i++) {
	    		Point p = lineString.getPointN(i);
	    		this.bufferString += Double.toString(p.getCoordinate().getX()) +
    			" "+Double.toString(p.getCoordinate().getY());
				if(i != lineString.getNumPoints() - 1) {
					this.bufferString += ",";
				}
	    	}
	    	this.bufferString += ")";
	    }
	}
	
	public void visit(GeometryCollection geomC) {
		this.bufferString = geomC.getType().toUpperCase();
		if(geomC.isEmpty()) {
	    	this.bufferString += " EMPTY";
	    }else {
	    	this.bufferString += "(";
			for(int i=0; i < geomC.getNumGeometries(); i++) {
				AbstractGeometry g = (AbstractGeometry)geomC.getGeometryN(i);
				this.bufferString += g.asText();
				if(i != geomC.getNumGeometries()-1) {
					this.bufferString += ",";
				}
			}
			this.bufferString += ")";
	    }
	}
	
	public String getResult() {
		return this.bufferString;
	}
}
