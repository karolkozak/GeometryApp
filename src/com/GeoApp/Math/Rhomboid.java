package com.GeoApp.Math;

public class Rhomboid implements Rhomboidable {
	
	private double a, b, angleA, angleB, heightB, heightA; //angleA - k¹t ostry, wiêc diagonalShort mu odpowiada do tw cosinusów
	private double area, perimeter, diagonalShort, diagonalLong, angleDiagonal;
	private boolean checkVariables;
	
	public Rhomboid(double a, double b, double angleA, double angleB, double area, double heightA, double heightB, 
			double perimeter, double diagonalShort, double diagonalLong, double angleDiagonal) {
		this.a = a;
		this.b = b;
		this.angleA = angleA;
		this.angleB = angleB;
		this.heightA = heightA;
		this.heightB = heightB;
		this.area = area;
		this.perimeter = perimeter;
		this.diagonalLong = diagonalLong;
		this.diagonalShort = diagonalShort;
		this.angleDiagonal = angleDiagonal;
		checkVariables = false;
		
		checkParameters();
	}

	private void checkParameters() {
		if(a>0 && b>0){
			perimeter();
			if(angleA>0){
				diagonalShort();
				areaSideSideAngle();
				heightAFromAreaAndSide();
				heightBFromAreaAndSide();
			}
			else if(angleB>0){
				areaSideSideAngle();
				diagonalLong();
				heightAFromAreaAndSide();
				heightBFromAreaAndSide();
			}
		}
		else if(a>0 && heightA>0)
			areaSideHeight(a, heightA);
		else if(b>0 && heightB>0)
			areaSideHeight(b, heightB);
		else if(diagonalLong>0 && diagonalShort>0 && angleDiagonal>0){
			areaDiagDiagAngle();
		}
		if(perimeter>0 && a>0)
			setBFromSideAndArea();
		if(perimeter>0 && b>0)
			setAFromSideAndArea();
		if(area>0 && heightA>0)
			aFromAreaAndHeight();
		if(area>0 && heightB>0)
			bFromAreaAndHeight();
		if(area>0 && a>0)
			heightAFromAreaAndSide();
		if(area>0 && b>0)
			heightBFromAreaAndSide();
		if(diagonalLong>0 && diagonalShort>0 && angleDiagonal>0){
			aFromDiagDiagAngleDiag();
			bFromDiagDiagAngleDiag();
		}
	}


	private void setAFromSideAndArea() {
		a = (perimeter - (2*b))/2;
		checkVariables = true;
	}

	private void setBFromSideAndArea() {
		b = (perimeter - (2*a))/2;
		checkVariables = true;
	}

	private void bFromDiagDiagAngleDiag() {
		b = Math.sqrt(Math.pow(diagonalShort, 2)/4.0+Math.pow(diagonalLong, 2)/4.0-(diagonalLong*diagonalShort*Math.cos(angleDiagonal))/2.0);
		checkVariables = true;
	}

	private void aFromDiagDiagAngleDiag() {
		a = Math.sqrt(Math.pow(diagonalShort, 2)/4.0+Math.pow(diagonalLong, 2)/4.0+(diagonalLong*diagonalShort*Math.cos(angleDiagonal))/2.0);
		checkVariables = true;
	}

	private void heightBFromAreaAndSide() {
		heightB = area/b;
		checkVariables = true;
	}
	public double getHeightB(){
		return heightB;
	}

	private void heightAFromAreaAndSide() {
		heightA = area/a;
		checkVariables = true;
	}
	public double getHeightA(){
		return heightA;
	}

	private void bFromAreaAndHeight() {
		b = area/heightB;
		checkVariables = true;
	}
	public double getA(){
		return a;
	}

	private void aFromAreaAndHeight() {
		a = area/heightA;
		checkVariables = true;
	}
	public double getB(){
		return b;
	}

	private void diagonalLong() {
		diagonalLong = Math.sqrt(Math.pow(a, 2)+2*a*b*Math.cos(angleB)+Math.pow(b, 2));
		checkVariables = true;
	}
	public double getDiagonalLong(){
		return diagonalLong;
	}

	private void diagonalShort() {
		diagonalShort = Math.sqrt(Math.pow(a, 2)-2*a*b*Math.cos(angleA)+Math.pow(b, 2));
		checkVariables = true;
	}
	public double getDiagonalShort(){
		return diagonalShort;
	}

	private void perimeter() {
		perimeter = 2*a+(2*b);
		checkVariables = true;
	}
	public double getPerimeter(){
		return perimeter;
	}

	private void areaDiagDiagAngle() {
		area = (diagonalLong*diagonalShort*Math.sin(angleDiagonal))/2.0;
		checkVariables = true;
	}
	private void areaSideSideAngle() {
		area = a*b*Math.sin(angleA);
		checkVariables = true;
	}
	private void areaSideHeight(double side, double heigth){
		area = side*heigth;
		checkVariables = true;
	}
	public double getArea(){
		return area;
	}
	
	public boolean checkCorrect(){
		return checkVariables;
	}
}