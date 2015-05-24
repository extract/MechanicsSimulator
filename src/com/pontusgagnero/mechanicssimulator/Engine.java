package com.pontusgagnero.mechanicssimulator;

import java.awt.*;

/**
 * Created by extract on 2015-05-23.
 */
public abstract class Engine {
	private final long _versionNumber = 1; // First version of the engine starts at 1.000 or 1000

	private int _targetFramerate;
	private float _deltaTime;
	private float _timeSinceLastUpdate;

	public Engine(){

	}

	public void paint(Graphics g){

	}

	public int getFramerate() {
		return _targetFramerate;
	}

	public void update() {

	}
	public abstract void jump();

	public Object getDeltaTime() {
		return _deltaTime;
	}
}
