package org.acme.geometry;

public class WktWriter {

	
	public String write(Geometry geom) {
		String wkt = "";
		if ( geom instanceof Point ){
		    Point point = (Point)geom;
		    wkt += point.getType().toUpperCase();
		    if(point.isEmpty()) {
		    	wkt += " EMPTY";
		    }else {
		    	wkt += "("+Double.toString(point.getCoordinate().getX()) +
		    			" "+Double.toString(point.getCoordinate().getY())+")";
		    }
		}else if ( geom instanceof LineString ){
		    LineString lineString = (LineString)geom;
		    wkt += lineString.getType().toUpperCase();
		    if(lineString.isEmpty()) {
		    	wkt += " EMPTY";
		    }else {
		    	wkt += "(";
		    	for(int i=0; i < lineString.getNumPoints(); i++) {
		    		Point p = lineString.getPointN(i);
    				wkt += Double.toString(p.getCoordinate().getX()) +
	    			" "+Double.toString(p.getCoordinate().getY());
    				if(i != lineString.getNumPoints() - 1) {
    					wkt += ",";
    				}
		    	}
		    	wkt += ")";
		    }
		}else{
		    throw new RuntimeException("Geometry type not supported");
		}
		
		return wkt;
	}
}
