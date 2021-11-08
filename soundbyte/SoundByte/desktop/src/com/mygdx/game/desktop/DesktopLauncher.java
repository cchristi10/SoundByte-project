package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.SoundByte;
import com.mygdx.game.testLevel;

public class DesktopLauncher {
	public static void main (String[] arg) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1920;
		config.height = 1080;



		new LwjglApplication(new SoundByte(), config);
	}
}
