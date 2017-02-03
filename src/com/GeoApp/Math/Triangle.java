package com.GeoApp.Math;

public class Triangle implements Trianglable {
	
	protected double a, b, c, angleA, angleB, angleC, heightA, heightB, heightC, 
					radiusSmaller, radiusBigger, area, perimeter;
	protected boolean checkVariables;
	
	public Triangle(double a, double b, double c, double angleA, double angleB, double angleC, double area, 
				double perimeter, double heightA, double heightB, double heightC) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.angleA = angleA;
		this.angleB = angleB;
		this.angleC = angleC;
		this.area = area;
		this.perimeter = perimeter;
		this.heightA = heightA;
		this.heightB = heightB;
		this.heightC = heightC;
		checkVariables = false;
		
		checkParameters();
	}
	
	private void checkParameters(){
		if(a>0 && b>0 && c>0){
			perimeterABC();
			areaABC();
			biggerRadiusFromArea(a, b, c, area);
		}
		if(area>0 && a>0)
			heightFromAreaA();
		if(area>0 && b>0)
			heightFromAreaB();
		if(area>0 && c>0)
			heightFromAreaC();
		if(a>0 && b>0 && angleC>0){
			area2Sides1Angle(a, b, angleC);
			setCSide();
		}
		if(b>0 && c>0 && angleA>0){
			area2Sides1Angle(b, c, angleA);
			setASide();
		}
		if(a>0 && c>0 && angleB>0){
			area2Sides1Angle(a, c, angleB);
			setBSide();
		}
		if(a>0 && heightA>0)
			areaSide1Height(a, heightA);
		if(b>0 && heightB>0)
			areaSide1Height(b, heightB);
		if(c>0 && heightC>0)
			areaSide1Height(c, heightC);
		if(area>0 && perimeter>0)
			smallerRadiusFromArea();
		if(a>0 && angleA>0)
			biggerRadiusFromAngle(a, angleA);
		if(b>0 && angleB>0)
			biggerRadiusFromAngle(b, angleB);
		if(c>0 && angleC>0)
			biggerRadiusFromAngle(c, angleC);
		if(perimeter>0 && a>0 &&b>0)
			cFromPerimeterAB();
		if(perimeter>0 && b>0 && c>0)
			aFromPerimeterBC();
		if(perimeter>0 && a>0 && c>0)
			bFromPerimeterAC();
	}
	
	private void perimeterABC () {
		perimeter = a+b+c;
		checkVariables = true;
	}
	
	public double getPerimeter () {
		return perimeter;
	}
	private void bFromPerimeterAC(){
		b=perimeter-a-c;
		checkVariables=true;
	}
	
	private void aFromPerimeterBC(){
		a=perimeter-b-c;
		checkVariables=true;
	}
	
	private void cFromPerimeterAB(){
		c=perimeter-a-b;
		checkVariables=true;
	}
	
	
	private void areaABC () {
		double P = (a+b+c)/2.0;
		area = Math.sqrt(P*(P-a)*(P-b)*(P-c));
		checkVariables = true;
	}
	private void area2Sides1Angle (double side1, double side2, double angle) {
		area = side1*side2*Math.sin(angle)/2.0;
		checkVariables = true;
	}
	private void areaSide1Height (double side, double height) {
		area = side*height/2.0;
		checkVariables = true;
	}
	private void areaSmallerRadius (double a, double b, double c, double r) {
		area = (a+b+c)*r/2.0;
		checkVariables = true;
	}
	private void areaBiggerRadius (double a, double b, double c, double R) {
		area = a*b*c/(4*R);
		checkVariables = true;
	}
	public double getArea () {
		return area;
	}
	
	private void heightFromAreaA () {
		heightA = 2*area/a;
		checkVariables = true;
	}
	private void heightFromAreaB () {
		heightB = 2*area/b;
		checkVariables = true;
	}
	private void heightFromAreaC () {
		heightC = 2*area/c;
		checkVariables = true;
	}
	public double getHeightA () {return heightA;}
	public double getHeightB () {return heightB;}
	public double getHeightC () {return heightC;}
	
	private void smallerRadiusFromArea (){
		radiusSmaller = 2*area/perimeter;
		checkVariables = true;
	}
	public double getSmallerRadius() {
		return radiusSmaller;
	}
	
	private void biggerRadiusFromArea (double side1, double side2, double side3, double area){
		radiusBigger = side1*side2*side3/(4*area);
		checkVariables = true;
	}
	private void biggerRadiusFromAngle (double side, double angle){
		radiusBigger = side/(2*Math.sin(angle));
		checkVariables = true;
	}
	public double getBiggerRadius() {return radiusBigger;}

	private void setCSide(){
		c = Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)-2*a*b*Math.cos(angleC));
		checkVariables = true;
	}
	private void setBSide(){
		b = Math.sqrt(Math.pow(a, 2)+Math.pow(c, 2)-2*a*b*Math.cos(angleB));
		checkVariables = true;
	}
	private void setASide(){
		a = Math.sqrt(Math.pow(b, 2)+Math.pow(c, 2)-2*a*b*Math.cos(angleA));
		checkVariables = true;
	}
	public double getASide(){
		return a;
	}
	public double getBSide(){
		return b;
	}
	public double getCSide(){
		return c;
	}
	
	public boolean checkCorrect(){
		return checkVariables;
	}
}