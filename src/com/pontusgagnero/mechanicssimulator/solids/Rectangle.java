package com.pontusgagnero.mechanicssimulator.solids;

import java.awt.*;

/**
 * Created by extract on 2015-05-10.
 *
 * The point of this class is to draw itself and interact. It will not do anything but show up as a retangle graphically.
 * For example, if a physicsbody uses this, it will change it's dimensions but if a staticbody uses it it will not.
 */

public class Rectangle extends Solid {
	private float _x, _y, _width, _height;
	private Color _color;

	private double _localRotation = 0;

	public void paint( Graphics g ) {
		// Save the previous color and set it after so if a class forgot to put a color it will be put in the default color
		Color temp = g.getColor();
		g.setColor(_color);
		Graphics2D gg = (Graphics2D)g.create();
		gg.rotate(_localRotation, _x + _width / 2, _y + _height / 2);
		gg.fillRect((int) _x, (int) _y, (int) _width, (int)_height);

		gg.dispose();
		g.setColor(temp);
	}

	public Rectangle() {


	}

	public float getX() {
		return _x;
	}

	public void setX(float _x) {
		this._x = _x;
	}

	public float getY() {
		return _y;
	}

	public void setY(float _y) {
		this._y = _y;
	}

	public float getWidth() {
		return _width;
	}

	public void setWidth(float _width) {
		this._width = _width;
	}

	public float getHeight() {
		return _height;
	}

	@Override
	public void setColor(Color color) {
		_color = color;
	}

	public void setHeight(float _height) {
		this._height = _height;
	}

	public double getLocalRotation() {
		return _localRotation;
	}

	public void setLocalRotation(double _localRotation) {
		this._localRotation = _localRotation;
	}
}
