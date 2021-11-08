package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Sandbox extends BaseScreen {

    // Level 1 sounds
    private Music soundA5;
    private Music soundB5;
    private Music soundC6;
    private Music soundE6;
    private Music soundKick;
    private Music soundSnare;
    private Music soundHiHat;
    private Music soundSnaph;
    private boolean soundA5Played;
    private boolean soundB5Played;
    private boolean soundC6Played;
    private boolean soundE6Played;
    private boolean soundKickPlayed;
    private boolean soundSnarePlayed;
    private boolean soundHiHatPlayed;
    private boolean soundSnaphPlayed;


    private TextButton timer;
    private float time = 0;
    private int seconds = 0;
    private float dtSince = 0;
    private boolean record = false;
    private boolean playback = false;
    private TextButton RecordButton;


    private TextButton LayerButton;
    private int layer;
    // Layer 1
    private int count = 0;
    private int check = 0;
    public Music[] soundArray = new Music[1000];
    public float[] timeArray = new float[1000];
    // Layer 2
    private int count2 = 0;
    private int check2 = 0;
    public Music[] soundArray2 = new Music[1000];
    public float[] timeArray2 = new float[1000];
    // Layer 3
    private int count3 = 0;
    private int check3 = 0;
    public Music[] soundArray3 = new Music[1000];
    public float[] timeArray3 = new float[1000];



    public Sandbox() {
    }

    public void initialize() {
        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("wallpapers/Level One—Reference.jpg");
        background.setSize(virWidth, virHeight);

        //Sounds from Level 1
        soundA5 = Gdx.audio.newMusic(Gdx.files.internal("Beats/noteA51.ogg"));
        soundA5.setLooping(false);
        soundB5 = Gdx.audio.newMusic(Gdx.files.internal("Beats/noteB51.ogg"));
        soundB5.setLooping(false);
        soundC6 = Gdx.audio.newMusic(Gdx.files.internal("Beats/noteC61.ogg"));
        soundC6.setLooping(false);
        soundE6 = Gdx.audio.newMusic(Gdx.files.internal("Beats/noteE61.ogg"));
        soundE6.setLooping(false);
        soundKick = Gdx.audio.newMusic(Gdx.files.internal("Beats/kick.ogg"));
        soundKick.setLooping(false);
        soundSnare = Gdx.audio.newMusic(Gdx.files.internal("Beats/snare.ogg"));
        soundSnare.setLooping(false);
        soundHiHat = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_hihat.ogg"));
        soundHiHat.setLooping(false);
        soundSnaph = Gdx.audio.newMusic(Gdx.files.internal("sounds/test_snaph.ogg"));
        soundSnaph.setLooping(false);

        // Invisible Buttons for QWERUIOP sounds
        TextButton QButton = new TextButton( "Q", BaseGame.textButtonStyle );
        QButton.setPosition(393 * WidthOffset,278 * HeightOffset);
        QButton.setSize(110 * WidthOffset,110 * HeightOffset);
        QButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(QButton);
        QButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundA5.play(); if(soundA5.isPlaying()){soundA5.stop();soundA5.play();} if (record) { soundA5Played = true; }
            return true; }
        );

        TextButton WButton = new TextButton( "W", BaseGame.textButtonStyle );
        WButton.setPosition(734 * WidthOffset,278 * HeightOffset);
        WButton.setSize(110 * WidthOffset,110 * HeightOffset);
        WButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(WButton);
        WButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundB5.play(); if(soundB5.isPlaying()){soundB5.stop();soundB5.play();} if (record) { soundB5Played = true; }
            return true; }
        );

        TextButton EButton = new TextButton( "E", BaseGame.textButtonStyle );
        EButton.setPosition(1074 * WidthOffset,278 * HeightOffset);
        EButton.setSize(110 * WidthOffset,110 * HeightOffset);
        EButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(EButton);
        EButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundC6.play(); if(soundC6.isPlaying()){soundC6.stop();soundC6.play();} if (record) { soundC6Played = true; }
            return true; }
        );

        TextButton RButton = new TextButton( "R", BaseGame.textButtonStyle );
        RButton.setPosition(1418 * WidthOffset,278 * HeightOffset);
        RButton.setSize(110 * WidthOffset,110 * HeightOffset);
        RButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(RButton);
        RButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundE6.play(); if(soundE6.isPlaying()){soundE6.stop();soundE6.play();} if (record) { soundE6Played = true; }
            return true; }
        );

        TextButton UButton = new TextButton( "U", BaseGame.textButtonStyle );
        UButton.setPosition(395 * WidthOffset,72 * HeightOffset);
        UButton.setSize(110 * WidthOffset,110 * HeightOffset);
        UButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(UButton);
        UButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundKick.play(); if(soundKick.isPlaying()){soundKick.stop();soundKick.play();} if (record) { soundKickPlayed = true; }
            return true; }
        );

        TextButton IButton = new TextButton( "I", BaseGame.textButtonStyle );
        IButton.setPosition(735 * WidthOffset,72 * HeightOffset);
        IButton.setSize(110 * WidthOffset,110 * HeightOffset);
        IButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(IButton);
        IButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundSnare.play(); if(soundSnare.isPlaying()){soundSnare.stop();soundSnare.play();} if (record) { soundSnarePlayed = true; }
            return true; }
        );

        TextButton OButton = new TextButton( "O", BaseGame.textButtonStyle );
        OButton.setPosition(1074 * WidthOffset,72 * HeightOffset);
        OButton.setSize(110 * WidthOffset,110 * HeightOffset);
        OButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(OButton);
        OButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundHiHat.play(); if(soundHiHat.isPlaying()){soundHiHat.stop();soundHiHat.play();} if (record) { soundHiHatPlayed = true; }
            return true; }
        );

        TextButton PButton = new TextButton( "P", BaseGame.textButtonStyle );
        PButton.setPosition(1418 * WidthOffset,72 * HeightOffset);
        PButton.setSize(110 * WidthOffset,110 * HeightOffset);
        PButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(PButton);
        PButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundSnaph.play(); if(soundSnaph.isPlaying()){soundSnaph.stop();soundSnaph.play();} if (record) { soundSnaphPlayed = true; }
            return true; }
        );

        // Extra Menu Options
        TextButton PlaybackButton = new TextButton( "Playback", BaseGame.textButtonStyle );
        PlaybackButton.setPosition(50 * WidthOffset,600 * HeightOffset);
        PlaybackButton.setSize(350 * WidthOffset,90 * HeightOffset);
        PlaybackButton.setColor(1f,1f,1f,1f);
        uiStage.addActor(PlaybackButton);
        PlaybackButton.addListener( (Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
                    if(playback || timeArray[0] == 0) {playback = false;  }
                    else{ playback = true; check = 0; check2 = 0; check3 = 0; dtSince = 0; time = 0; seconds = 0; }
                    return true; }
        );

        RecordButton = new TextButton( "Record", BaseGame.textButtonStyle );
        RecordButton.setPosition(1520 * WidthOffset,600 * HeightOffset);
        RecordButton.setSize(350 * WidthOffset,90 * HeightOffset);
        RecordButton.setColor(1f,1f,1f,1f);
        uiStage.addActor(RecordButton);
        RecordButton.addListener( (Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
                    if(record) {record = false; dtSince = 0; time = 0; seconds = 0;}
                    else{ record = true; time = 0; seconds = 0; dtSince = 0;
                        if (layer == 1) {soundArray = new Music[1000]; timeArray = new float[1000]; count = 0; }
                        if (layer == 2) {soundArray2 = new Music[1000]; timeArray2 = new float[1000]; count2 = 0; }
                        if (layer == 3) {soundArray3 = new Music[1000]; timeArray3 = new float[1000]; count3 = 0; }
                    }
                    return true; }
        );

        layer = 1;
        LayerButton = new TextButton( "Layer: " + layer, BaseGame.textButtonStyle );
        LayerButton.setPosition(1520 * WidthOffset,500 * HeightOffset);
        LayerButton.setSize(300 * WidthOffset,90 * HeightOffset);
        LayerButton.setColor(1f,1f,1f,1f);
        uiStage.addActor(LayerButton);

        TextButton plusButton = new TextButton("+", BaseGame.textButtonStyle);
        plusButton.setColor(Color.WHITE);
        plusButton.setSize(45 * WidthOffset, 45 * HeightOffset);
        plusButton.setPosition(1820 * WidthOffset, 540 * HeightOffset);
        uiStage.addActor(plusButton);
        plusButton.addListener( (Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
                    if(layer < 3) { layer ++; } return true; }
        );
        TextButton minusButton = new TextButton("-", BaseGame.textButtonStyle);
        minusButton.setColor(Color.WHITE);
        minusButton.setSize(45 * WidthOffset, 45 * HeightOffset);
        minusButton.setPosition(1820 * WidthOffset, 500 * HeightOffset);
        uiStage.addActor(minusButton);
        minusButton.addListener( (Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
                    if(layer > 1) { layer --; } return true; }
        );

        timer = new TextButton("Time: " + seconds, BaseGame.textButtonStyle);
        timer.setSize(350 * WidthOffset,90 * HeightOffset);
        timer.setPosition(50 * WidthOffset,500 * HeightOffset);
        uiStage.addActor(timer);

        Label Controls = new Label("Q-W-E-R + U-I-O-P Play sounds" , BaseGame.labelStyle);
        Controls.setPosition(10 * WidthOffset,10 * HeightOffset);
        uiStage.addActor(Controls);

        TextButton menuButton = new TextButton( "Back", BaseGame.textButtonStyle);
        menuButton.setColor(Color.WHITE);
        menuButton.setPosition(1650 * WidthOffset,920 * HeightOffset);
        uiStage.addActor(menuButton);
        menuButton.addListener( (Event e) -> {
                    if ( !(e instanceof InputEvent) ) return false;
                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
                    SoundByte.setActiveScreen(new MenuScreen()); return true; }
        );


    }

    public void update(float dt) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) { soundA5.play(); if(soundA5.isPlaying()){soundA5.stop();soundA5.play();} if (record) { soundA5Played = true; }}
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) { soundB5.play(); if(soundB5.isPlaying()){soundB5.stop();soundB5.play();} if (record) { soundB5Played = true; }}
        if (Gdx.input.isKeyJustPressed(Input.Keys.E)) { soundC6.play(); if(soundC6.isPlaying()){soundC6.stop();soundC6.play();} if (record) { soundC6Played = true; }}
        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) { soundE6.play(); if(soundE6.isPlaying()){soundE6.stop();soundE6.play();} if (record) { soundE6Played = true; }}
        if (Gdx.input.isKeyJustPressed(Input.Keys.U)) { soundKick.play(); if(soundKick.isPlaying()){soundKick.stop();soundKick.play();} if (record) { soundKickPlayed = true; }}
        if (Gdx.input.isKeyJustPressed(Input.Keys.I)) { soundSnare.play(); if(soundSnare.isPlaying()){soundSnare.stop();soundSnare.play();} if (record) { soundSnarePlayed = true; }}
        if (Gdx.input.isKeyJustPressed(Input.Keys.O)) { soundHiHat.play(); if(soundHiHat.isPlaying()){soundHiHat.stop();soundHiHat.play();} if (record) { soundHiHatPlayed = true; }}
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) { soundSnaph.play(); if(soundSnaph.isPlaying()){soundSnaph.stop();soundSnaph.play();} if (record) { soundSnaphPlayed = true; }}


        if (record) {
            RecordButton.setColor(Color.RED);
            dtSince ++;
            time ++;
            if(time >= 60) { seconds ++; timer.setText("Time: " + seconds); time = 0;}

            if (soundA5Played) {
                if(layer == 1) {
                    soundArray[count] = soundA5;
                    timeArray[count] = dtSince;
                    count++;
                }
                if(layer == 2) {
                    soundArray2[count2] = soundA5;
                    timeArray2[count2] = dtSince;
                    count2++;
                }
                if(layer == 3) {
                    soundArray3[count3] = soundA5;
                    timeArray3[count3] = dtSince;
                    count3++;
                }
                soundA5Played = false;
            }
            if (soundB5Played) {
                if(layer == 1) {
                    soundArray[count] = soundB5;
                    timeArray[count] = dtSince;
                    count++;
                }
                if(layer == 2) {
                    soundArray2[count2] = soundB5;
                    timeArray2[count2] = dtSince;
                    count2++;
                }
                if(layer == 3) {
                    soundArray3[count3] = soundB5;
                    timeArray3[count3] = dtSince;
                    count3++;
                }
                soundB5Played = false;
            }
            if (soundC6Played) {
                if(layer == 1) {
                    soundArray[count] = soundC6;
                    timeArray[count] = dtSince;
                    count++;
                }
                if(layer == 2) {
                    soundArray2[count2] = soundC6;
                    timeArray2[count2] = dtSince;
                    count2++;
                }
                if(layer == 3) {
                    soundArray3[count3] = soundC6;
                    timeArray3[count3] = dtSince;
                    count3++;
                }
                soundC6Played = false;
            }
            if (soundE6Played) {
                if(layer == 1) {
                    soundArray[count] = soundE6;
                    timeArray[count] = dtSince;
                    count++;
                }
                if(layer == 2) {
                    soundArray2[count2] = soundE6;
                    timeArray2[count2] = dtSince;
                    count2++;
                }
                if(layer == 3) {
                    soundArray3[count3] = soundE6;
                    timeArray3[count3] = dtSince;
                    count3++;
                }
                soundE6Played = false;
            }
            if (soundKickPlayed) {
                if(layer == 1) {
                    soundArray[count] = soundKick;
                    timeArray[count] = dtSince;
                    count++;
                }
                if(layer == 2) {
                    soundArray2[count2] = soundKick;
                    timeArray2[count2] = dtSince;
                    count2++;
                }
                if(layer == 3) {
                    soundArray3[count3] = soundKick;
                    timeArray3[count3] = dtSince;
                    count3++;
                }
                soundKickPlayed = false;
            }
            if (soundSnarePlayed) {
                if(layer == 1) {
                    soundArray[count] = soundSnare;
                    timeArray[count] = dtSince;
                    count++;
                }
                if(layer == 2) {
                    soundArray2[count2] = soundSnare;
                    timeArray2[count2] = dtSince;
                    count2++;
                }
                if(layer == 3) {
                    soundArray3[count3] = soundSnare;
                    timeArray3[count3] = dtSince;
                    count3++;
                }
                soundSnarePlayed = false;
            }
            if (soundHiHatPlayed) {
                if(layer == 1) {
                    soundArray[count] = soundHiHat;
                    timeArray[count] = dtSince;
                    count++;
                }
                if(layer == 2) {
                    soundArray2[count2] = soundHiHat;
                    timeArray2[count2] = dtSince;
                    count2++;
                }
                if(layer == 3) {
                    soundArray3[count3] = soundHiHat;
                    timeArray3[count3] = dtSince;
                    count3++;
                }
                soundHiHatPlayed = false;
            }
            if (soundSnaphPlayed) {
                if(layer == 1) {
                    soundArray[count] = soundSnaph;
                    timeArray[count] = dtSince;
                    count++;
                }
                if(layer == 2) {
                    soundArray2[count2] = soundSnaph;
                    timeArray2[count2] = dtSince;
                    count2++;
                }
                if(layer == 3) {
                    soundArray3[count3] = soundSnaph;
                    timeArray3[count3] = dtSince;
                    count3++;
                }
                soundSnaphPlayed = false;
            }
        }
        else{
            RecordButton.setColor(Color.WHITE);
        }

        if(playback) {
            time ++;
            if(time >= 60) { seconds ++;  time = 0;}

            dtSince ++;
            if(timeArray[0] != 0) {
                if(dtSince +- 5 == timeArray[check]) {
                    soundArray[check].play();
                    check++;
                }
            }
            if(timeArray2[0] != 0) {
                if (dtSince + -5 == timeArray2[check2]) {
                    soundArray2[check2].play();
                    check2++;
                }
            }
            if(timeArray3[0] != 0) {
                if (dtSince + -5 == timeArray3[check3]) {
                    soundArray3[check3].play();
                    check3++;
                }
            }
            if( check >= count && check2 >= count2 && check3 >= count3) {
                playback = false;
                time = 0;
                seconds = 0;
            }
        }

        timer.setText("Time: " + seconds);
        LayerButton.setText("Layer: " + layer);
    }

}
