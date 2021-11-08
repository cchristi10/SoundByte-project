package com.mygdx.game;

public class Level3 extends BaseScreen {
    public void initialize() {
        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("wallpapers/Level One—Reference.jpg");
        background.setSize(virWidth, virHeight);
    }

    public void update(float dt) {

    }
}
