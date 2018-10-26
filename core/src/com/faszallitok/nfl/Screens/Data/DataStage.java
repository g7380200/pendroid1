package com.faszallitok.nfl.Screens.Data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.faszallitok.nfl.MyBaseClasses.Scene2D.MyStage;
import com.faszallitok.nfl.MyBaseClasses.UI.InputListener;
import com.faszallitok.nfl.MyBaseClasses.UI.MyLabel;
import com.faszallitok.nfl.MyGdxGame;

public class DataStage extends MyStage {

    MyLabel Avel;
    MyLabel Bvel;
    MyLabel Szvel;
    MyLabel tav;
    MyLabel Atav;
    MyLabel Btav;

    public DataStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        InputListener listener = new InputListener();
        Gdx.input.getTextInput(listener, "Kérem a sebességet", "", "Sebesség (m/s)");

        Avel = new MyLabel("'A' sebessége (m/s): ", game.getLabelStyle());
        addActor(Avel);

    }

    @Override
    public void init() {

    }
}
