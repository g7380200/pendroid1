package com.faszallitok.nfl.Screens.Data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.faszallitok.nfl.MyBaseClasses.Scene2D.MyStage;
import com.faszallitok.nfl.MyBaseClasses.UI.InputListener;
import com.faszallitok.nfl.MyBaseClasses.UI.LabelInput;
import com.faszallitok.nfl.MyBaseClasses.UI.MyButton;
import com.faszallitok.nfl.MyBaseClasses.UI.MyLabel;
import com.faszallitok.nfl.MyGdxGame;

public class DataStage extends MyStage {

    LabelInput Avel;
    LabelInput Bvel;
    LabelInput Szvel;
    LabelInput tav;
    LabelInput Atav;
    LabelInput Btav;
    MyButton submit;

    public DataStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        InputListener listener = new InputListener();
        Gdx.input.getTextInput(listener, "Kérem a sebességet", "", "Sebesség (m/s)");

        Avel = new LabelInput("'A' sebessége (m/s)", game.getLabelStyle());
        Avel.setY(getViewport().getWorldHeight() - 180);
        addActor(Avel);

        Bvel = new LabelInput("'B' sebessége (m/s)", game.getLabelStyle());
        Bvel.setY(getViewport().getWorldHeight() - 250);
        addActor(Bvel);

        Szvel = new LabelInput("Szunyog sebessége (m/s)", game.getLabelStyle());
        Szvel.setY(getViewport().getWorldHeight() - 310);
        addActor(Szvel);

        tav = new LabelInput("Repülni kívánt távolság (m)", game.getLabelStyle());
        tav.setY(getViewport().getWorldHeight() - 180);
        tav.setX(500);
        addActor(tav);

        Atav = new LabelInput("'A' távolsága (m)", game.getLabelStyle());
        Atav.setY(getViewport().getWorldHeight() - 250);
        Atav.setX(500);
        addActor(Atav);

        Btav = new LabelInput("'B' távolsága (m)", game.getLabelStyle());
        Btav.setY(getViewport().getWorldHeight() - 310);
        Btav.setX(500);
        addActor(Btav);

        submit = new MyButton("Ok", game.getButtonStyle());
        submit.setPosition(getViewport().getWorldWidth() / 2 - submit.getWidth() / 2, 20);
        addActor(submit);
    }

    @Override
    public void init() {

    }
}
