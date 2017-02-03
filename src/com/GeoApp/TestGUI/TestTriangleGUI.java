package com.GeoApp.TestGUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.GeoApp.Math.Triangle;
import com.GeoApp.Math.TriangleEquilateral;

public class TestTriangleGUI extends JFrame implements ActionListener {

	private double a, b, c, angleA, angleB, angleC, heightA, heightB, heightC, 
					radiusSmaller, radiusBigger, area, perimeter;
	private JLabel labelA, labelB, labelC, labelAngleA, labelAngleB, labelAngleC, labelHeightA, labelHeightB, labelHeightC, 
					labelRadiusSmaller, labelRadiusBigger, labelArea, labelPerimeter;
	private JTextField textA, textB, textC, textAngleA, textAngleB, textAngleC, textHeightA, textHeightB, textHeightC, 
						textRadiusSmaller, textRadiusBigger, textArea, textPerimeter;
	private JButton solve, reset;
	private JPanel panelA, panelB, panelC, panelHeightA, panelHeightB, panelHeightC, panelAngleA, 
					panelAngleB, panelAngleC, panelRadiusSmaller, panelRadiusBigger, panelArea, panelPerimeter, panelButton;

	public TestTriangleGUI() {
		setSize(400, 220);
		setTitle("Traingle Test");
		setLocation(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);
		
		drawFrame();
		repaint();
		revalidate();
	}

