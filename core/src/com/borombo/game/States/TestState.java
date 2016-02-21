package com.borombo.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.borombo.game.MyGdxGame;
import com.borombo.game.Sprites.Boy;

/**
 * Created by Erwan on 21/02/2016.
 */
public class TestState extends State {

    private Texture background;
    private Boy boy;

    public TestState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background.png");
        boy = new Boy(50,120);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            System.out.println(Gdx.input.getX());
            boy.move(Gdx.input.getX(), Gdx.input.getY());
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        boy.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, MyGdxGame.WHIDTH, MyGdxGame.HEIGHT);
        sb.draw(boy.getTexture(),boy.getPosition().x,boy.getPosition().y);
        sb.end();
    }
}
