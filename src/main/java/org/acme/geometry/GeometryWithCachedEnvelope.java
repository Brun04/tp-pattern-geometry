package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry, GeometryListener{
	private Geometry original;
	private Envelope cachedBbox;
	
	public GeometryWithCachedEnvelope(Geometry original) {
		this.original = original;
		this.original.addListener(this);
	}

	@Override
	public String getType() {
		return this.original.getType();
	}

	@Override
	public boolean isEmpty() {
		return this.original.isEmpty();
	}

	@Override
	public void translate(double dx, double dy) {
		this.original.translate(dx, dy);
	}

	@Override
	public Geometry clone() {
		return this.original.clone();
	}

	@Override
	public Envelope getEnvelope() {
		if(this.cachedBbox == null) {
			this.cachedBbox = this.original.getEnvelope();
			
		}
		return this.cachedBbox;
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		this.original.accept(visitor);
	}

	@Override
	public void addListener(GeometryListener listener) {
		this.original.addListener(listener);
	}

	@Override
	public void onChange(Geometry geometry) {
		this.cachedBbox = geometry.getEnvelope();
	}
	
	@Override
	public String asText() {
		return this.original.asText();
	}
}
