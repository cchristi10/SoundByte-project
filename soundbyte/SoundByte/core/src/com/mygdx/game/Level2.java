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

public class Level2 extends BaseScreen{

    // The sounds
    private Music beat;
    private Music soundOne;
    private Music soundTwo;
    private Music soundThree;
    private Music soundFour;
    private Music soundE6;
    private Music soundKick;
    private Music soundHat;
    private Music soundBass;
    private Music soundAmChord;
    private Music soundGChord;
    private Music soundDmChord;
    private Music soundSnare;
    private Music melodyPattern;
    private Music drumPattern;
    private Music chordPattern;
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
    boolean next5 = false;
    boolean finish = false;
    boolean prev1;
    boolean prev2;
    boolean prev3;
    boolean prev4;
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
    private final int delay = 20 / SettingsScreen.getDifficulty();

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
    private int countChord;
    // array of sounds matched

    private int[] matchedKick;
    private int[] matchedSnare;
    private int[] matchedHat;
    private int[] matchedBass;
    private int[] matchedMelody;
    private int[] matchedChord;

    // number of sounds matched
    private int correctKick;
    private int correctSnare;
    private int correctHat;
    private int correctBass;
    private int correctMelody;
    private int correctChord;

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
    boolean hatAttempt;
    boolean melodyAttempt;
    boolean chordAttempt;

    //ADD Ten to every time stamps/////
    private int beatLength = 454;
   // private int beatLength = 544;
    private int givenKicks = 6;
    private int givenSnares = 8;
    private int givenMelody = 6;
    private int givenChord = 6;

    private int count = 0;
    private int check = 0;
    private int attemptedKickCheck = 0;
    public int[] kickTimeArray = {453,411,301,231,190,79,0};
   //public int[] kickTimeArray = {543,501,391,321,280,169,0};

    public int[] timeArray = new int[1000];

    private int count2 = 0;
    private int check2 = 0;
    private int attemptedSnareCheck2 = 0;
    public int[] snareTimeArray = {398,356,287,245,176,135,66,24,0};
  // public int[] snareTimeArray = {488,446,377,335,266,225,156,114,0};
    public int[] timeArray2 = new int[1000];

    private int count3 = 0;
    private int check3 = 0;
    private int attemptedHatCheck3 = 0;
    public int[] hatTimeArray = {453,0};
  // public int[] hatTimeArray = {543,0};
    public int[] timeArray3 = new int[1000];

    // step 3
    private int count4 = 0;
    private int check4 = 0;


    private int attemptedMelodyCheck4 = 0;

    public Music[] soundArray4= new Music[1000];
    public int[] melodyTimeArray = {356,301,245,135,79,24,0};
 //   public int[] melodyTimeArray = {446,391,335,225,169,114,0};
    public char[] melodyKeysArray = {'R','E','W','R','E','W',0};
    public Label[] melodyLabel = {RLabel,ELabel,WLabel,RLabel,ELabel,WLabel,nullLabel };
    public int[] timeArray4 = new int[1000];
    //Chords
    private int count5 = 0;
    private int check5 = 0;
    private int attemptedChordCheck5 = 0;
    public Music[] soundArray5= new Music[1000];
    public int[] chordTimeArray = {453,342,287,231,121,66,0};
   // public int[] chordTimeArray = {543,432,377,321,211,156,0};
    public char[] chordKeysArray = {'W','R','Q','W','R','Q',0};
    public Label[] chordLabel = {WLabel,RLabel,QLabel,WLabel,RLabel,QLabel,nullLabel};

    public int[] timeArray5 = new int[1000];
    private char keyName; //// Keyboard key name that is assignet to a sound

