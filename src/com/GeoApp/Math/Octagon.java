package com.GeoApp.Math;

public class Octagon implements Octagonable {
	
	private double a, area, perimeter, radiusBigger, radiusSmaller;
	private boolean checkVariables;
	
	public Octagon(double a, double area, double perimeter, double radiusBigger, double radiusSmaller) {
		this.a = a;
		this.area = area;
		this.perimeter = perimeter;
		this.radiusBigger = radiusBigger;
		this.radiusSmaller = radiusSmaller;
		checkVariables = false;
		
		checkParameters();
	}
	
	private void checkParameters() {
		if(a>0){
			setPerimeter();
			setArea();
			setRadiusBigger();
			setRadiusSmaller();
			checkVariables = true;
		}else if(area>0){
			setSideFromArea();
			setPerimeter();
			setRadiusBigger();
			setRadiusSmaller();
			checkVariables = true;
		}else if(perimeter>0){
			setSideFromPerimeter();
			setArea();
			setRadiusBigger();
			setRadiusSmaller();
			checkVariables = true;
		}else if(radiusBigger>0){
			setSideFromRadiusBigger();
			setPerimeter();
			setArea();
			setRadiusSmaller();
			checkVariables = true;
		}else if(radiusSmaller>0){
			setSideFromRadiusSmaller();
			setPerimeter();
			setArea();
			setRadiusBigger();
			checkVariables = true;
		}
	}
	
	private void setSideFromArea(){
		a = Math.sqrt(area/(2*(1/Math.tan(Math.PI/8))));
	}
	
	private void setSideFromPerimeter(){
		a = perimeter/8.0;
	}
	
	private void setSideFromRadiusBigger(){
		a = radiusBigger/(Math.sqrt((2+Math.sqrt(2))/2.0));
	}
	
	private void setSideFromRadiusSmaller(){
		a = 2*radiusSmaller/(1+Math.sqrt(2));
	}
	
	public double getSide(){
		return a;
	}
	
	private void setRadiusSmaller(){
		radiusSmaller = (a*(1+Math.sqrt(2)))/2.0;
	}
	
	public double getRadiusSmaller(){
		return radiusSmaller;
	}
	
	private void setRadiusBigger(){
		radiusBigger = a*Math.sqrt((2+Math.sqrt(2))/2.0);
	}
	
	public double getRadiusBigger(){
		return radiusBigger;
	}
	
	private void setPerimeter(){
		perimeter = 8*a;
	}
	
	public double getPerimeter(){
		return perimeter;
	}
	
	private void setArea(){
		area = 2*Math.pow(a, 2)*(1/Math.tan(Math.PI/8));
	}
	
	public double getArea(){
		return area;
	}
	
	public double getAngleSide(){
		return 135;
	}
	
	public boolean checkCorrect(){
		return checkVariables;
	}
}
