package com.pontusgagnero.mechanicssimulator.solids;

import com.pontusgagnero.mechanicssimulator.physics.Force;

import java.awt.*;

/**
 * Created by extract on 2015-05-10.
 */
public class PhysicsObject {
	private Solid _solid;

	private float _x, _y, _width, _height;
	private double _localRotation = 0;
	private Color _color;
	private double _jumpingVelocity = 5;

	public float getMass() {
		return _mass;
	}

	public void setMass(float _mass) {
		this._mass = _mass;
	}

	private float _mass;

	private double _velocityX, _velocityY;
	private double _accelerationX;

	public double getAccelerationY() {
		return _accelerationY;
	}

	public double getAccelerationX() {
		return _accelerationX;
	}

	private double _accelerationY;
	private double _rotationAcceleration;
	private double _rotationSpeed;


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
	public PhysicsObject(float x, float y, float width, float height, double rotatation, float mass, Color color, Solid shape) {
		_solid = shape;
		_mass = mass;
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setColor(color);
		setLocalRotation(rotatation);
	}

	// Mostly for testing purposes
	public void move(double velocityX, double velocityY) {
		this._x += velocityX;
		setX(this._x);
		this._y += velocityY;
		setY(this._y);
	}

	public void jump(){
		addVelocity(0, -_jumpingVelocity);
	}

	public void addVelocity(double velocityX, double velocityY) {

		this._velocityX += velocityX;
		this._velocityY += velocityY;
	}

	public void setVelocity(double velocityX, double velocityY) {
		this._velocityX = velocityX;
		this._velocityY = velocityY;
	}
	public double getVelocityX() {
		return this._velocityX;
	}
	public double getVelocityY() {
		return this._velocityY;
	}

	public void rotate(double angularVelocity) {
		_localRotation += angularVelocity;
		setLocalRotation(_localRotation);
	}

	public void addForceToCenter(float force, double angleInDegrees) { // Force in newtons and angle in radians. One pixel = 1 meter currently.
		_accelerationX += force*Math.cos(Math.toRadians(angleInDegrees))/_mass;
		_accelerationY += force*Math.sin(Math.toRadians(angleInDegrees))/_mass;
	}

	public void addMomentum(float momentum) {
		_rotationAcceleration += momentum;
	}

	public void addMomentum(float force, double distance, double direction) {

		_rotationAcceleration -= force*Math.cos(Math.toDegrees(direction))*distance;
	}
	// Not working perfectly....
	public void addForce(Force force) {
		double angleBetween = 0;
		if(force.getPositionY()-getYM() > 0) angleBetween = -90;
		else if (force.getPositionY()-getYM() < 0) angleBetween = 90;
		if(force.getPositionX()-getXM() != 0)
			angleBetween = Math.toDegrees(Math.atan((force.getPositionY() - getYM())/(force.getPositionX() - getXM())));
		if(force.getPositionX()-getXM() != 0 && force.getDirection() < 0)
			angleBetween = Math.toDegrees(Math.atan2((force.getPositionY() - getYM()),(force.getPositionX() - getXM())));
		double distance = Math.sqrt(
				Math.pow(force.getPositionY()-getYM(),2)+
				Math.pow(force.getPositionX()-getXM(),2)
		);
		System.out.println((float)(force.getPositionY()-getYM()) + "G "+force.getDirection()+"G ->"+(force.getDirection()-angleBetween)+" G"+angleBetween+"G " + (float)(force.getPositionX() - getXM()));
		addMomentum((float) (force.getForce() * Math.sin(force.getDirection() - angleBetween)), distance, force.getDirection());
		addForceToCenter(force.getForce(), force.getDirection());
	}

	// Remove
	public double getLocalRotationSpeed(){
		return _rotationSpeed;
	}

	public void update(float deltaTime) {
		// Add friction or else this will go forever.
		_velocityX += _accelerationX*deltaTime;
		_velocityY += _accelerationY*deltaTime;
		_rotationSpeed += _rotationAcceleration*deltaTime;
		move(_velocityX, _velocityY);
		rotate(_rotationSpeed);
	}

	public float getX() {
		return _x;
	}

	public float getXM() {
		return _x+_width/2;
	}
	public float getYM() {
		return _y+_height/2;
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

	public float getLocalRotation() {
		return _height;
	}

	public void setLocalRotation(double _localRotation) {
		this._localRotation = _localRotation;
		_solid.setLocalRotation(_localRotation);
	}

	public Color getColor() {
		return _color;
	}

	public void setColor(Color _color) {
		this._color = _color;
		_solid.setColor(_color);
	}
}
