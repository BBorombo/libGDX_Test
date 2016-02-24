package com.borombo.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.borombo.game.MyGdxGame;
import com.borombo.game.Sprites.AnimationLapin;
import com.borombo.game.Sprites.Boy;

import sun.awt.SunHints;

/**
 * Created by Erwan on 21/02/2016.
 */
public class TestState extends State {

    private Texture background;
    private Boy boy;
    private AnimationLapin lapin;

    public TestState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background.png");
        //boy = new Boy(50,120);
        lapin = new AnimationLapin(50,120);
    }

    @Override
    protected void handleInput() {
//        if (Gdx.input.justTouched()){
//            System.out.println(Gdx.input.getX());
//            boy.move(Gdx.input.getX(), Gdx.input.getY());
//        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            lapin.deplacement(4);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            lapin.deplacement(0);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            lapin.deplacement(7);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            lapin.deplacement(3);
        if (!Gdx.input.isKeyPressed(Input.Keys.ANY_KEY))
            lapin.stop();
        else
            lapin.setAnimated();
    }

    @Override
    public void update(float dt) {
        handleInput();
        lapin.update(dt);
        //boy.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, MyGdxGame.WHIDTH, MyGdxGame.HEIGHT);
        sb.draw(lapin.getRegionCourante(), lapin.getX(), lapin.getY());
        //sb.draw(boy.getTexture(),boy.getPosition().x,boy.getPosition().y);
        sb.end();
    }
}
