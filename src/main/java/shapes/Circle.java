package shapes;

public class Circle implements Shape {
	private final Point center;
	private final int radius;
	
	public Circle(Point center, int radius) {
		this.center = center;
		
		if (radius < 0) {
			throw new IllegalArgumentException("negative radius");
		}
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return String.format("Circle(center:%s, radius:%d)", center.toString(), radius);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Circle otherCircle) {
			return center.equals(otherCircle.center) &&
					radius == otherCircle.radius;
		}
		return false;
		
	}
	
	@Override
	public boolean contains(Point p) {
		int x = p.getX() - center.getX();
		int y = p.getY() - center.getY();
		return x*x + y*y <= radius*radius;
	}
	
	// contains(int, int) overloads contain(Point)
	public boolean contains(int x, int y ) {
		Point p = new Point(x, y);
		return this.contains(p);
	}
	

	public Box boundingBox() {
		Point upperLeft = new Point(center.getX()-radius, center.getY()+radius);
		Point lowerRight = new Point(center.getX()+radius, center.getY()-radius);
		return new Box(upperLeft, lowerRight);
	}
	
	public Point getCenter() {
		return center;
	}
	
	public int getRadius() {
		return radius;
	}
}
