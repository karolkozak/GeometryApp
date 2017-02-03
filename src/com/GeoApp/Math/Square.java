package com.GeoApp.Math;

public class Square extends Rectangle {
	

	public Square(double a, double diagonal, double area, double perimeter) {
		
		super(a, a, diagonal, area, perimeter, 90);
	
		if(area>0)
			setA();

	
	}
	
	private void setA(){
		a = Math.sqrt(area);
		b = Math.sqrt(area);
	}

	

	public double getA(){
		return a;
	}
	
	
	
	
}
