package com.pontusgagnero.mechanicssimulator.graphics;

import com.pontusgagnero.mechanicssimulator.Engine;
import com.pontusgagnero.mechanicssimulator.solids.Rectangle;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by extract on 2015-05-10.
 */
public class GraphicsPanel extends JPanel implements ActionListener {
	private Timer _timer;
	private Dimension _windowSize;

	// Target framerate as default will be 25.
	private int _targetFramerate = 60; // FPS

	private int _framerate = 1000/_targetFramerate; // In milliseconds

	private float _deltaTime = 1f/_targetFramerate; // this is a hack. Make this actually count the time
	// this is used to multiply with all
	// factors that contain movement as different framerates
	// should not make objects move with different speeds.

	//
	private Engine _engine;

	@Override
	public void paint(Graphics g){
		g.setColor(getBackground());
		g.clearRect(0, 0, _windowSize.width, _windowSize.height);

		_engine.paint(g);
	}

	public GraphicsPanel(Dimension windowSize, Engine engine) {
		_engine = engine;
		_targetFramerate = _engine.getFramerate();

		_windowSize = windowSize;

		this.setBackground(Color.red);
		this.setVisible(true);
		// Don't you hate it when libraries use words that are common?
		_timer = new Timer(_framerate, this);
		_timer.start();

	}


	public void update() {
		_engine.update();
		this.repaint();
		Toolkit.getDefaultToolkit().sync();
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		update();

	}
}
