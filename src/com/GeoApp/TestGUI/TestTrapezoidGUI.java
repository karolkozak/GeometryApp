package com.GeoApp.TestGUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

import com.GeoApp.Math.*;
public class TestTrapezoidGUI extends JFrame implements ActionListener{

	private double a, b, c, d, area, angleAcute1, angleAcute2, diagonalOne,
						diagonalTwo, perimeter, height, centerLine, centerLineDiagonal, angleDiagonal; 
	private JLabel labelA, labelB, labelC, labelD, labelArea, labelAngleAcute1,
					labelAngleAcute2, labelDiagonalOne, labelDiagonalTwo, labelPerimeter, labelHeight,
						labelCenterLine, labelCenterLineDiagonal, labelAngleDiagonal; 
	private JTextField textA, textB, textC, textD, textArea, textAngleAcute1,
					textAngleAcute2, textDiagonalOne, textDiagonalTwo, textPerimeter, textHeight,
						textCenterLine, textCenterLineDiagonal, textAngleDiagonal;
	private JButton solve, reset;
	private JPanel panelA, panelB, panelC, panelD, panelArea, panelAngleAcute1,
					panelAngleAcute2, panelDiagonalOne, panelDiagonalTwo, panelPerimeter, panelHeight,
						panelCenterLine, panelCenterLineDiagonal, panelAngleDiagonal, panelButton;

	public TestTrapezoidGUI() {
		setSize(350, 320);
		setResizable(false);
		setTitle("Trapezoid Test");
		setLocation(420, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout()); 
		setVisible(true);

		createGUI();
		repaint();
		revalidate();
	}

