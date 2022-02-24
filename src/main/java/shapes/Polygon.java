package shapes;

import java.util.ArrayList;

public class Polygon implements Shape {
	private final ArrayList<Point> points;

	protected Polygon() {
		points = null;
	}

	public Polygon(Point ...points) {
		this.points = new ArrayList<>();
		for (Point p: points) {
			this.points.add(p);
		}
	}

	public Polygon(int[] x, int[] y) {
		if (x.length != y.length) {
			throw new IllegalArgumentException("different lengths");
		}
		points = new ArrayList<>();
		// TODO: should reject if duplicate points are adjacent !!
		for (int index=0; index<x.length; index++) {
			var p = new Point(x[index], y[index]);
			points.add(p);
		}
	}
	
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof Polygon otherPolygon) {
			if (sideCount() != otherPolygon.sideCount()) {
				return false;
			} 
			// if two polygons are equivalent but ordering of corners is rotated,
			// then this still returns false!!!!
			for(int index=0; index<sideCount(); index++) {
				if (!getCorner(index).equals(otherPolygon.getCorner(index))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(points.get(0).toString());
		for (int index = 1; index<points.size(); index++) {
			Point p = getCorner(index);
			sb.append("-");
			sb.append(p.toString());
		}
		return sb.toString();
		//return super.toString(); // TODO: fix this!!!
	}
	
	private static double angle(Point center, Point p1, Point p2) {
		double deltaX1 = p1.getX() - center.getX();
		double deltaY1 = p1.getY() - center.getY();
		double deltaX2 = p2.getX() - center.getX();
		double deltaY2 = p2.getY() - center.getY();
		double angle1 = Math.atan2(deltaY1, deltaX1);
		double angle2 = Math.atan2(deltaY2, deltaX2);

		double deltaAngle = angle1 - angle2;
		if (deltaAngle >= Math.PI/2) {
			return deltaAngle - Math.PI;
		}
		if (deltaAngle <= -Math.PI/2) {
			return deltaAngle + Math.PI;
		}
		return deltaAngle;
	}
	
	public boolean contains(Point p) {
		if (!boundingBox().contains(p)) {
			return false;
		}
		int sideCountMinus1 = sideCount() - 1;
		double angleSum = 0.0;
		for (int index = 0; index < sideCountMinus1; index++) {
			double delta = angle(p, points.get(index), points.get(index+1));
			angleSum += delta;
		}
		double delta = angle(p, points.get(sideCountMinus1), points.get(0));
		angleSum += delta;
		double windingEstimate = angleSum / (2*Math.PI);
		return Math.abs(windingEstimate) > 0.5;
	}
	
	public Box boundingBox() {
		int xMin = Integer.MAX_VALUE;
		int yMin = Integer.MAX_VALUE;
		int xMax = Integer.MIN_VALUE;
		int yMax = Integer.MIN_VALUE;
		
		for (Point p : points) {
			int x = p.getX();
			int y = p.getY();
			
			if (x < xMin) xMin = x;
			if (x > xMax) xMax = x;
			if (y < yMin) yMin = y;
			if (y > yMax) yMax = y;
		}
		
		Point upperLeft = new Point(xMin, yMax);
		Point lowerRight = new Point(xMax, yMin);
		
		return new Box(upperLeft, lowerRight);	
	}
	
	public int sideCount() {
		return points.size();
	}
	
	public Point getCorner(int index) {
		return points.get(index);
	}
}