
package com.politecnicomalaga.spaceinvaders;

import java.util.Random;

public class NaveEnemiga extends NaveEspacial {
    private float tiempoTranscurrido;
    private float tiempoDisparo;
    private Random random;

    public NaveEnemiga(float posx, float posy, String imgStr, float velX, float velY, float ancho, float alto) {
        super(posx, posy, imgStr, velX, velY, ancho, alto);
        random = new Random();
        tiempoTranscurrido = 0;
        tiempoDisparo = random.nextFloat() * 6.0f; // Establece el intervalo de tiempo inicial en un valor aleatorio entre 0 y 5 segundos
    }

    public Disparo update(float delta) {
        Disparo nuevoDisparo = null;
        tiempoTranscurrido += delta;
        if (tiempoTranscurrido >= tiempoDisparo) {
            nuevoDisparo = disparar(-1.5f); // Velocidad de disparo enemiga
            tiempoTranscurrido = 0;
            tiempoDisparo = 6.0f + (random.nextFloat() * 2 - 1); // Actualiza el intervalo de tiempo
        }
        return nuevoDisparo;
    }

    @Override
    public Disparo disparar(float velDisparoY) {
        return new Disparo(posX + (this.getWidth() / 2) - 2.5f, posY, "laserBullet.png", 0, velDisparoY, 8, 12);
    }
}