package com.pontusgagnero.mechanicssimulator.physics;

import com.pontusgagnero.mechanicssimulator.Engine;
import com.pontusgagnero.mechanicssimulator.solids.*;
import com.pontusgagnero.mechanicssimulator.solids.Rectangle;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


/**
 * Created by extract on 2015-05-10.
 *
 * This is the current engine. It is called PhysM after Physics Manager. Inspired by PhysX name.
 */
public class PhysM extends Engine {
	private static final float GRAVITYACCELERATION = 9.81f;
	private float _deltaTime;
	private ArrayList<PhysicsObject> _physObjects = new ArrayList<>();
	private long _timeSinceLastUpdate;
	private float _targetFramerate;
	private boolean _isGrounded = false;

	public void paint(Graphics g) {
		for(PhysicsObject p : _physObjects) {
			p.paint(g);

		}
	}

	public PhysM(float targetFramerate) {
		_targetFramerate = targetFramerate;
		_timeSinceLastUpdate = System.nanoTime()/1000;
		addPhysicsObject(new PhysicsObject(0.f, 0.f, 50.f, 50.f, 10f, Color.red, new Rectangle()));
		for(PhysicsObject p : _physObjects) {
			p.addForceToCenter(GRAVITYACCELERATION * p.getMass(), 90);
		}
		//this.addMouseListener(this);
		//_physObjects.get(0).addForce(new Force(22f, 28f, 0.1f, 135));
	}

	public void update() {
		long curTime = System.nanoTime() / 1000;
		if(_deltaTime != 0) {

			_deltaTime = (curTime - _timeSinceLastUpdate) / 1000000.0f;

		}else{
			_deltaTime = 1/_targetFramerate;
		}
		_timeSinceLastUpdate = curTime;
		//System.out.println("DELTA TIME: "+ _deltaTime);
		for(PhysicsObject p : _physObjects) {
			// Attempt at normal force
			if(p.getY()+p.getHeight()*2 > 600) {
				p.addVelocity( 0, -(p.getVelocityY()+p.getVelocityY()*0.8));
				if(Math.abs(p.getY()+p.getHeight()*2-600) < 3 && Math.abs(p.getVelocityY()) < 0.2f) _isGrounded = true;
				if(_isGrounded == true) {



					if(true) {
						p.addForceToCenter(GRAVITYACCELERATION * p.getMass(), -90);
						p.setVelocity(0,0);

					}


				}

			}
			jump();
			p.update(_deltaTime);
		}
		//System.out.println(_physObjects.get(0)());
	}

	public void addPhysicsObject(PhysicsObject po) {
		_physObjects.add(po);
	}

	public void jump() {
		if(_isGrounded) {
			_physObjects.get(0).jump();
			_physObjects.get(0).addForceToCenter(GRAVITYACCELERATION * _physObjects.get(0).getMass(), 90);
			_isGrounded = false;
		}
	}
}
