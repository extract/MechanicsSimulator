package com.pontusgagnero.mechanicssimulator.graphics.PanelTypes;

import com.pontusgagnero.mechanicssimulator.graphics.GUIManager;
import javafx.application.Application;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.Callable;

/**
 * Created by extract on 2015-05-10.
 */
public class MenuPanel extends JPanel {
	private JLabel textHeader;
	private JButton startButton;
	private JButton optionsButton;
	private JButton exitButton;
	private GUIManager _init;

	public MenuPanel(Dimension windowSize, GUIManager init) {
		_init = init;
		_init.runSimulation();
		this.setBackground(new Color(0.1f, 0.1f, 0.1f));
		this.setPreferredSize(windowSize);
		//this.setLayout(new FlowLayout());
		this.setVisible(true);
		createTitle("Mechanics simulator");
		createButton("Start", 1);
		createButton("Options", 2);
		createButton("Exit", 0);

	}

	public void createTitle(String titleText) {
		textHeader = new JLabel(titleText);
		textHeader.setFont(new Font(Font.MONOSPACED, 0, 58));
		textHeader.setForeground(new Color(0.9f, 0.9f, 0.9f));
		add(textHeader);
	}

	public void createButton(String s, int action) {
		startButton = new JButton(s);
		startButton.setForeground(Color.white);
		//startButton.setMnemonic(KeyEvent.VK_S);

		add(startButton);
	}
}
