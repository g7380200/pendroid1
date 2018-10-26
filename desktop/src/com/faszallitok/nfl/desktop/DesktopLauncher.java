package com.faszallitok.nfl.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.faszallitok.nfl.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		//System.setProperty("user.name", "Public");

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1024;
		config.height = 576;
		//config.title = "NeedForLegy: Mosquito Wanted";
		config.title = "MyGdxGame";

		new LwjglApplication(new MyGdxGame(), config);
	}
}
