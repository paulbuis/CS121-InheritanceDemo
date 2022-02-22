package shapes;

/*
 * Point is an immutable class!
 */
public final class Point {
	private final int x;
	private final int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
		this(p.x, p.y);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
	    if (o instanceof Point otherPoint) {
	    	if (this == otherPoint) {
	    		return true;
	    	}
			return otherPoint.x == x && otherPoint.y == y;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
