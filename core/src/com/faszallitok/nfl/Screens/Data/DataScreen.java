package com.faszallitok.nfl.Screens.Data;

import com.badlogic.gdx.Gdx;
import com.faszallitok.nfl.MyBaseClasses.Scene2D.MyScreen;
import com.faszallitok.nfl.MyGdxGame;

public class DataScreen extends MyScreen {
    DataStage dataStage;

    public DataScreen(MyGdxGame game) {
        super(game);

        dataStage = new DataStage(spriteBatch, game);
        Gdx.input.setInputProcessor(dataStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        dataStage.act(delta);
        dataStage.draw();
    }

    @Override
    public void init() {

    }
}
