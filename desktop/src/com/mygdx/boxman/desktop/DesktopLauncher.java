package com.mygdx.boxman.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.boxman.BoxmanMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Boxman";
		config.width = 1280;
		config.height = 720;
		
		
		new LwjglApplication(new BoxmanMain(), config);
	}
}
