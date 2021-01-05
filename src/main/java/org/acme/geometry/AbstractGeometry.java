package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry{
	private List<GeometryListener> listeners = new ArrayList<GeometryListener>();;
	
	@Override
	public abstract Geometry clone();
	
	/**
	 * Stringify the geometry as WKT.
	 * @return The text describing the geometry.
	 */
	public String asText() {
		WktVisitor visitor = new WktVisitor();
		this.accept(visitor);
		return visitor.getResult();
	}
	
	/**
	 * Get the geometry bounding box.
	 * @return The bbox as an envelope.
	 */
	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		this.accept(builder);
		return builder.build();
	}
	
	public void addListener(GeometryListener listener) {
		this.listeners.add(listener);
	}
	
	/**
	 * Activate when the geometry is modified.
	 */
	protected void triggerChange() {
		for(int i=0; i < this.listeners.size(); i++) {
			listeners.get(i).onChange(this);
		}
	}
}
