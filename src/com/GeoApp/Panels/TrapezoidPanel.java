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
import com.GeoApp.Math.Trapezoid;
import com.GeoApp.Math.TrapezoidIsosceles;

public class TrapezoidPanel extends JPanel implements ActionListener {

	private double a, b, c, d, area, angleAcute1, angleAcute2, diagonalOne,
					diagonalTwo, perimeter, height, centerLine, centerLineDiagonal, angleDiagonal; 
	private JLabel labelImage, labelA, labelB, labelC, labelD, labelArea, labelAngleAcute1,
					labelAngleAcute2, labelDiagonalOne, labelDiagonalTwo, labelPerimeter, labelHeight,
						labelCenterLine, labelCenterLineDiagonal, labelAngleDiagonal; 
	private JTextField textA, textB, textC, textD, textArea, textAngleAcute1,
					textAngleAcute2, textDiagonalOne, textDiagonalTwo, textPerimeter, textHeight,
						textCenterLine, textCenterLineDiagonal, textAngleDiagonal;
	private JButton solve, reset;
	private JPanel panelText, panelImage, panelA, panelB, panelC, panelD, panelArea, panelAngleAcute1,
					panelAngleAcute2, panelDiagonalOne, panelDiagonalTwo, panelPerimeter, panelHeight,
					panelCenterLine, panelCenterLineDiagonal, panelAngleDiagonal, panelButton;
	private ApplicationToolBarFormat myToolBarFormat;
	
	public TrapezoidPanel(ApplicationToolBarFormat myToolBarFormat) {
		setLayout(new GridLayout(1, 2));
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");			
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		setBackground(new Color(214,217,223));
		
		this.myToolBarFormat = myToolBarFormat;
		
		createGUI();
		repaint();
		revalidate();
	}
	
