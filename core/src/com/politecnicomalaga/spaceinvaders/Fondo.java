package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Fondo {
    private float posY;
    private float velY;
    private float width;
    private float height;
    private Texture imgStr;
    private float posX;

    public Fondo(float posY, float velY, float width, float height, Texture imgStr, float posX) {
        this.posY = posY;
        this.velY = velY;
        this.width = width;
        this.height = height;
        this.imgStr = imgStr;
        this.posX = posX;
    }

    public void render(SpriteBatch sp) {
        sp.draw(imgStr,posX,posY,width,height);
    }

    public void dispose() {
        if (imgStr != null)
            imgStr.dispose();
    }

    public void moverse(){
        posY -= velY;
    }

    //Getters y Setters
    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }   

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }


    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }   
}
