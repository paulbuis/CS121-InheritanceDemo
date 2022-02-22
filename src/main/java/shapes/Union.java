package shapes;

public class Union implements Shape {
	private final Shape shape1;
	private final Shape shape2;
	
	public Union(Shape shape1, Shape shape2) {
		this.shape1 = shape1;
		this.shape2 = shape2;
	}
	
	@Override
	public boolean contains(Point p) {
		return shape1.contains(p)  || shape2.contains(p);
	}

	@Override
	public Box boundingBox() {
		final Box box1 = shape1.boundingBox();
		final Box box2 = shape2.boundingBox();
		
		int xMin = Math.min(box1.getXMin(), box2.getXMin());
		int xMax = Math.max(box1.getXMax(), box2.getXMax());
		int yMin = Math.min(box1.getYMin(), box2.getYMin());
		int yMax = Math.max(box1.getYMax(), box2.getYMax());

		return new Box(xMin, yMax, xMax, yMin);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o == this) {
			return true;
		}
		if (o instanceof Union otherUnion) {
			return ((shape1.equals(otherUnion.shape1) && shape2.equals(otherUnion.shape2)) ||
				    (shape2.equals(otherUnion.shape1) && shape1.equals(otherUnion.shape2)));
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("Union(%s, %s)", shape1.toString(), shape2.toString());
	}

}
