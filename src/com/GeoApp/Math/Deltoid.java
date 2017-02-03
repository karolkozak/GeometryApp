package com.GeoApp.Math;

public class Deltoid implements Deltoidable {

	private double a, b, radius, diagonalLong, diagonalShort, area, perimeter, angle;
	private boolean checkVariables;
	
	public Deltoid(double a, double b, double radius, double diagonalLong, double diagonalShort, double area, 
			double perimeter, double angle) {
		this.a = a;
		this.b = b;
		this.radius=radius;
		this.diagonalLong = diagonalLong;
		this.diagonalShort = diagonalShort;
		this.area = area;
		this.perimeter = perimeter;
		this.angle = angle;
		checkVariables = false;
		
		checkParameters();
	}

	private void checkParameters() {
		if(a>0 && b>0){
			perimeter();
			if(angle>0){	
				areaFromSideSideAngle();
				diagonals();
				setRadius();
				}
		}
		else if(diagonalLong>0 && diagonalShort>0){
			areaFromDiagonals();
		}else if(perimeter>0){
			if(a>0)
				BFromPerimeterA();
			
			if(b>0)
				AFromPerimeterB();
				
		}
	}
	private void AFromPerimeterB(){
		a=(perimeter-2*b)/2.0;
		checkVariables=true;
	}
	private void BFromPerimeterA(){
		b=(perimeter-2*a)/2.0;
		checkVariables=true;
	}
	
	private void diagonals(){
		diagonalLong = Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)-2*a*b*Math.cos(angle));
		diagonalShort = Math.sqrt(Math.pow(a, 2)+Math.pow(a, 2)-2*a*a*Math.cos(Math.PI/2-angle));
		checkVariables = true;
	}
	public double getDiagonalLong(){
		return diagonalLong;
	}
	
	public double getDiagonalShort(){
		return diagonalShort;
	}
	
	private void setRadius(){
		radius = 2*area/perimeter;
		checkVariables = true;
	}
	public double getRadius(){
		return radius;
	}
	
	private void areaFromSideSideAngle() {
		area = a*b*Math.sin(angle);
		checkVariables = true;
	}
	private void areaFromDiagonals() {
		area = diagonalLong*diagonalShort/2;
		checkVariables = true;
	}
	public double getArea(){
		return area;
	}
	
	private void perimeter() {
		perimeter = 2*a + 2*b;
		checkVariables = true;
	}
	
	public double getPerimeter(){
		return perimeter;
	}
	public double getA(){
		return a;
	}
	public double getB(){
		return b;
	}

	public boolean checkCorrect(){
		return checkVariables;
	}
}