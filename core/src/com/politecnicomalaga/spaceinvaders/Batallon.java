package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Batallon {
    private Escuadron[] escuadrones;
    private int numEscuadrones;

    public Batallon(int numEscuadrones, byte numNaves, int anchoPantalla, int anchoDisponible, float posicionx, float posiciony,float velx,float vely, int w, int h, String imgStr) {
        this.numEscuadrones = numEscuadrones;
        escuadrones = new Escuadron[numEscuadrones];
        for (int i = 0; i < numEscuadrones; i++) {
            escuadrones[i] = new Escuadron(numNaves, anchoPantalla, anchoDisponible, posicionx, posiciony + (i * (- 80)), velx, vely, w, h, imgStr);
        }
    }

    public void moverse() {
        for (int i = 0; i < numEscuadrones; i++) {
            escuadrones[i].moverse();
        }
    }

    public void pintar(SpriteBatch sp) {
        for (int i = 0; i < numEscuadrones; i++) {
            escuadrones[i].pintar(sp);
        }
    }

    public void dispose() {
        for (int i = 0; i < numEscuadrones; i++) {
            escuadrones[i].dispose();
        }
    }
}
