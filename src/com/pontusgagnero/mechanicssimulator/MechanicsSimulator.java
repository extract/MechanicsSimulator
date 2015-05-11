package com.pontusgagnero.mechanicssimulator;

import com.pontusgagnero.mechanicssimulator.graphics.GUIManager;

import java.awt.*;

/**
 * Created by extract on 2015-05-10.
 */
public class MechanicsSimulator {
	public static final String WINDOW_TITLE = "Mechanics Simulator";
	private static final int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
	    new Simulator(WINDOW_TITLE, new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
    }
}
