package com.politecnicomalaga.spaceinvaders;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Meteorito {
    private float posX, posY;
    private Texture img;
    private float angle = 0; // ángulo de rotación inicial

    public Meteorito(float initX, float initY) {
        img = new Texture("Asteroid.png");
        posX = initX;
        posY = initY;
    }

    public void moverse(){ //movimiento del meteorito acelerado
        posY -= 2;
        if (posY<0-img.getHeight()){
            posY = Gdx.graphics.getHeight()+img.getHeight();
            posX = MathUtils.random(0,Gdx.graphics.getWidth()-img.getWidth());
        }
    }

    public void rotar() {
        // actualizar el ángulo de rotación cada vez que se llama a este método
        angle += 0.5; // 0.2 es el ángulo en radianes que quieres rotar cada 0.2 segundos
    }

    public Float getPosX() {
        return posX;
    }
    public Float getPosY() {
        return posY;
    }
    public float getHeight() {
        return img.getHeight();
    }
    public float getWidth() {
        return img.getWidth();
    }

    public void pintar(SpriteBatch lienzo) {
        // aplicar la rotación a la imagen del meteorito antes de dibujarla en pantalla
        lienzo.draw(img, posX, posY, img.getWidth() / 2, img.getHeight() / 2, img.getWidth(), img.getHeight(), 1, 1, angle, 0, 0, img.getWidth(), img.getHeight(), false, false);
    }

    public void dispose() {
        if (img != null){
            img.dispose();
        }
    }

    public Rectangle getBoundingBox() {
        return new Rectangle(posX, posY, img.getWidth(), img.getHeight());
    }

    
}