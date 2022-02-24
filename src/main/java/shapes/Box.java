package shapes;

public class Box extends Polygon {
	private final int xMin;
	private final int xMax;
	private final int yMin;
	private final int yMax;

	public Box(Point upperLeft, Point lowerRight) {
		super(upperLeft,
				new Point(lowerRight.getX(), upperLeft.getY()),
				lowerRight,
				new Point(upperLeft.getX(), lowerRight.getY())
		    );
		if (upperLeft == null || lowerRight == null) {
			throw new IllegalArgumentException("null argument");
		}
		// TODO: if min is greater than max, swap min and max
		if (upperLeft.getX() < lowerRight.getX()) {
			xMin = upperLeft.getX();
			xMax = lowerRight.getX();
		} else {
			xMin = lowerRight.getX();
			xMax = upperLeft.getX();
		}
		if (lowerRight.getY() < upperLeft.getY()) {
			yMin = lowerRight.getY();
			yMax = upperLeft.getY();
		} else {
			yMin = upperLeft.getY();
			yMax = lowerRight.getY();
		}
	}
	
	public Box(int xMin, int yMax, int xMax, int yMin) {
		this(new Point(xMin, yMax), new Point(xMax, yMin));
	}
	
	public Box(Box otherBox) {
		this(otherBox.xMin, otherBox.yMax,
			 otherBox.xMax, otherBox.yMin);
	}
	
	@Override
	public String toString() {
		return String.format("Box(upperLeft:(%d, %d), lowerRight:(%d, %d)), width: %d, height: %d)",
				xMin, yMax, xMax, yMin, getWidth(), getHeight());
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof Box otherBox) {
			if (this == otherBox) {
				return true;
			}
			return xMin == otherBox.xMin &&
				   xMax == otherBox.xMax &&
				   yMin == otherBox.yMin &&
				   yMax == otherBox.yMax;
		}
		if (o instanceof Polygon otherPolygon) {
			return otherPolygon.equals(this);
		}
		return false;
	}

	@Override
	public boolean contains(Point p) {
		if (p == null) {
			return false;
		}
		final int x = p.getX();
		final int y = p.getY();
		return ((xMin <= x) && (x <= xMax) &&
				(yMin <= y) && (y <= yMax));
	}



	@Override
	public Box boundingBox() {
		return this;
	}

	@Override
	public final int sideCount() {
		return 4;
	}

	@Override
	public final Point getCorner(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("negative index");
		}

		if (index == 0) 
			return new Point(xMin, yMax);
		if (index == 1) 
			return new Point(xMax, yMax);
		if (index == 2) 
			return new Point(xMax, yMin);
		if (index == 3) 
			return new Point(xMin, yMin);


		throw new IllegalArgumentException("index > = 4");
	}
	
	public int getXMin() { return xMin; }
	public int getXMax() { return xMax; }
	public int getYMin() { return yMin; }
	public int getYMax() { return yMax; }
	public int getHeight() { return yMax - yMin; }
	public int getWidth() { return xMax - xMin; }
}
