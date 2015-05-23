package com.pontusgagnero.mechanicssimulator.physics;

import com.pontusgagnero.mechanicssimulator.Engine;
import com.pontusgagnero.mechanicssimulator.solids.*;
import com.pontusgagnero.mechanicssimulator.solids.Rectangle;


import java.awt.*;
import java.util.ArrayList;


/**
 * Created by extract on 2015-05-10.
 *
 * This is the current engine. It is called PhysM after Physics Manager. Inspired by PhysX name.
 */
public class PhysM extends Engine {
	private float _deltaTime;
	private ArrayList<PhysicsObject> _physObjects = new ArrayList<>();
	private long _timeSinceLastUpdate;

	public void paint(Graphics g) {
		for(PhysicsObject p : _physObjects) {
			p.paint(g);
		}
	}

	public PhysM() {
		_timeSinceLastUpdate = System.nanoTime()/1000;
		addPhysicsObject(new PhysicsObject(0.f, 0.f, 50.f, 50.f, 10f, Color.red, new Rectangle()));
	}

	public void update() {

		long curTime = System.nanoTime()/1000;
		_deltaTime = (curTime - _timeSinceLastUpdate)/1000000.0f;
		_timeSinceLastUpdate = curTime;

		for(PhysicsObject p : _physObjects) {
			p.addForceToCenter(1, 45);
			p.addForceToCenter(1, 45+180);
			p.update(_deltaTime);
		}
		System.out.println(_physObjects.get(0).getX());
	}

	public void addPhysicsObject(PhysicsObject po) {
		_physObjects.add(po);
	}
}
