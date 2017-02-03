package com.GeoApp.Math;

public class Rectangle implements Rectangable {
	
	protected double a, b, area;
	protected double diagonal, perimeter, angleDiagonal;
	private boolean checkVariables;
	
	
	public Rectangle(double a, double b, double diagonal, double area, double perimeter, double angleDiagonal) {
		this.a=a;
		this.b=b;
		this.diagonal=diagonal;
		this.area=area;
		this.perimeter=perimeter;
		this.angleDiagonal=angleDiagonal;
		checkVariables = false;
		
		checkParameters();
	}

	private void checkParameters() {
		if(a>0 && b>0){
			area();
			perimeter();
			diagonal();
		}
		else if(angleDiagonal>0 && diagonal>0)
			areaAngle();
		else if(perimeter>0){
			if(a>0){
				BFromPerimeter();
				perimeter();
				diagonal();
				area();
			}
			else if(b>0){
				AFromPerimeter();
				perimeter();
				diagonal();
				area();
			}
		}
		else if(area>0){
			if(a>0){
				BFromArea();
				perimeter();
				diagonal();
			}
			else if(b>0){
				AFromArea();
				perimeter();
				diagonal();
			}
		}
		else if(diagonal>0){
			if(a>0){
				bFromDiagonalA();
				perimeter();
				area();
			}
			else if(b>0){
				aFromDiagonalB();
				perimeter();
				area();
			}
		}
	}
	private void area(){
		area=a*b;
		checkVariables = true;
	}
	private void AFromArea(){
		a=area/b;
		checkVariables=true;
	}
	private void BFromArea(){
		b=area/a;
		checkVariables=true;
	}
	private void bFromDiagonalA(){
		b=Math.sqrt(Math.pow(diagonal,2)-Math.pow(a,2));
		checkVariables=true;
	}
	
	private void aFromDiagonalB(){
		a=Math.sqrt(Math.pow(diagonal,2)-Math.pow(b, 2));
		checkVariables=true;
	}
	
	
	private void areaAngle(){
		area = 2*diagonal*Math.sin(angleDiagonal);
		checkVariables = true;
	}
	
	private void AFromPerimeter(){
		a=(perimeter-2*b)/2.0;
		checkVariables=true;
	}
	
	private void BFromPerimeter(){
		b=(perimeter-2*a)/2.0;
		checkVariables=true;
	}
	
	public double getArea(){
		return area;
	}
	
	private void perimeter(){
		perimeter=2*a+(2*b);
		checkVariables = true;
	}
	public double getPerimeter(){
		return perimeter;
	}
	
	private void diagonal(){
		diagonal = Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
		checkVariables = true;
	}
	public double getDiagonal(){
		return diagonal;
	}
	public double getA(){
		return a;
	}
	public double getB(){
		return b;
	}
	public double getAngleDiagonal(){
		return angleDiagonal;
	}
	public boolean checkCorrect(){
		return checkVariables;
	}
}