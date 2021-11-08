package com.mygdx.game;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
public class Help extends BaseScreen
{
    // Difficulty variables


    private Label freePlayLabel;
    private Label helpLabel;



    public void initialize()
    {
        BaseActor background = new BaseActor(0,0, mainStage);
        background.loadTexture( "black_wallpaper.jpg" );
        background.setSize(800,600);

        Button.ButtonStyle PlayButtonStyle = new Button.ButtonStyle();
        Texture PlaybuttonTex = new Texture(Gdx.files.internal("playbefore.png"));
        TextureRegion PlaybuttonRegion = new TextureRegion(PlaybuttonTex);
        PlayButtonStyle.up = new TextureRegionDrawable(PlaybuttonRegion);
        Button PlayButton = new Button(PlayButtonStyle);
        PlayButton.setColor(Color.WHITE);
        PlayButton.setSize(100, 100);
        PlayButton.setPosition(350, 200);

        // Instructions
        /*
        freePlayLabel = new Label("Press F to enter Tutorial mode", BaseGame.labelStyle);
        freePlayLabel.setPosition(0,300);
        freePlayLabel.setColor(Color.WHITE);
        uiStage.addActor(freePlayLabel);


         */
         helpLabel = new Label("Press Space to listen pattern " +
                 "\nPress V to pause" +
                 "\nPress H to restart" +
                 "\nPress M to begin attempt", BaseGame.labelStyle);
        helpLabel.setPosition(0,200);
        helpLabel.setColor(Color.WHITE);
        uiStage.addActor(helpLabel);

        TextButton menuButton = new TextButton( "Back", BaseGame.textButtonStyle);
        menuButton.setColor(Color.BLACK);
        menuButton.setPosition(600,450);
        uiStage.addActor(menuButton);



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

                    Gdx.app.exit();
                    return true;
                }
        );

        menuButton.addListener(
                (Event e) ->
                {
                    if ( !(e instanceof InputEvent) )
                        return false;

                    if ( !((InputEvent)e).getType().equals(Type.touchDown) )
                        return false;

                    SoundByte.setActiveScreen(new MenuScreen());
                    return true;
                }
        );


        /////// Difficulty options - Event Listeners do not work (clicking arrows)



    }

    public void update(float dt)
    {
        // Difficulty Options

    }

    public boolean keyDown(int keyCode)
    {
        if (Gdx.input.isKeyPressed(Keys.BACKSPACE))
            SoundByte.setActiveScreen( new MenuScreen() );
        if(Gdx.input.isKeyPressed(Keys.F))
            SoundByte.setActiveScreen(new Tutorial());
        if (Gdx.input.isKeyPressed(Keys.ESCAPE))
            Gdx.app.exit();
        return false;
    }


}
