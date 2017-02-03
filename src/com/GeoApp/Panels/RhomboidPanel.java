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
import com.GeoApp.Math.Rhomboid;

public class RhomboidPanel extends JPanel implements ActionListener {

	private double a, b, angleA, angleB, heightB, heightA, area, perimeter, diagonalShort, diagonalLong, angleDiagonal;
	private JLabel labelImage, labelA, labelB, labelAngleA, labelAngleB, labelHeightB, labelHeightA, labelArea, 
					labelPerimeter, labelDiagonalShort, labelDiagonalLong, labelAngleDiagonal;
	private JTextField textA, textB, textAngleA, textAngleB, textHeightB, textHeightA, textArea, 
						textPerimeter, textDiagonalShort, textDiagonalLong, textAngleDiagonal;
	private JButton solve, reset;
	private JPanel panelText, panelImage, panelA, panelB, panelAngleA, panelAngleB, panelHeightB, panelHeightA, panelArea, 
					panelPerimeter, panelDiagonalShort, panelDiagonalLong, panelAngleDiagonal, panelButton;
	private ApplicationToolBarFormat myToolBarFormat;
	
	public RhomboidPanel(ApplicationToolBarFormat myToolBarFormat) {
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
		
		panelDiagonalLong = new JPanel();
		labelDiagonalLong = new JLabel("<html>d<sub>1</sub></html>");
		panelDiagonalLong.add(labelDiagonalLong);
		textDiagonalLong = new JTextField();
		textDiagonalLong.setPreferredSize(dimension);
		panelDiagonalLong.add(textDiagonalLong);
		panelText.add(panelDiagonalLong);
		
		panelDiagonalShort = new JPanel();
		labelDiagonalShort = new JLabel("<html>d<sub>2</sub></html>");
		panelDiagonalShort.add(labelDiagonalShort);
		textDiagonalShort = new JTextField();
		textDiagonalShort.setPreferredSize(dimension);
		panelDiagonalShort.add(textDiagonalShort);
		panelText.add(panelDiagonalShort);
		
		panelAngleDiagonal = new JPanel();
		labelAngleDiagonal = new JLabel("γ");
		panelAngleDiagonal.add(labelAngleDiagonal);
		textAngleDiagonal = new JTextField();
		textAngleDiagonal.setPreferredSize(dimension);
		panelAngleDiagonal.add(textAngleDiagonal);
		panelText.add(panelAngleDiagonal);
		
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
		textAngleA.addActionListener(this);
		textAngleB.addActionListener(this);
		textHeightB.addActionListener(this);
		textHeightA.addActionListener(this);
		textArea.addActionListener(this);
		textPerimeter.addActionListener(this);
		textDiagonalShort.addActionListener(this);
		textDiagonalLong.addActionListener(this);
		textAngleDiagonal.addActionListener(this);
		
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
		
		labelImage=new JLabel(new ImageIcon(getClass().getResource("/rhomboidImage.png")));
		panelImage=new JPanel();
		panelImage.add(labelImage, new BorderLayout());

		add(panelText);
		add(panelImage);
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
		int numberOfDotted = myToolBarFormat.getNumberOfDotted();
		String form = "%.2f";
		if(numberOfDotted==2)
			form = "%.2f";
		else if(numberOfDotted==3)
			form = "%.3f";
		else
			form = "%.4f";
		
		if(rhomboid.getA()!=-1)	textA.setText(String.format(form, rhomboid.getA()));
		if(rhomboid.getB()!=-1) textB.setText(String.format(form, rhomboid.getB()));
		if(rhomboid.getHeightA()!=-1) textHeightA.setText(String.format(form, rhomboid.getHeightA()));
		if(rhomboid.getHeightB()!=-1) textHeightB.setText(String.format(form, rhomboid.getHeightB()));
		if(rhomboid.getDiagonalShort()!=-1) textDiagonalShort.setText(String.format(form, rhomboid.getDiagonalShort()));
		if(rhomboid.getDiagonalLong()!=-1) textDiagonalLong.setText(String.format(form, rhomboid.getDiagonalLong()));
		if(rhomboid.getPerimeter()!=-1) textPerimeter.setText(String.format(form, rhomboid.getPerimeter()));
		if(rhomboid.getArea()!=-1) textArea.setText(String.format(form, rhomboid.getArea()));
	}
	
	private boolean checkSensOfArguments() {
		//TODO
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!getFromTextFields())
			JOptionPane.showMessageDialog(this, "Jeden z podanych argumentów jest błędny", 
					"Ostrzeżenie", JOptionPane.ERROR_MESSAGE);
		else{
			if(!checkSensOfArguments()){
				JOptionPane.showMessageDialog(this, "Błędne dane, podane wartości nie są wartościami równoległoboku", 
						"Ostrzeżenie", JOptionPane.ERROR_MESSAGE);
			}
			else{
				Rhomboid rhomboid = new Rhomboid(a, b, angleA, angleB, area, heightA, 
												heightB, perimeter, diagonalShort, diagonalLong, angleDiagonal);
				if(rhomboid.checkCorrect())
					setTextFields(rhomboid);
				else
					JOptionPane.showMessageDialog(this, "Nic nie zostało obliczone", "Komunikat", 
							JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
