package com.GeoApp.Math;

public class Diamond implements Diamondable {

	private double a, diagonalShort, diagonalLong, acuteAngle, radius, height, area, perimeter;
	private boolean checkVariables;
	
	public Diamond(double a, double diagonalShort, double diagonalLong, double acuteAngle, double radius, double height, 
			double area, double perimeter) {
		this.a = a;
		this.diagonalLong = diagonalLong;
		this.diagonalShort = diagonalShort;
		this.acuteAngle = acuteAngle;
		this.height = height;
		this.radius = radius;
		this.area = area;
		this.perimeter = perimeter;
		checkVariables = false;
		
		checkParameters();
	}
	
	private void checkParameters() {
		if(a>0){
			perimeter();
			if(height>0){
				areaSideHeight();
				radiusHeight();
			}
			if(acuteAngle>0){
				areaFromSideAngle();
				radiusAngle();
				diagonals();
			
			}
			if(radius>0)
				heightFromRadius();
			if(area>0)
				heightFromAreaA();
		}
		else if(diagonalLong>0 && diagonalShort>0){
			areaFromDiagonals();
			AFromDiagonals();
			perimeter();
			heightFromAreaA();
			radiusHeight();
			
		}else if(area>0){
			if(height>0){
				AFromAreaHeight();
				perimeter();
				radiusHeight();
			}
			if(acuteAngle>0){
				AFromAreaAngle();
				perimeter();
				heightFromAreaA();
				radiusHeight();
				diagonals();
			}
		}else if(perimeter>0)
			AFromPerimeter();
	}

	private void diagonals() {
		diagonalLong = 2.0*a*Math.cos(acuteAngle/2.0);
		diagonalShort = 2.0*a*Math.sin(acuteAngle/2.0);
		checkVariables = true;
	}
	private void AFromDiagonals(){
		a=Math.sqrt(Math.pow(diagonalLong/2.0,2)+Math.pow(diagonalShort/2.0,2));
		checkVariables=true;
	}
	private void heightFromAreaA(){
		height=area/a;
		checkVariables=true;
	}
	
	public double getDiagonalLong(){
		return diagonalLong;
	}

	public double getDiagonalShort(){
		return diagonalShort;
	}
	
	private void AFromPerimeter(){
		a=perimeter/4.0;
		checkVariables=true;
	}
	private void AFromAreaHeight(){
		a=area/height;
		checkVariables=true;
	}
	private void AFromAreaAngle(){
		a=Math.sqrt(area/Math.sin(acuteAngle));
		checkVariables=true;
	}
	public double getA(){
		return a;
	}
	public double getHeight(){
		return height;
	}
	private void radiusAngle() {
		radius = (a*Math.sin(acuteAngle))/2.0;
		checkVariables = true;
	}
	private void radiusHeight(){
		radius=(height)/2.0;
		checkVariables=true;
	}
	
	public double getRadius(){
		return radius;
	}

	private void perimeter() {
		perimeter = 4*a;
		checkVariables = true;
	}

	public double getPerimeter(){
		return perimeter;
	}
	private void heightFromRadius(){
		height=2.0*radius;
		checkVariables=true;
	}
	
	private void areaFromDiagonals() {
		area = (diagonalLong*diagonalShort)/2.0;
		checkVariables = true;
	}

	private void areaFromSideAngle() {
		area = Math.pow(a, 2)*Math.sin(acuteAngle);	
		checkVariables = true;
	}

	private void areaSideHeight() {
		area = a*height;
		checkVariables = true;
	}
	
	public double getArea(){
		return area;
	}
	
	public boolean checkCorrect(){
		return checkVariables;
	}
}