package org.acme.geometry;

public class EnvelopeBuilder implements GeometryVisitor {
	private Envelope bbox;
	
	
	public EnvelopeBuilder() {
		this.bbox = new Envelope();
	}
	
	public void insert(Coordinate coordinate) {
		assert(coordinate != null);
		if(this.bbox.isEmpty()) {
			this.bbox = new Envelope(coordinate, coordinate);
		}else {
			if(coordinate.getX() < this.bbox.getXmin() && coordinate.getY() < this.bbox.getYmin()) {
				this.bbox = new Envelope(coordinate, new Coordinate(this.bbox.getXmax(), this.bbox.getYmax()));
			}
			if(coordinate.getX() < this.bbox.getXmin() && coordinate.getY() > this.bbox.getYmin()) {
				this.bbox = new Envelope(new Coordinate(coordinate.getX(), this.bbox.getYmin()), new Coordinate(this.bbox.getXmax(), this.bbox.getYmax()));
			}
			if(coordinate.getX() > this.bbox.getXmin() && coordinate.getY() < this.bbox.getYmin()) {
				this.bbox = new Envelope(new Coordinate(this.bbox.getXmin(), coordinate.getY()), new Coordinate(this.bbox.getXmax(), this.bbox.getYmax()));
			}
			
			if(coordinate.getX() > this.bbox.getXmax() && coordinate.getY() > this.bbox.getYmax()) {
				this.bbox = new Envelope(new Coordinate(this.bbox.getXmin(), this.bbox.getYmin()), coordinate);
			}
			if(coordinate.getX() > this.bbox.getXmax() && coordinate.getY() < this.bbox.getYmax()) {
				this.bbox = new Envelope(new Coordinate(this.bbox.getXmin(), this.bbox.getYmin()), new Coordinate(coordinate.getX(), this.bbox.getYmax()));
			}
			if(coordinate.getX() < this.bbox.getXmax() && coordinate.getY() > this.bbox.getYmax()) {
				this.bbox = new Envelope(new Coordinate(this.bbox.getXmin(), this.bbox.getYmin()), new Coordinate(this.bbox.getXmax(), coordinate.getY()));
			}
		}
	}
	
	public Envelope build() {
		return this.bbox;
	}

	@Override
	public void visit(Point point) {
		this.insert(point.getCoordinate());
		
	}

	@Override
	public void visit(LineString lineString) {
		for(int i=0; i < lineString.getNumPoints(); i++) {
			this.insert(lineString.getPointN(i).getCoordinate());
		}
	}
}
