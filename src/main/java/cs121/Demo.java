package cs121;

import shapes.*;

public class Demo {

	public static Shape f(Shape s) {
		if (s instanceof Box b)
			return b;
		return new Box(0,1,1,0);
	}
	
	public static void main(String[] args) {
		Box box = new Box(new Point(0,10), new Point(10,0));
		Circle circle = new Circle(new Point(0,0), 10);
		Shape shape = circle;

		if (shape instanceof Circle) {
			Circle circle1 = (Circle)shape;
			System.out.println(circle1.getRadius());
		}
		System.out.println(shape);
		Box oops = (Box)shape;
		System.out.println(oops);

		f(box);
		f(shape);
		
		//SpecialBox special = null;
		//special.getCorner(0);
		
		//Union union = new Union(box, circle);
		
		

	}

}
