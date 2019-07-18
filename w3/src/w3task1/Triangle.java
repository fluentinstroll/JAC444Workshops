package w3task1;

public class Triangle extends GeometricObject {
	private double SideOne;
	private double SideTwo;
	private double SideThree;

	public Triangle() {
		super("White", false);
		SideOne = 1;
		SideTwo = 1;
		SideThree = 1;
	}

	public Triangle(double s1, double s2, double s3, String color, boolean filled) {
		super(color, filled);
		SideOne = s1;
		SideTwo = s2;
		SideThree = s3;
	}

	public double getSideOne() {
		return SideOne;
	}

	public double getSideTwo() {
		return SideThree;
	}

	public double getSideThree() {
		return SideThree;
	}

	public double getArea() {
		double perimeter = getPerimeter();
		return Math.sqrt(perimeter * ((perimeter - SideOne) * (perimeter - SideTwo) * (perimeter - SideThree)));
	}

	public double getPerimeter() {
		return (getSideOne() + getSideTwo() + getSideThree());
	}

	@Override
	public String toString() {
		return "Triangle: side 1 = " + SideOne + " side 2 = " + SideTwo + " side 3 = " + SideThree;
	}

	@Override
	public int compareTo(GeometricObject o) {
		return 0;
	}

}