	private void drawFrame() {
		panelA = new JPanel();
		labelA = new JLabel("a");
		panelA.add(labelA);
		textA = new JTextField();
		textA.setPreferredSize(new Dimension(50, 20));
		panelA.add(textA);
		add(panelA);
		
		panelB = new JPanel();
		labelB = new JLabel("b");
		panelB.add(labelB);
		textB = new JTextField();
		textB.setPreferredSize(new Dimension(50, 20));
		panelB.add(textB);
		add(panelB);
		
		panelC = new JPanel();
		labelC = new JLabel("c");
		panelC.add(labelC);
		textC = new JTextField();
		textC.setPreferredSize(new Dimension(50, 20));
		panelC.add(textC);
		add(panelC);
		
		panelAngleA = new JPanel();
		labelAngleA = new JLabel("AngleA");
		panelAngleA.add(labelAngleA);
		textAngleA = new JTextField();
		textAngleA.setPreferredSize(new Dimension(50, 20));
		panelAngleA.add(textAngleA);
		add(panelAngleA);
		
		panelAngleB = new JPanel();
		labelAngleB = new JLabel("AngleB");
		panelAngleB.add(labelAngleB);
		textAngleB = new JTextField();
		textAngleB.setPreferredSize(new Dimension(50, 20));
		panelAngleB.add(textAngleB);
		add(panelAngleB);
		
		panelAngleC = new JPanel();
		labelAngleC = new JLabel("AngleC");
		panelAngleC.add(labelAngleC);
		textAngleC = new JTextField();
		textAngleC.setPreferredSize(new Dimension(50, 20));
		panelAngleC.add(textAngleC);
		add(panelAngleC);
		
		panelHeightA = new JPanel();
		labelHeightA = new JLabel("HeightA");
		panelHeightA.add(labelHeightA);
		textHeightA = new JTextField();
		textHeightA.setPreferredSize(new Dimension(50, 20));
		panelHeightA.add(textHeightA);
		add(panelHeightA);
		
		panelHeightB = new JPanel();
		labelHeightB = new JLabel("HeightB");
		panelHeightB.add(labelHeightB);
		textHeightB = new JTextField();
		textHeightB.setPreferredSize(new Dimension(50, 20));
		panelHeightB.add(textHeightB);
		add(panelHeightB);
		
		panelHeightC = new JPanel();
		labelHeightC = new JLabel("HeightC");
		panelHeightC.add(labelHeightC);
		textHeightC = new JTextField();
		textHeightC.setPreferredSize(new Dimension(50, 20));
		panelHeightC.add(textHeightC);
		add(panelHeightC);
		
		panelRadiusSmaller = new JPanel();
		labelRadiusSmaller = new JLabel("Radius Smaller");
		panelRadiusSmaller.add(labelRadiusSmaller);
		textRadiusSmaller = new JTextField();
		textRadiusSmaller.setPreferredSize(new Dimension(50, 20));
		panelRadiusSmaller.add(textRadiusSmaller);
		add(panelRadiusSmaller);
		
		panelRadiusBigger = new JPanel();
		labelRadiusBigger = new JLabel("Radius Bigger");
		panelRadiusBigger.add(labelRadiusBigger);
		textRadiusBigger = new JTextField();
		textRadiusBigger.setPreferredSize(new Dimension(50, 20));
		panelRadiusBigger.add(textRadiusBigger);
		add(panelRadiusBigger);		
		
		panelArea = new JPanel();
		labelArea = new JLabel("Area");
		panelArea.add(labelArea);
		textArea = new JTextField();
		textArea.setPreferredSize(new Dimension(50, 20));
		panelArea.add(textArea);
		add(panelArea);
		
		panelPerimeter = new JPanel();
		labelPerimeter = new JLabel("Perimeter");
		panelPerimeter.add(labelPerimeter);
		textPerimeter = new JTextField();
		textPerimeter.setPreferredSize(new Dimension(50, 20));
		panelPerimeter.add(textPerimeter);
		add(panelPerimeter);
		
		panelButton = new JPanel();
		solve = new JButton("Solve!");
		solve.setPreferredSize(new Dimension(100, 20));
		panelButton.add(solve);
		solve.addActionListener(this);
		
		reset = new JButton("Reset");
		reset.setPreferredSize(new Dimension(100, 20));
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
		textA.setText(""); textB.setText(""); textC.setText(""); textAngleA.setText(""); textAngleB.setText(""); 
		textAngleC.setText(""); textHeightA.setText(""); textHeightB.setText(""); textHeightC.setText(""); 
		textRadiusSmaller.setText(""); textRadiusBigger.setText(""); textArea.setText(""); textPerimeter.setText("");
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
		
		if(!textAngleA.getText().equals("")) {
			try {
				angleA = convert(textAngleA.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(angleA<=0) return false;
			angleA = angleA*(Math.PI/180.0);
		}
		else angleA = -1;
		
		if(!textAngleB.getText().equals("")) {
			try {
				angleB = convert(textAngleB.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(angleB<=0) return false;
			angleB = angleB*(Math.PI/180.0);
		}
		else angleB = -1;
		
		if(!textAngleC.getText().equals("")) {
			try {
				angleC = convert(textAngleC.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(angleC<=0) return false;
			angleC = angleC*(Math.PI/180.0);
		}
		else angleC = -1;
		
		if(!textHeightA.getText().equals("")) {
			try {
				heightA = convert(textHeightA.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(heightA<=0) return false;
		}
		else heightA = -1;
		
		if(!textHeightB.getText().equals("")) {
			try {
				heightB = convert(textHeightB.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(heightB<=0) return false;
		}
		else heightB = -1;
		
		if(!textHeightC.getText().equals("")) {
			try {
				heightC = convert(textHeightC.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(heightC<=0) return false;
		}
		else heightC = -1;
		
		if(!textRadiusSmaller.getText().equals("")){
			try {
				radiusSmaller = convert(textRadiusSmaller.getText());
			} catch (NumberFormatException e1) {
				return false;
			}
			if(radiusSmaller<=0) return false;
		}
		else radiusSmaller = -1;
		
		if(!textRadiusBigger.getText().equals("")) {
			try {
				radiusBigger = convert(textRadiusBigger.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(radiusBigger<=0) return false;
		}
		else radiusBigger = -1;
		
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

	private void setTextFields(Triangle triangle) {
		if(triangle.getASide()!=-1)	textA.setText(String.format("%.3f", triangle.getASide()));
		if(triangle.getBSide()!=-1) textB.setText(String.format("%.3f", triangle.getBSide()));
		if(triangle.getCSide()!=-1) textC.setText(String.format("%.3f", triangle.getCSide()));
		if(triangle.getHeightA()!=-1) textHeightA.setText(String.format("%.3f", triangle.getHeightA()));
		if(triangle.getHeightB()!=-1) textHeightB.setText(String.format("%.3f", triangle.getHeightB()));
		if(triangle.getHeightC()!=-1) textHeightC.setText(String.format("%.3f", triangle.getHeightC()));
		if(triangle.getBiggerRadius()!=-1) textRadiusBigger.setText(String.format("%.3f", triangle.getBiggerRadius()));
		if(triangle.getSmallerRadius()!=-1) textRadiusSmaller.setText(String.format("%.3f", triangle.getSmallerRadius()));
		if(triangle.getPerimeter()!=-1) textPerimeter.setText(String.format("%.3f", triangle.getPerimeter()));
		if(triangle.getArea()!=-1) textArea.setText(String.format("%.3f", triangle.getArea()));
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
				if(a==b && b==c){
					TriangleEquilateral traingleEquilateral = new TriangleEquilateral(a, area, perimeter, heightA);
					if(traingleEquilateral.checkCorrect())
						setTextFields(traingleEquilateral);
					else
						JOptionPane.showMessageDialog(this, "Nic nie zosta³o obliczone", "Komunikat", 
								JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					Triangle triangle = new Triangle(a, b, c, angleA, angleB, angleC, area, perimeter, heightA, 
							heightB, heightC);
					if(triangle.checkCorrect())
						setTextFields(triangle);
					else
						JOptionPane.showMessageDialog(this, "Nic nie zosta³o obliczone", "Komunikat", 
								JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	public static void main(String[] args) {
		new TestTriangleGUI();
	}
}
