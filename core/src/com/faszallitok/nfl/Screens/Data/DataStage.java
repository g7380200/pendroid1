package com.faszallitok.nfl.Screens.Data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.faszallitok.nfl.MyBaseClasses.Scene2D.MyStage;
import com.faszallitok.nfl.MyBaseClasses.UI.InputListener;
import com.faszallitok.nfl.MyBaseClasses.UI.LabelInput;
import com.faszallitok.nfl.MyBaseClasses.UI.MyButton;
import com.faszallitok.nfl.MyBaseClasses.UI.MyLabel;
import com.faszallitok.nfl.MyGdxGame;
import com.faszallitok.nfl.Screens.Game.GameScreen;

public class DataStage extends MyStage {

    LabelInput Avel;
    LabelInput Bvel;
    LabelInput Szvel;
    LabelInput tav;
    LabelInput ABtav;
    MyButton submit;

    public float[] datas = new float[5];

    public DataStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        for (int i = 0; i < datas.length; i++) {
            datas[i] = 0;
            System.out.println(datas[i]);
        }

        //InputListener listener = new InputListener();
        //Gdx.input.getTextInput(listener, "Kérem a sebességet", "", "Sebesség (m/s)");

        Avel = new LabelInput("'A' sebessége (m/s)", game.getLabelStyle(), this, 0);
        Avel.setY(getViewport().getWorldHeight() - 180);
        addActor(Avel);

        Bvel = new LabelInput("'B' sebessége (m/s)", game.getLabelStyle(), this, 1);
        Bvel.setY(getViewport().getWorldHeight() - 250);
        addActor(Bvel);

        Szvel = new LabelInput("Szunyog sebessége (m/s)", game.getLabelStyle(), this, 2);
        Szvel.setY(getViewport().getWorldHeight() - 310);
        addActor(Szvel);

        tav = new LabelInput("Repülni kívánt távolság (m)", game.getLabelStyle(), this, 3);
        tav.setY(getViewport().getWorldHeight() - 180);
        tav.setX(500);
        addActor(tav);

        ABtav = new LabelInput("'A' és 'B' távolsága (m)", game.getLabelStyle(), this, 4);
        ABtav.setY(getViewport().getWorldHeight() - 250);
        ABtav.setX(500);
        addActor(ABtav);

        submit = new MyButton("Ok", game.getButtonStyle());
        submit.setPosition(getViewport().getWorldWidth() / 2 - submit.getWidth() / 2, 20);
        submit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                for(int i = 0; i < datas.length; i++)
                    System.out.println(datas[i]);

                for(int i = 0; i < datas.length; i++) {
                    if(datas[i] == 0) {
                        System.out.println("hiba");
                        return;
                    }
                }

                getGame().setScreen(new GameScreen(getGame(), datas));
            }
        });
        addActor(submit);
    }

    @Override
    public void init() {

    }
}
