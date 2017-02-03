package com.GeoApp.Math;

public class Hexagon implements Hexagonable {

	private double a, area, perimeter, radiusBigger, radiusSmaller, diagonalShort, diagonalLong;
	private boolean checkVariables;
	
	public Hexagon(double a, double area, double perimeter, double radiusBigger, 
				double radiusSmaller, double diagonalShort, double diagonalLong) {
		this.a = a;
		this.area = area;
		this.perimeter = perimeter;
		this.radiusBigger = radiusBigger;
		this.radiusSmaller = radiusSmaller;
		this.diagonalLong = diagonalLong;
		this.diagonalShort = diagonalShort;
		checkVariables = false;
		
		checkParameters();
	}

	private void checkParameters() {
		if(a>0){
			setRadiusBigger();
			setRadiusSmaller();
			area();
			perimeter();
			diagonalLong();
			diagonalShort();
			checkVariables = true;
		}
		else if(area>0){
			aSideFromArea();
			setRadiusBigger();
			setRadiusSmaller();
			perimeter();
			diagonalLong();
			diagonalShort();
			checkVariables = true;
		}
		else if(perimeter>0){
			aSideFromPerimeter();
			setRadiusBigger();
			setRadiusSmaller();
			diagonalLong();
			diagonalShort();
			area();
			checkVariables = true;
		}
		else if(radiusBigger>0){
			a = radiusBigger;
			setRadiusSmaller();
			area();
			perimeter();
			diagonalLong();
			diagonalShort();
			checkVariables = true;
		}
		else if(radiusSmaller>0){
			a = (2*radiusSmaller)/Math.sqrt(3);
			setRadiusBigger();
			area();
			perimeter();
			diagonalLong();
			diagonalShort();
			checkVariables = true;
		}
		else if(diagonalLong>0){
			a = diagonalLong/2.0;
			setRadiusBigger();
			setRadiusSmaller();
			area();
			perimeter();
			diagonalShort();
			checkVariables = true;
		}
		else if(diagonalShort>0){
			a = diagonalShort/Math.sqrt(3);
			setRadiusBigger();
			setRadiusSmaller();
			area();
			perimeter();
			diagonalLong();
			checkVariables = true;
		}
	}
	//-------------------------------------------
	private void aSideFromPerimeter() {
		a = perimeter/6.0;
	}
	//--------------------------------------------
	private void aSideFromArea() {
		a = Math.sqrt((2*area)/Math.sqrt(3)*3);
	}
	public double getASide(){
		return a;
	}
	//---------------------------------------------
	private void diagonalShort() {
		diagonalShort = a*Math.sqrt(3);
	}
	public double getDiagonalShort(){
		return diagonalShort;
	}
	//----------------------------------------------
	private void diagonalLong() {
		diagonalLong = 2*a;
	}
	public double getDiagonalLong(){
		return diagonalLong;
	}
	//----------------------------------------------
	private void setRadiusBigger() {
		radiusBigger = a;
	}
	public double getRadiusBigger(){
		return radiusBigger;
	}
	//-----------------------------------------------
	private void setRadiusSmaller() {
		radiusSmaller = (a*Math.sqrt(3))/2.0;
	}
	public double getRadiusSmaller(){
		return radiusSmaller;
	}
	//------------------------------------------------
	private void perimeter() {
		perimeter = 6*a;
	}
	public double getPerimeter(){
		return perimeter;
	}
	//-------------------------------------------------
	private void area() {
		area = (Math.pow(a, 2)*3*Math.sqrt(3))/2.0;
	}
	public double getArea(){
		return area;
	}
	//-------------------------------------------------
	public double getAngleSide(){
		return 120;
	}
	//-------------------------------------------------
	public boolean checkCorrect(){
		return checkVariables;
	}
}
