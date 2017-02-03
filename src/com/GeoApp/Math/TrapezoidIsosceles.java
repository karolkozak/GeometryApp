package com.GeoApp.Math;

public class TrapezoidIsosceles extends Trapezoid {
	
	private double angleDiagonal;
	
	public TrapezoidIsosceles(double a, double b, double c, double angleAcute, double diagonal, double height, 
						double area, double perimeter, double centerLine, double centerLineDiagonal, double angleDiagonal) {
		
		super(a, b, c, c, angleAcute, angleAcute, diagonal, diagonal, height, area, perimeter, centerLine, centerLineDiagonal);
		this.angleDiagonal = angleDiagonal;
		
		if(diagonalOne>0 && diagonalTwo>0){
			areaFromDiagonals();
		}
		if(a>0 && b>0 && c>0)
			heightFrom3Sides();
		if(a>0 && b>0 && height>0)
			cSideFromABHeight();
	}

	private void cSideFromABHeight() {
		c = Math.sqrt(Math.pow((a-b)/2.0, 2) + Math.pow(height, 2));
		checkVariables = true;
	}

	private void heightFrom3Sides() {
		height = Math.sqrt(Math.pow(c, 2) - Math.pow((a-b)/2.0, 2));
		checkVariables = true;
	}

	private void areaFromDiagonals() {
		area = (Math.pow(diagonalOne, 2)*Math.sin(angleDiagonal))/2.0;
		checkVariables = true;
	}
}