    public void initialize() {
        ///////////////////////////////////////////////////////////////////////////

        drumPattern = Gdx.audio.newMusic(Gdx.files.internal("Beat2/Beat2DrumPattern.ogg"));
        drumPattern.setLooping(false);

        beat = Gdx.audio.newMusic(Gdx.files.internal("Beat2/ClarenceBeat2.ogg"));
        beat.setLooping(false);
        soundOne = Gdx.audio.newMusic(Gdx.files.internal("Beat2/one.ogg"));
        soundOne.setLooping(false);
        soundTwo = Gdx.audio.newMusic(Gdx.files.internal("Beat2/two.ogg"));
        soundTwo.setLooping(false);
        soundThree= Gdx.audio.newMusic(Gdx.files.internal("Beat2/three.ogg"));
        soundThree.setLooping(false);
        soundFour = Gdx.audio.newMusic(Gdx.files.internal("Beat2/four.ogg"));
        soundFour.setLooping(false);
        soundE6 = Gdx.audio.newMusic(Gdx.files.internal("Beats/noteE61.ogg"));
        soundE6.setLooping(false);
        soundKick = Gdx.audio.newMusic(Gdx.files.internal("Beat2/808Kick.ogg"));
        soundKick.setLooping(false);
        soundHat = Gdx.audio.newMusic(Gdx.files.internal("Beat2/Beat2HatPattern.ogg"));
        soundHat.setLooping(false);

        ///////CHANGE BASS ONLY FOR LEVEL////////
        soundBass = Gdx.audio.newMusic(Gdx.files.internal("Beats/noteE61.ogg"));
        soundBass.setLooping(false);

        soundSnare = Gdx.audio.newMusic(Gdx.files.internal("Beat2/808Snare.ogg"));
        soundSnare.setLooping(false);
        melodyPattern = Gdx.audio.newMusic(Gdx.files.internal("Beat2/Beat2MelodyPattern.ogg"));
        melodyPattern.setLooping(false);

        /////////CHORD SOUNDS////////////
        chordPattern = Gdx.audio.newMusic(Gdx.files.internal("Beat2/Beat2ChordPattern.ogg"));
        chordPattern.setLooping(false);
        soundAmChord = Gdx.audio.newMusic(Gdx.files.internal("Beat2/AmChord.ogg"));
        soundAmChord.setLooping(false);
        soundDmChord = Gdx.audio.newMusic(Gdx.files.internal("Beat2/DmChord.ogg"));
        soundDmChord.setLooping(false);
        soundGChord = Gdx.audio.newMusic(Gdx.files.internal("Beat2/GChord.ogg"));
        soundGChord.setLooping(false);



        // Initial values for the variables
        playback = false;
        attemptPlayback = false;
        start = false;
        attempted = false;
        complete = false;
        Timer1 = 0;
        counterTimer = 3;
        beatTime = beatLength;
        // The amount of sounds
        countKick = givenKicks;
        countSnare = givenSnares;
        countHat = 1;
        countBass = 1;
        countMelody = givenMelody;
        countChord = givenChord;


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

        matchedChord = new int[countChord];
        //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
        Arrays.fill(matchedChord, 0);

        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("wallpapers/Level One—Reference.jpg");
        background.setSize(virWidth, virHeight);

        BaseActor.setWorldBounds(background);

        kickLabel = new Label("U", BaseGame.labelStyle);
        kickLabel.setColor(Color.CYAN);
        uiStage.addActor(kickLabel);
        kickLabel.setVisible(false);
        kickLabel.setPosition(430 * WidthOffset,97 * HeightOffset);

        snareLabel = new Label("I", BaseGame.labelStyle);
        snareLabel.setColor(Color.CYAN);
        uiStage.addActor(snareLabel);
        snareLabel.setVisible(false);
        snareLabel.setPosition(780 * WidthOffset,97 * HeightOffset);

        bassLabel = new Label("O", BaseGame.labelStyle);
        bassLabel.setColor(Color.CYAN);
        uiStage.addActor(bassLabel);
        bassLabel.setVisible(false);
        bassLabel.setPosition(1110 * WidthOffset,97 * HeightOffset);

        hatLabel = new Label("P", BaseGame.labelStyle);
        hatLabel.setColor(Color.CYAN);
        uiStage.addActor(hatLabel);
        hatLabel.setVisible(false);
        hatLabel.setPosition(1460 * WidthOffset,97 * HeightOffset);

        ////////// MELODY LABELS////////////////////
        QLabel = new Label("Q", BaseGame.labelStyle);
        QLabel.setColor(Color.PURPLE);
        uiStage.addActor(QLabel);
        QLabel.setVisible(false);
        QLabel.setPosition(430 * WidthOffset,300 * HeightOffset);

        nullLabel = new Label("NULL", BaseGame.labelStyle);
        nullLabel.setColor(Color.PURPLE);
        uiStage.addActor(nullLabel);
        nullLabel.setVisible(false);
        nullLabel.setPosition(430 * WidthOffset,300 * HeightOffset);

        WLabel = new Label("W", BaseGame.labelStyle);
        WLabel.setColor(Color.PURPLE);
        uiStage.addActor(WLabel);
        WLabel.setVisible(false);
        WLabel.setPosition(762 * WidthOffset,300 * HeightOffset);

        ELabel = new Label("E", BaseGame.labelStyle);
        ELabel.setColor(Color.PURPLE);
        uiStage.addActor(ELabel);
        ELabel.setVisible(false);
        ELabel.setPosition(1115 * WidthOffset,300 * HeightOffset);

        RLabel = new Label("R", BaseGame.labelStyle);
        RLabel.setColor(Color.PURPLE);
        uiStage.addActor(RLabel);
        RLabel.setVisible(false);
        RLabel.setPosition(1458 * WidthOffset,300 * HeightOffset);

        TimeLeft = new Label("", BaseGame.labelStyle);
        TimeLeft.setSize(350 * WidthOffset,90 * HeightOffset);
        TimeLeft.setPosition(860 * WidthOffset,500 * HeightOffset);
        uiStage.addActor(TimeLeft);

        beatTimeLeft= new Label(" ", BaseGame.labelStyle);
        beatTimeLeft.setColor(Color.GOLDENROD);
        beatTimeLeft.setPosition(50 * WidthOffset,900 * HeightOffset);
        uiStage.addActor(beatTimeLeft);

        stepLabel = new Label("", BaseGame.labelStyle);
        stepLabel.setColor(Color.WHITE);
        stepLabel.setPosition(20*WidthOffset,850*HeightOffset);
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
                beatTime = beatLength;

                // soundHat.setLooping(false);
                //  soundHat.stop();

                drumPattern.stop();
                melodyPattern.stop();
                chordPattern.stop();
            }
            else{
                check = 0;
                check2 = 0;
                check3 = 0;
                check4 = 0;
                check5 = 0;


                if(drumPattern.isPlaying() || melodyPattern.isPlaying() || chordPattern.isPlaying() ||soundHat.isPlaying()){
                    drumPattern.stop();
                    melodyPattern.stop();
                    chordPattern.stop();
                    soundHat.stop();
                }

                beatTime=beatLength;
                playback = true;
                drumPattern.play();
                chordPattern.play();

                drumPattern.setLooping(true);
                chordPattern.setLooping(true);

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
                beatTime = beatLength;

                soundHat.setLooping(false);
                soundHat.stop();
                soundBass.setLooping(false);
                soundBass.stop();
                drumPattern.stop();
                melodyPattern.stop();
                chordPattern.stop();
            }
            else{
                check = 0;
                check2 = 0;
                check3 = 0;
                check4 = 0;
                check5 = 0;
                beatTime=beatLength;
                start = false;
                attemptPlayback = true;
                playback=false;
                replayAttempt=false;
                if(drumPattern.isPlaying() || melodyPattern.isPlaying() || chordPattern.isPlaying()) {
                    drumPattern.stop();
                    melodyPattern.stop();
                    chordPattern.stop();
                }
                if ((step == 0 || step == 1)) {

                    if(kickAttempt == true)
                    {
                        drumPattern.play();
                        drumPattern.setLooping(true);
                    }
                    if(snareAttempt == true) {
                        drumPattern.play();
                        drumPattern.setLooping(true);

                    }
                    if(hatAttempt == true) {
                        drumPattern.play();
                        drumPattern.setLooping(true);

                    }

                }
                if(step == 2)
                {
                    if(chordAttempt == true) {
                        chordPattern.play();
                        chordPattern.setLooping(true);

                    }
                }
                if(step == 3)
                {
                    if(melodyAttempt == true) {
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
                check5 =0;
                attemptedKickCheck = 0;
                attemptedSnareCheck2 = 0;
                attemptedHatCheck3 = 0;
                attemptedMelodyCheck4 = 0;
                attemptedChordCheck5 = 0;
                beatTime = beatLength;
                soundHat.setLooping(false);
                soundHat.stop();
                soundBass.setLooping(false);
                soundBass.stop();
            }
            else{
                if(drumPattern.isPlaying() || melodyPattern.isPlaying()||chordPattern.isPlaying() ){
                    drumPattern.stop();
                    melodyPattern.stop();
                    chordPattern.stop();
                }
                check = 0;
                check2 = 0;
                check3 = 0;
                check4 = 0;
                check5=0;
                attemptedKickCheck = 0;
                attemptedSnareCheck2 = 0;
                attemptedHatCheck3 = 0;
                attemptedMelodyCheck4 = 0;
                attemptedChordCheck5 = 0;
                playback=false;
                beatTime=beatLength;
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

            chordPattern.stop();
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
            attemptedMelodyCheck4 = 0;
            attemptedChordCheck5 = 0;
            check =  0;
            check2 = 0;
            check3 = 0;
            check4 = 0;
            check5=0;
            count2 = 0;
            count  = 0;
            beatTime = beatLength+59;

            //reset attempted kicks
            if(step ==0) {
                timeArray = new int[1000]; count = 0;
                timeArray2 = new int[1000]; count2 = 0;
            }

            //reset attempted snare
            if(step ==1) {
                timeArray3 = new int[1000]; count3 = 0;
            }

            if(step == 2)
            {
                soundArray5 = new Music[1000];timeArray5 = new int[1000]; count5 = 0;
            }

            if(step == 3)
            {
                soundArray4 = new Music[1000];timeArray4 = new int[1000]; count4 = 0;
            }

            countKick = givenKicks;
            countSnare = givenSnares;
            countMelody = givenMelody;
            countChord = givenChord;
            countHat = 1;
            countBass = 1;
            correctKick = 0;
            correctSnare = 0;
            correctHat = 0;
            correctBass = 0;
            correctMelody =0;
            correctChord = 0;

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

            ////////////RESETS CHORD///////
            matchedChord = new int[countChord];

            //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
            Arrays.fill(matchedChord, 0);

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
            check5=0;
            attemptedKickCheck = 0;
            attemptedSnareCheck2 = 0;
            attemptedHatCheck3 = 0;
            attemptedMelodyCheck4 = 0;
            attemptedChordCheck5 = 0;
            if(next1 || next2 || next3 ||next4||next5)
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

            beatTime = beatLength;

            check = 0;
            check2 = 0;
            check3 = 0;
            check4 = 0;
            check5=0;
            attemptedKickCheck = 0;
            attemptedSnareCheck2 = 0;
            attemptedHatCheck3 = 0;
            attemptedMelodyCheck4 = 0;
            attemptedChordCheck5 = 0;

            if(step == 1 && prev1 ==true)
            {
                nextButton.setVisible(true);
                prevButton.setVisible(true);
                hatAttempt = false;
                step = 0;
            }

            if(step == 2 && prev2 ==true)
            {
                nextButton.setVisible(true);
                prevButton.setVisible(true);
                chordAttempt= false;
                step =1;
            }
            if(step == 3 && prev3 == true)
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
        QButton.setPosition(393 * WidthOffset,275 * HeightOffset);
        QButton.setSize(110 * WidthOffset,110 * HeightOffset);
        QButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(QButton);
        QButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;

            soundGChord.play();
            keyName ='Q';
            if(soundGChord.isPlaying()) { soundGChord.stop();soundGChord.play(); }if (start) { QPressed= true; }
            return true; }
        );

        WButton = new TextButton( "W", BaseGame.textButtonStyle );
        WButton.setPosition(734 * WidthOffset,275 * HeightOffset);
        WButton.setSize(110 * WidthOffset,110 * HeightOffset);
        WButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(WButton);
        WButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundAmChord.play();
            keyName ='W';
            if(step == 3)
            { soundAmChord.stop();soundFour.play();
                if(soundFour.isPlaying()){ soundFour.stop();soundFour.play();}if (start) { WPressed= true; } }
            else if(soundAmChord.isPlaying()){soundAmChord.stop();soundAmChord.play();}if (start) { WPressed = true; }
            return true; }
        );

        EButton = new TextButton( "E", BaseGame.textButtonStyle );
        EButton.setPosition(1074 * WidthOffset,275 * HeightOffset);
        EButton.setSize(110 * WidthOffset,110 * HeightOffset);
        EButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(EButton);
        EButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundThree.play();
            keyName ='E';

            if(soundThree.isPlaying()){soundThree.stop();soundThree.play();}
            if (start) { EPressed = true; }
            return true; }
        );

        RButton = new TextButton( "R", BaseGame.textButtonStyle );
        RButton.setPosition(1418 * WidthOffset,275 * HeightOffset);
        RButton.setSize(110 * WidthOffset,110 * HeightOffset);
        RButton.setColor(0f,0f,0f,0f);
        uiStage.addActor(RButton);
        RButton.addListener( (Event e) -> {
            if ( !(e instanceof InputEvent) ) return false;
            if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) ) return false;
            soundDmChord.play();
            keyName ='R';
            if(step == 3)
            { soundDmChord.stop();soundTwo.play();
                if(soundTwo.isPlaying()){ soundTwo.stop();soundTwo.play();}
                if (start) { RPressed= true; } }
            else if(soundDmChord.isPlaying()){soundDmChord.stop();soundDmChord.play();}
            if (start) { RPressed = true; }
            return true; }
        );

        UButton = new TextButton( "U", BaseGame.textButtonStyle );
        UButton.setPosition(395 * WidthOffset,75 * HeightOffset);
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
        IButton.setPosition(735 * WidthOffset,75 * HeightOffset);
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
        OButton.setPosition(1074 * WidthOffset,75* HeightOffset);
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
        PButton.setPosition(1418 * WidthOffset,75 * HeightOffset);
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
        //  step = 1;

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q))
        {soundGChord.play();
            keyName ='Q';
            if(soundGChord.isPlaying()) { soundGChord.stop();soundGChord.play(); }
            if (start) { QPressed= true; }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.W))
        {soundAmChord.play();
            keyName ='W';
            if(step == 3)
            { soundAmChord.stop();soundFour.play();
                if(soundFour.isPlaying()){ soundFour.stop();soundFour.play();}if (start) { WPressed= true; } }
            else if(soundAmChord.isPlaying()){soundAmChord.stop();soundAmChord.play();}if (start) { WPressed = true; }}


        if(Gdx.input.isKeyJustPressed(Input.Keys.E))
        {soundThree.play();
            keyName ='E';

            if(soundThree.isPlaying()){soundThree.stop();soundThree.play();}
            if (start) { EPressed = true; }}


        if(Gdx.input.isKeyJustPressed(Input.Keys.R))
        {soundDmChord.play();
            keyName ='R';

            if(step == 3)
            { soundDmChord.stop();soundTwo.play();
                if(soundTwo.isPlaying()){ soundTwo.stop();soundTwo.play();}
                if (start) { RPressed= true; } }
            else if(soundDmChord.isPlaying()){soundDmChord.stop();soundDmChord.play();}
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

        // Starts tracking your key preses to match (Currently no picture)
        if (Gdx.input.isKeyPressed(Input.Keys.M)) {

            counterStart = true;
        }
      //  beatTimeLeft.setText(beatTime);

        if(counterStart && counterTimer>=0)
        {
            counterTimer -= dt;
            playback = false;
            melodyPattern.stop();
            drumPattern.stop();
            chordPattern.stop();
            attemptPlayback = false;
            replayAttempt = false;
            beatTime = beatLength;
            TimeLeft.setText("Countdown: " + Math.round(counterTimer));

            if(counterTimer <= 0) {
                beatTime = beatLength+60; //gives 60 seconds
                TimeLeft.setText("");

                attemptButton.setText("STOP");
                start = true;
            }
        }

        if(start == false)
        {
            attemptButton.setText("Attempt");
        }

            ////////////////PLAYS ENTIRE BEAT////////////////////////////
            // Playback the sound to match
            if (playback) {
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


                if (beatTime == hatTimeArray[check3]) {
                    check3++;
                    hatLabel.setVisible(true);
                    hatLabel.addAction(Actions.fadeIn(1 / 2));
                    hatLabel.addAction(Actions.fadeOut(1));

                }

                ///////////////SNARE/////////////

                if (beatTime == snareTimeArray[check2]) {
                    check2++;
                    snareLabel.setVisible(true);
                    snareLabel.addAction(Actions.fadeIn(1 / 2));
                    snareLabel.addAction(Actions.fadeOut(1));

                }
                ///CHORDS///

                if (beatTime == chordTimeArray[check5]) {

                    chordLabel[check5].setVisible(true);
                    chordLabel[check5].addAction(Actions.after(Actions.fadeIn(1 / 2)));
                    chordLabel[check5].addAction(Actions.after(Actions.fadeOut(1)));
                    check5++;

                }

                ////////////////MELODY////////////////

                if (beatTime == melodyTimeArray[check4]) {

                    //     melodyLabel[check4].setVisible(true);
                    //    melodyLabel[check4].addAction(Actions.after(Actions.fadeIn(1/2)));
                    //  melodyLabel[check4].addAction(Actions.after(Actions.fadeOut(1)));
                    // Plays the sound for the specified count amount of times

                    check4++;
                }
                if (beatTime <= 10 && start == false) {
                    beatTime = beatLength;
                    check = 0;
                    check2 = 0;
                    check3 = 0;
                    check4 = 0;
                    check5 = 0;
                }
                if (beatTime <= 0) {
                    playback = false;
                    check = 0;
                    check2 = 0;
                    check3 = 0;
                    check4 = 0;
                    check5 = 0;
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

            if(hatAttempt==true) {

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

            /////////////CHORDS///////////////
            if(chordAttempt == true) {

                if (beatTime == chordTimeArray[check5]) {

                    chordLabel[check5].setVisible(true);
                    chordLabel[check5].addAction(Actions.after(Actions.fadeIn(1/2)));
                    chordLabel[check5].addAction(Actions.after(Actions.fadeOut(1)));
                    check5++;

                }
            }
            if(replayAttempt == true){
                if(beatTime == timeArray5[attemptedChordCheck5])
                {
                    soundArray5[attemptedChordCheck5].play();
                    attemptedChordCheck5++;

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

            if(beatTime<=10 && start == false)
            {
                if(replayAttempt == true)

                {
                    check = 0;
                    check2 = 0;
                    check3 = 0;
                    check4 = 0;
                    check5 = 0;
                    attemptedKickCheck = 0;
                    attemptedSnareCheck2 = 0;
                    attemptedHatCheck3 = 0;
                    attemptedMelodyCheck4 = 0;
                    attemptedChordCheck5 = 0;

                }
                check = 0;
                check2 = 0;
                check3 = 0;
                check4 = 0;
                check5=0;
                beatTime = beatLength;
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
                check5=0;
                attemptedKickCheck = 0;
                attemptedSnareCheck2 = 0;
                attemptedHatCheck3 = 0;
                attemptedMelodyCheck4 = 0;
                attemptedChordCheck5 = 0;

                kickLabel.setVisible(false);
                snareLabel.setVisible(false);
                hatLabel.setVisible(false);
                bassLabel.setVisible(false);
                nullLabel.setVisible(false);
            }

        }

        if(count>=kickTimeArray.length-1)
        {
            count = 0;
        }
        if(count2>=snareTimeArray.length-1)
        {
            count2 = 0;
        }
        if(count3>=hatTimeArray.length-1)
        {
            count3 = 0;
        }
        if(count4>=melodyTimeArray.length-1)
        {
            count4 = 0;
        }
        if(count5>=chordTimeArray.length-1)
        {
            count5 = 0;
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
            snareAttempt = true;
            stepLabel.setText("Step 1: Make Kick and Snare Pattern");

            // Try to match the playback
            if (start) {

                playback = false;
                replayAttempt = true;
                attemptPlayback = true;
                drumPatternPlay = false;
                drumPattern.stop();
                chordPattern.stop();
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
                        beatTime = beatLength;

                        attemptPlayback = false;
                        playback = false;
                    }
                    UPressed = false;

                }
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
                        beatTime = beatLength;
                        attemptPlayback = false;
                        playback = false;
                    }

                    IPressed= false;
                }
                if(beatTime<=10)
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
                    beatTime = beatLength+60;
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

                for (int j : matchedSnare) {
                    if (j == 1) {
                        correctSnare++;
                    }
                }

                // If the sound was matched, the level is complete

                if (correctKick == countKick && correctSnare == countSnare) {

                    complete = true;
                }
                // Otherwise, reset the matched array for the next attempt
                else {
                    incorrectLabel = new Label("\n Kicks Matched: " + correctKick +
                            " Total Kicks: "+ countKick +"\n Snares Matched: "+correctSnare+
                            " Total Snares: "+countSnare, BaseGame.labelStyle);

                    incorrectLabel.setColor(Color.RED);
                    uiStage.addActor(incorrectLabel);
                    incorrectLabel.setPosition(500, 500);
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

                countKick = givenKicks;
                countSnare = givenSnares;
                countMelody = givenMelody;
                countChord = givenChord;
                countHat = 1;
                countBass = 1;

                attempted = false;
                complete = false;
                correctKick = 0;
                correctSnare = 0;
                correctHat = 0;
                correctBass = 0;
                correctMelody =0;
                correctChord = 0;
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

            kickAttempt = false;
            snareAttempt = false;
            hatAttempt = true;

            stepLabel.setText("Step 2: Add Hat Pattern");

            // Playback the sound to match

            // Try to match the attemptedPlayback

            if (start) {

                attemptPlayback = true;

                replayAttempt = true;

                playback = false;

                if(PPressed){

                    if(beatTime>=hatTimeArray[count3]-delay && beatTime <=hatTimeArray[count3]+delay)
                    {
                        matchedHat[count3]++;
                        timeArray3[count3] = beatTime;
                        count3++;

                    }
                    PPressed = false;

                }

                if(beatTime<=10)
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
                    beatTime = beatLength;
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


                // If the sound was matched, the level is complete

                if (correctHat == countHat) {
                    complete = true;


                }
                // Otherwise, reset the matched array for the next attempt
                else {
                    incorrectLabel = new Label("Hats Matched" +correctHat +
                            "\nTotal Hats: " +countHat,BaseGame.labelStyle);

                    incorrectLabel.setColor(Color.RED);
                    uiStage.addActor(incorrectLabel);
                    incorrectLabel.setPosition(500, 500);
                    incorrectLabel.addAction(Actions.delay(1));
                    incorrectLabel.addAction(Actions.after(Actions.fadeOut(4)));

                    //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
                    Arrays.fill(matchedHat, 0);
                    correctHat = 0;


                    correctHat= 0;

                    attempted = false;
                }
            }


            // When the level is complete, returns goes to another level
            if (complete) {

                countKick = givenKicks;
                countSnare = givenSnares;
                countMelody = givenMelody;
                countChord = givenChord;
                countSnare = 4;
                countHat = 1;
                countBass = 1;
                attempted = false;
                complete = false;
                correctKick = 0;
                correctSnare = 0;
                correctHat = 0;
                correctBass = 0;
                correctMelody =0;
                correctChord =0;
                next2 = true;
                nextButton.setVisible(true);
                // step = 2;

            }

        }

        ///STEP 2: ADD CHORDS///////////

        if(step ==2) {


            prev2 =true;
            prevButton.setVisible(true);

            if( next3== false)
            {
                nextButton.setVisible(false);
            }

            kickAttempt=false;
            snareAttempt=false;
            hatAttempt=false;
            chordAttempt = true;

            //@K—removed "==true" as redundant—Nov 12, 2020 at 7.31PM


            stepLabel.setText("Step 3: Make CHORD");

            //@K—removed "==true" as redundant—Nov 12, 2020 at 7.31PM



            // Try to match the attemptedPlayback
            if (start) {

                playback = false;
                attemptPlayback= true;
                replayAttempt = true;

                /// PUT CHORD PATTERN

                chordPattern.stop();

                if(QPressed){
                    QPressed = false;

                    if (beatTime > chordTimeArray[count5] - delay && beatTime < chordTimeArray[count5] + delay
                            && keyName == chordKeysArray[count5]) {

                        matchedChord[count5]++;
                        soundArray5[count5] = soundGChord;
                        timeArray5[count5] = beatTime;


                        count5++;

                    } else {
                        attempted = true;
                        start = false;
                        Timer1 = 0;
                        beatTime = beatLength;
                        attemptPlayback = false;
                        playback = false;
                    }

                }

                if(WPressed){

                    if (beatTime > chordTimeArray[count5] - delay && beatTime < chordTimeArray[count5] + delay
                            && keyName == chordKeysArray[count5]) {

                        matchedChord[count5]++;
                        soundArray5[count5] = soundAmChord;
                        timeArray5[count5] = beatTime;


                        count5++;

                    } else {
                        attempted = true;
                        start = false;
                        Timer1 = 0;
                        beatTime = beatLength;

                        attemptPlayback = false;
                        playback = false;
                    }
                    WPressed = false;
                }

                if(EPressed){

                    if (beatTime > chordTimeArray[count5] - delay && beatTime < chordTimeArray[count5] + delay
                            && keyName == chordKeysArray[count5]) {

                        matchedChord[count5]++;
                        soundArray5[count5] = null;
                        timeArray5[count5] = beatTime;


                        count5++;

                    } else {
                        attempted = true;
                        start = false;
                        Timer1 = 0;
                        beatTime =  beatLength;

                        attemptPlayback = false;
                        playback = false;
                    }
                    EPressed=false;

                }



                if(RPressed){

                    if (beatTime > chordTimeArray[count5] - delay && beatTime < chordTimeArray[count5] + delay
                            && keyName == chordKeysArray[count5]) {

                        matchedChord[count5]++;
                        soundArray5[count5] = soundDmChord;
                        timeArray5[count5] = beatTime;


                        count5++;

                    } else {
                        attempted = true;
                        start = false;
                        Timer1 = 0;
                        beatTime =  beatLength;

                        attemptPlayback = false;
                        playback = false;
                    }
                    RPressed=false;
                }


                if(beatTime<=10)
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
                    beatTime =  beatLength;
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
                for (int j : matchedChord) {
                    if (j == 1) {
                        correctChord++;
                    }
                }
                // If the sound was matched, the level is complete

                // ONLY FOR MELODY////////
                if (correctChord >= countChord) {
                    complete = true;


                }
                // Otherwise, reset the matched array for the next attempt
                else {
                    incorrectLabel = new Label("Chords Matched: " + correctChord +
                            "\nTotal Chords: "+ countChord, BaseGame.labelStyle);

                    incorrectLabel.setColor(Color.RED);
                    uiStage.addActor(incorrectLabel);
                    incorrectLabel.setPosition(500, 500);
                    incorrectLabel.addAction(Actions.delay(1));
                    incorrectLabel.addAction(Actions.after(Actions.fadeOut(1)));
                    //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
                    Arrays.fill(matchedChord, 0);

                    correctChord = 0;
                    attempted = false;
                }
            }



            if (complete) {
                countKick = givenKicks;
                countSnare = givenSnares;
                countMelody = givenMelody;
                countChord = givenChord;
                countHat = 1;
                countBass = 1;


                attempted = false;
                complete = false;
                correctKick = 0;
                correctSnare = 0;
                correctHat = 0;
                correctBass = 0;
                correctMelody =0;
                correctChord = 0;
                next3 = true;
                nextButton.setVisible(true);

            }

        }



        ////// STEP 3: ADD MELODY////////

        if(step ==3) {

            prev3 =true;
            prevButton.setVisible(true);

            if( next4== false)
            {
                nextButton.setVisible(false);
            }

            kickAttempt=false;
            snareAttempt=false;
            chordAttempt = false;
            hatAttempt = false;
            melodyAttempt = true;

            //@K—removed "==true" as redundant—Nov 12, 2020 at 7.31PM


            stepLabel.setText("Step 4: Make Melody");

            //@K—removed "==true" as redundant—Nov 12, 2020 at 7.31PM



            // Try to match the attemptedPlayback
            if (start) {

                playback = false;
                attemptPlayback= true;
                replayAttempt = true;

                /// PUT CHORD PATTERN

                chordPattern.stop();

                if(QPressed){
                    QPressed = false;

                    if (beatTime >melodyTimeArray[count4] - delay && beatTime < melodyTimeArray[count4] + delay
                            && keyName == melodyKeysArray[count4]) {

                        matchedMelody[count4]++;
                        soundArray4[count4] = soundOne;
                        timeArray4[count4] = beatTime;


                        count4++;

                    } else {
                        attempted = true;
                        start = false;
                        Timer1 = 0;
                        beatTime = beatLength;
                        attemptPlayback = false;
                        playback = false;
                    }

                }

                if(WPressed){

                    //ONLY FOR W -10 instead of - delay as it is at the end of the loop. Because sometimes
                    // Player might press key that is more than last 10 seconds of the loop and the game will consider it
                    //correct but will not play sound in LOOP PLAY
                    // Using this will cause player to not pass the step as it will not
                    //count the note if it is >10 seconds.
                    if (beatTime >melodyTimeArray[count4] - delay && beatTime < melodyTimeArray[count4] + delay
                            && keyName == melodyKeysArray[count4]) {

                        matchedMelody[count4]++;
                        soundArray4[count4] = soundFour;
                        timeArray4[count4] = beatTime;


                        count4++;

                    } else {
                        attempted = true;
                        start = false;
                        Timer1 = 0;
                        beatTime = beatLength;

                        attemptPlayback = false;
                        playback = false;
                    }
                    WPressed = false;
                }

                if(EPressed){

                    if (beatTime >melodyTimeArray[count4] - delay && beatTime < melodyTimeArray[count4] + delay
                            && keyName == melodyKeysArray[count4]) {

                        matchedMelody[count4]++;
                        soundArray4[count4] = soundThree;
                        timeArray4[count4] = beatTime;


                        count4++;

                    } else {
                        attempted = true;
                        start = false;
                        Timer1 = 0;
                        beatTime =  beatLength;
                        attemptPlayback = false;
                        playback = false;
                    }
                    EPressed=false;

                }



                if(RPressed){

                    if (beatTime >melodyTimeArray[count4] - delay && beatTime < melodyTimeArray[count4] + delay
                            && keyName == melodyKeysArray[count4]) {

                        matchedMelody[count4]++;
                        soundArray4[count4] = soundTwo;
                        timeArray4[count4] = beatTime;


                        count4++;

                    } else {
                        attempted = true;
                        start = false;
                        Timer1 = 0;
                        beatTime =  beatLength;

                        attemptPlayback = false;
                        playback = false;
                    }
                    RPressed=false;
                }


                if(beatTime<=10)
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
                    beatTime =  beatLength;
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
                    incorrectLabel = new Label("Notes Matched: " + correctMelody +
                            "\nTotal Notes: "+ countMelody, BaseGame.labelStyle);

                    incorrectLabel.setColor(Color.RED);
                    uiStage.addActor(incorrectLabel);
                    incorrectLabel.setPosition(500, 500);
                    incorrectLabel.addAction(Actions.delay(1));
                    incorrectLabel.addAction(Actions.after(Actions.fadeOut(1)));
                    //@K—simpler filling methodology—Nov 12, 2020 at 7.31PM
                    Arrays.fill(matchedChord, 0);

                    correctMelody = 0;
                    attempted = false;
                }
            }



            if (complete) {
                countKick = givenKicks;
                countSnare = givenSnares;
                countMelody = givenMelody;
                countChord = givenChord;
                countHat = 1;
                countBass = 1;


                attempted = false;
                complete = false;
                correctKick = 0;
                correctSnare = 0;
                correctHat = 0;
                correctBass = 0;
                correctMelody =0;
                correctChord = 0;
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
            hatAttempt=true;
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
