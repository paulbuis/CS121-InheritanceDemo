package shapes;

public interface Shape {
	public boolean contains(Point p);
	public Box boundingBox();
}
