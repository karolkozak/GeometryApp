package com.GeoApp.App;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.GeoApp.Panels.CirclePanel;
import com.GeoApp.Panels.DeltoidPanel;
import com.GeoApp.Panels.DiamondPanel;
import com.GeoApp.Panels.EllipsePanel;
import com.GeoApp.Panels.HexagonPanel;
import com.GeoApp.Panels.OctagonPanel;
import com.GeoApp.Panels.PentagonPanel;
import com.GeoApp.Panels.RectanglePanel;
import com.GeoApp.Panels.RhomboidPanel;
import com.GeoApp.Panels.SquarePanel;
import com.GeoApp.Panels.TrapezoidPanel;
import com.GeoApp.Panels.TrianglePanel;

public class ApplicationAlfa extends JFrame {
	
	private static final int defaultWidth = 750;
	private static final int defaultHeigth = 400;
	private ApplicationMenu myMenu;
	private ApplicationToolBar myToolBar;
	private ApplicationToolBarFormat myToolBarFormat = new ApplicationToolBarFormat();
	private ToolBarListener toolBarListener;
	
	private TrianglePanel panelTriangle = new TrianglePanel(myToolBarFormat);
	private RectanglePanel panelRectangle = new RectanglePanel(myToolBarFormat);
	private CirclePanel panelCircle = new CirclePanel(myToolBarFormat);
	private SquarePanel panelSquare = new SquarePanel(myToolBarFormat);
	private DiamondPanel panelDiamond = new DiamondPanel(myToolBarFormat);
	private RhomboidPanel panelRhomboid = new RhomboidPanel(myToolBarFormat);
	private DeltoidPanel panelDeltoid = new DeltoidPanel(myToolBarFormat);
	private TrapezoidPanel panelTrapezoid = new TrapezoidPanel(myToolBarFormat);
	private HexagonPanel panelHexagon = new HexagonPanel(myToolBarFormat);
	private PentagonPanel panelPentagon = new PentagonPanel(myToolBarFormat);
	private EllipsePanel panelEllipse = new EllipsePanel(myToolBarFormat);
	private OctagonPanel panelOctagon = new OctagonPanel(myToolBarFormat);
	
