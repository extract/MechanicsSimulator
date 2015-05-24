package com.pontusgagnero.mechanicssimulator.physics;

/**
 * Created by extract on 2015-05-23.
 */
public class Force {
	private float _positionX, _positionY;
	private float _force;
	private double _direction;

	public Force(float x, float y, float force, double direction) {
		_positionX = x;
		_positionY = y;
		_force = force;
		_direction = direction;
	}

	public float getPositionX() {
		return _positionX;
	}

	public float getPositionY() {
		return _positionY;
	}

	public float getForce() {
		return _force;
	}

	public void setPositionX(float _positionX) {
		this._positionX = _positionX;
	}

	public void setForce(float _force) {
		this._force = _force;
	}

	public void setPositionY(float _positionY) {
		this._positionY = _positionY;
	}

	public double getDirection() {
		return _direction;
	}

	public void setDirection(double _direction) {
		this._direction = _direction;
	}
}
