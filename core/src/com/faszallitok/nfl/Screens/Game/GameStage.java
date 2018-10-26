package com.faszallitok.nfl.Screens.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.faszallitok.nfl.GlobalClasses.Assets;
import com.faszallitok.nfl.MyBaseClasses.Scene2D.MyStage;
import com.faszallitok.nfl.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.faszallitok.nfl.MyBaseClasses.UI.MyButton;
import com.faszallitok.nfl.MyGdxGame;

public class GameStage extends MyStage {
	private OneSpriteStaticActor menu;

	OneSpriteStaticActor aman;
	OneSpriteStaticActor bman;
	OneSpriteStaticActor szunyog;

	public GameStage(Batch batch, MyGdxGame game, final GameScreen screen) {
		super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

		OneSpriteStaticActor bg = new OneSpriteStaticActor(Assets.manager.get(Assets.BG_MENU));
		bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
		addActor(bg);

		menu = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_ICON));
		menu.setSize(30, 30);
		menu.setPosition(getViewport().getWorldWidth() - 40, getViewport().getWorldHeight() - 40);
		menu.addListener(new ClickListener() {
			@Override public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				screen.isPaused = true;
			}
		});
		addActor(menu);

		aman = new OneSpriteStaticActor(Assets.manager.get(Assets.AMAN));
		aman.setSize(aman.getWidth() / 4, aman.getHeight() / 4);
		addActor(aman);

		bman = new OneSpriteStaticActor(Assets.manager.get(Assets.BMAN));
        bman.setSize(bman.getWidth() / 4, bman.getHeight() / 4);
        bman.setX(800);
		addActor(bman);

		szunyog = new OneSpriteStaticActor(Assets.manager.get(Assets.SZUNYOG));
		szunyog.setSize(szunyog.getWidth() / 12, szunyog.getHeight() / 12);
		addActor(szunyog);


	}

	@Override public void init() {}
}
