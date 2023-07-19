package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.math.Rectangle;

public class Disparo extends ObjetoVolador {
    private Rectangle rectColision;

    public Disparo(float posX, float posY, String imgStr, float velX, float velY, float w, float h) {
        super(posX, posY, velX, velY, imgStr, w, h);
        rectColision = new Rectangle(posX, posY, w, h);
    }

    @Override
    public void moverse() {
        posY += velY;
        rectColision.setPosition(posX, posY);
    }

    public Rectangle getRectColision() {
        return rectColision;
    }
}