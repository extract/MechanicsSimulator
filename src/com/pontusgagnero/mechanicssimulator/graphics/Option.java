package com.pontusgagnero.mechanicssimulator.graphics;

import javax.swing.*;


/**
 * Created by extract on 2015-05-23.
 */
public class Option extends JPanel {
	private JLabel _settingText;
	private JComponent _settingOption;

	public enum SettingType {
		TEXTBOX, TEXTAREA, RADIOBUTTON, CHECKBOX, BUTTON;
	}

	public Option(String settingText, SettingType st, String defaultValue) {
		_settingText = new JLabel(settingText);
		switch(st) {
			case BUTTON:
				_settingOption = new JButton(defaultValue);
				break;
			default:
				_settingOption = new JButton(defaultValue);
				break;
		}
		add(_settingText);
		add(_settingOption);
	}
	public JButton getButton() {
		if(_settingOption instanceof JButton) {
			return (JButton)_settingOption;
		} else {
			return null;
		}
	}
}
