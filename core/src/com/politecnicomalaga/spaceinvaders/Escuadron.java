package com.politecnicomalaga.spaceinvaders;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Escuadron {
    //Array de NaveEspacial
    private NaveEspacial[] escuadron;
    private byte numNaves;
    private int anchoPantalla;
    private int anchoDisponible;
    private float posicionx;
    private float posiciony;
    private float velx;
    private float vely;
    private Texture imgStr;
    private int w;
    private int h;
    private int espacioEntreNaves;
    

    public Escuadron(Byte numNaves, int anchoPantalla, int anchoDisponible, float posicionx, float posiciony,float velx,float vely, int w, int h, String imgStr) {
        this.numNaves = numNaves;
        this.anchoPantalla = anchoPantalla;
        this.anchoDisponible = anchoDisponible;
        this.posicionx = (this.anchoPantalla - this.anchoDisponible) / 2;
        this.posiciony = posiciony;
        this.velx = velx; 
        this.vely = vely;
        this.w = w;
        this.h = h;
        this.imgStr = new Texture(imgStr);
        escuadron = new NaveEspacial[this.numNaves];
        int posicion = 0;
        
        //Usar el segmento para calcular la posición de cada nave en el escuadrón
        espacioEntreNaves = this.anchoDisponible / (this.numNaves);  
        
        //public NaveEspacial(float posx, float posy, String imgStr, float velX, float velY, float w, float h) 
        
        for (int i = 0; i < this.numNaves; i++) {
            
            escuadron[i] = new NaveEspacial(this.posicionx + posicion, this.posiciony, imgStr, this.velx, this.vely, this.w, this.h); 
            posicion += espacioEntreNaves;
        }



    }
    
    //moverse en X, si choca cada nave con el borde derecho de la pantalla, cambian de dirección a izquierda, y si chocan con el borde izquierdo de la pantalla, cambian de dirección a la derecha  
    public void moverse() {
        for (int i = 0; i < numNaves; i++) {
            escuadron[i].moverse(); 
            if (escuadron[i].getPosX() <= 0 || escuadron[i].getPosX() >= anchoPantalla - w) { 
                for (int j = 0; j < numNaves; j++) {
                    escuadron[j].setVelX(-escuadron[j].getVelX());  //Mueve todas las naves hacia la izquierda/derecha
                    escuadron[j].setPosY(escuadron[j].getPosY() - 20); // Mueve todas las naves hacia abajo
                }
            }
        }
    }

        
    

    //Pintar el escuadrón
    public void pintar(SpriteBatch sp){
  
        for (int i = 0; i < numNaves; i++) {
            escuadron[i].render(sp);
        }
    }
    /*OtraForma
    public void pintar(SpriteBatch sp){
        for (NaveEspacial nave : escuadron) {
            nave.render(sp);
        }
    }
    */

    //Disposar el escuadrón
    public void dispose(){
        for (int i = 0; i < numNaves; i++) {
            escuadron[i].dispose();
        }
    }
    


}
