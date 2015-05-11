package com.pontusgagnero.mechanicssimulator.graphics.PanelTypes;

import javafx.application.Application;

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;

/**
 * Created by extract on 2015-05-10.
 */
public class MenuPanel extends JPanel {
	private JLabel textHeader;
	private JButton startButton;

	public MenuPanel(Dimension windowSize) {
		this.setBackground(new Color(0.1f, 0.1f, 0.1f));
		this.setPreferredSize(windowSize);
		//this.setLayout(new FlowLayout());
		this.setVisible(true);
		createTitle("Mechanics simulator");
		createStartButton();

	}

	public void createTitle(String titleText) {
		textHeader = new JLabel(titleText);
		textHeader.setFont(new Font(Font.MONOSPACED, 0, 58));
		textHeader.setForeground(new Color(0.9f, 0.9f, 0.9f));
		add(textHeader);
	}

	public void createStartButton() {
		startButton = new JButton("Start simulation");
		startButton.setForeground(Color.white);
		startButton.setMnemonic(KeyEvent.VK_S);
		/*startButton.setAction(new Action() {
			@Override
			public Object getValue(String key) {
				return null;
			}

			@Override
			public void putValue(String key, Object value) {

			}

			@Override
			public void setEnabled(boolean b) {

			}

			@Override
			public boolean isEnabled() {
				return false;
			}

			@Override
			public void addPropertyChangeListener(PropertyChangeListener listener) {

			}

			@Override
			public void removePropertyChangeListener(PropertyChangeListener listener) {

			}

			@Override
			public void actionPerformed(ActionEvent e) {
				this.setEnabled(false);
			}
		});*/
		//setBackground(Color.DARK_GRAY);
		add(startButton);
	}
}
