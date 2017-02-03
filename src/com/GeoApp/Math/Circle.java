package com.GeoApp.Math;

public class Circle implements Roundable {
	
	private double diameter, radius, area, perimeter, centralAngle, inscribedAngle,
					sector, angleLength;
	private boolean checkVariables;
	
	public Circle (double diameter, double radius, double area, double perimeter, double centralAngle, 
			double inscribedAngle, double sector, double angleLength) {
		this.diameter = diameter;
		this.radius = radius;
		this.area = area;
		this.perimeter = perimeter;
		this.centralAngle = centralAngle;
		this.inscribedAngle = inscribedAngle;
		this.sector = sector;
		this.angleLength = angleLength;
		checkVariables = false;
		
		checkParameters();
	}
	
	private void checkParameters () {
		if (radius > 0) {
			setDiameter();
			areaRadiusVersion (radius);
			perimeterRadiusVersion (radius);
		}
		if (radius > 0) {
			if (centralAngle > 0) {
				sectorAreaRadians (centralAngle, radius);
				angleLengthRadians (centralAngle, radius);
			}
		}
		if (radius > 0) {
			if (sector > 0) {
				centralAngleFromSector (radius, sector);
			}
		}
		if (radius > 0) {
			if (angleLength > 0) {
				centralAngleFromLength (radius, angleLength);
			}
		}
		
		if (diameter > 0) {
			areaDiameterVersion (diameter);
			perimeterDiameterVersion (diameter);
		}
		if (diameter > 0) {
			if (centralAngle > 0) {
				sectorAreaRadiansDiameter (centralAngle, diameter);
				angleLengthRadiansDiameter (centralAngle, diameter);
			}
		}
		if (diameter > 0) {
			if (sector > 0) {
				centralAngleFromSector (diameter/2.0, sector);
			}
		}
		if (diameter > 0) {
			if (angleLength > 0) {
				centralAngleFromLength (diameter/2.0, angleLength);
			}
		}
		
		if (area > 0) {
			radiusFromArea (area);
		}
		if (perimeter > 0) {
			radiusFromPerimeter (perimeter);
		}
		if(centralAngle>0)
			setInscribedAngle();
	}
//.........................................................
	private void areaRadiusVersion (double radius) {
		area = Math.PI*Math.pow(radius, 2);
		checkVariables = true;
	}
	private void areaDiameterVersion (double diameter) {
		area = Math.pow(diameter/2.0, 2)*Math.PI;
		checkVariables = true;
	}
	public double getArea () {
		return area;
	}
//.........................................................
	private void perimeterRadiusVersion (double radius) {
		perimeter = 2.0*radius*Math.PI;
		checkVariables = true;
	}
	private void perimeterDiameterVersion (double diameter) {
		perimeter = diameter*Math.PI;
		checkVariables = true;
	}
	public double getPerimeter () {
		return perimeter;
	}
//.........................................................
	private void radiusFromArea (double area) {
		radius = Math.sqrt(area/Math.PI);
		setDiameter();
		checkVariables = true;
	}
	private void radiusFromPerimeter (double perimeter) {
		radius = perimeter/(2.0*Math.PI);
		checkVariables = true;
	}
	public double getRadius () {
		return radius;
	}
	private void setDiameter(){
		diameter = 2.0*radius;
	}
	public double getDiameter () {
		return diameter;
	}
//.........................................................
	private void sectorAreaRadians (double centralAngle, double radius) {
		sector = (centralAngle/(2.0*Math.PI))*Math.pow(radius, 2)*Math.PI;
		checkVariables = true;
	}
	private void sectorAreaRadiansDiameter (double centralAngle, double diameter) {
		sector = (centralAngle/(2.0*Math.PI))*Math.pow(diameter/2.0, 2)*Math.PI;
		checkVariables = true;
	}
	public double getSector () {
		return sector;
	}
//.........................................................
	private void angleLengthRadians (double centralAngle, double radius) {
		angleLength = (centralAngle/(2.0*Math.PI))*2.0*radius*Math.PI;
		checkVariables = true;
	}
	private void angleLengthRadiansDiameter (double centralAngle, double diameter) {
		angleLength = (centralAngle/(2.0*Math.PI))*diameter*Math.PI;
		checkVariables = true;
	}
	public double getAngleLength () {
		return angleLength;
	}
//.........................................................
	private void centralAngleFromSector (double radius, double sector) {
		centralAngle = (2.0*sector)/(Math.pow(radius, 2));
		checkVariables = true;
	}
	private void centralAngleFromLength (double radius, double angleLength) {
		centralAngle = (sector)/(radius);
		checkVariables = true;
	}

	public double getCentralAngle () {
		return centralAngle;
	}
	
	private void setInscribedAngle(){
		inscribedAngle = centralAngle/2.0;
	}
	public double getInscribedAngle () {
		return inscribedAngle;
	}
//..............................................................
	public boolean checkCorrect(){
		return checkVariables;
	}
}
