package com.pontusgagnero.mechanicssimulator.graphics;
import com.pontusgagnero.mechanicssimulator.graphics.PanelTypes.MenuPanel;
import javax.swing.*;
import java.awt.*;
/**
 * Created by extract on 2015-05-10.
 * This class will manage the panels, when to show up.
 */
public class GUIManager extends JFrame {
	public GUIManager(String title, Dimension windowSize) {
		this.setTitle(title);
		this.setLocation(0, 0);
		this.setMinimumSize(windowSize);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		add(new MenuPanel(windowSize));
	}
}