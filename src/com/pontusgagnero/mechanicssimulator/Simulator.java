package com.pontusgagnero.mechanicssimulator;

import com.pontusgagnero.mechanicssimulator.graphics.GUIManager;
import com.pontusgagnero.mechanicssimulator.physics.PhysM;

import java.awt.*;

/**
 * Created by extract on 2015-05-10.
 */
public class Simulator {
	private Engine _engine;

	public Simulator(String title, Dimension windowSize){
		_engine = new PhysM();
		GUIManager GUI = new GUIManager(title, windowSize, _engine);
	}
}