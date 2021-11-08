package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
//import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
//import sun.font.TextRecord;
//import sun.jvm.hotspot.gc.shared.Space;

//import java.awt.*;
//import java.security.Key;
//import java.text.DecimalFormat;
import java.util.Arrays;
//import java.util.Timer;

/**
 * CSC 395L
 * TEAM: GRIFFINS
 * PROJECT:SOUNDBYTE
 */

public class Tutorial extends BaseScreen{

    // The sounds
    private Music soundA5;
    private Music soundB5;
    private Music soundC6;
    private Music soundD6;
    private Music soundE6;
    private Music soundKick;
    private Music soundHat;
    private Music soundBass;
    private Music soundSnare;
    private Music melodyPattern;
    private Music drumPattern;

    private boolean QPressed;
    private boolean WPressed;
    private boolean EPressed;
    private boolean RPressed;
    private boolean UPressed;
    private boolean IPressed;
    private boolean OPressed;
    private boolean PPressed;
    boolean next1 = false;
    boolean next2= false;
    boolean next3 = false;
    boolean next4 =false;
    boolean finish = false;
    boolean prev1;
    boolean prev2;
    boolean prev3;
    private boolean attemptPlayback;
    private boolean replayAttempt;
    private boolean drumPatternPlay;
    private boolean melodyPatternPlay ;



    TextButton QButton;
    TextButton WButton;
    TextButton EButton;
    TextButton RButton;
    TextButton UButton;
    TextButton IButton;
    TextButton OButton;
    TextButton PButton;
    private TextButton attemptButton;
    private TextButton nextButton;
    private TextButton prevButton;
    private TextButton replayAttemptButton;
    private TextButton patternPlaybackButton;
    private TextButton PlaybackButton;

    private Label TimeLeft;
    private Label beatTimeLeft;
    private Label stepLabel;

    private float counterTimer;
    private float Timer1;


    private int labelDisplayTime = 0;
    private int step;
    private int beatTime;



    //@K—made "final" to prevent accidental modification; also as it's not prone to alteration later in the sourcecode
    private final int delay = 50 / SettingsScreen.getDifficulty();


    // whether the game should play the sounds to match
    private boolean playback;

    // starts listening to your key presses
    private boolean start;

    private boolean counterStart;

    // checks to see if you made an attempt at matching
    private boolean attempted;


    // the number of sounds to play
    private int countKick;
    private int countSnare;
    private int countHat;
    private int countBass;
    private int countMelody;

    // array of sounds matched

    private int[] matchedKick;
    private int[] matchedSnare;
    private int[] matchedHat;
    private int[] matchedBass;
    private int[] matchedMelody;

    // number of sounds matched
    private int correctKick;
    private int correctSnare;
    private int correctHat;
    private int correctBass;
    private int correctMelody;

    // Level Complete
    private boolean complete;

    // SOUND LABELS/// VISIBLE WHEN KEYS PRESSED OR PLAYBACK IS ON
    private Label kickLabel;
    private Label snareLabel;
    private Label bassLabel;
    private Label hatLabel;
    private Label QLabel;
    private Label WLabel;
    private Label ELabel;
    private Label RLabel;

    private Label nullLabel;

    /// ATTEMPT BOOLEAN VARIABLES////////
    boolean kickAttempt;
    boolean snareAttempt;
    boolean hatBassAttempt;
    boolean melodyAttempt;

    // step 0
    private int count = 0;
    private int check = 0;
    private int attemptedKickCheck = 0;
    public int[] kickTimeArray = {600,507,381,350,257,131,0};
    public int[] timeArray = new int[1000];
    // step 1
    private int count2 = 0;
    private int check2 = 0;
    private int attemptedSnareCheck2 = 0;
    public int[] snareTimeArray = {538,413,366,288,162,116,0};
    public int[] timeArray2 = new int[1000];
    // step 2
    private int count3 = 0;
    private int check3 = 0;
    private int attemptedHatCheck3 = 0;
    private int attemptedBassCheck3 = 0;
    public int[] hatTimeArray = {600,0};
    public int[] bassTimeArray = {600,0};
    public int[] timeArray3 = new int[1000];
    // step 3
    private int count4 = 0;
    private int check4 = 0;
    private char keyName;
    private int attemptedMelodyCheck4 = 0;
    public Music[] soundArray4= new Music[1000];
    public int[] melodyTimeArray = {600,569,538,507,444,413,381,350,319,288,257,194,162,131,0};
    public char[] melodyKeysArray = {'Q','R','E','W','R','E','W','Q','R','E','W','R','E','W'};
    public Label[] melodyLabel = {QLabel,RLabel,ELabel,WLabel,RLabel,ELabel,WLabel,
            QLabel,RLabel,ELabel,WLabel,RLabel,ELabel,WLabel,nullLabel };

    public int[] timeArray4 = new int[1000];

