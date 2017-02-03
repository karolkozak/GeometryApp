package com.GeoApp.Math;

public class Ellipse implements Ellipseable{
	
	private double axis1;
	private double axis2;
	private double area;
	private double perimeter;
	private boolean checkVariables;
	
	public Ellipse (double axis1, double axis2, double area, double perimeter) {
		this.axis1 = axis1;
		this.axis2 = axis2;
		this.area = area;
		this.perimeter = perimeter;
		checkVariables = false;
		
		checkParameters();
	}
	
	private void checkParameters() {
		if (axis1>0 && axis2>0) {
			areaEllipse(axis1, axis2);
			perimeterEllipse(axis1, axis2);
		}
		if (axis1>0 && area>0) axis2FromArea (axis1, area);
		if (axis2>0 && area>0) axis1FromArea (axis2, area);
		if (axis1>0 && perimeter>0) axis2FromPerimeter(axis1, perimeter);
		if (axis2>0 && perimeter>0) axis1FromPerimeter(axis2, perimeter);
	}
//................................................POLE
	private void areaEllipse (double axis1, double axis2) {
		area = axis1*axis2*Math.PI/4;
		checkVariables=true;
	}
	public double getArea() {
		return area;
	}
//.................................................OBWOD
	private void perimeterEllipse (double axis1, double axis2) {
		perimeter = Math.PI*(1.5*(axis1 + axis2) - Math.sqrt(axis1*axis2));
		checkVariables=true;
	}
	public double getPerimeter() {
		return perimeter;
	}
//.................................................PROMIEN1 Z POLA
	private void axis1FromArea (double axis2, double area) {
		axis1 = (4*area)/(axis2*Math.PI);
		checkVariables=true;
	}
	public double getAxis1() {
		return axis1;
	}
//.................................................PROMIEN2 Z POLA
	private void axis2FromArea (double axis1, double area) {
		axis2 = (4*area)/(axis1*Math.PI);
		checkVariables=true;
	}
	public double getAxis2() {
		return axis2;
	}
//.................................................PROMIEN1 Z OBWODU
	private void axis1FromPerimeter (double axis2, double perimeter) {
		double delta = ((196*Math.PI)-(336*perimeter*Math.PI)+(144*perimeter)-(144*Math.pow(perimeter, 2))-(432*Math.PI*axis2*perimeter));
		axis1 = (((12*perimeter-14*Math.PI)/(9*Math.PI))+Math.sqrt(delta))/2;
		checkVariables=true;
	}
//.................................................PROMIEN2 Z OBWODU
	private void axis2FromPerimeter (double axis1, double perimeter) {
		double delta = ((196*Math.PI)-(336*perimeter*Math.PI)+(144*perimeter)-(144*Math.pow(perimeter, 2))-(432*Math.PI*axis1*perimeter));
		axis2 = (((12*perimeter-14*Math.PI)/(9*Math.PI))+Math.sqrt(delta))/2;
		checkVariables=true;
	}
	
	public boolean checkCorrect(){
		return checkVariables;
	}
}
