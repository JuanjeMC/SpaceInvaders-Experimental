package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ObjetoVolador {

    //Atributos

    protected float posX, posY;
    protected Texture img;
    protected float velX, velY;
    protected float width,height;

    //Métodos
    //Constructor
    public ObjetoVolador(float pX, float pY, float vX, float vY, String imgStr, float w, float h) {
        img = new Texture(imgStr);
        this.init(pX,pY,vX,vY,w,h);
    }

    public ObjetoVolador(float pX, float pY, float vX, float vY, Texture img, float w, float h) {
        this.img = img;
        this.init(pX,pY,vX,vY,w,h);
    }

    private void init(float pX, float pY, float vX, float vY, float w, float h) {
        posX = pX;
        posY = pY;
        velX = vX;
        velY = vY;
        width = w;
        height = h;
    }

    //Resto de Métodos
    public void render(SpriteBatch sp) {

        sp.draw(img,posX,posY,width,height);
    }

    public void dispose() {
        if (img != null)
            img.dispose();
    }

    public void moverse() {
        posX += velX;
        posY += velY;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public void acelX(float acelX) {
        velX += acelX;
    }

    public void acelY(float acelY) {
        velY += acelY;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    
}
