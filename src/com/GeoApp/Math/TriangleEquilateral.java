package com.GeoApp.Math;

public class TriangleEquilateral extends Triangle {

	public TriangleEquilateral(double a, double area, double perimeter, double height) {
		
		super(a, a, a, Math.PI/3, Math.PI/3, Math.PI/3, area, perimeter, height, height, height);
		
		if(area>0)
			aFromArea();
		if(perimeter>0)
			setAFromPerimeter();
		if(a>0){
			areaFromA();
			smallerRadiusFromA();
			biggerRadiusFromA();
			heightFromA();
			perimeter();
		}
		if(heightA>0){
			smallerRadiusFromHeight();
			biggerRadiusFromHeight();
		}
	}

	private void perimeter() {
		perimeter = 3*a;
	}

	private void heightFromA() {
		heightA = (a*Math.sqrt(3))/2.0;
		heightB = heightC = heightA;
		checkVariables = true;
	}

	private void biggerRadiusFromA() {
		radiusBigger = (a*Math.sqrt(3)/3.0);
		checkVariables = true;
	}

	private void smallerRadiusFromA() {
		radiusSmaller = (a*Math.sqrt(3)/6.0);
		checkVariables = true;
	}

	private void biggerRadiusFromHeight() {
		radiusBigger = (2*heightA)/3.0;
		checkVariables = true;
	}

	private void smallerRadiusFromHeight() {
		radiusSmaller = heightA/3.0;
		checkVariables = true;	
	}

	private void areaFromA() {
		area = (Math.pow(a, 2)*Math.sqrt(3))/4.0;
		checkVariables = true;	
	}

	private void setAFromPerimeter() {
		a = perimeter/3.0;
		checkVariables = true;		
	}

	private void aFromArea() {
		a = Math.sqrt((4*area)/Math.sqrt(3));
		checkVariables = true;
	}
	
}
