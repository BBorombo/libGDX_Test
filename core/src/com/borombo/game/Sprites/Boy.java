package com.borombo.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Erwan on 21/02/2016.
 */
public class Boy {

    private Vector3 position;
    private Texture texture;
    private Animation boyAniamtion;

    public Boy(int x, int y){
        position = new Vector3(x, y, 0);
        texture = new Texture("running.png");
        boyAniamtion = new Animation(new TextureRegion(texture), 3, 0.3f);
    }

    public void update(float dt){
        boyAniamtion.update(dt);
    }

    public void move(int x, int y){
        position.set(x, y, 0);
    }
    public Vector3 getPosition(){return position;}

    public TextureRegion getTexture(){return boyAniamtion.getFrame();}

    public void dispose(){texture.dispose();}
}
