package com.borombo.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
/**
 * Created by Erwan on 24/02/2016.
 */
public class AnimationLapin {

    private static final int nb_colonne = 4;
    private static final int nb_ligne = 8;
    private static final int nb_image_animation = 4;
    private static final float duree_animation = 1f;
    private float vitesse = 1f;

    private Animation animation[];
    private Texture sheetTexture;
    private TextureRegion regionCourante, regionInitial;

    private int largeurTexture;
    private int hauteurTexture;

    private float temps;

    private float x;
    private float y;

    private int typeAnimation;
    private boolean isAnimated;

    public AnimationLapin(float x, float y){
        this.x = x;
        this.y = y;
        sheetTexture = new Texture("rabbitmanSheet.PNG");
        largeurTexture = sheetTexture.getWidth();
        hauteurTexture = sheetTexture.getHeight();
        isAnimated = false;
        animation = new Animation[8];
        typeAnimation = 0;
        temps = 0.0f;

        TextureRegion[][] tmp = TextureRegion.split(sheetTexture,
                largeurTexture / nb_colonne, hauteurTexture / nb_ligne);
        regionInitial = tmp[0][1];

        for (int i = 0; i < 8; i++ ) {
            animation[i] = new Animation(duree_animation / nb_image_animation, tmp[i]);
        }

    }

    public void update(float dt){
        if (isAnimated){
            this.temps += dt;
            regionCourante = animation[typeAnimation].getKeyFrame(temps/1,true);
        }
    }

    public void stop(){
        regionCourante = regionInitial;
        isAnimated = false;
    }

    public void setAnimated(){
        isAnimated = true;
    }

    public TextureRegion getRegionCourante(){
        return regionCourante;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public void deplacement(int typeAnimation){
        switch (typeAnimation){
            case 4:
                y += vitesse;
                break;
            case 0:
                y -= vitesse;
                break;
            case 7:
                x += vitesse;
                break;
            case 3:
                x -= vitesse;
                break;
        }
        this.typeAnimation = typeAnimation;
    }

    public void dispose(){
        sheetTexture.dispose();
    }



}
