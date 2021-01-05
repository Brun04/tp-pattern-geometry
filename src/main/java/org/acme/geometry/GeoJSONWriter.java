package org.acme.geometry;

public class GeoJSONWriter implements GeometryWriter{

	@Override
	public String getName() {
		return "GeoJSON";
	}
	
	private String writePoint(Point point) {
		String buff = "";
		if(!point.isEmpty()) {
		    buff += "{\"type\": \"Feature\",\"geometry\": { \"type\": \""+point.getType()+"\", \"coordinates\": ["
		    		+Double.toString(point.getCoordinate().getX()) +
		    		", "+Double.toString(point.getCoordinate().getY())+"]}}";
	    }
		buff += "]}";
		return buff;
	}
	
	private String writeLineString(LineString lineString) {
		String buff = "";
		if(!lineString.isEmpty()) {
			buff += "{\"type\": \"Feature\",\"geometry\": { \"type\": \""+lineString.getType()+"\", \"coordinates\": [";
	    	for(int i=0; i < lineString.getNumPoints(); i++) {
	    		Point p = lineString.getPointN(i);
	    		buff += "["+Double.toString(p.getCoordinate().getX()) +
    			", "+Double.toString(p.getCoordinate().getY())+"]";
				if(i != lineString.getNumPoints() - 1) {
					buff += ",";
				}
	    	}
	    	buff += "]}}";
	    }
		buff += "]}";
		return buff;
	}

	@Override
	public String write(Geometry geom) {
		String buffer = "{\"type\": \"FeatureCollection\", \"features\": [";
		if ( geom instanceof Point ){
			Point point = (Point)geom;
			buffer += this.writePoint(point);
		}else if ( geom instanceof LineString ){
		    LineString lineString = (LineString)geom;
		    buffer += this.writeLineString(lineString);
		}else{
		    throw new RuntimeException("Geometry type not supported");
		}
		return buffer;
	}
	
	

}
