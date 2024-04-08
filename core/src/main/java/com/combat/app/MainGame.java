package com.combat.app;

import com.badlogic.gdx.Game;

/**
 * Principal entry pont of the entire game
 */
public class MainGame extends Game {

	@Override
	public void create() {

		this.setScreen(new MainMenuScreen(this));
	}
	
	
}
