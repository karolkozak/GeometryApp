package com.GeoApp.Math;

public class Pentagon implements Pentagonable{

	private double side, area, height, perimeter, radiusSmaller, radiusBigger, diagonal;
	private boolean checkVariables;
	
	public Pentagon(double side, double height, double area, double perimeter, double diagonal, 
					double radiusSmaller, double radiusBigger){
		this.side=side;
		this.height=height;
		this.area=area;
		this.perimeter=perimeter;
		this.diagonal=diagonal;
		this.radiusSmaller=radiusSmaller;
		this.radiusBigger=radiusBigger;
		checkVariables=false;
		
		checkParameters();
	}
	
	private void checkParameters(){
		if(side>0){
			perimeterFromSide();
			areaFromSide();
			heightFormSide();
			radiusSmaller();
			radiusBigger();
			diagonalFromSide();
			
		}else if(perimeter>0){
			sideFromPerimeter();
			areaFromSide();
			heightFormSide();
			radiusSmaller();
			radiusBigger();
			diagonalFromSide();
		}
		else if(area>0){
			sideFromArea();
			heightFormSide();
			radiusSmaller();
			radiusBigger();
			perimeterFromSide();
			diagonalFromSide();
		}
		else if(height>0){
			sideFromHeight();
			areaFromSide();
			perimeterFromSide();
			radiusSmaller();
			radiusBigger();
			diagonalFromSide();
		}
		else if(radiusSmaller>0){
			sideFromRadiusSmaller();
			areaFromSide();
			heightFormSide();
			perimeterFromSide();
			radiusBigger();
			diagonalFromSide();
		}
		else if(radiusBigger>0){
			sideFromRadiusBigger();
			areaFromSide();
			perimeterFromSide();
			heightFormSide();
			radiusSmaller();
			diagonalFromSide();
		}
		else if(diagonal>0){
			sideFromDiagonal();
			areaFromSide();
			heightFormSide();
			radiusSmaller();
			radiusBigger();
			perimeterFromSide();
		}
		
	}
	
	private void sideFromRadiusSmaller(){
		side=radiusSmaller*10/Math.sqrt(25+10*Math.sqrt(5));
		checkVariables=true;
	}
	
	private void sideFromRadiusBigger(){
		side=radiusBigger*10/Math.sqrt(50+10*Math.sqrt(5));
		checkVariables=true;
	}
	private void sideFromDiagonal(){
		side=diagonal*2.0/(Math.sqrt(5)+1);
		checkVariables=true;
	}
	
	private void sideFromHeight(){
		side=height*Math.sqrt(8)/(5-Math.sqrt(5)+Math.sqrt(5+Math.sqrt(5)));
		checkVariables=true;
	}
	
	private void heightFormSide(){
		height=side*(Math.sqrt(5-Math.sqrt(5))+Math.sqrt(5+Math.sqrt(5))/Math.sqrt(8));	
		checkVariables=true;
	}
	
	public double getHeight(){
		return height;
	}
	
	private void areaFromSide(){
		area=5*Math.pow(side, 2)/(Math.tan(Math.PI/5)*4);
		checkVariables=true;
	}
	
	public double getArea(){
		return area;
	}
	
	public double getSide(){
		return side;
	}
	private void perimeterFromSide(){
		perimeter=5*side;
		checkVariables=true;
	}
	public double getPerimeter(){
		return perimeter;
	}
	
	private void diagonalFromSide(){
		diagonal=side*(Math.sqrt(5)+1)/2.0;
		checkVariables=true;
	}
	
	public double getDiagonal(){
		return diagonal;
	}
	
	private void radiusBigger(){
		radiusBigger=side*(Math.sqrt(50+10*Math.sqrt(5)))/10.0;
		checkVariables=true;
	}
	
	private void radiusSmaller(){
		radiusSmaller=side*(Math.sqrt(25+10*Math.sqrt(5)))/10.0;
		checkVariables=true;
	}
	
	public double getRadiusBigger(){
		return radiusBigger;
	}
	public double getRadiusSmaller(){
		return radiusSmaller;
	}
	private void sideFromPerimeter(){
		side=perimeter/5.0;
		checkVariables=true;
	}
	private void sideFromArea(){
		side=Math.sqrt(4*area*Math.tan(Math.PI/5)/5.0);
		checkVariables=true;
	}
	
	public double getAngleSide(){
		return 108;
	}
	
	public boolean checkCorrect(){
		return checkVariables;
	}
	
	
}
