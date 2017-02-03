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
import com.GeoApp.Math.Deltoid;

public class DeltoidPanel extends JPanel implements ActionListener {
	
	private double a, b, radius, diagonalLong, diagonalShort, area, perimeter, angle;
	private JLabel labelImage, labelA, labelB, labelRadius, labelDiagonalLong, labelDiagonalShort,
	labelArea, labelPerimeter, labelAngle;
	private JTextField textA, textB, textRadius, textDiagonalLong, textDiagonalShort,
	textArea, textPerimeter, textAngle;
	private JButton solve, reset;
	private JPanel panelText, panelImage, panelA, panelB, panelRadius, panelDiagonalLong, panelDiagonalShort,
	panelArea, panelPerimeter, panelAngle, panelButton;
	private ApplicationToolBarFormat myToolBarFormat;
	
	public DeltoidPanel(ApplicationToolBarFormat myToolBarFormat) {
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

		Dimension d=new Dimension(70,25);
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

		panelRadius=new JPanel();
		labelRadius= new JLabel("r");
		panelRadius.add(labelRadius);
		textRadius=new JTextField();
		textRadius.setPreferredSize(d);
		panelRadius.add(textRadius);
		panelText.add(panelRadius);

		panelAngle=new JPanel();
		labelAngle = new JLabel("α");
		panelAngle.add(labelAngle);
		textAngle=new JTextField();
		textAngle.setPreferredSize(d);
		panelAngle.add(textAngle);
		panelText.add(panelAngle);

		panelDiagonalShort=new JPanel();
		labelDiagonalShort=new JLabel("<html>d<sub>1</sub></html>");
		panelDiagonalShort.add(labelDiagonalShort);
		textDiagonalShort=new JTextField();
		textDiagonalShort.setPreferredSize(d);
		panelDiagonalShort.add(textDiagonalShort);
		panelText.add(panelDiagonalShort);
		
		panelDiagonalLong=new JPanel();
		labelDiagonalLong= new JLabel("<html>d<sub>2</sub></html>");
		panelDiagonalLong.add(labelDiagonalLong);
		textDiagonalLong = new JTextField();
		textDiagonalLong.setPreferredSize(d);
		panelDiagonalLong.add(textDiagonalLong);
		panelText.add(panelDiagonalLong);

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
		textRadius.addActionListener(this);
		textDiagonalLong.addActionListener(this);
		textDiagonalShort.addActionListener(this);
		textArea.addActionListener(this);
		textPerimeter.addActionListener(this);
		textAngle.addActionListener(this);

		panelButton=new JPanel();
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
	
		labelImage=new JLabel(new ImageIcon(getClass().getResource("/deltoidImage.png")));
		panelImage=new JPanel();
		panelImage.add(labelImage, new BorderLayout());

		add(panelText);
		add(panelImage);
	}
	private void resetFields() {
		textA.setText(""); textB.setText("");  textDiagonalLong.setText(""); textDiagonalShort.setText("");
		textAngle.setText(""); textRadius.setText(""); textArea.setText(""); textPerimeter.setText(""); textAngle.setText("");
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



		if(!textDiagonalLong.getText().equals("")){
			try {
				diagonalLong = convert(textDiagonalLong.getText());
			} catch (NumberFormatException e1) {
				return false;
			}
			if(diagonalLong<=0) return false;
		}
		else diagonalLong = -1;


		if(!textDiagonalShort.getText().equals("")){
			try {
				diagonalShort = convert(textDiagonalShort.getText());
			} catch (NumberFormatException e1) {
				return false;
			}
			if(diagonalShort<=0) return false;
		}
		else diagonalShort = -1;

		if(!textRadius.getText().equals("")){
			try{
				radius=convert(textRadius.getText());
			}catch(NumberFormatException e){
				return false;
			}
			if(radius<=0) return false;
		}
		else radius=-1;

		if(!textAngle.getText().equals("")){
			try{
				angle=convert(textAngle.getText());
			}catch(NumberFormatException e){
				return false;
			}
			if(angle<=0) return false;
			angle = angle*(Math.PI/180.0);
		}
		else angle=-1;

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

	private void setTextFields(Deltoid deltoid) {
		int numberOfDotted = myToolBarFormat.getNumberOfDotted();
		String form = "%.2f";
		if(numberOfDotted==2)
			form = "%.2f";
		else if(numberOfDotted==3)
			form = "%.3f";
		else
			form = "%.4f";
		
		if(deltoid.getA()!=-1) textA.setText(String.format(form,deltoid.getA()));
		if(deltoid.getB()!=-1) textB.setText(String.format(form,deltoid.getB()));
		if(deltoid.getPerimeter()!=-1) textPerimeter.setText(String.format(form,deltoid.getPerimeter()));
		if(deltoid.getDiagonalLong()!=-1) textDiagonalLong.setText(String.format(form,deltoid.getDiagonalLong()));
		if(deltoid.getDiagonalShort()!=-1) textDiagonalShort.setText(String.format(form,deltoid.getDiagonalShort()));
		if(deltoid.getRadius()!=-1) textRadius.setText(String.format(form, deltoid.getRadius()));
		if(deltoid.getArea()!=-1) textArea.setText(String.format(form,deltoid.getArea()));
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

				Deltoid deltoid = new Deltoid(a, b, radius, diagonalLong, diagonalShort, area, perimeter, angle);
				if(deltoid.checkCorrect())
					setTextFields(deltoid);
				else
					JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostrzeżenie", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
