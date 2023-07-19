package com.politecnicomalaga.spaceinvaders;



public class NaveEspacial extends ObjetoVolador {

    
    // Constructor de la clase NaveEspacial
    public NaveEspacial(float posx, float posy, String imgStr, float velX, float velY, float w, float h) {
        super(posx, posy, velX, velY, imgStr, w, h);
    }

    @Override
    public void moverse(){
        posX+=velX;

    }

    public Disparo disparar(float velDisparoY) {
        return new Disparo(posX , posY, "laserBullet.png", 0, velDisparoY, 3, 5);
    }
}
