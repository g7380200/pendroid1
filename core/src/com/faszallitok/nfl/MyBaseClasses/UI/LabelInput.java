package com.faszallitok.nfl.MyBaseClasses.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.faszallitok.nfl.Screens.Data.DataStage;

public class LabelInput extends MyLabel {
    public CharSequence origText = "";
    public CharSequence val = "";

    public LabelInput(CharSequence text, LabelStyle style, final DataStage stage, final int id) {
        super(text, style);
        origText = text;
        val = "(Katt)";

        setText(origText + ": "+val);

        setX(20);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                Gdx.input.getTextInput(new Input.TextInputListener() {
                    @Override
                    public void input(String text) {
                        try {
                            stage.datas[id] = Float.parseFloat(text);
                            val = text;
                            setText(origText + ": "+val);

                            LabelStyle ls = getStyle();
                            ls.fontColor = new Color(1, 1, 1, 1);
                            setStyle(ls);

                        }catch(Exception e) {
                            stage.datas[id] = 0;

                            LabelStyle ls = getStyle();
                            ls.fontColor = new Color(1, 0, 0, 1);
                            setStyle(ls);
                        }
                    }

                    @Override
                    public void canceled() {

                    }
                }, origText+"", "", "");

            }
        });
    }
}
