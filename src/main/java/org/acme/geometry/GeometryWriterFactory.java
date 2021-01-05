package org.acme.geometry;

public class GeometryWriterFactory {

	public GeometryWriterFactory() {
		
	}
	
	public GeometryWriter createGeometryWriter(String name) {
		if(name.compareTo("WKT") == 0) {
			return new WktWriter();
		}
		else if(name.compareTo("GeoJSON") == 0) {
			return new GeoJSONWriter();
		}
		throw new RuntimeException("Format not supported");
	}
}
