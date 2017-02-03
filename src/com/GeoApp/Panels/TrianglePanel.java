package com.GeoApp.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.GeoApp.App.ApplicationToolBarFormat;
import com.GeoApp.Math.Triangle;
import com.GeoApp.Math.TriangleEquilateral;

public class TrianglePanel extends JPanel implements ActionListener {

	private double a, b, c, angleA, angleB, angleC, heightA, heightB, heightC, 
					radiusSmaller, radiusBigger, area, perimeter;
	private JLabel labelImage, labelA, labelB, labelC, labelAngleA, labelAngleB, labelAngleC, labelHeightA, labelHeightB, 
					labelHeightC, labelRadiusSmaller, labelRadiusBigger, labelArea, labelPerimeter;
	private JTextField textA, textB, textC, textAngleA, textAngleB, textAngleC, textHeightA, textHeightB, textHeightC, 
						textRadiusSmaller, textRadiusBigger, textArea, textPerimeter;
	private JButton solve, reset;
	private JPanel panelText, panelImage, panelA, panelB, panelC, panelHeightA, panelHeightB, panelHeightC, panelAngleA, 
					panelAngleB, panelAngleC, panelRadiusSmaller, panelRadiusBigger, panelArea, panelPerimeter, panelButton;
	private ApplicationToolBarFormat myToolBarFormat;
	
	public TrianglePanel(ApplicationToolBarFormat myToolBarFormat) {
		setLayout(new GridLayout(1, 2));
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");			
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		setBackground(new Color(214,217,223));
		
		this.myToolBarFormat = myToolBarFormat;
		
		drawFrame();
		repaint();
		revalidate();
	}
	
