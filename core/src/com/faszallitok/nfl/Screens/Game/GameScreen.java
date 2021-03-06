package com.faszallitok.nfl.Screens.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.faszallitok.nfl.MyBaseClasses.Scene2D.MyScreen;
import com.faszallitok.nfl.MyGdxGame;
import com.faszallitok.nfl.Screens.Menu.HUD;

public class GameScreen extends MyScreen {
    GameStage gameStage;
    HUD hud;
    public boolean isPaused = false;

    public GameScreen(MyGdxGame game, float datas[]) {
        super(game);
        gameStage = new GameStage(spriteBatch, game, this, datas);
        hud = new HUD(spriteBatch, game, this);

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(hud);
        inputMultiplexer.addProcessor(gameStage);

        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if(!isPaused)
            gameStage.act(delta);
        gameStage.draw();

        if(isPaused) {
            hud.act();
            hud.draw();
        }

    }

    @Override
    public void init() {

    }
}
