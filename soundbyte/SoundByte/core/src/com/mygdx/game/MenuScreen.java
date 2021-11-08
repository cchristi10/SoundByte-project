package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
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
public class MenuScreen extends BaseScreen
{

    public void initialize()
    {
        BaseActor background = new BaseActor(0,0, mainStage);
        background.loadTexture( "wallpapers/Main Menu—Reference.jpg" );
        background.setSize(virWidth, virHeight);

        TextButton TutorialButton = new TextButton( "Tutorial", BaseGame.textButtonStyle );
        TutorialButton.setPosition(425 * WidthOffset,85 * HeightOffset);
        TutorialButton.setSize(350 * WidthOffset,90 * HeightOffset);
        TutorialButton.setColor(0f,0f,0f,1f);
        uiStage.addActor(TutorialButton);
        TutorialButton.addListener( (Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(Type.touchDown) ) return false;
                    SoundByte.setActiveScreen(new Tutorial()); return true; }
        );

        TextButton SandboxButton = new TextButton( "Sandbox", BaseGame.textButtonStyle );
        SandboxButton.setPosition(50 * WidthOffset,85 * HeightOffset);
        SandboxButton.setSize(350 * WidthOffset,90 * HeightOffset);
        SandboxButton.setColor(0f,0f,0f,1f);
        uiStage.addActor(SandboxButton);
        SandboxButton.addListener( (Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(Type.touchDown) ) return false;
                    SoundByte.setActiveScreen(new Sandbox()); return true; }
        );

        TextButton LevelsButton = new TextButton( "Levels", BaseGame.textButtonStyle );
        LevelsButton.setPosition(1145 * WidthOffset,85 * HeightOffset);
        LevelsButton.setSize(350 * WidthOffset,90 * HeightOffset);
        LevelsButton.setColor(0f,0f,0f,1f);
        uiStage.addActor(LevelsButton);
        LevelsButton.addListener( (Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(Type.touchDown) ) return false;
                    SoundByte.setActiveScreen(new LevelSelect()); return true; }
        );

        TextButton settingsButton = new TextButton( "Settings", BaseGame.textButtonStyle );
        settingsButton.setPosition(1525 * WidthOffset,85 * HeightOffset);
        settingsButton.setSize(350 * WidthOffset,90 * HeightOffset);
        settingsButton.setColor(Color.WHITE);
        uiStage.addActor(settingsButton);
        settingsButton.addListener((Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(Type.touchDown) ) return false;
                    SoundByte.setActiveScreen( new SettingsScreen() ); return true; }
        );

    }

    public void update(float dt)
    {

    }

    public boolean keyDown(int keyCode)
    {
        if (Gdx.input.isKeyPressed(Keys.ENTER))
            SoundByte.setActiveScreen( new testLevel() );
        if(Gdx.input.isKeyPressed(Keys.F))
            SoundByte.setActiveScreen(new Tutorial());
        if (Gdx.input.isKeyPressed(Keys.ESCAPE))
            Gdx.app.exit();
        return false;
    }


}