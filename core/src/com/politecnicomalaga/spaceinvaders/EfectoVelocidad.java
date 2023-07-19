package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;

public class EfectoVelocidad {

    private ArrayList<Vector2> puntos;
    private float velocidadDescenso;
    private final float LIMITE_INFERIOR = -40f;
    private final float LIMITE_SUPERIOR = Gdx.graphics.getHeight() + 50f;
    private final float ANCHO_PUNTO = 0.9f;
    private int altoPunto = 4;
    private Texture texturaPunto;
    private float tiempo;
    private float incremento;
    private float tiempoTotal;
    private float aceleracion;
    private float velocidadMaxima = 60f;

    public EfectoVelocidad() {
        puntos = new ArrayList<Vector2>();

        // Inicializa la lista de puntos con valores aleatorios
        for (int i = 0; i < 10; i++) {
            float x = MathUtils.random(0, Gdx.graphics.getWidth());
            float y = MathUtils.random(0, Gdx.graphics.getHeight());
            Vector2 punto = new Vector2(x, y);
            puntos.add(punto);
        }

        texturaPunto = new Texture("dot.png");
        velocidadDescenso = 0.2f;
        tiempo = 0f;
        incremento = 0.1f;
        tiempoTotal = 15f; 
        aceleracion = 10f / tiempoTotal;
    }

    // Actualiza la posición de los puntos y la velocidad de descenso
    public void actualizar() {
        for (Vector2 punto : puntos) {
            punto.y -= velocidadDescenso;
    
            // Si el punto sale por la parte inferior de la pantalla, lo reposiciona aleatoriamente
            if (punto.y < LIMITE_INFERIOR) {
                punto.x = MathUtils.random(0, Gdx.graphics.getWidth());
                punto.y = MathUtils.random(LIMITE_SUPERIOR, LIMITE_SUPERIOR + 50f);
            }
        }
    
        // Aumenta la velocidad de descenso y el alto de los puntos de manera progresiva
        tiempo += Gdx.graphics.getDeltaTime();

        
        if (tiempo > incremento) { // Si el tiempo transcurrido es mayor que el incremento
            tiempo -= incremento; // Resta el tiempo transcurrido al tiempo
            velocidadDescenso += aceleracion * incremento; // Acelera la velocidad de descenso
            // Limita la velocidad máxima permitida
            if (velocidadDescenso > velocidadMaxima) { //Condicional para que el efecto de velocidad no se ejecute indefinidamente
                velocidadDescenso = velocidadMaxima;
            }
            altoPunto += (int) (velocidadDescenso / 25f); // Aumenta el alto de los puntos, casteando a int.
        }
    
        // Limita el alto de los puntos
        if (altoPunto >= 50) {
            altoPunto = 50;
        }
    }

    // Dibuja los puntos en pantalla
    public void dibujar(SpriteBatch batch) {
        for (Vector2 punto : puntos) {
            batch.draw(texturaPunto, punto.x, punto.y, ANCHO_PUNTO, altoPunto);
        }
    }

    // Libera los recursos utilizados por la textura del punto
    public void dispose() {
        texturaPunto.dispose();
    }
}