    public void initialize() {

        // Initial values for the variables
        playback = false;
        attemptPlayback = false;
        start = false;
        attempted = false;
        complete = false;
        Timer1 = 0;
        counterTimer = 3;
        beatTime = 660;
        // The amount of sounds
        countKick = 6;
        countSnare = 6;
        countHat = 1;
        countBass = 1;
        countMelody = 14;


        matchedSnare = new int[countSnare];
        //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
        Arrays.fill(matchedSnare, 0);

        // This array makes sure that a button isn't pressed more than it is supposed to be during it's interval
        // i.e. if it is pressed more than once, this will count that whereas simple T/F booleans could not
        matchedKick = new int[countKick];
        //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
        Arrays.fill(matchedKick, 0);

        matchedHat = new int[countHat];
        //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
        Arrays.fill(matchedHat, 0);

        matchedBass = new int[countBass];
        //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
        Arrays.fill(matchedBass, 0);

        matchedMelody = new int[countMelody];
        //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
        Arrays.fill(matchedMelody, 0);



        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("wallpapers/Tutorial—Reference.jpg");
        background.setSize(virWidth, virHeight);

        BaseActor.setWorldBounds(background);

        kickLabel = new Label("U", BaseGame.labelStyle);
        kickLabel.setColor(Color.CYAN);
        uiStage.addActor(kickLabel);
        kickLabel.setVisible(false);
        kickLabel.setPosition(430 * WidthOffset,306 * HeightOffset);

        snareLabel = new Label("I", BaseGame.labelStyle);
        snareLabel.setColor(Color.CYAN);
        uiStage.addActor(snareLabel);
        snareLabel.setVisible(false);
        snareLabel.setPosition(780 * WidthOffset,306 * HeightOffset);

        bassLabel = new Label("O", BaseGame.labelStyle);
        bassLabel.setColor(Color.CYAN);
        uiStage.addActor(bassLabel);
        bassLabel.setVisible(false);
        bassLabel.setPosition(1110 * WidthOffset,306 * HeightOffset);

        hatLabel = new Label("P", BaseGame.labelStyle);
        hatLabel.setColor(Color.CYAN);
        uiStage.addActor(hatLabel);
        hatLabel.setVisible(false);
        hatLabel.setPosition(1460 * WidthOffset,306 * HeightOffset);

        ////////// MELODY LABELS////////////////////
        QLabel = new Label("Q", BaseGame.labelStyle);
        QLabel.setColor(Color.PURPLE);
        uiStage.addActor(QLabel);
        QLabel.setVisible(false);
        QLabel.setPosition(430 * WidthOffset,507 * HeightOffset);

        nullLabel = new Label("NULL", BaseGame.labelStyle);
        nullLabel.setColor(Color.PURPLE);
        uiStage.addActor(nullLabel);
        nullLabel.setVisible(false);
        nullLabel.setPosition(430 * WidthOffset,507 * HeightOffset);

        WLabel = new Label("W", BaseGame.labelStyle);
        WLabel.setColor(Color.PURPLE);
        uiStage.addActor(WLabel);
        WLabel.setVisible(false);
        WLabel.setPosition(762 * WidthOffset,507 * HeightOffset);

        ELabel = new Label("E", BaseGame.labelStyle);
        ELabel.setColor(Color.PURPLE);
        uiStage.addActor(ELabel);
        ELabel.setVisible(false);
        ELabel.setPosition(1115 * WidthOffset,507 * HeightOffset);

        RLabel = new Label("R", BaseGame.labelStyle);
        RLabel.setColor(Color.PURPLE);
        uiStage.addActor(RLabel);
        RLabel.setVisible(false);
        RLabel.setPosition(1458 * WidthOffset,507 * HeightOffset);
        ///////////////////////////////////////////////////////////////////////////
        drumPattern = Gdx.audio.newMusic(Gdx.files.internal("Beats/drumPattern.ogg"));
        drumPattern.setLooping(false);
        soundA5 = Gdx.audio.newMusic(Gdx.files.internal("Beats/noteA51.ogg"));
        soundA5.setLooping(false);
        soundB5 = Gdx.audio.newMusic(Gdx.files.internal("Beats/noteB51.ogg"));
        soundB5.setLooping(false);
        soundC6 = Gdx.audio.newMusic(Gdx.files.internal("Beats/noteC61.ogg"));
        soundC6.setLooping(false);
        soundD6 = Gdx.audio.newMusic(Gdx.files.internal("Beats/noteD61.ogg"));
        soundD6.setLooping(false);
        soundE6 = Gdx.audio.newMusic(Gdx.files.internal("Beats/noteE61.ogg"));
        soundE6.setLooping(false);
        soundKick = Gdx.audio.newMusic(Gdx.files.internal("Beats/kick.ogg"));
        soundKick.setLooping(false);
        soundHat = Gdx.audio.newMusic(Gdx.files.internal("Beats/hat.ogg"));
        soundHat.setLooping(false);
        soundBass = Gdx.audio.newMusic(Gdx.files.internal("Beats/bass.ogg"));
        soundBass.setLooping(false);
        soundSnare = Gdx.audio.newMusic(Gdx.files.internal("Beats/snare.ogg"));
        soundSnare.setLooping(false);
        melodyPattern = Gdx.audio.newMusic(Gdx.files.internal("Beats/melodyPattern.ogg"));
        melodyPattern.setLooping(false);


        TimeLeft = new Label("", BaseGame.labelStyle);
        TimeLeft.setSize(350 * WidthOffset,90 * HeightOffset);
        TimeLeft.setPosition(860 * WidthOffset,985 * HeightOffset);
        uiStage.addActor(TimeLeft);

        beatTimeLeft= new Label(" ", BaseGame.labelStyle);

        beatTimeLeft.setColor(Color.GOLDENROD);
        beatTimeLeft.setPosition(50 * WidthOffset,900 * HeightOffset);
        uiStage.addActor(beatTimeLeft);


        stepLabel = new Label("", BaseGame.labelStyle);
        stepLabel.setColor(Color.WHITE);
        stepLabel.setPosition(20*WidthOffset,1000*HeightOffset);
        uiStage.addActor(stepLabel);

        PlaybackButton = new TextButton( "Playback", BaseGame.textButtonStyle );
        PlaybackButton.setPosition(50 * WidthOffset,600 * HeightOffset);
        PlaybackButton.setSize(350 * WidthOffset,90 * HeightOffset);
        PlaybackButton.setColor(1f,1f,1f,1f);
        uiStage.addActor(PlaybackButton);

        PlaybackButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) )
                return false;

            if(playback==true) {
                playback = false;
                Timer1 = 0;
                beatTime = 601;
                drumPattern.stop();
                melodyPattern.stop();
            }
            else{
                check = 0;
                check2 = 0;
                check3 = 0;
                check4 = 0;

                if(drumPattern.isPlaying() || melodyPattern.isPlaying() || soundHat.isPlaying() ||soundBass.isPlaying()){
                    drumPattern.stop();
                    melodyPattern.stop();
                    soundHat.stop();
                    soundBass.stop();
                }

                beatTime=601;
                playback = true;
                drumPattern.play();
                drumPattern.setLooping(true);
                melodyPattern.setLooping(true);
                melodyPattern.play();
            }


            return true; }
        );

        patternPlaybackButton = new TextButton( "patternPlay", BaseGame.textButtonStyle );
        patternPlaybackButton.setPosition(50 * WidthOffset,500 * HeightOffset);
        patternPlaybackButton.setSize(350 * WidthOffset,90 * HeightOffset);
        patternPlaybackButton.setColor(1f,1f,1f,1f);
        uiStage.addActor(patternPlaybackButton);

        patternPlaybackButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) )
                return false;

            if(attemptPlayback==true) {

                attemptPlayback = false;
                Timer1 = 0;
                beatTime = 601;
                soundHat.setLooping(false);
                soundHat.stop();
                soundBass.setLooping(false);
                soundBass.stop();
                drumPattern.stop();
                melodyPattern.stop();
            }
            else{
                check = 0;
                check2 = 0;
                check3 = 0;
                check4 = 0;
                playback=false;
                replayAttempt=false;
                if(drumPattern.isPlaying() || melodyPattern.isPlaying()) {
                    drumPattern.stop();
                    melodyPattern.stop();

                }
                if ((step == 0 || step == 1 || step == 2)) {

                    beatTime=601 + labelDisplayTime;
                    start = false;
                    attemptPlayback = true;

                    if(kickAttempt == true)
                    {
                        drumPattern.play();
                        drumPattern.setLooping(true);
                    }
                    if(snareAttempt == true) {
                        drumPattern.play();
                        drumPattern.setLooping(true);

                    }
                    if(hatBassAttempt == true) {
                        drumPattern.play();
                        drumPattern.setLooping(true);

                    }
                }
                if(step == 3)
                {
                    beatTime=601 + labelDisplayTime;
                    start = false;
                    attemptPlayback = true;

                    if(melodyAttempt == true)
                    {
                        melodyPattern.play();
                        melodyPattern.setLooping(true);
                    }

                }
            }


            return true; }
        );


        ////////////REPLAY ATTEMPT BUTTON//////////////
        replayAttemptButton = new TextButton( "PLAY LOOP", BaseGame.textButtonStyle );
        replayAttemptButton.setPosition(50 * WidthOffset,700 * HeightOffset);
        replayAttemptButton.setSize(350 * WidthOffset,90 * HeightOffset);
        replayAttemptButton.setColor(1f,1f,1f,1f);
        uiStage.addActor(replayAttemptButton);

        replayAttemptButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) )
                return false;

            if(replayAttempt==true) {
                attemptPlayback = false;
                replayAttempt = false;
                Timer1 = 0;
                check = 0;
                check2 = 0;
                check3 = 0;
                check4 = 0;
                attemptedKickCheck = 0;
                attemptedSnareCheck2 = 0;
                attemptedHatCheck3 = 0;
                attemptedBassCheck3 = 0;
                attemptedMelodyCheck4 =0;
                beatTime = 601;
                soundHat.setLooping(false);
                soundHat.stop();
                soundBass.setLooping(false);
                soundBass.stop();
            }
            else{
                if(drumPattern.isPlaying() || melodyPattern.isPlaying()){
                    drumPattern.stop();
                    melodyPattern.stop();
                }
                check = 0;
                check2 = 0;
                check3 = 0;
                check4 = 0;
                attemptedKickCheck = 0;
                attemptedSnareCheck2 = 0;
                attemptedHatCheck3 = 0;
                attemptedBassCheck3 = 0;
                attemptedMelodyCheck4 =0;
                playback=false;
                beatTime=601;
                attemptPlayback = true;
                replayAttempt = true;

            }


            return true; }
        );
        ////////// BACK TO MENUSCREEN BUTTON/////////////////

        TextButton menuButton = new TextButton( "Back", BaseGame.textButtonStyle);
        menuButton.setColor(Color.WHITE);
        menuButton.setPosition(1650 * WidthOffset,920 * HeightOffset);
        uiStage.addActor(menuButton);
        menuButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;

            drumPattern.stop();
            melodyPattern.stop();
            soundHat.stop();
            soundBass.stop();
            SoundByte.setActiveScreen(new MenuScreen()); return true; }
        );

        //// ATTEMPT BUTTON///////////////
        attemptButton = new TextButton( "Attempt", BaseGame.textButtonStyle );
        attemptButton.setPosition(1520 * WidthOffset,600 * HeightOffset);
        attemptButton.setSize(350 * WidthOffset,90 * HeightOffset);
        attemptButton.setColor(1f,1f,1f,1f);
        uiStage.addActor(attemptButton);
        attemptButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;

            counterStart = true;
            attemptButton.setText("Attempt");
            if(counterStart == true && counterTimer <=0)
            {
                counterStart = false;
            }

            counterTimer = 3;
            start = false;
            attempted = false;
            attemptPlayback = false;
            replayAttempt = false;
            attemptedKickCheck = 0;
            attemptedSnareCheck2 = 0;
            attemptedHatCheck3 = 0;
            attemptedBassCheck3 = 0;
            attemptedMelodyCheck4 =0;
            check =  0;
            check2 = 0;
            check3 = 0;
            check4 = 0;
            count2 = 0;
            count  = 0;
            beatTime = 660;

            //reset attempted kicks
            if(step ==0) {
                timeArray = new int[1000]; count = 0;
            }

            //reset attempted snare
            if(step ==1) {
                timeArray2 = new int[1000]; count2 = 0;
            }

            //reset attempted hats and bass
            if(step ==2) {
                timeArray3 = new int[1000]; count3 = 0;
            }
            if(step == 3)
            {
                soundArray4 = new Music[1000]; timeArray4 = new int[1000]; count4 = 0;
            }


            countKick = 6;
            countSnare = 6;
            countHat = 1;
            countBass = 1;
            countMelody= 14;
            correctKick = 0;
            correctSnare = 0;
            correctHat = 0;
            correctBass = 0;
            correctMelody =0;

            ////////////RESETS KICK///////
            matchedKick = new int[countKick];

            //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
            Arrays.fill(matchedKick, 0);

            ////////////RESETS SNARE///////
            matchedSnare = new int[countSnare];

            //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
            Arrays.fill(matchedSnare, 0);

            ////////////RESETS HAT///////
            matchedHat = new int[countHat];

            //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
            Arrays.fill(matchedHat, 0);

            ////////////RESETS BASS///////
            matchedBass = new int[countBass];

            //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
            Arrays.fill(matchedBass, 0);


            ////////////RESETS MELODY///////
            matchedMelody = new int[countMelody];

            //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
            Arrays.fill(matchedMelody, 0);

            soundHat.stop();
            soundBass.stop();

            return true; }


        );

        //////////////NEXT BUTTON/////////////

        nextButton = new TextButton( "NEXT", BaseGame.textButtonStyle );
        nextButton.setPosition(1520 * WidthOffset,150 * HeightOffset);
        nextButton.setSize(350 * WidthOffset,90 * HeightOffset);
        nextButton.setColor(1f,1f,1f,1f);
        nextButton.setVisible(false);
        uiStage.addActor(nextButton);
        nextButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;


            check = 0;
            check2 = 0;
            check3 = 0;
            check4 = 0;
            attemptedKickCheck = 0;
            attemptedSnareCheck2 = 0;
            attemptedHatCheck3 = 0;
            attemptedBassCheck3 = 0;
            attemptedMelodyCheck4 =0;

            if(next1 || next2 || next3 ||next4)
            {

                step+=1;
            }

            return true; }
        );

        //////////////PREVIOUS BUTTON/////////////

        prevButton = new TextButton( "Previous", BaseGame.textButtonStyle );
        prevButton.setPosition(20 * WidthOffset,150 * HeightOffset);
        prevButton.setSize(350 * WidthOffset,90 * HeightOffset);
        prevButton.setColor(1f,1f,1f,1f);
        prevButton.setVisible(true);
        uiStage.addActor(prevButton);
        prevButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;

            beatTime = 660;

            check = 0;
            check2 = 0;
            check3 = 0;
            check4 = 0;
            attemptedKickCheck = 0;
            attemptedSnareCheck2 = 0;
            attemptedHatCheck3 = 0;
            attemptedBassCheck3 = 0;
            attemptedMelodyCheck4 =0;


            if(step == 1 && prev1 ==true)
            {

                nextButton.setVisible(true);
                prevButton.setVisible(true);
                snareAttempt = false;
                step = 0;
            }

            if(step == 2&& prev2 ==true)
            {
                nextButton.setVisible(true);
                prevButton.setVisible(true);
                hatBassAttempt = false;
                step = 1;

            }

            if(step == 3 && prev3 ==true)
            {
                nextButton.setVisible(true);
                prevButton.setVisible(true);
                melodyAttempt= false;
                step =2;
            }

            return true; }
        );
        menuButton.addListener(
                (Event e) ->
                {
                    if ( !(e instanceof InputEvent) )
                        return false;

                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) )
                        return false;

                    SoundByte.setActiveScreen( new MenuScreen() );
                    return true;
                }
        );


        // Invisible Buttons for QWERUIOP sounds
        QButton = new TextButton( "Q", BaseGame.textButtonStyle );
        QButton.setPosition(393 * WidthOffset,485 * HeightOffset);
        QButton.setSize(110 * WidthOffset,110 * HeightOffset);
        QButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(QButton);
        QButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;

            soundA5.play();  keyName ='Q';if(soundA5.isPlaying()){soundA5.stop();soundA5.play();} if (start) { QPressed = true; }
            return true; }
        );

        WButton = new TextButton( "W", BaseGame.textButtonStyle );
        WButton.setPosition(734 * WidthOffset,485 * HeightOffset);
        WButton.setSize(110 * WidthOffset,110 * HeightOffset);
        WButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(WButton);
        WButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundB5.play();  keyName ='W';if(soundB5.isPlaying()){soundB5.stop();soundB5.play();} if (start) { WPressed = true; }
            return true; }
        );

        EButton = new TextButton( "E", BaseGame.textButtonStyle );
        EButton.setPosition(1074 * WidthOffset,485 * HeightOffset);
        EButton.setSize(110 * WidthOffset,110 * HeightOffset);
        EButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(EButton);
        EButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundC6.play();  keyName ='E';if(soundC6.isPlaying()){soundC6.stop();soundC6.play();} if (start) { EPressed = true; }
            return true; }
        );

        RButton = new TextButton( "R", BaseGame.textButtonStyle );
        RButton.setPosition(1418 * WidthOffset,485 * HeightOffset);
        RButton.setSize(110 * WidthOffset,110 * HeightOffset);
        RButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(RButton);
        RButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundE6.play();  keyName ='R';if(soundE6.isPlaying()){soundE6.stop();soundE6.play();} if (start) { RPressed = true; }
            return true; }
        );

        UButton = new TextButton( "U", BaseGame.textButtonStyle );
        UButton.setPosition(395 * WidthOffset,280 * HeightOffset);
        UButton.setSize(110 * WidthOffset,110 * HeightOffset);
        UButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(UButton);
        UButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;

            soundKick.play(); if(soundKick.isPlaying()){soundKick.stop();soundKick.play();} if (start) { UPressed = true; }
            return true; }
        );

        IButton = new TextButton( "I", BaseGame.textButtonStyle );
        IButton.setPosition(735 * WidthOffset,280 * HeightOffset);
        IButton.setSize(110 * WidthOffset,110 * HeightOffset);
        IButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(IButton);
        IButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundSnare.play(); if(soundSnare.isPlaying()){soundSnare.stop();soundSnare.play();} if (start) { IPressed = true; }
            return true; }
        );

        OButton = new TextButton( "O", BaseGame.textButtonStyle );
        OButton.setPosition(1074 * WidthOffset,280 * HeightOffset);
        OButton.setSize(110 * WidthOffset,110 * HeightOffset);
        OButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(OButton);
        OButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundBass.play(); if(soundBass.isPlaying()){soundBass.stop();soundBass.play();} if (start) { OPressed = true; }
            return true; }
        );

        PButton = new TextButton( "P", BaseGame.textButtonStyle );
        PButton.setPosition(1418 * WidthOffset,280 * HeightOffset);
        PButton.setSize(110 * WidthOffset,110 * HeightOffset);
        PButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(PButton);
        PButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundHat.play(); if(soundHat.isPlaying()){soundHat.stop();soundHat.play();} if (start) { PPressed = true; }
            return true; }
        );

    }

    public void update(float dt) {
        //COMMENT THIS VARIABLE LATER
        //step = 1;

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q))
        {soundA5.play();
        keyName ='Q';

            if(soundA5.isPlaying()){soundA5.stop();soundA5.play();}
            if (start) { QPressed= true; }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.W))
        {soundB5.play();
            keyName ='W';
            if(soundB5.isPlaying()){soundB5.stop();soundB5.play();}
            if (start) { WPressed = true; }}

        if(Gdx.input.isKeyJustPressed(Input.Keys.E))
        {soundC6.play();
            keyName ='E';

            if(soundC6.isPlaying()){soundC6.stop();soundC6.play();}
            if (start) { EPressed = true; }}


        if(Gdx.input.isKeyJustPressed(Input.Keys.R))
        {soundE6.play();
            keyName ='R';

            if(soundE6.isPlaying()){soundE6.stop();soundE6.play();}
            if (start) { RPressed = true; }}

        if(Gdx.input.isKeyJustPressed(Input.Keys.U))
        {soundKick.play();


            if(soundKick.isPlaying()){
                soundKick.stop();soundKick.play();}
            if (start) { UPressed= true; }}
        if(Gdx.input.isKeyJustPressed(Input.Keys.I))
        {soundSnare.play();

            if(soundSnare.isPlaying()){soundSnare.stop();soundSnare.play();}
            if (start) { IPressed = true; }}


        if(Gdx.input.isKeyJustPressed(Input.Keys.O))
        {soundBass.play();

            if(soundBass.isPlaying()){soundBass.stop();soundBass.play();}
            if (start) { OPressed = true; }}


        if(Gdx.input.isKeyJustPressed(Input.Keys.P))
        {soundHat.play();

            if(soundHat.isPlaying()){soundHat.stop();soundHat.play();}
            if (start) {PPressed = true; }}

        // Starts the playback
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            playback = true;

            if(step == 0 || step == 1 || step == 2)
            {
                start = false;
                drumPatternPlay =true;
                melodyPatternPlay = true;
                beatTime = 660;
            }

            if(step == 3) {
                melodyPatternPlay = true;
            }
        }

        // Starts tracking your key preses to match (Currently no picture)
        if (Gdx.input.isKeyPressed(Input.Keys.M)) {

            counterStart = true;
        }
        beatTimeLeft.setText(beatTime);
        if(counterStart && counterTimer>=0)
        {
            counterTimer -= dt;
            playback = false;
            melodyPattern.stop();
            drumPattern.stop();
            attemptPlayback = false;
            replayAttempt = false;
            beatTime = 660;
            TimeLeft.setText("Countdown: " + Math.round(counterTimer));

            if(counterTimer <= 0) {
                beatTime = 660;
                TimeLeft.setText("");

                attemptButton.setText("STOP");
                start = true;
            }
        }

        if(start == false)
        {
            attemptButton.setText("Attempt");
        }
        {

            ////////////////PLAYS ENTIRE BEAT////////////////////////////
            // Playback the sound to match
            if (playback) {


                if (Timer1 >= 0) {
                    Timer1 += dt;

                }
                beatTime -= dt;

                attemptPlayback = false;
                start = false;
                replayAttempt = false;

                ///////////////////KICK////////////////
                if (beatTime == kickTimeArray[check]) {
                    check++;

                    kickLabel.setVisible(true);
                    kickLabel.addAction(Actions.fadeIn(1 / 2));
                    kickLabel.addAction(Actions.fadeOut(1));

                }
                /////////////HAT AND BASS///////////////////

                if (beatTime == hatTimeArray[check3])

                {
                    hatLabel.setVisible(true);
                    hatLabel.addAction(Actions.after(Actions.fadeIn(1/2)));
                    hatLabel.addAction(Actions.after(Actions.fadeOut(1)));

                }
                if (beatTime == bassTimeArray[check3])

                {

                    bassLabel.setVisible(true);
                    bassLabel.addAction(Actions.after(Actions.fadeIn(1/2)));
                    bassLabel.addAction(Actions.after(Actions.fadeOut(1)));

                }
                ///////////////SNARE/////////////

                if (beatTime == snareTimeArray[check2])

                {
                    check2++;
                    snareLabel.setVisible(true);
                    snareLabel.addAction(Actions.fadeIn(1 / 2));
                    snareLabel.addAction(Actions.fadeOut(1));

                }
                ////////////////MELODY////////////////

                if (beatTime == melodyTimeArray[check4])

                {

                    melodyLabel[check4].setVisible(true);
                    melodyLabel[check4].addAction(Actions.after(Actions.fadeIn(1/2)));
                    melodyLabel[check4].addAction(Actions.after(Actions.fadeOut(1)));
                    // Plays the sound for the specified count amount of times

                    check4++;
                }
                if(beatTime<=100 && start == false)
                {
                    beatTime = 601;
                    check = 0;
                    check2 = 0;
                    check3 = 0;
                    check4 =0;
                }

                if (beatTime <= 0)

                {

                    playback = false;
                    check = 0;
                    check2 = 0;
                    check3 = 0;
                    check4 =0;

                }

            }

            //@K—removed "==true" as redundant—Nov 12, 2020 at 7.31PM
            if (playback) {
                if (Gdx.input.isKeyPressed(Input.Keys.V)) {
                    playback = false;
                    melodyPatternPlay = false;
                    melodyPattern.stop();

                    drumPatternPlay = false;

                    drumPattern.stop();

                    soundBass.stop();
                    soundHat.stop();

                    countKick = 6;
                    countSnare = 6;
                }
            }
        }

        //////////////// PATTERN PLAYBACK/////////////////
        //Used when making attempt. Guides player to press the right key
        // Playback the sound to match
        if (attemptPlayback) {
            beatTime -= dt;
            if(kickAttempt == true) {

                if (beatTime == kickTimeArray[check]) {

                    check++;

                    kickLabel.setVisible(true);
                    kickLabel.addAction(Actions.fadeIn(1 / 2));
                    kickLabel.addAction(Actions.fadeOut(1));
                }
            }
            if(replayAttempt == true){
                if(beatTime == timeArray[attemptedKickCheck])
                {
                    soundKick.play();
                    attemptedKickCheck++;

                }
            }

/////////////HAT AND BASS///////////////////

            if(hatBassAttempt==true) {

                if (beatTime == hatTimeArray[check3]) {

                    hatLabel.setVisible(true);
                    hatLabel.addAction(Actions.after(Actions.fadeIn(1 / 2)));
                    hatLabel.addAction(Actions.after(Actions.fadeOut(1)));

                }
            }
            if(replayAttempt == true ) {

                if(beatTime == timeArray3[attemptedHatCheck3]) {

                    soundHat.play();
                    soundHat.setLooping(true);
                    attemptedHatCheck3++;
                }

            }


            if(hatBassAttempt==true) {

                if (beatTime == bassTimeArray[check3]) {

                    bassLabel.setVisible(true);
                    bassLabel.addAction(Actions.after(Actions.fadeIn(1 / 2)));
                    bassLabel.addAction(Actions.after(Actions.fadeOut(1)));
                }
            }
            if(replayAttempt == true ) {

                if(beatTime == timeArray3[attemptedBassCheck3]) {

                    soundBass.play();
                    soundBass.setLooping(true);
                    attemptedBassCheck3++;
                }

            }
            ///////////////SNARE/////////////

            if(snareAttempt == true) {
                if (beatTime == snareTimeArray[check2]) {
                    snareLabel.setVisible(true);
                    snareLabel.addAction(Actions.fadeIn(1 / 2));
                    snareLabel.addAction(Actions.fadeOut(1));
                    check2++;
                }
            }

            if(replayAttempt == true){
                if(beatTime == timeArray2[attemptedSnareCheck2])
                {
                    soundSnare.play();
                    attemptedSnareCheck2++;
                }
            }

            ////////////////MELODY////////////////
            if(melodyAttempt == true)
            {
                if (beatTime == melodyTimeArray[check4])
                {

                    melodyLabel[check4].setVisible(true);
                    melodyLabel[check4].addAction(Actions.after(Actions.fadeIn(1/2)));
                    melodyLabel[check4].addAction(Actions.after(Actions.fadeOut(1)));

                    check4++;

                }
            }
            if(replayAttempt == true){
                if(beatTime == timeArray4[attemptedMelodyCheck4])
                {
                    soundArray4[attemptedMelodyCheck4].play();
                    attemptedMelodyCheck4++;
                }
            }

            if(beatTime<=100 && start == false)
            {

                if(replayAttempt == true)

                {
                    check = 0;
                    check2 = 0;
                    check3 = 0;
                    check4 =0;
                    attemptedKickCheck = 0;
                    attemptedSnareCheck2 = 0;
                    attemptedHatCheck3 = 0;
                    attemptedBassCheck3 = 0;
                    attemptedMelodyCheck4 =0;

                }
                check = 0;
                check2 = 0;
                check3 = 0;
                check4 =0;
                beatTime = 601+ labelDisplayTime;
            }

            if (beatTime <= 0)

            {
                soundHat.setLooping(false);
                soundHat.stop();

                soundBass.setLooping(false);
                soundBass.stop();

                check = 0;
                check2 = 0;
                check3 = 0;
                check4 = 0;
                attemptedKickCheck = 0;
                attemptedSnareCheck2 = 0;
                attemptedHatCheck3 = 0;
                attemptedBassCheck3 = 0;
                attemptedMelodyCheck4 =0;

                kickLabel.setVisible(false);
                snareLabel.setVisible(false);
                hatLabel.setVisible(false);
                bassLabel.setVisible(false);
                nullLabel.setVisible(false);

            }

        }

        //@K—made Label "incorrectLabel" local method var since only utilized in here/this initialize() method
        //Incorrect Label appears if input notes are not equal to given notes
        Label incorrectLabel;
        if(step == 0)
        {

            if(next1 == true)
            {
                nextButton.setVisible(true);
            }
            prevButton.setVisible(false);

            kickAttempt = true;

            stepLabel.setText("Step 1: Make Kick Pattern");


            // Try to match the playback
            if (start) {

                playback = false;
                replayAttempt = true;
                attemptPlayback = true;
                drumPatternPlay = false;
                drumPattern.stop();
                melodyPatternPlay = false;
                melodyPattern.stop();
                //////// KICK //////////////

                // if x key is pressed than go further in a given time array
                //if x is not pressed don't go further in a given time array and countx not increment
                //as beatTime will not be equal to given time array[x]

                if(UPressed)
                {

                    if(beatTime>kickTimeArray[count]-delay && beatTime<kickTimeArray[count]+delay)
                    {
                        matchedKick[count]++;
                        timeArray[count] = beatTime;
                        count++;
                    }
                    else{
                        attempted = true;
                        start = false;
                        Timer1 = 0;
                        beatTime = 660;

                        attemptPlayback = false;
                        playback = false;
                    }
                    UPressed = false;


                }
                if(beatTime<=100)
                {
                    // **IMP**
                    //If replayAttempt = true all the way through beatTime = 0; it will play sounds
                    // because beatTime which is 0 becomes equals to timeArrayx[0] = 0;

                    replayAttempt = false;
                }

                // time runs out, stop listening for keys

                if(beatTime<=0)
                {

                    attempted = true;
                    start = false;
                    Timer1 = 0;
                    beatTime = 660;
                    attemptPlayback = false;
                    playback = false;
                }

            }

            // Checks if the attempt was correct
            if (attempted) {

                counterTimer = 3;
                counterStart = false;
                // Checks if the correct keys were pressed the correct number of times in each interval
                //@K—simpler "enhanced for loop" methodology—Nov 12, 2020 at 7.32PM

                for (int j : matchedKick) {
                    if (j == 1) {
                        correctKick++;
                    }
                }

                // If the sound was matched, the level is complete

                if (correctKick == countKick) {
                    complete = true;
                }
                // Otherwise, reset the matched array for the next attempt
                else {
                    incorrectLabel = new Label("\n Kicks Matched: " + correctKick +
                            "\n Total Kicks: "+ countKick, BaseGame.labelStyle);

                    incorrectLabel.setColor(Color.RED);
                    uiStage.addActor(incorrectLabel);
                    incorrectLabel.setPosition(500, 100);
                    incorrectLabel.addAction(Actions.delay(1));
                    incorrectLabel.addAction(Actions.after(Actions.fadeOut(4)));
                    //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
                    Arrays.fill(matchedKick, 0);
                    correctKick = 0;
                    attempted = false;
                }
            }

            // When the level is complete, returns goes to another level
            if (complete) {

                countKick = 6;
                countSnare = 6;
                countHat = 1;
                countBass = 1;
                countMelody = 14;
                attempted = false;
                complete = false;
                correctKick = 0;
                correctSnare = 0;
                correctHat = 0;
                correctBass = 0;
                correctMelody =0;
                next1 = true;
                nextButton.setVisible(true);

            }
        }

        if(step ==1)
        {
            prev1 =true;
            prevButton.setVisible(true);
            if( next2== false)
            {
                nextButton.setVisible(false);
            }

            // nextButton.setVisible(false);
            kickAttempt = false;
            snareAttempt = true;
            stepLabel.setText("Step 2: Make Snare Pattern");

            // Playback the sound to match

            // Try to match the attemptedPlayback
            if (start) {

                attemptPlayback = true;
                replayAttempt = true;
                playback = false;
                drumPatternPlay = false;
                drumPattern.stop();
                melodyPatternPlay = false;
                melodyPattern.stop();
                ///////////SNARE//////////////

                if(IPressed){


                    if(beatTime>=snareTimeArray[count2]-delay && beatTime<=snareTimeArray[count2]+delay)
                    {
                        matchedSnare[count2]++;
                        timeArray2[count2] = beatTime;
                        count2++;
                    }

                     else{
                        attempted = true;
                        start = false;
                        Timer1 = 0;
                        beatTime = 660;

                        attemptPlayback = false;
                        playback = false;
                    }

                     IPressed= false;

                }

                if(beatTime<=100)
                {
                    // **IMP**
                    //If replayAttempt = true all the way through beatTime = 0; it will play sounds
                    // because beatTime which is 0 becomes equals to timeArrayx[0] = 0;

                    replayAttempt = false;
                }
                // time runs out, stop listening for keys

                if(beatTime<=0)
                {

                    attempted = true;
                    start = false;
                    Timer1 = 0;
                    beatTime = 660;
                    playback = false;
                    attemptPlayback = false;
                }
            }

            // Checks if the attempt was correct
            if (attempted) {

                counterTimer = 3;
                counterStart = false;
                // Checks if the correct keys were pressed the correct number of times in each interval
                //@K—simpler "enhanced for loop" methodology—Nov 12, 2020 at 7.32PM
                for (int j : matchedSnare) {
                    if (j == 1) {
                        correctSnare++;
                    }
                }

                // If the sound was matched, the level is complete

                if (correctSnare == countSnare) {
                    complete = true;


                }
                // Otherwise, reset the matched array for the next attempt
                else {
                    incorrectLabel = new Label(
                            "\n Snares Matched"+correctSnare+
                                    "\nTotal Snares: "+countSnare, BaseGame.labelStyle);

                    incorrectLabel.setColor(Color.RED);
                    uiStage.addActor(incorrectLabel);
                    incorrectLabel.setPosition(500, 100);
                    incorrectLabel.addAction(Actions.delay(1));
                    incorrectLabel.addAction(Actions.after(Actions.fadeOut(4)));
                    //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
                    Arrays.fill(matchedSnare, 0);
                    correctSnare = 0;

                    attempted = false;
                }
            }

            // When the level is complete, returns goes to another level
            if (complete) {

                countKick = 6;
                countSnare = 6;
                countHat = 1;
                countBass = 1;
                countMelody = 14;
                attempted = false;
                complete = false;
                correctKick = 0;
                correctSnare = 0;
                correctHat = 0;
                correctBass = 0;
                correctMelody =0;
                next2 = true;
                nextButton.setVisible(true);
                // step = 2;

            }

        }

        /////STEP 2: ADD BASS AND HAT PATTERN////////////////////

        if(step ==2){

            prev2 =true;

            prevButton.setVisible(true);
            if( next3== false)
            {
                nextButton.setVisible(false);
            }

            kickAttempt=false;
            snareAttempt=false;
            hatBassAttempt=true;

            //@K—removed "==true" as redundant—Nov 12, 2020 at 7.31PM

            stepLabel.setText("Step 3: Add Bass and Hat");

            if (start) {

                attemptPlayback = true;
                replayAttempt = true;
                playback = false;

                if(PPressed){

                    if(beatTime>=hatTimeArray[count3]-delay && beatTime <=hatTimeArray[count3]+delay)
                    {
                        matchedHat[count3]++;
                        timeArray3[count3] = beatTime;
                      //  count3++;

                    }
                    PPressed = false;
                }

                if(OPressed){

                    if(beatTime>=bassTimeArray[count3]-delay && beatTime <=bassTimeArray[count3]+delay)
                    {

                        matchedBass[count3]++;
                        timeArray3[count3] = beatTime;
                        //count3++;

                    }
                    OPressed = false;
                }
                if(beatTime<=100)
                {
                    // **IMP**
                    //If replayAttempt = true all the way through beatTime = 0; it will play sounds
                    // because beatTime which is 0 becomes equals to timeArrayx[0] = 0;

                    replayAttempt = false;
                }

                // time runs out, stop listening for keys
                //if (total == 0)
                if (beatTime<=0)
                {
                    attempted = true;
                    start = false;
                    Timer1 = 0;
                    beatTime = 660;
                    playback = false;
                    attemptPlayback = false;
                }

            }

            // Checks if the attempt was correct
            if (attempted) {

                counterTimer = 3;
                counterStart = false;
                // Checks if the correct keys were pressed the correct number of times in each interval
                //@K—simpler "enhanced for loop" methodology—Nov 12, 2020 at 7.32PM
                for (int j : matchedHat) {
                    if (j == 1) {
                        correctHat++;
                    }
                }

                //@K—simpler "enhanced for loop" methodology—Nov 12, 2020 at 7.32PM
                for (int bass : matchedBass) {
                    if (bass == 1) {
                        correctBass++;
                    }
                }



                // If the sound was matched, the level is complete

                if (correctHat == countHat && correctBass == countBass) {
                    complete = true;

                }
                // Otherwise, reset the matched array for the next attempt
                else {
                    incorrectLabel = new Label("Hats Matched" +correctHat +
                            "\nTotal Hats: " +countHat+
                            "\n Bass Matched " +correctBass +
                            "\nTotal Bass: " +countBass, BaseGame.labelStyle);

                    incorrectLabel.setColor(Color.RED);
                    uiStage.addActor(incorrectLabel);
                    incorrectLabel.setPosition(500, 100);
                    incorrectLabel.addAction(Actions.delay(1));
                    incorrectLabel.addAction(Actions.after(Actions.fadeOut(4)));

                    //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
                    Arrays.fill(matchedHat, 0);
                    correctHat = 0;

                    //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
                    Arrays.fill(matchedBass, 0);
                    //@K—commented below line since value alreadys set to 0 above
                    correctHat= 0;
                    correctBass = 0;
                    attempted = false;
                }
            }

            // When the level is complete, goes to another level
            if (complete) {

                countKick = 6;
                countSnare = 6;
                countHat = 1;
                countBass = 1;
                countMelody = 14;
                attempted = false;
                complete = false;
                correctKick = 0;
                correctSnare = 0;
                correctHat = 0;
                correctBass = 0;
                correctMelody =0;
                next3 = true;
                nextButton.setVisible(true);
            }
        }


        ////// STEP 3: ////////
        if(step ==3) {
            prev3 =true;
            prevButton.setVisible(true);

            if( next4== false)
            {
                nextButton.setVisible(false);
            }

            kickAttempt=false;
            snareAttempt=false;
            hatBassAttempt=false;
            melodyAttempt = true;

            //@K—removed "==true" as redundant—Nov 12, 2020 at 7.31PM
            if(drumPatternPlay)
            {
                drumPattern.play();
            }

            stepLabel.setText("Step 4: Make Melody");

            //@K—removed "==true" as redundant—Nov 12, 2020 at 7.31PM
            if(melodyPatternPlay)
            {
                melodyPattern.play();
            }



            // Try to match the attemptedPlayback
            if (start) {

                playback = false;
                attemptPlayback= true;
                replayAttempt = true;

                melodyPatternPlay = false;

                melodyPattern.stop();

                if(QPressed){
                    QPressed = false;

                    if (beatTime > melodyTimeArray[count4] - delay && beatTime < melodyTimeArray[count4] + delay
                            && keyName == melodyKeysArray[count4]) {

                        matchedMelody[count4]++;
                        soundArray4[count4] = soundA5;
                        timeArray4[count4] = beatTime;


                        count4++;

                    } else {
                        attempted = true;
                        start = false;
                        Timer1 = 0;
                        beatTime = 660;

                        attemptPlayback = false;
                        playback = false;
                    }
                }

                if(WPressed){

                    if (beatTime > melodyTimeArray[count4] - delay && beatTime < melodyTimeArray[count4] + delay
                            && keyName == melodyKeysArray[count4]) {

                        matchedMelody[count4]++;
                        soundArray4[count4] = soundB5;
                        timeArray4[count4] = beatTime;

                        count4++;

                    } else {
                        attempted = true;
                        start = false;
                        Timer1 = 0;
                        beatTime = 660;

                        attemptPlayback = false;
                        playback = false;
                    }
                    WPressed = false;
                }

                if(EPressed){

                    if (beatTime > melodyTimeArray[count4] - delay && beatTime < melodyTimeArray[count4] + delay
                            && keyName == melodyKeysArray[count4]) {

                        matchedMelody[count4]++;
                        soundArray4[count4] = soundC6;
                        timeArray4[count4] = beatTime;


                        count4++;

                    } else {
                        attempted = true;
                        start = false;
                        Timer1 = 0;
                        beatTime = 660;

                        attemptPlayback = false;
                        playback = false;
                    }
                    EPressed =false;
                }

                if(RPressed){

                    if (beatTime > melodyTimeArray[count4] - delay && beatTime < melodyTimeArray[count4] + delay
                            && keyName == melodyKeysArray[count4]) {

                        matchedMelody[count4]++;
                        soundArray4[count4] = soundE6;
                        timeArray4[count4] = beatTime;
                        melodyLabel[count4].addAction(Actions.after(Actions.fadeOut(1)));


                        count4++;

                    } else {
                        attempted = true;
                        start = false;
                        Timer1 = 0;
                        beatTime = 660;

                        attemptPlayback = false;
                        playback = false;
                    }
                    RPressed=false;
                }


                if(beatTime<=100)
                {
                    // **IMP**
                    //If replayAttempt = true all the way through beatTime = 0; it will play sounds
                    // because beatTime which is 0 becomes equals to timeArrayx[0] = 0;

                    replayAttempt = false;
                }



                // time runs out, stop listening for keys
                if (beatTime<=0)
                {
                    attempted = true;
                    start = false;
                    Timer1 = 0;
                    beatTime = 660;
                    playback = false;
                    attemptPlayback = false;
                }

            }

            // Checks if the attempt was correct
            if (attempted) {

                counterTimer = 3;
                counterStart = false;
                // Checks if the correct keys were pressed the correct number of times in each interval
                //@K—simpler "enhanced for loop" methodology—Nov 12, 2020 at 7.32PM
                for (int j : matchedMelody) {
                    if (j == 1) {
                        correctMelody++;
                    }
                }
                // If the sound was matched, the level is complete

                // ONLY FOR MELODY////////
                if (correctMelody >= countMelody) {
                    complete = true;


                }
                // Otherwise, reset the matched array for the next attempt
                else {
                    incorrectLabel = new Label("Melody notes Matched: " + correctMelody +
                            "\nTotal melody Note: "+ countMelody, BaseGame.labelStyle);

                    incorrectLabel.setColor(Color.RED);
                    uiStage.addActor(incorrectLabel);
                    incorrectLabel.setPosition(500, 100);
                    incorrectLabel.addAction(Actions.delay(1));
                    incorrectLabel.addAction(Actions.after(Actions.fadeOut(1)));
                    //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
                    Arrays.fill(matchedMelody, 0);

                    correctMelody = 0;
                    attempted = false;
                }
            }



            if (complete) {
                countKick = 6;
                countSnare = 6;
                countHat = 1;
                countBass = 1;
                countMelody = 14;
                attempted = false;
                complete = false;
                correctKick = 0;
                correctSnare = 0;
                correctHat = 0;
                correctBass = 0;
                correctMelody =0;
                next4 = true;
                nextButton.setVisible(true);

            }

        }

        if(step == 4)
        {

            attemptPlayback=true;
            replayAttempt = true;
            kickAttempt=true;
            snareAttempt=true;
            hatBassAttempt=true;
            melodyAttempt=true;
            replayAttemptButton.remove();
            patternPlaybackButton.remove();
            PlaybackButton.remove();
            prevButton.remove();
            nextButton.remove();
            attemptButton.remove();

        }

    }

}
