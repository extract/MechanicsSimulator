package com.pontusgagnero.mechanicssimulator.solids;

import java.awt.*;

/**
 * Created by extract on 2015-05-23.
 */
public abstract class Solid {
	private float _x, _y, _width, _height;
	private Color _color;
	public abstract void paint( Graphics g );
	public abstract void setX(float x);
	public abstract void setY(float y);
	public abstract void setWidth(float w);
	public abstract void setHeight(float h);
	public abstract void setLocalRotation(double localRotation);
	public abstract float getX();
	public abstract float getY();
	public abstract float getWidth();
	public abstract float getHeight();
	public abstract double getLocalRotation();


	public abstract void setColor(Color color);
}
