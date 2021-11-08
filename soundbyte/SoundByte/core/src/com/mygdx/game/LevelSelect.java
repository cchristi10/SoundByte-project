package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class LevelSelect extends BaseScreen {
    public void initialize() {
        BaseActor background = new BaseActor(0,0, mainStage);
        background.loadTexture( "wallpapers/Levels_Modules—Reference.jpg" );
        background.setSize(virWidth,virHeight);

        TextButton OneButton = new TextButton( "1", BaseGame.textButtonStyle );
        OneButton.setPosition(35 * WidthOffset,280 * HeightOffset);
        OneButton.setSize(520 * WidthOffset,520 * HeightOffset);
        OneButton.setColor(1f, 1f, 1f, 0f);
        uiStage.addActor(OneButton);
        OneButton.addListener((Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
                    SoundByte.setActiveScreen(new Level1()); return true; }
        );

        TextButton TwoButton = new TextButton( "2", BaseGame.textButtonStyle );
        TwoButton.setPosition(700 * WidthOffset,280 * HeightOffset);
        TwoButton.setSize(520 * WidthOffset,520 * HeightOffset);
        TwoButton.setColor(1f, 1f, 1f, 0f);
        uiStage.addActor(TwoButton);
        TwoButton.addListener( (Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
                    SoundByte.setActiveScreen(new Level2());return true; }
        );

        TextButton ThreeButton = new TextButton( "3", BaseGame.textButtonStyle );
        ThreeButton.setPosition(1365 * WidthOffset,280 * HeightOffset);
        ThreeButton.setSize(520 * WidthOffset,520 * HeightOffset);
        ThreeButton.setColor(1f, 1f, 1f, 0f);
        uiStage.addActor(ThreeButton);
        ThreeButton.addListener( (Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
                    SoundByte.setActiveScreen(new Level3());return true; }
        );


    }

    public void update(float dt) {

    }
}
