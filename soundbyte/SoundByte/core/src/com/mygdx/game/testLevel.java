package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * CSC 395L
 * TEAM: GRIFFINS
 * PROJECT:SOUNDBYTE
 */
public class testLevel extends BaseScreen {

    Music soundA5;
    Music soundB5;
    Music soundC6;
    Music soundD6;
    Music soundKick;
    Music soundHiHat;
    Music soundSnaph;
    Music soundSnare;



    public void initialize() {


        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("black_wallpaper.jpg");
        background.setSize(800, 600);
        BaseActor.setWorldBounds(background);



        soundA5 = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_A5.ogg"));
        soundB5 = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_B5.ogg"));
        soundC6 = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_C6.ogg"));
        soundD6 = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_D6.ogg"));
        soundKick = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_kick.ogg"));
        soundHiHat = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_hihat.ogg"));
        soundSnaph = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_snaph.ogg"));
        soundSnare = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_snare.ogg"));



    }


    public void update(float dt) {

        //////////////////////Q Button////////////////////////////////////////////////////////////////////
        Button.ButtonStyle QButtonStyle = new Button.ButtonStyle();
        Texture QbuttonTex = new Texture(Gdx.files.internal("buttons/Q.png"));
        TextureRegion QbuttonRegion = new TextureRegion(QbuttonTex);
        QButtonStyle.up = new TextureRegionDrawable(QbuttonRegion);
        Button QButton = new Button(QButtonStyle);
        QButton.setColor(Color.WHITE);
        QButton.setSize(100, 100);
        QButton.setPosition(100, 300);


        QButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundA5.play(); if(soundA5.isPlaying()){soundA5.stop();soundA5.play();}
                    return true;
                }
        );

        ////////////////W Button/////////////////////////////////////

        Button.ButtonStyle WButtonStyle = new Button.ButtonStyle();
        Texture WbuttonTex = new Texture(Gdx.files.internal("buttons/W.png"));
        TextureRegion WbuttonRegion = new TextureRegion(WbuttonTex);
        WButtonStyle.up = new TextureRegionDrawable(WbuttonRegion);
        Button WButton = new Button(WButtonStyle);
        WButton.setColor(Color.WHITE);
        WButton.setSize(100, 100);
        WButton.setPosition(200, 300);


        WButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundB5.play(); if(soundB5.isPlaying()){soundB5.stop();soundB5.play();}
                    return true;
                }
        );

        //////////E Button//////////////////////////////////
        Button.ButtonStyle EButtonStyle = new Button.ButtonStyle();
        Texture EbuttonTex = new Texture(Gdx.files.internal("buttons/E.png"));
        TextureRegion EbuttonRegion = new TextureRegion(EbuttonTex);
        EButtonStyle.up = new TextureRegionDrawable(EbuttonRegion);
        Button EButton = new Button(EButtonStyle);
        EButton.setColor(Color.WHITE);
        EButton.setSize(100, 100);
        EButton.setPosition(300, 300);


        EButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundC6.play(); if(soundC6.isPlaying()){soundC6.stop();soundC6.play();}
                    return true;
                }
        );


        ///////////////////R Button/////////////////////////////
        Button.ButtonStyle RButtonStyle = new Button.ButtonStyle();
        Texture RbuttonTex = new Texture(Gdx.files.internal("buttons/R.png"));
        TextureRegion RbuttonRegion = new TextureRegion(RbuttonTex);
        RButtonStyle.up = new TextureRegionDrawable(RbuttonRegion);
        Button RButton = new Button(RButtonStyle);
        RButton.setColor(Color.WHITE);
        RButton.setSize(100, 100);
        RButton.setPosition(400, 300);


        RButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundD6.play(); if(soundD6.isPlaying()){soundD6.stop();soundD6.play();}
                    return true;
                }
        );

        ///////////////////U Button/////////////////////////////
        Button.ButtonStyle UButtonStyle = new Button.ButtonStyle();
        Texture UbuttonTex = new Texture(Gdx.files.internal("buttons/U.png"));
        TextureRegion UbuttonRegion = new TextureRegion(UbuttonTex);
        UButtonStyle.up = new TextureRegionDrawable(UbuttonRegion);
        Button UButton = new Button(UButtonStyle);
        UButton.setColor(Color.WHITE);
        UButton.setSize(100, 100);
        UButton.setPosition(100, 100);


        UButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundKick.play(); if(soundKick.isPlaying()){soundKick.stop();soundKick.play();}
                    return true;
                }
        );

        ///////////////////I Button/////////////////////////////
        Button.ButtonStyle IButtonStyle = new Button.ButtonStyle();
        Texture IbuttonTex = new Texture(Gdx.files.internal("buttons/I.png"));
        TextureRegion IbuttonRegion = new TextureRegion(IbuttonTex);
        IButtonStyle.up = new TextureRegionDrawable(IbuttonRegion);
        Button IButton = new Button(IButtonStyle);
        IButton.setColor(Color.WHITE);
        IButton.setSize(100, 100);
        IButton.setPosition(200, 100);


        IButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundHiHat.play(); if(soundHiHat.isPlaying()){soundHiHat.stop();soundHiHat.play();}
                    return true;
                }
        );

        ///////////////////O Button/////////////////////////////
        Button.ButtonStyle OButtonStyle = new Button.ButtonStyle();
        Texture ObuttonTex = new Texture(Gdx.files.internal("buttons/O.png"));
        TextureRegion ObuttonRegion = new TextureRegion(ObuttonTex);
        OButtonStyle.up = new TextureRegionDrawable(ObuttonRegion);
        Button OButton = new Button(OButtonStyle);
        OButton.setColor(Color.WHITE);
        OButton.setSize(100, 100);
        OButton.setPosition(300, 100);


        OButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundSnaph.play(); if(soundSnaph.isPlaying()){soundSnaph.stop();soundSnaph.play();}
                    return true;
                }
        );

        ///////////////////P Button/////////////////////////////
        Button.ButtonStyle PButtonStyle = new Button.ButtonStyle();
        Texture PbuttonTex = new Texture(Gdx.files.internal("buttons/P.png"));
        TextureRegion PbuttonRegion = new TextureRegion(PbuttonTex);
        PButtonStyle.up = new TextureRegionDrawable(PbuttonRegion);
        Button PButton = new Button(PButtonStyle);
        PButton.setColor(Color.WHITE);
        PButton.setSize(100, 100);
        PButton.setPosition(400, 100);


        PButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundSnare.play(); if(soundSnare.isPlaying()){soundSnare.stop();soundSnare.play();}
                    return true;
                }
        );
        ////////////////////////ADD BUTTONS TO THE STAGE////////////////
        uiStage.addActor(QButton);
        uiStage.addActor(WButton);
        uiStage.addActor(EButton);
        uiStage.addActor(RButton);
        uiStage.addActor(UButton);
        uiStage.addActor(IButton);
        uiStage.addActor(OButton);
        uiStage.addActor(PButton);


