package com.pontusgagnero.mechanicssimulator.graphics;

import com.pontusgagnero.mechanicssimulator.Engine;
import com.pontusgagnero.mechanicssimulator.physics.PhysM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by extract on 2015-05-10.
 * This class will manage the panels, when to show up.
 */
public class GUIManager extends JFrame implements ActionListener {
	private Dimension _windowSize;



	// Add necessary JStuff for _menuPanel.
	private JPanel _menuPanel = new JPanel();
	private JLabel _menuTextTitle = new JLabel("Mechanics simulator");
	private JButton _menuButtonStart = new JButton("Start");
	private JButton _menuButtonOption = new JButton("Options");
	private JButton _menuButtonQuit = new JButton("Quit");

	// Add necessary JStuff for _optionPanel.
	private JPanel _optionPanel = new JPanel();
	private JLabel _optionTextTitle = new JLabel("Options"); // There should be a class named JTitle which just makes big JLabel.
	private Option[] _optionStuff = new Option[0];

	// Add simulation panel
	private GraphicsPanel _graphicsPanel;


	// Defines the engine as a PhysM engine.
	private Engine _engine;

	public GUIManager(String title, Dimension windowSize, Engine engine) {
		_windowSize = windowSize;
		_engine = engine;
		this.setTitle(title);
		this.setLocation(0, 0);
		this.setMinimumSize(windowSize);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		drawMenu();
	}

	public void clearDrawingSpace() {
		this.remove(_menuPanel);
		this.remove(_optionPanel);

	}

	public void drawMenu() {
		_menuPanel.setBackground(Color.red);
		_menuPanel.add(_menuTextTitle);

		_menuPanel.add(_menuButtonStart);
		_menuPanel.add(_menuButtonOption);
		_menuPanel.add(_menuButtonQuit);

		_menuButtonStart.addActionListener(this);
		_menuButtonOption.addActionListener(this);
		_menuButtonQuit.addActionListener(this);
		clearDrawingSpace();
		this.add(_menuPanel);
		repaint();
		validate();
	}

	public void drawOptions() {
		_optionPanel.setBackground(Color.blue);
		_optionPanel.add(_menuTextTitle);


		// Placeholder
		_optionPanel.add(_menuButtonStart);
		_optionPanel.add(_menuButtonOption);
		_optionPanel.add(_menuButtonQuit);
		clearDrawingSpace();
		this.add(_optionPanel);
		repaint();
		validate();
	}

	public void runSimulation() {
		clearDrawingSpace();
		_graphicsPanel = new GraphicsPanel(_windowSize, _engine);
		add(_graphicsPanel);
		repaint();
		validate();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(_menuButtonStart)) {
			runSimulation();
			return;
		}
		if(e.getSource().equals(_menuButtonOption)) {
			drawOptions();
			return;
		}
		if(e.getSource().equals(_menuButtonQuit)) {
			System.exit(0);
		}

	}
}
