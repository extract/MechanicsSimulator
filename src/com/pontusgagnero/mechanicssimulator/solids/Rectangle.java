package com.pontusgagnero.mechanicssimulator.solids;

import java.awt.*;

/**
 * Created by extract on 2015-05-10.
 *
 * The point of this class is to draw itself and interact. It will not do anything but show up as a retangle graphically.
 * For example, if a physicsbody uses this, it will change it's dimensions but if a staticbody uses it it will not.
 */

public class Rectangle extends SimObject {
	private int _x, _y, _width, _height;
	private Color _color;

	void paint( Graphics g ) {

		g.drawRect(_x, _y, _width, _height);
	}

	public Rectangle(int positionX, int positionY, int width, int height, Color color) {
		_x = positionX;
		_y = positionY;

		_width = width;
		_height = height;

		_color = color;

	}

	public int getX() {
		return _x;
	}

	public void setX(int _x) {
		this._x = _x;
	}

	public int getY() {
		return _y;
	}

	public void setY(int _y) {
		this._y = _y;
	}

	public int getWidth() {
		return _width;
	}

	public void setWidth(int _width) {
		this._width = _width;
	}

	public int getHeight() {
		return _height;
	}

	public void setHeight(int _height) {
		this._height = _height;
	}
}