//////////////////////// KEYS///////////////////////////////////
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {


            soundA5.play(); if(soundA5.isPlaying()){soundA5.stop();soundA5.play();}
        }


        if (Gdx.input.isKeyPressed(Input.Keys.W)) {

            soundB5.play(); if(soundB5.isPlaying()){soundB5.stop();soundB5.play();}
        }


        if (Gdx.input.isKeyPressed(Input.Keys.E)) {

            soundC6.play(); if(soundC6.isPlaying()){soundC6.stop();soundC6.play();}

        }
        if (Gdx.input.isKeyPressed(Input.Keys.R)) {

            soundD6.play(); if(soundD6.isPlaying()){soundD6.stop();soundD6.play();}
        }


        if (Gdx.input.isKeyPressed(Input.Keys.U))


            soundKick.play(); if(soundKick.isPlaying()){soundKick.stop();soundKick.play();}


        if (Gdx.input.isKeyPressed(Input.Keys.I))

            soundHiHat.play(); if(soundHiHat.isPlaying()){soundHiHat.stop();soundHiHat.play();}


        if (Gdx.input.isKeyPressed(Input.Keys.O))


            soundSnaph.play(); if(soundSnaph.isPlaying()){soundSnaph.stop();soundSnaph.play();}

        if (Gdx.input.isKeyPressed(Input.Keys.P))

            soundSnare.play(); if(soundSnare.isPlaying()){soundSnare.stop();soundSnare.play();}
    }
}