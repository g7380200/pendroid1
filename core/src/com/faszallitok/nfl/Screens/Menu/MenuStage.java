package com.faszallitok.nfl.Screens.Menu;

import com.badlogic.gdx.Gdx;
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
import com.faszallitok.nfl.Screens.About.AboutScreen;
import com.faszallitok.nfl.Screens.Data.DataScreen;
import com.faszallitok.nfl.Screens.Game.GameScreen;

public class MenuStage extends MyStage {

    private MyButton play;
    private MyButton about;
	private MyButton debug;
    private MyButton quit;

    public MenuStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        OneSpriteStaticActor bg = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU));
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

        addActor(bg);

        play = new MyButton("Játék", game.getButtonStyle());
        play.setPosition(50, 250);
        play.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getGame().setScreen(new DataScreen(getGame()));
            }
        });
        addActor(play);

        about = new MyButton("A Játékról", game.getButtonStyle());
        about.setPosition(50, 190);
        about.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getGame().setScreen(new AboutScreen(getGame()));
            }
        });
        addActor(about);

        debug = new MyButton("DEBUG", game.getButtonStyle());
        debug.setPosition(50, 390);
        debug.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getGame().setScreen(new GameScreen(getGame(), new float[] { 8.0f, 5.0f, 30.0f, 70.0f, 150.0f }));
            }
        });
        addActor(debug);

        quit = new MyButton("Kilépés", game.getButtonStyle());
        quit.setPosition(50, 130);
        quit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });
        addActor(quit);
    }

    @Override
    public void init() {

    }
}
