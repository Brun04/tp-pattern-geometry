package org.acme.geometry;

public class GeoJSONWriter implements GeometryWriter{

	@Override
	public String getName() {
		return "GeoJSON";
	}

	@Override
	public String write(Geometry geom) {
		String buffer = "{\"type\": \"FeatureCollection\", \"features\": [";
		if ( geom instanceof Point ){
			Point point = (Point)geom;
			if(!point.isEmpty()) {
		    buffer += "{\"type\": \"Feature\",\"geometry\": { \"type\": \""+point.getType()+"\", \"coordinates\": ["
		    		+Double.toString(point.getCoordinate().getX()) +
		    		", "+Double.toString(point.getCoordinate().getY())+"]}}]}";
		    }
		}else if ( geom instanceof LineString ){
		    LineString lineString = (LineString)geom;
		    if(!lineString.isEmpty()) {
		    	buffer += "{\"type\": \"Feature\",\"geometry\": { \"type\": \""+lineString.getType()+"\", \"coordinates\": [";
		    	for(int i=0; i < lineString.getNumPoints(); i++) {
		    		Point p = lineString.getPointN(i);
    				buffer += "["+Double.toString(p.getCoordinate().getX()) +
	    			", "+Double.toString(p.getCoordinate().getY())+"]";
    				if(i != lineString.getNumPoints() - 1) {
    					buffer += ",";
    				}
		    	}
		    	buffer += "]}}]}";
		    }
		}else{
		    throw new RuntimeException("Geometry type not supported");
		}
		return buffer;
	}

}
