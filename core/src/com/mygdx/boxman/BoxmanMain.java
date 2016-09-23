package com.mygdx.boxman;

import com.badlogic.gdx.Game;
import com.mygdx.boxman.screns.Start;

public class BoxmanMain extends Game {

	
	@Override
	public void create () {
		setScreen(new Start());
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
