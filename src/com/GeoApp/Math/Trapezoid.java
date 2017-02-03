package com.GeoApp.Math;

public class Trapezoid implements Trapezoidable {
	
	protected double a, b, c, d, area, angleAcute1, angleAcute2, diagonalOne, diagonalTwo, perimeter, height, centerLine, 
					centerLineDiagonal; // centerLine- odc ³¹cz¹cy œrodki ramion
	protected boolean checkVariables;
	
	public Trapezoid(double a, double b, double c, double d, double angleAcute1, double angleAcute2, 
					double diagonalOne, double diagonalTwo, double height, double area, double perimeter, 
					double centerLine, double centerLineDiagonal){
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
		this.angleAcute1=angleAcute1;
		this.angleAcute2=angleAcute2;
		this.height=height;
		this.diagonalOne=diagonalOne;
		this.diagonalTwo=diagonalTwo;
		this.area=area;
		this.centerLine=centerLine;
		this.centerLineDiagonal=centerLineDiagonal;
		this.perimeter=perimeter;
		checkVariables=false;
		
		checkParameters();
	}

	public void checkParameters() {
		if(a>0 && b>0) {
			centerLine();
			centerLineDiagonal();
			if(c>0 && d>0){
				perimeter();
				areaFrom4Sides();
				heightFromSideSideArea();
				if(angleAcute1>0 && angleAcute2>0){
					diagonals();
					}
			}
			if(height>0)
				areaFormSidesHeight();
			//radius();
		}
		if(a>0 && b>0 && c>0 && perimeter>0){
			sideD();
			areaFrom4Sides();
			centerLine();
			heightFromSideSideArea();
			centerLineDiagonal();
		}
		if(a>0 && b>0 && d>0 && perimeter>0){
			sideC();
			areaFrom4Sides();
			centerLine();
			centerLineDiagonal();
			heightFromSideSideArea();
		}
		if(a>0 && d>0 && c>0 && perimeter>0){
			sideB();
			areaFrom4Sides();
			centerLine();
			centerLineDiagonal();
			heightFromSideSideArea();
		}
		if(d>0 && b>0 && c>0 && perimeter>0){
			sideA();
			areaFrom4Sides();
			centerLine();
			centerLineDiagonal();
			heightFromSideSideArea();
		}
		if(a>0 && b>0 && area>0)
			heightFromSideSideArea();
	}

	private void heightFromSideSideArea() {
		height = (2*area)/(a+b);
		checkVariables=true;
	}
	public double getHeight(){
		return height;
	}

	private void sideA() {
		a = perimeter-(d+b+c);
		checkVariables=true;
	}
	private void sideB() {
		b = perimeter-(a+d+c);
		checkVariables=true;
	}
	private void sideC() {
		c = perimeter-(a+b+d);
		checkVariables=true;
	}
	private void sideD() {
		d = perimeter-(a+b+c);
		checkVariables=true;
	}
	public double getA() {return a;}
	public double getB() {return b;}
	public double getC() {return c;}
	public double getD() {return d;}

	private void areaFrom4Sides() {
		area=( (a+b)/Math.abs(a-b) * Math.sqrt(Math.abs(a-b)+c+d) * Math.sqrt(Math.abs(a-b)+c-d) * Math.sqrt(Math.abs(a-b)-c+d) * Math.sqrt(-Math.abs(a-b)+c+d) )/4.0;
		checkVariables=true;
	}

	private void areaFormSidesHeight(){
		area=(a+b)*height/2;
		checkVariables=true;
	}
	public double getArea(){
		return area;
	}
	
	private void centerLine(){
		centerLine=(a+b)/2;
		checkVariables=true;
	}
	public double getCenterLine(){
		return centerLine;
	}
	private void centerLineDiagonal(){
		centerLineDiagonal=Math.abs((a-b)/2);
		checkVariables=true;
	}
	public double getCenterLineDiagonal(){
		return centerLineDiagonal;
	}
	
	private void perimeter(){
		perimeter=a+b+c+d;
		checkVariables=true;
	}
	public double getPerimeter(){
		return perimeter;
	}
	private void diagonals(){
		diagonalOne=Math.sqrt(Math.pow(a, 2)+Math.pow(c, 2)-2*a*c*Math.cos(angleAcute1));
		diagonalTwo=Math.sqrt(Math.pow(b, 2)+Math.pow(d, 2)-2*b*d*Math.cos(angleAcute2));
		checkVariables=true;
	}
	
	public double getDiagonalOne(){
		return diagonalOne;
	}
	public double getDiagonalTwo(){
		return diagonalTwo;
	}
	
	public boolean checkCorrect(){
		return checkVariables;
	}
}

