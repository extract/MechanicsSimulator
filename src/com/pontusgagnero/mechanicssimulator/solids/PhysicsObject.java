package com.pontusgagnero.mechanicssimulator.solids;

import java.awt.*;

/**
 * Created by extract on 2015-05-10.
 */
public class PhysicsObject {
	private Solid _solid;

	private float _x, _y, _width, _height;
	private Color _color;
	private float _mass;

	private double _velocityX, _velocityY;
	private double _accelerationX, _accelerationY;

	public void paint(Graphics g) {
		_solid.paint(g);
	}

	public PhysicsObject(float x, float y, float width, float height, float mass, Color color, Solid shape) {
		_solid = shape;
		_mass = mass;
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setColor(color);

	}

	// Mostly for testing purposes
	public void move(double velocityX, double velocityY) {
		_x += velocityX;
		setX(_x);
		_y += velocityY;
		setY(_y);
	}

	public void addForceToCenter(float force, float angleInDegrees) { // Force in newtons and angle in radians. One pixel = 1 meter currently.
		_accelerationX += force*Math.cos(Math.toRadians(angleInDegrees))/_mass;
		_accelerationY += force*Math.sin(Math.toRadians(angleInDegrees))/_mass;
		System.out.println(_accelerationX+" | "+_accelerationY);
	}

	public void update(float deltaTime) {
		// Add friction or else this will go forever.
		_velocityX += _accelerationX*deltaTime;
		_velocityY += _accelerationY*deltaTime;
		move(_velocityX, _velocityY);
	}

	public float getX() {
		return _x;
	}

	public void setX(float _x) {
		this._x = _x;
		_solid.setX(_x);
	}

	public float getY() {
		return _y;
	}

	public void setY(float _y) {
		this._y = _y;
		_solid.setY(_y);
	}

	public float getWidth() {
		return _width;
	}

	public void setWidth(float _width) {
		this._width = _width;
		_solid.setWidth(_width);
	}

	public float getHeight() {
		return _height;
	}

	public void setHeight(float _height) {
		this._height = _height;
		_solid.setHeight(_height);
	}

	public Color getColor() {
		return _color;
	}

	public void setColor(Color _color) {
		this._color = _color;
		_solid.setColor(_color);
	}
}