	private void createGUI() {
		Dimension d=new Dimension(50, 25);
		panelA=new JPanel();
		labelA = new JLabel("a");
		panelA.add(labelA);
		textA = new JTextField();
		textA.setPreferredSize(d);
		panelA.add(textA);
		add(panelA);

		panelB=new JPanel();
		labelB = new JLabel("b");
		panelB.add(labelB);
		textB = new JTextField();
		textB.setPreferredSize(d);
		panelB.add(textB);
		add(panelB);

		panelC=new JPanel();
		labelC = new JLabel("c");
		panelC.add(labelC);
		textC = new JTextField();
		textC.setPreferredSize(d);
		panelC.add(textC);
		add(panelC);

		panelD=new JPanel();
		labelD = new JLabel("d");
		panelD.add(labelD);
		textD = new JTextField();
		textD.setPreferredSize(d);
		panelD.add(textD);
		add(panelD);

		panelAngleAcute1=new JPanel();
		labelAngleAcute1 = new JLabel("Angle Acute 1");
		panelAngleAcute1.add(labelAngleAcute1);
		textAngleAcute1 = new JTextField();
		textAngleAcute1.setPreferredSize(d);
		panelAngleAcute1.add(textAngleAcute1);
		add(panelAngleAcute1);

		panelAngleAcute2=new JPanel();
		labelAngleAcute2 = new JLabel("Angle Acute 2");
		panelAngleAcute2.add(labelAngleAcute2);
		textAngleAcute2 = new JTextField();
		textAngleAcute2.setPreferredSize(d);
		panelAngleAcute2.add(textAngleAcute2);
		add(panelAngleAcute2);

		panelHeight=new JPanel();
		labelHeight = new JLabel("Height");
		panelHeight.add(labelHeight);
		textHeight = new JTextField();
		textHeight.setPreferredSize(d);
		panelHeight.add(textHeight);
		add(panelHeight);

		panelDiagonalOne=new JPanel();
		labelDiagonalOne= new JLabel("DiagonalOne");
		panelDiagonalOne.add(labelDiagonalOne);
		textDiagonalOne = new JTextField();
		textDiagonalOne.setPreferredSize(d);
		panelDiagonalOne.add(textDiagonalOne);
		add(panelDiagonalOne);

		panelDiagonalTwo=new JPanel();
		labelDiagonalTwo = new JLabel("DiagonalTwo");
		panelDiagonalTwo.add(labelDiagonalTwo);
		textDiagonalTwo = new JTextField();
		textDiagonalTwo.setPreferredSize(d);
		panelDiagonalTwo.add(textDiagonalTwo);
		add(panelDiagonalTwo);

		panelCenterLine=new JPanel();
		labelCenterLine = new JLabel("Center Line");
		panelCenterLine.add(labelCenterLine);
		textCenterLine= new JTextField();
		textCenterLine.setPreferredSize(d);
		panelCenterLine.add(textCenterLine);
		add(panelCenterLine);

		panelCenterLineDiagonal=new JPanel();
		labelCenterLineDiagonal = new JLabel("CenterLineDiagonal");
		panelCenterLineDiagonal.add(labelCenterLineDiagonal);
		textCenterLineDiagonal= new JTextField();
		textCenterLineDiagonal.setPreferredSize(d);
		panelCenterLineDiagonal.add(textCenterLineDiagonal);
		add(panelCenterLineDiagonal);

		panelArea=new JPanel();
		labelArea = new JLabel("Area");
		panelArea.add(labelArea);
		textArea = new JTextField();
		textArea.setPreferredSize(d);
		panelArea.add(textArea);
		add(panelArea);
		
		panelAngleDiagonal = new JPanel();
		labelAngleDiagonal = new JLabel("Angle Diagonal");
		panelAngleDiagonal.add(labelAngleDiagonal);
		textAngleDiagonal = new JTextField();
		textAngleDiagonal.setPreferredSize(d);
		panelAngleDiagonal.add(textAngleDiagonal);
		add(panelAngleDiagonal);

		panelPerimeter=new JPanel();
		labelPerimeter = new JLabel("Perimeter");
		panelPerimeter.add(labelPerimeter);
		textPerimeter = new JTextField();
		textPerimeter.setPreferredSize(d);
		panelPerimeter.add(textPerimeter);
		add(panelPerimeter);

		panelButton=new JPanel();
		solve = new JButton("Solve!");
		solve.setPreferredSize(new Dimension(100,20));
		panelButton.add(solve);
		solve.addActionListener(this);

		reset = new JButton("Reset");
		reset.setPreferredSize(new Dimension(100,20));
		panelButton.add(reset);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetFields();
			}
		});
		add(panelButton);
	}
	private void resetFields() {
		textA.setText(""); textB.setText(""); textC.setText(""); textD.setText(""); textAngleAcute1.setText(""); 
		textAngleAcute2.setText(""); textHeight.setText(""); textDiagonalOne.setText(""); textDiagonalTwo.setText(""); 
		textCenterLine.setText(""); textCenterLineDiagonal.setText("");
		textArea.setText(""); textPerimeter.setText("");
	}
	
	private double convert(String toConvert){
		int index;
		if(toConvert.contains("."))
			index = toConvert.indexOf(".");
		else if(toConvert.contains(","))
			index = toConvert.indexOf(",");
		else
			return Double.parseDouble(toConvert);
		String suf = toConvert.substring(index+1, toConvert.length());
		String pre = toConvert.substring(0, index);
		String convert = pre.concat(".").concat(suf);
		return Double.parseDouble(convert);
	}

	private boolean getFromTextFields() {

		if(!textA.getText().equals("")){
			try {
				a = convert(textA.getText());//jeœli niepusty, to pobieramy
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Litery!", "Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
				return false;							//jeœli litery to koñczymy
			}
			if(a<=0) return false;						//jeœli ujemny, to zwracamy false
		}
		else a = -1;									//jeœli by³ pusty, to inicjalizujemy na -1

		if(!textB.getText().equals("")){
			try {
				b = convert(textB.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(b<=0) return false;
		}
		else b = -1;

		if(!textC.getText().equals("")) {
			try {
				c = convert(textC.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(c<=0) return false;
		}
		else c = -1;

		if(!textD.getText().equals("")) {
			try {
				d = convert(textC.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(d<=0) return false;
		}
		else d = -1;

		if(!textAngleAcute1.getText().equals("")) {
			try {
				angleAcute1 = convert(textAngleAcute1.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(angleAcute1<=0) return false;
			angleAcute1 = angleAcute1*(Math.PI/180.0);
		}
		else angleAcute1 = -1;

		if(!textAngleAcute2.getText().equals("")) {
			try {
				angleAcute2 = convert(textAngleAcute2.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(angleAcute2<=0) return false;
			angleAcute2 = angleAcute2*(Math.PI/180.0);
		}
		else angleAcute2 = -1;

		if(!textHeight.getText().equals("")) {
			try {
				height = convert(textHeight.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(height<=0) return false;
		}
		else height = -1;

		if(!textDiagonalOne.getText().equals("")){
			try {
				diagonalOne = convert(textDiagonalOne.getText());
			} catch (NumberFormatException e1) {
				return false;
			}
			if(diagonalOne<=0) return false;
		}
		else diagonalOne = -1;

		if(!textDiagonalTwo.getText().equals("")) {
			try {
				diagonalTwo = convert(textDiagonalTwo.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(diagonalTwo<=0) return false;
		}
		else diagonalTwo = -1;

		if(!textCenterLine.getText().equals("")) {
			try {
				centerLine = convert(textCenterLine.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(centerLine<=0) return false;
		}
		else centerLine = -1;

		if(!textCenterLineDiagonal.getText().equals("")) {
			try {
				centerLineDiagonal = convert(textCenterLineDiagonal.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(centerLineDiagonal<=0) return false;
		}
		else centerLineDiagonal = -1;
		
		if(!textAngleDiagonal.getText().equals("")) {
			try {
				angleDiagonal = convert(textAngleDiagonal.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(angleDiagonal<=0) return false;
		}
		else angleDiagonal = -1;

		if(!textPerimeter.getText().equals("")) {
			try {
				perimeter = convert(textPerimeter.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(perimeter<=0) return false;
		}
		else perimeter = -1;

		if(!textArea.getText().equals("")) {
			try {
				area = convert(textArea.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(area<=0) return false;
		}
		else area = -1;

		return true;
	}

	private boolean checkSensOfArguments() {

		//TODO

		return true;
	}

	private void setTextFields(Trapezoid trapezoid) {
		if(trapezoid.getA()!=-1) textA.setText(String.format("%.3f",trapezoid.getA()));
		if(trapezoid.getB()!=-1) textB.setText(String.format("%.3f",trapezoid.getB()));
		if(trapezoid.getC()!=-1) textC.setText(String.format("%.3f",trapezoid.getC()));
		if(trapezoid.getD()!=-1) textD.setText(String.format("%.3f",trapezoid.getD()));
		if(trapezoid.getHeight()!=-1) textHeight.setText(String.format("%.3f",trapezoid.getHeight()));
		if(trapezoid.getPerimeter()!=-1) textPerimeter.setText(String.format("%.3f",trapezoid.getPerimeter()));
		if(trapezoid.getDiagonalOne()!=-1) textDiagonalOne.setText(String.format("%.3f",trapezoid.getDiagonalOne()));
		if(trapezoid.getDiagonalTwo()!=-1) textDiagonalTwo.setText(String.format("%.3f",trapezoid.getDiagonalTwo()));
		if(trapezoid.getCenterLine()!=-1) textCenterLine.setText(String.format("%.3f",trapezoid.getCenterLine()));
		if(trapezoid.getCenterLineDiagonal()!=-1) textCenterLineDiagonal.setText(String.format("%.3f",trapezoid.getCenterLineDiagonal()));
		if(trapezoid.getArea()!=-1) textArea.setText(String.format("%.3f",trapezoid.getArea()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!getFromTextFields())
			JOptionPane.showMessageDialog(this, "Jeden z podanych argumentów jest b³êdny", 
					"Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
		else{
			if(!checkSensOfArguments()){
				JOptionPane.showMessageDialog(this, "B³êdne dane, podane wartoœci nie s¹ wartoœciami trójk¹ta", 
						"Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
			}
			else{
				if(d==c){

					Trapezoid trapezoidIsosceles=new TrapezoidIsosceles(a,b,c, angleAcute1, diagonalOne, height, area, perimeter, centerLine, centerLineDiagonal,angleDiagonal);
					if(trapezoidIsosceles.checkCorrect())
						setTextFields(trapezoidIsosceles);
					else
						JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostre¿enie", JOptionPane.ERROR_MESSAGE);
				}
				else{
					Trapezoid trapezoid = new Trapezoid(a, b, c, d, angleAcute1, angleAcute2, diagonalOne, diagonalTwo, height, area, perimeter, centerLine, centerLineDiagonal);
					if(trapezoid.checkCorrect())
						setTextFields(trapezoid);
					else
						JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	public static void main(String[] args) {
		new TestTrapezoidGUI();
	}
}