	public ApplicationAlfa() {
		setTitle("Geometry Application");
		setMinimumSize(new Dimension(defaultWidth, defaultHeigth));
		setLocation(300, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		setIconImage(new ImageIcon(getClass().getResource("/favicon2.png")).getImage());
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");			
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		int dismissDelay = ToolTipManager.sharedInstance().getDismissDelay();
	    // Keep the tool tip showing
	    dismissDelay = 1000;
	    ToolTipManager.sharedInstance().setDismissDelay(dismissDelay);

		drawFrame();
		repaint();
		revalidate();
	}
	
	private JPanel panelToolBar;
	private JScrollPane scrollToolBar;
	private void drawFrame() {
		myMenu = new ApplicationMenu();
		myToolBar = new ApplicationToolBar();
		toolBarListener = new ToolBarListener();
		
		myMenu.getMenuItemClose().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		int length = myToolBar.getJButtons().length;
		for(int i = 0; i<length; i++){
			myToolBar.getJButtons()[i].addActionListener(toolBarListener);
		}
		
		setJMenuBar(myMenu.getMyMenuBar());
		myMenu.getCheckBoxMenuItemFormat().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(myMenu.getCheckBoxMenuItemFormat().isSelected()){
					add(myToolBarFormat.getToolBar(), BorderLayout.EAST);
					repaint();
					revalidate();
				}
				else{
					remove(myToolBarFormat.getToolBar());
					repaint();
					revalidate();
				}
			}
		});
		panelToolBar = new JPanel(new GridLayout(1, 1));
		panelToolBar.add(myToolBar.getToolBar());
		scrollToolBar = new JScrollPane(panelToolBar, JScrollPane.VERTICAL_SCROLLBAR_NEVER, 
											JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollToolBar, BorderLayout.NORTH);	
	}

	class ToolBarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if(buttonName.equals("Trójk¹t")){
				remove(panelRectangle);
				remove(panelCircle);
				remove(panelSquare);
				remove(panelDiamond);
				remove(panelRhomboid);
				remove(panelDeltoid);
				remove(panelTrapezoid);
				remove(panelHexagon);
				remove(panelPentagon);
				remove(panelEllipse);
				remove(panelOctagon);
				add(panelTriangle, BorderLayout.CENTER);
				repaint();
				revalidate();
			}
			else if(buttonName.equals("Prostok¹t")){
				remove(panelTriangle);
				remove(panelCircle);
				remove(panelSquare);
				remove(panelDiamond);
				remove(panelRhomboid);
				remove(panelDeltoid);
				remove(panelTrapezoid);
				remove(panelHexagon);
				remove(panelPentagon);
				remove(panelEllipse);
				remove(panelOctagon);
				add(panelRectangle, BorderLayout.CENTER);
				repaint();
				revalidate();
			}
			else if(buttonName.equals("Ko³o")){
				remove(panelTriangle);
				remove(panelRectangle);
				remove(panelSquare);
				remove(panelDiamond);
				remove(panelRhomboid);
				remove(panelDeltoid);
				remove(panelTrapezoid);
				remove(panelHexagon);
				remove(panelPentagon);
				remove(panelEllipse);
				remove(panelOctagon);
				add(panelCircle, BorderLayout.CENTER);
				repaint();
				revalidate();
			}
			else if(buttonName.equals("Kwadrat")){
				remove(panelTriangle);
				remove(panelRectangle);
				remove(panelCircle);
				remove(panelDiamond);
				remove(panelRhomboid);
				remove(panelDeltoid);
				remove(panelTrapezoid);
				remove(panelHexagon);
				remove(panelPentagon);
				remove(panelEllipse);
				remove(panelOctagon);
				add(panelSquare, BorderLayout.CENTER);
				repaint();
				revalidate();
			}
			else if(buttonName.equals("Romb")){
				remove(panelTriangle);
				remove(panelRectangle);
				remove(panelCircle);
				remove(panelSquare);
				remove(panelRhomboid);
				remove(panelDeltoid);
				remove(panelTrapezoid);
				remove(panelHexagon);
				remove(panelPentagon);
				remove(panelEllipse);
				remove(panelOctagon);
				add(panelDiamond, BorderLayout.CENTER);
				repaint();
				revalidate();
			}
			else if(buttonName.equals("Równoleg³obok")){
				remove(panelTriangle);
				remove(panelRectangle);
				remove(panelCircle);
				remove(panelSquare);
				remove(panelDiamond);
				remove(panelDeltoid);
				remove(panelTrapezoid);
				remove(panelHexagon);
				remove(panelPentagon);
				remove(panelEllipse);
				remove(panelOctagon);
				add(panelRhomboid, BorderLayout.CENTER);
				repaint();
				revalidate();
			}
			else if(buttonName.equals("Deltoid")){
				remove(panelTriangle);
				remove(panelRectangle);
				remove(panelCircle);
				remove(panelSquare);
				remove(panelDiamond);
				remove(panelRhomboid);
				remove(panelTrapezoid);
				remove(panelHexagon);
				remove(panelPentagon);
				remove(panelEllipse);
				remove(panelOctagon);
				add(panelDeltoid, BorderLayout.CENTER);
				repaint();
				revalidate();
			}
			else if(buttonName.equals("Trapez")){
				remove(panelTriangle);
				remove(panelRectangle);
				remove(panelCircle);
				remove(panelSquare);
				remove(panelDiamond);
				remove(panelRhomboid);
				remove(panelDeltoid);
				remove(panelHexagon);
				remove(panelPentagon);
				remove(panelEllipse);
				remove(panelOctagon);
				add(panelTrapezoid, BorderLayout.CENTER);
				repaint();
				revalidate();
			}
			else if(buttonName.equals("Piêciok¹t foremny")){
				remove(panelTriangle);
				remove(panelRectangle);
				remove(panelCircle);
				remove(panelSquare);
				remove(panelDiamond);
				remove(panelRhomboid);
				remove(panelDeltoid);
				remove(panelTrapezoid);
				remove(panelHexagon);
				remove(panelEllipse);
				remove(panelOctagon);
				add(panelPentagon, BorderLayout.CENTER);
				repaint();
				revalidate();
			}
			else if(buttonName.equals("Szeœciok¹t foremny")){
				remove(panelTriangle);
				remove(panelRectangle);
				remove(panelCircle);
				remove(panelSquare);
				remove(panelDiamond);
				remove(panelRhomboid);
				remove(panelDeltoid);
				remove(panelTrapezoid);
				remove(panelPentagon);
				remove(panelEllipse);
				remove(panelOctagon);
				add(panelHexagon, BorderLayout.CENTER);
				repaint();
				revalidate();
			}
			else if(buttonName.equals("Elipsa")){
				remove(panelTriangle);
				remove(panelRectangle);
				remove(panelCircle);
				remove(panelSquare);
				remove(panelDiamond);
				remove(panelRhomboid);
				remove(panelDeltoid);
				remove(panelTrapezoid);
				remove(panelHexagon);
				remove(panelPentagon);
				remove(panelOctagon);
				add(panelEllipse, BorderLayout.CENTER);
				repaint();
				revalidate();
			}
			else if(buttonName.equals("Oœmiok¹t foremny")){
				remove(panelTriangle);
				remove(panelRectangle);
				remove(panelCircle);
				remove(panelSquare);
				remove(panelDiamond);
				remove(panelRhomboid);
				remove(panelDeltoid);
				remove(panelTrapezoid);
				remove(panelHexagon);
				remove(panelPentagon);
				remove(panelEllipse);
				add(panelOctagon, BorderLayout.CENTER);
				repaint();
				revalidate();
			}
		}
	}
	
	public static void main(String[] args) {
		new ApplicationAlfa();
	}
}

