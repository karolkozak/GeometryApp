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

import com.GeoApp.Math.Rhomboid;
import com.GeoApp.Math.Triangle;
import com.GeoApp.Math.TriangleEquilateral;

public class TestRhomboidGUI extends JFrame implements ActionListener {

	private double a, b, angleA, angleB, heightB, heightA, area, perimeter, diagonalShort, diagonalLong, angleDiagonal;
	private JLabel labelA, labelB, labelAngleA, labelAngleB, labelHeightB, labelHeightA, labelArea, 
					labelPerimeter, labelDiagonalShort, labelDiagonalLong, labelAngleDiagonal;
	private JTextField textA, textB, textAngleA, textAngleB, textHeightB, textHeightA, textArea, 
						textPerimeter, textDiagonalShort, textDiagonalLong, textAngleDiagonal;
	private JButton solve, reset;
	private JPanel panelA, panelB, panelAngleA, panelAngleB, panelHeightB, panelHeightA, panelArea, 
					panelPerimeter, panelDiagonalShort, panelDiagonalLong, panelAngleDiagonal, panelButton;
	
	public TestRhomboidGUI() {
		setSize(400, 220);
		setTitle("Rhomboid Test");
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
		
		panelDiagonalShort = new JPanel();
		labelDiagonalShort = new JLabel("Short diagonal");
		panelDiagonalShort.add(labelDiagonalShort);
		textDiagonalShort = new JTextField();
		textDiagonalShort.setPreferredSize(new Dimension(50, 20));
		panelDiagonalShort.add(textDiagonalShort);
		add(panelDiagonalShort);
		
		panelDiagonalLong = new JPanel();
		labelDiagonalLong = new JLabel("Long diagonal");
		panelDiagonalLong.add(labelDiagonalLong);
		textDiagonalLong = new JTextField();
		textDiagonalLong.setPreferredSize(new Dimension(50, 20));
		panelDiagonalLong.add(textDiagonalLong);
		add(panelDiagonalLong);
		
		panelAngleDiagonal = new JPanel();
		labelAngleDiagonal = new JLabel("Angle diagonal");
		panelAngleDiagonal.add(labelAngleDiagonal);
		textAngleDiagonal = new JTextField();
		textAngleDiagonal.setPreferredSize(new Dimension(50, 20));
		panelAngleDiagonal.add(textAngleDiagonal);
		add(panelAngleDiagonal);
		
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
		textA.setText(""); textB.setText(""); textAngleA.setText(""); textAngleB.setText(""); textHeightB.setText("");
		textHeightA.setText(""); textArea.setText(""); textPerimeter.setText(""); textDiagonalShort.setText("");
		textDiagonalLong.setText(""); textAngleDiagonal.setText("");
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
		
		if(!textDiagonalShort.getText().equals("")) {
			try {
				diagonalShort = convert(textDiagonalShort.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(diagonalShort<=0) return false;
		}
		else diagonalShort = -1;
		
		if(!textDiagonalLong.getText().equals("")) {
			try {
				diagonalLong = convert(textDiagonalLong.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(diagonalLong<=0) return false;
		}
		else diagonalLong = -1;
		
		if(!textAngleDiagonal.getText().equals("")) {
			try {
				angleDiagonal = convert(textAngleDiagonal.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(angleDiagonal<=0) return false;
			angleDiagonal = angleDiagonal*(Math.PI/180.0);
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
	
	private void setTextFields(Rhomboid rhomboid) {
		if(rhomboid.getA()!=-1)	textA.setText(String.format("%.3f", rhomboid.getA()));
		if(rhomboid.getB()!=-1) textB.setText(String.format("%.3f", rhomboid.getB()));
		if(rhomboid.getHeightA()!=-1) textHeightA.setText(String.format("%.3f", rhomboid.getHeightA()));
		if(rhomboid.getHeightB()!=-1) textHeightB.setText(String.format("%.3f", rhomboid.getHeightB()));
		if(rhomboid.getDiagonalShort()!=-1) textDiagonalShort.setText(String.format("%.3f", rhomboid.getDiagonalShort()));
		if(rhomboid.getDiagonalLong()!=-1) textDiagonalLong.setText(String.format("%.3f", rhomboid.getDiagonalLong()));
		if(rhomboid.getPerimeter()!=-1) textPerimeter.setText(String.format("%.3f", rhomboid.getPerimeter()));
		if(rhomboid.getArea()!=-1) textArea.setText(String.format("%.3f", rhomboid.getArea()));
	}
	
	private boolean checkSensOfArguments() {
		//TODO
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!getFromTextFields())
			JOptionPane.showMessageDialog(this, "Jeden z podanych argumentów jest b³êdny", 
					"Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
		else{
			if(!checkSensOfArguments()){
				JOptionPane.showMessageDialog(this, "B³êdne dane, podane wartoœci nie s¹ wartoœciami równoleg³oboku", 
						"Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
			}
			else{
				Rhomboid rhomboid = new Rhomboid(a, b, angleA, angleB, area, heightA, 
												heightB, perimeter, diagonalShort, diagonalLong, angleDiagonal);
				if(rhomboid.checkCorrect())
					setTextFields(rhomboid);
				else
					JOptionPane.showMessageDialog(this, "Nic nie zosta³o obliczone", "Komunikat", 
							JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		new TestRhomboidGUI();
	}
}
