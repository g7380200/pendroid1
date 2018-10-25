package com.faszallitok.nfl.Screens.Game;

import com.badlogic.gdx.Gdx;
import com.faszallitok.nfl.MyBaseClasses.Scene2D.MyScreen;
import com.faszallitok.nfl.MyGdxGame;

public class GameScreen extends MyScreen {
    GameStage gameStage;

    public GameScreen(MyGdxGame game) {
        super(game);
        gameStage = new GameStage(spriteBatch, game);
        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        gameStage.act(delta);
        gameStage.draw();
    }

    @Override
    public void init() {

    }
}
