package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.compression.lzma.Base;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Lee Stemkoski
 */
public class completeScreen extends BaseScreen
{
    // Difficulty variables
    private Label completeLabel;

    private Label freePlayLabel;

    private Music beat1Pattern;

    public static int difficulty = 1;

    public static int getDifficulty(){
        return difficulty;
    }

    public void initialize()
    {

        beat1Pattern = Gdx.audio.newMusic(Gdx.files.internal("Beats/beat1Pattern.ogg"));
        beat1Pattern.setLooping(false);

        BaseActor background = new BaseActor(0,0, mainStage);
        background.loadTexture( "MenuScreen.jpg" );
        background.setSize(800,600);

        Button.ButtonStyle menuButtonStyle = new Button.ButtonStyle();
        Texture menuButtonTex = new Texture(Gdx.files.internal("back.png"));
        TextureRegion menuButtonRegion = new TextureRegion(menuButtonTex);
        menuButtonStyle.up = new TextureRegionDrawable(menuButtonRegion);
        Button menuButton = new Button(menuButtonStyle);
        menuButton.setColor(Color.WHITE);
        menuButton.setSize(100, 100);
        menuButton.setPosition(350, 100);

        // Instructions
        /*
        freePlayLabel = new Label("Press M to go back", BaseGame.labelStyle);
        freePlayLabel.setPosition(0,0);
        freePlayLabel.setColor(Color.WHITE);
        uiStage.addActor(freePlayLabel);
       */

        uiStage.addActor(menuButton);

        menuButton.addListener(
                (Event e) ->
                {
                    if ( !(e instanceof InputEvent) )
                        return false;

                    if ( !((InputEvent)e).getType().equals(Type.touchDown) )
                        return false;
                    beat1Pattern.stop();

                    SoundByte.setActiveScreen( new MenuScreen() );
                    return true;
                }
        );

        TextButton quitButton = new TextButton( "Quit", BaseGame.textButtonStyle );
        quitButton.setPosition(600,10);
        uiStage.addActor(quitButton);

        quitButton.addListener(
                (Event e) ->
                {
                    if ( !(e instanceof InputEvent) )
                        return false;

                    if ( !((InputEvent)e).getType().equals(Type.touchDown) )
                        return false;
                    beat1Pattern.stop();

                    Gdx.app.exit();
                    return true;
                }
        );


    }

    public void update(float dt)
    {

        beat1Pattern.play();

        completeLabel = new Label("CONGRATULATIONS!!!\n",BaseGame.labelStyle);

        completeLabel.setColor(Color.GOLD);
        uiStage.addActor(completeLabel);
       completeLabel.setPosition(150,250);
        completeLabel.addAction(Actions.delay(1));
        completeLabel.addAction(Actions.after(Actions.fadeIn(1)));

    }

    public boolean keyDown(int keyCode)
    {
        if (Gdx.input.isKeyPressed(Keys.ENTER))
            SoundByte.setActiveScreen( new MenuScreen() );
        if (Gdx.input.isKeyPressed(Keys.ESCAPE))
            Gdx.app.exit();
        return false;
    }


}