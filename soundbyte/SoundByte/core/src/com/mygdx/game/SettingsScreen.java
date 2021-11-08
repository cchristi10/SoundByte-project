package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class SettingsScreen extends BaseScreen {

    // Difficulty variables
    private Label diff;

    public static int difficulty = 1;

    public static int getDifficulty(){
        return difficulty;
    }

    public void initialize() {
        BaseActor background = new BaseActor(0,0, mainStage);
       background.loadTexture( "wallpapers/Main Menu—Reference.jpg" );
        background.setSize(virWidth,virHeight);

        TextButton menuButton = new TextButton( "Back", BaseGame.textButtonStyle);
        menuButton.setColor(Color.WHITE);
        menuButton.setPosition(1680 * WidthOffset,450 * HeightOffset);
        uiStage.addActor(menuButton);
        menuButton.addListener( (Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
                    SoundByte.setActiveScreen(new MenuScreen());return true; }
        );

        /*
        TextButton helpButton = new TextButton( "Help", BaseGame.textButtonStyle );
        helpButton.setPosition(1680 * WidthOffset,600 * HeightOffset);
        helpButton.setColor(Color.BLACK);
        uiStage.addActor(helpButton);
        helpButton.addListener( (Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
                    SoundByte.setActiveScreen( new Help() );return true; }
        );


         */

        /////// Difficulty options
        TextButton plusButton = new TextButton("+", BaseGame.textButtonStyle);
        plusButton.setColor(Color.WHITE);
        plusButton.setSize(50 * WidthOffset, 50 * HeightOffset);
        plusButton.setPosition(50 * WidthOffset, 400 * HeightOffset);
        uiStage.addActor(plusButton);
        plusButton.addListener( (Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
                    if(difficulty < 3) { difficulty ++; } return true; }
        );

        TextButton minusButton = new TextButton("-", BaseGame.textButtonStyle);
        minusButton.setColor(Color.WHITE);
        minusButton.setSize(50 * WidthOffset, 50 * HeightOffset);
        minusButton.setPosition(100 * WidthOffset, 400 * HeightOffset);
        uiStage.addActor(minusButton);
        minusButton.addListener( (Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
                    if(difficulty > 1) { difficulty --; } return true; }
        );

        diff = new Label("Difficulty: " + difficulty, BaseGame.labelStyle);
        diff.setPosition(40 * WidthOffset,500 * HeightOffset);
        diff.setColor(Color.WHITE);
        uiStage.addActor(diff);
    }

    public void update(float dt) {

        diff.setText("Difficulty: " + difficulty);

    }
}
