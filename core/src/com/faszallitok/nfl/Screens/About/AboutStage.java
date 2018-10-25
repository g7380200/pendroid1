package com.faszallitok.nfl.Screens.About;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.faszallitok.nfl.GlobalClasses.Assets;
import com.faszallitok.nfl.MyBaseClasses.Scene2D.MyStage;
import com.faszallitok.nfl.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.faszallitok.nfl.MyBaseClasses.UI.MyButton;
import com.faszallitok.nfl.MyBaseClasses.UI.MyLabel;
import com.faszallitok.nfl.MyGdxGame;
import com.faszallitok.nfl.Screens.Menu.MenuScreen;

import javax.swing.GroupLayout;

public class AboutStage extends MyStage {
    private MyButton back;
    private MyLabel title;
    private MyLabel info;
    public AboutStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        OneSpriteStaticActor bg = new OneSpriteStaticActor(Assets.manager.get(Assets.BG_MENU));
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bg);

        title = new MyLabel("A Játékról", game.getLabelStyle());
        title.setAlignment(Align.center);
        title.setPosition(getViewport().getWorldWidth() / 2 - title.getWidth() / 2, getViewport().getWorldHeight() - 150);
        title.setFontScale(1.6f);
        addActor(title);

        info = new MyLabel("Szöveg", game.getLabelStyle());
        info.setAlignment(Align.center);
        info.setPosition(getViewport().getWorldWidth() / 2 - info.getWidth() / 2, getViewport().getWorldHeight() - 250);
        addActor(info);

        back = new MyButton("Vissza", game.getButtonStyle());
        back.setPosition(getViewport().getWorldWidth() / 2 - back.getWidth() / 2, 40 );
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getGame().setScreen(new MenuScreen(getGame()));
            }
        });
        addActor(back);
    }

    @Override
    public void init() {

    }
}