	private void drawFrame() {
		Dimension dimension = new Dimension(70, 25);
		panelText=new JPanel(new FlowLayout());
		
		panelA = new JPanel();
		labelA = new JLabel("a");
		panelA.add(labelA);
		textA = new JTextField();
		textA.setPreferredSize(dimension);
		panelA.add(textA);
		panelText.add(panelA);
		
		panelB = new JPanel();
		labelB = new JLabel("b");
		panelB.add(labelB);
		textB = new JTextField();
		textB.setPreferredSize(dimension);
		panelB.add(textB);
		panelText.add(panelB);
		
		panelC = new JPanel();
		labelC = new JLabel("c");
		panelC.add(labelC);
		textC = new JTextField();
		textC.setPreferredSize(dimension);
		panelC.add(textC);
		panelText.add(panelC);
		
		panelAngleA = new JPanel();
		labelAngleA = new JLabel("α");
		panelAngleA.add(labelAngleA);
		textAngleA = new JTextField();
		textAngleA.setPreferredSize(dimension);
		panelAngleA.add(textAngleA);
		panelText.add(panelAngleA);
		
		panelAngleB = new JPanel();
		labelAngleB = new JLabel("β");
		panelAngleB.add(labelAngleB);
		textAngleB = new JTextField();
		textAngleB.setPreferredSize(dimension);
		panelAngleB.add(textAngleB);
		panelText.add(panelAngleB);
		
		panelAngleC = new JPanel();
		labelAngleC = new JLabel("γ");
		panelAngleC.add(labelAngleC);
		textAngleC = new JTextField();
		textAngleC.setPreferredSize(dimension);
		panelAngleC.add(textAngleC);
		panelText.add(panelAngleC);
		
		panelHeightA = new JPanel();
		labelHeightA = new JLabel("<html>h<sub>a</sub></html>");
		panelHeightA.add(labelHeightA);
		textHeightA = new JTextField();
		textHeightA.setPreferredSize(dimension);
		panelHeightA.add(textHeightA);
		panelText.add(panelHeightA);
		
		panelHeightB = new JPanel();
		labelHeightB = new JLabel("<html>h<sub>b</sub></html>");
		panelHeightB.add(labelHeightB);
		textHeightB = new JTextField();
		textHeightB.setPreferredSize(dimension);
		panelHeightB.add(textHeightB);
		panelText.add(panelHeightB);
		
		panelHeightC = new JPanel();
		labelHeightC = new JLabel("<html>h<sub>c</sub></html>");
		panelHeightC.add(labelHeightC);
		textHeightC = new JTextField();
		textHeightC.setPreferredSize(dimension);
		panelHeightC.add(textHeightC);
		panelText.add(panelHeightC);
		
		panelRadiusSmaller = new JPanel();
		labelRadiusSmaller = new JLabel("r");
		panelRadiusSmaller.add(labelRadiusSmaller);
		textRadiusSmaller = new JTextField();
		textRadiusSmaller.setPreferredSize(dimension);
		panelRadiusSmaller.add(textRadiusSmaller);
		panelText.add(panelRadiusSmaller);
		
		panelRadiusBigger = new JPanel();
		labelRadiusBigger = new JLabel("R");
		panelRadiusBigger.add(labelRadiusBigger);
		textRadiusBigger = new JTextField();
		textRadiusBigger.setPreferredSize(dimension);
		panelRadiusBigger.add(textRadiusBigger);
		panelText.add(panelRadiusBigger);		
		
		panelArea = new JPanel();
		labelArea = new JLabel("Pole");
		panelArea.add(labelArea);
		textArea = new JTextField();
		textArea.setPreferredSize(dimension);
		panelArea.add(textArea);
		panelText.add(panelArea);
		
		panelPerimeter = new JPanel();
		labelPerimeter = new JLabel("Obwód");
		panelPerimeter.add(labelPerimeter);
		textPerimeter = new JTextField();
		textPerimeter.setPreferredSize(dimension);
		panelPerimeter.add(textPerimeter);
		panelText.add(panelPerimeter);
		
		textA.addActionListener(this);
		textB.addActionListener(this);
		textC.addActionListener(this);
		textAngleA.addActionListener(this);
		textAngleB.addActionListener(this);
		textAngleC.addActionListener(this);
		textHeightA.addActionListener(this);
		textHeightB.addActionListener(this);
		textHeightC.addActionListener(this);
		textRadiusSmaller.addActionListener(this);
		textRadiusBigger.addActionListener(this);
		textArea.addActionListener(this);
		textPerimeter.addActionListener(this);
		
		panelButton = new JPanel();
		solve = new JButton("Oblicz!");
		solve.setPreferredSize(new Dimension(100, 25));
		panelButton.add(solve);
		solve.addActionListener(this);
		
		reset = new JButton("Resetuj");
		reset.setPreferredSize(new Dimension(100, 25));
		panelButton.add(reset);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetFields();
			}
		});
		panelText.add(panelButton);

		labelImage=new JLabel(new ImageIcon(getClass().getResource("/triangleImage.png")));
		panelImage=new JPanel();
		panelImage.add(labelImage, new BorderLayout());

		add(panelText);
		add(panelImage);
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
				a = convert(textA.getText());//jeśli niepusty, to pobieramy
			} catch (NumberFormatException e) {
				return false;							//jeśli litery to kończymy
			}
			if(a<=0) return false;						//jeśli ujemny, to zwracamy false
		}
		else a = -1;									//jeśli był pusty, to inicjalizujemy na -1
		
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
		int numberOfDotted = myToolBarFormat.getNumberOfDotted();
		String form = "%.2f";
		if(numberOfDotted==2)
			form = "%.2f";
		else if(numberOfDotted==3)
			form = "%.3f";
		else
			form = "%.4f";
		
		if(triangle.getASide()!=-1)	textA.setText(String.format(form, triangle.getASide()));
		if(triangle.getBSide()!=-1) textB.setText(String.format(form, triangle.getBSide()));
		if(triangle.getCSide()!=-1) textC.setText(String.format(form, triangle.getCSide()));
		if(triangle.getHeightA()!=-1) textHeightA.setText(String.format(form, triangle.getHeightA()));
		if(triangle.getHeightB()!=-1) textHeightB.setText(String.format(form, triangle.getHeightB()));
		if(triangle.getHeightC()!=-1) textHeightC.setText(String.format(form, triangle.getHeightC()));
		if(triangle.getBiggerRadius()!=-1) textRadiusBigger.setText(String.format(form, triangle.getBiggerRadius()));
		if(triangle.getSmallerRadius()!=-1) textRadiusSmaller.setText(String.format(form, triangle.getSmallerRadius()));
		if(triangle.getPerimeter()!=-1) textPerimeter.setText(String.format(form, triangle.getPerimeter()));
		if(triangle.getArea()!=-1) textArea.setText(String.format(form, triangle.getArea()));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!getFromTextFields())
			JOptionPane.showMessageDialog(this, "Jeden z podanych argumentów jest błędny", 
					"Ostrzeżenie", JOptionPane.ERROR_MESSAGE);
		else{
			if(!checkSensOfArguments()){
				JOptionPane.showMessageDialog(this, "Błędne dane, podane wartości nie są wartościami trójkąta", 
						"Ostrzeżenie", JOptionPane.ERROR_MESSAGE);
			}
			else{
				if(a==b && b==c){
					TriangleEquilateral traingleEquilateral = new TriangleEquilateral(a, area, perimeter, heightA);
					if(traingleEquilateral.checkCorrect())
						setTextFields(traingleEquilateral);
					else
						JOptionPane.showMessageDialog(this, "Nic nie zostało obliczone", "Komunikat", 
								JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					Triangle triangle = new Triangle(a, b, c, angleA, angleB, angleC, area, perimeter, heightA, 
							heightB, heightC);
					if(triangle.checkCorrect())
						setTextFields(triangle);
					else
						JOptionPane.showMessageDialog(this, "Nic nie zostało obliczone", "Komunikat", 
								JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
}