	private void createGUI() {
		Dimension d=new Dimension(70, 25);
		panelText=new JPanel(new FlowLayout());
		
		panelA=new JPanel();
		labelA = new JLabel("a");
		panelA.add(labelA);
		textA = new JTextField();
		textA.setPreferredSize(d);
		panelA.add(textA);
		panelText.add(panelA);

		panelB=new JPanel();
		labelB = new JLabel("b");
		panelB.add(labelB);
		textB = new JTextField();
		textB.setPreferredSize(d);
		panelB.add(textB);
		panelText.add(panelB);

		panelC=new JPanel();
		labelC = new JLabel("c");
		panelC.add(labelC);
		textC = new JTextField();
		textC.setPreferredSize(d);
		panelC.add(textC);
		panelText.add(panelC);

		panelD=new JPanel();
		labelD = new JLabel("d");
		panelD.add(labelD);
		textD = new JTextField();
		textD.setPreferredSize(d);
		panelD.add(textD);
		panelText.add(panelD);

		panelAngleAcute2=new JPanel();
		labelAngleAcute2 = new JLabel("α");
		panelAngleAcute2.add(labelAngleAcute2);
		textAngleAcute2 = new JTextField();
		textAngleAcute2.setPreferredSize(d);
		panelAngleAcute2.add(textAngleAcute2);
		panelText.add(panelAngleAcute2);
		
		panelAngleAcute1=new JPanel();
		labelAngleAcute1 = new JLabel("β");
		panelAngleAcute1.add(labelAngleAcute1);
		textAngleAcute1 = new JTextField();
		textAngleAcute1.setPreferredSize(d);
		panelAngleAcute1.add(textAngleAcute1);
		panelText.add(panelAngleAcute1);
		
		panelAngleDiagonal = new JPanel();
		labelAngleDiagonal = new JLabel("ϕ");
		panelAngleDiagonal.add(labelAngleDiagonal);
		textAngleDiagonal = new JTextField();
		textAngleDiagonal.setPreferredSize(d);
		panelAngleDiagonal.add(textAngleDiagonal);
		panelText.add(panelAngleDiagonal);

		panelHeight=new JPanel();
		labelHeight = new JLabel("h");
		panelHeight.add(labelHeight);
		textHeight = new JTextField();
		textHeight.setPreferredSize(d);
		panelHeight.add(textHeight);
		panelText.add(panelHeight);

		panelDiagonalOne=new JPanel();
		labelDiagonalOne= new JLabel("<html>d<sub>1</sub></html>");
		panelDiagonalOne.add(labelDiagonalOne);
		textDiagonalOne = new JTextField();
		textDiagonalOne.setPreferredSize(d);
		panelDiagonalOne.add(textDiagonalOne);
		panelText.add(panelDiagonalOne);

		panelDiagonalTwo=new JPanel();
		labelDiagonalTwo = new JLabel("<html>d<sub>2</sub></html>");
		panelDiagonalTwo.add(labelDiagonalTwo);
		textDiagonalTwo = new JTextField();
		textDiagonalTwo.setPreferredSize(d);
		panelDiagonalTwo.add(textDiagonalTwo);
		panelText.add(panelDiagonalTwo);

		panelCenterLine=new JPanel();
		labelCenterLine = new JLabel("m");
		panelCenterLine.add(labelCenterLine);
		textCenterLine= new JTextField();
		textCenterLine.setPreferredSize(d);
		panelCenterLine.add(textCenterLine);
		panelText.add(panelCenterLine);

		panelCenterLineDiagonal=new JPanel();
		labelCenterLineDiagonal = new JLabel("n");
		panelCenterLineDiagonal.add(labelCenterLineDiagonal);
		textCenterLineDiagonal= new JTextField();
		textCenterLineDiagonal.setPreferredSize(d);
		panelCenterLineDiagonal.add(textCenterLineDiagonal);
		panelText.add(panelCenterLineDiagonal);

		panelArea=new JPanel();
		labelArea = new JLabel("Pole");
		panelArea.add(labelArea);
		textArea = new JTextField();
		textArea.setPreferredSize(d);
		panelArea.add(textArea);
		panelText.add(panelArea);

		panelPerimeter=new JPanel();
		labelPerimeter = new JLabel("Obwód");
		panelPerimeter.add(labelPerimeter);
		textPerimeter = new JTextField();
		textPerimeter.setPreferredSize(d);
		panelPerimeter.add(textPerimeter);
		panelText.add(panelPerimeter);
		
		textA.addActionListener(this);
		textB.addActionListener(this);
		textC.addActionListener(this);
		textD.addActionListener(this);
		textArea.addActionListener(this);
		textAngleAcute1.addActionListener(this);
		textAngleAcute2.addActionListener(this);
		textDiagonalOne.addActionListener(this);
		textDiagonalTwo.addActionListener(this);
		textPerimeter.addActionListener(this);
		textHeight.addActionListener(this);
		textCenterLine.addActionListener(this);
		textCenterLineDiagonal.addActionListener(this);
		textAngleDiagonal.addActionListener(this);

		panelButton=new JPanel();
		solve = new JButton("Oblicz!");
		solve.setPreferredSize(new Dimension(100,25));
		panelButton.add(solve);
		solve.addActionListener(this);

		reset = new JButton("Resetuj");
		reset.setPreferredSize(new Dimension(100,25));
		panelButton.add(reset);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetFields();
			}
		});
		panelText.add(panelButton);
		
		labelImage=new JLabel(new ImageIcon(getClass().getResource("/trapezoidImage.png")));
		panelImage=new JPanel();
		panelImage.add(labelImage, new BorderLayout());

		add(panelText);
		add(panelImage);
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
		int numberOfDotted = myToolBarFormat.getNumberOfDotted();
		String form = "%.2f";
		if(numberOfDotted==2)
			form = "%.2f";
		else if(numberOfDotted==3)
			form = "%.3f";
		else
			form = "%.4f";
		
		if(trapezoid.getA()!=-1) textA.setText(String.format(form,trapezoid.getA()));
		if(trapezoid.getB()!=-1) textB.setText(String.format(form,trapezoid.getB()));
		if(trapezoid.getC()!=-1) textC.setText(String.format(form,trapezoid.getC()));
		if(trapezoid.getD()!=-1) textD.setText(String.format(form,trapezoid.getD()));
		if(trapezoid.getHeight()!=-1) textHeight.setText(String.format(form,trapezoid.getHeight()));
		if(trapezoid.getPerimeter()!=-1) textPerimeter.setText(String.format(form,trapezoid.getPerimeter()));
		if(trapezoid.getDiagonalOne()!=-1) textDiagonalOne.setText(String.format(form,trapezoid.getDiagonalOne()));
		if(trapezoid.getDiagonalTwo()!=-1) textDiagonalTwo.setText(String.format(form,trapezoid.getDiagonalTwo()));
		if(trapezoid.getCenterLine()!=-1) textCenterLine.setText(String.format(form,trapezoid.getCenterLine()));
		if(trapezoid.getCenterLineDiagonal()!=-1) 
			textCenterLineDiagonal.setText(String.format(form,trapezoid.getCenterLineDiagonal()));
		if(trapezoid.getArea()!=-1) textArea.setText(String.format(form,trapezoid.getArea()));
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
				if(d==c){
					Trapezoid trapezoidIsosceles=new TrapezoidIsosceles(a,b,c, angleAcute1, diagonalOne, 
							height, area, perimeter, centerLine, centerLineDiagonal, angleDiagonal);
					if(trapezoidIsosceles.checkCorrect())
						setTextFields(trapezoidIsosceles);
					else
						JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostreżenie", JOptionPane.ERROR_MESSAGE);
				}
				else{
					Trapezoid trapezoid = new Trapezoid(a, b, c, d, angleAcute1, angleAcute2, diagonalOne, diagonalTwo, 
							height, area, perimeter, centerLine, centerLineDiagonal);
					if(trapezoid.checkCorrect())
						setTextFields(trapezoid);
					else
						JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostrzeżenie", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
