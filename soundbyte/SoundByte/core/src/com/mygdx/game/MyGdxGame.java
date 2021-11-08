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
 * CSC 395
 * TEAM: GRIFFINS
 * PROJECT:SOUNDBYTE
 *
 */
public class MyGdxGame extends ApplicationAdapter {
    Stage stage;
    BitmapFont font;
    Skin skin;

    Music soundA5;
    Music soundB5;
    Music soundC6;
    Music soundD6;
    Music soundKick;
    Music soundHiHat;
    Music soundSnaph;
    Music soundSnare;
    @Override
    public void create() {
         stage = new Stage();
        Gdx.input.setInputProcessor(stage);


         font = new BitmapFont();
        skin = new Skin();



        soundA5 = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_A5.ogg"));
        soundB5 = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_B5.ogg"));
        soundC6 = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_C6.ogg"));
        soundD6 = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_D6.ogg"));
        soundKick = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_kick.ogg"));;
        soundHiHat = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_hihat.ogg"));;
        soundSnaph = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_snaph.ogg"));;
        soundSnare = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_snare.ogg"));;



    }


    public void update() {

 //////////////////////Q Button////////////////////////////////////////////////////////////////////
        Button.ButtonStyle QButtonStyle = new Button.ButtonStyle();
        Texture QbuttonTex = new Texture(Gdx.files.internal("buttons/Q.png"));
        TextureRegion QbuttonRegion = new TextureRegion(QbuttonTex);
        QButtonStyle.up = new TextureRegionDrawable(QbuttonRegion);
        Button QButton = new Button(QButtonStyle);
        QButton.setColor(Color.GOLD);
        QButton.setSize(100, 100);
        QButton.setPosition(100, 300);


        QButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundA5.play();
                    return true;
                }
        );

        ////////////////W Button/////////////////////////////////////

        Button.ButtonStyle WButtonStyle = new Button.ButtonStyle();
        Texture WbuttonTex = new Texture(Gdx.files.internal("buttons/W.png"));
        TextureRegion WbuttonRegion = new TextureRegion(WbuttonTex);
        WButtonStyle.up = new TextureRegionDrawable(WbuttonRegion);
        Button WButton = new Button(WButtonStyle);
        WButton.setColor(Color.GOLD);
        WButton.setSize(100, 100);
        WButton.setPosition(200, 300);


        WButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundB5.play();
                    return true;
                }
        );

       //////////E Button//////////////////////////////////
        Button.ButtonStyle EButtonStyle = new Button.ButtonStyle();
        Texture EbuttonTex = new Texture(Gdx.files.internal("buttons/E.png"));
        TextureRegion EbuttonRegion = new TextureRegion(EbuttonTex);
        EButtonStyle.up = new TextureRegionDrawable(EbuttonRegion);
        Button EButton = new Button(EButtonStyle);
        EButton.setColor(Color.GOLD);
        EButton.setSize(100, 100);
        EButton.setPosition(300, 300);


        EButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundC6.play();
                    return true;
                }
        );


        ///////////////////R Button/////////////////////////////
        Button.ButtonStyle RButtonStyle = new Button.ButtonStyle();
        Texture RbuttonTex = new Texture(Gdx.files.internal("buttons/R.png"));
        TextureRegion RbuttonRegion = new TextureRegion(RbuttonTex);
        RButtonStyle.up = new TextureRegionDrawable(RbuttonRegion);
        Button RButton = new Button(RButtonStyle);
        RButton.setColor(Color.GOLD);
        RButton.setSize(100, 100);
        RButton.setPosition(400, 300);


        RButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundD6.play();
                    return true;
                }
        );

        ///////////////////U Button/////////////////////////////
        Button.ButtonStyle UButtonStyle = new Button.ButtonStyle();
        Texture UbuttonTex = new Texture(Gdx.files.internal("buttons/U.png"));
        TextureRegion UbuttonRegion = new TextureRegion(UbuttonTex);
        UButtonStyle.up = new TextureRegionDrawable(UbuttonRegion);
        Button UButton = new Button(UButtonStyle);
        UButton.setColor(Color.GOLD);
        UButton.setSize(100, 100);
        UButton.setPosition(100, 100);


        UButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundKick.play();
                    return true;
                }
        );

        ///////////////////I Button/////////////////////////////
        Button.ButtonStyle IButtonStyle = new Button.ButtonStyle();
        Texture IbuttonTex = new Texture(Gdx.files.internal("buttons/I.png"));
        TextureRegion IbuttonRegion = new TextureRegion(IbuttonTex);
        IButtonStyle.up = new TextureRegionDrawable(IbuttonRegion);
        Button IButton = new Button(IButtonStyle);
        IButton.setColor(Color.GOLD);
        IButton.setSize(100, 100);
        IButton.setPosition(200, 100);


        IButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundHiHat.play();
                    return true;
                }
        );

        ///////////////////O Button/////////////////////////////
        Button.ButtonStyle OButtonStyle = new Button.ButtonStyle();
        Texture ObuttonTex = new Texture(Gdx.files.internal("buttons/O.png"));
        TextureRegion ObuttonRegion = new TextureRegion(ObuttonTex);
        OButtonStyle.up = new TextureRegionDrawable(ObuttonRegion);
        Button OButton = new Button(OButtonStyle);
        OButton.setColor(Color.GOLD);
        OButton.setSize(100, 100);
        OButton.setPosition(300, 100);


        OButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundSnaph.play();
                    return true;
                }
        );

        ///////////////////P Button/////////////////////////////
        Button.ButtonStyle PButtonStyle = new Button.ButtonStyle();
        Texture PbuttonTex = new Texture(Gdx.files.internal("buttons/P.png"));
        TextureRegion PbuttonRegion = new TextureRegion(PbuttonTex);
        PButtonStyle.up = new TextureRegionDrawable(PbuttonRegion);
        Button PButton = new Button(PButtonStyle);
        PButton.setColor(Color.GOLD);
        PButton.setSize(100, 100);
        PButton.setPosition(400, 100);


        PButton.addListener(
                (Event e) ->
                {

                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;


                    soundSnare.play();
                    return true;
                }
        );




//////////////////////// KEYS///////////////////////////////////
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {


            soundA5.play();
        }


        if (Gdx.input.isKeyPressed(Input.Keys.W)) {

            soundB5.play();
        }


        if (Gdx.input.isKeyPressed(Input.Keys.E)) {

            soundC6.play();

        }
        if (Gdx.input.isKeyPressed(Input.Keys.R)) {

            soundD6.play();
        }


        if (Gdx.input.isKeyPressed(Input.Keys.U))


            soundKick.play();


        if (Gdx.input.isKeyPressed(Input.Keys.I))

            soundHiHat.play();


        if (Gdx.input.isKeyPressed(Input.Keys.O))


            soundSnaph.play();

        if (Gdx.input.isKeyPressed(Input.Keys.P))

            soundSnare.play();


////////////////////////ADD BUTTONS TO THE STAGE////////////////
        stage.addActor(QButton);
        stage.addActor(WButton);
        stage.addActor(EButton);
        stage.addActor(RButton);
        stage.addActor(UButton);
        stage.addActor(IButton);
        stage.addActor(OButton);
        stage.addActor(PButton);



    }


    @Override
    public void render() {
        super.render();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update();

        stage.draw();
    }


}


