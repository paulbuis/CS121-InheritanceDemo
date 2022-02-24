package cs121;

import shapes.*;

public class ShapeTest {

	static void checkTest(boolean testPassed, String message) {
		if (!testPassed) {
			System.err.println("TEST FAILED: " + message);
		}
	}
	
	public static void main(String[] args) {		
		Point origin = new Point(0, 0);
		System.out.println("origin: " + origin);
		Point farPoint = new Point(100, 100);
		System.out.println("farPoint: " + farPoint);
		
		Box box1 = new Box(new Point(-10, 10), new Point(10, -10));
		System.out.println("box1: " + box1);
		checkTest(box1.equals(box1),"box1.equals(box1)");

		Circle circle1 = new Circle(new Point(1, 2), 3);
		System.out.println("circle1: " + circle1);
		checkTest(!box1.equals(circle1),"!box1.equals(circle1)");
		
		Box box2 = new Box(new Point(-2, 5), new Point(4, -1));
		System.out.println("box2: " + box2);
		checkTest(!box1.equals(box2),"!box1.equals(box2)");

		Polygon poly0 = box1; // a Box is-a Polygon!
		System.out.println("poly0: " + poly0);
		
		int[] px = {-10, 10, 10, -10};
		int[] py = {10, 10, -10, -10};
		Polygon poly1 = new Polygon(px, py);
		System.out.println("poly1: " + poly1);
		System.out.println("poly1.boundingBox(): " + poly1.boundingBox());
		Box poly1Bound = new Box(-10, 10, 10, -10);
		checkTest(poly1.boundingBox().equals(poly1Bound), "poly1.boundingBox().equals(poly1Bound)");

		int[] starX = {  0, -59, 95, -95,  59};
		int[] starY = {100, -81, 31,  31, -81};
		Polygon polyStar = new Polygon(starX, starY);
		System.out.println("polyStar: " + polyStar);
		System.out.println("polyStar.boundingBox(): " + polyStar.boundingBox());
		Box polyStarBound = new Box(-95, 100, 95, -81);
		checkTest(polyStar.boundingBox().equals(polyStarBound), "polyStar.boundingBox().equals(polyStarBound)");

		checkTest(origin.equals(origin), "origin.equals(origin)");
		checkTest(!origin.equals(farPoint), "!origin.equals(farPoint)");
		checkTest(!origin.equals(box1), "!origin.equals(box1)");
		
		checkTest(box1.contains(origin), "box1.contains(origin)");
		checkTest(!box1.contains(farPoint), "!box1.contains(farPoint)");
		checkTest(box1.boundingBox().equals(box1), "box1.boundingBox().equals(box1)");
		
		checkTest(box2.contains(origin), "box2.contains(origin)");
		checkTest(circle1.contains(origin), "circle1.contains(origin)");
		checkTest(!circle1.contains(farPoint), "!circle1.contains(farPoint)");
		checkTest(circle1.boundingBox().equals(box2), "circle1.boundingBox().equals(box2)");

		checkTest(poly1.contains(origin), "poly1.contains(origin)");
		checkTest(!poly1.contains(farPoint), "!poly1.contains(farPoint)");
		checkTest(poly1.boundingBox().equals(box1), "poly1.boundingBox().equals(box1)");
		checkTest(poly1.boundingBox().equals(box1), "box1.boundingBox().equals(box1)");
		checkTest(poly1.equals(box1), "poly1.equals(box1)");
		
		Point testPoint = new Point(4, 98);
		checkTest(!polyStar.contains(farPoint), "!polyStar.contains(farPoint)");
		checkTest(!polyStar.contains(testPoint), "!polyStar.contains( "+ testPoint + " )");
	
		System.out.println("\nTesting Unions");
		System.out.println("==============");
		System.out.println("box1: " + box1);
		Circle unionCircle1 = new Circle(new Point(0, 10), 10);
		Circle unionCircle2 = new Circle(new Point(0, 10), 10);
		System.out.println("unionCircle: " + unionCircle1);
		Union union1 = new Union(box1, unionCircle1);
		System.out.println("union1: " + union1);
		System.out.println("union1.boundingBox(): " + union1.boundingBox());
		
		checkTest(union1.boundingBox().equals(new Box(-10, 20, 10, -10)), "union1.boundingBox().equals(new Box(-10, 20, 10, -10)");
		checkTest(unionCircle1.equals(unionCircle2), "unionCircle1.equals(unionCircle2)");
		Union union2 = new Union(box1, unionCircle2);
		checkTest(union1.equals(union2), "union1.equals(union2)");
		checkTest(union2.equals(union1), "union2.equals(union1)");
		Union union3 = new Union(unionCircle1, box1);
		checkTest(union1.equals(union3), "union1.equals(union3)");
		checkTest(union3.equals(union1), "union3.equals(union1)");
		checkTest(union2.equals(union3), "union2.equals(union3)");
		checkTest(union3.equals(union2), "union3.equals(union2)");
		
		Union union4 = new Union(box1, box2);
		checkTest(!union4.equals(union1), "!union4.equals(union1)");

		/*
		Triangle t = new Triangle(new Point(0,10), new Point(0,0), new Point(10,0));
		System.out.println("Triangle: " + t);
		System.out.println("t.boundingBox()" + t.boundingBox());
		checkTest(t.contains(new Point(1,1)), "t.contains(new Point(1,1))");
		checkTest(!t.contains(new Point(10,10)), "!t.contains(new Point(10,10))");
		*/
	}

}
