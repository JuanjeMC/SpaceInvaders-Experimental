package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;

public class PlanetaInterestelar {
    private Sprite planeta;
    private float elapsedTime;
    private float duration;
    private float scaleFactorFinal;
    private float finalYPosition;

    public PlanetaInterestelar( float desiredInitialWidth, float desiredFinalWidth, float durationSeconds, float finalX) {

        Texture planetaTexture = new Texture("Planeta.png");
        planeta = new Sprite(planetaTexture);
        
        // Establecer el tamaño inicial y mantener la relación de aspecto
        float scaleFactorInitial = desiredInitialWidth / planeta.getWidth();
        float initialHeight = planeta.getHeight() * scaleFactorInitial;
        planeta.setSize(desiredInitialWidth, initialHeight);
        
        // Calcular el factor de escala final
        finalYPosition = finalX - planeta.getHeight() * (scaleFactorFinal / 2);
        scaleFactorFinal = desiredFinalWidth / planeta.getWidth();
        duration = durationSeconds; // Actualiza la duración en segundos del proceso
        planeta.setPosition(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() - planeta.getHeight());
        planeta.setAlpha(0);
        
        elapsedTime = 0;
        
    }

    public void render(SpriteBatch batch, float deltaTime) {
        update(deltaTime);
        
        // Dibujar el planeta
      
        planeta.draw(batch);
      
    }

    private void update(float deltaTime) {
        elapsedTime += deltaTime;

        if (elapsedTime < duration) {
            float progress = elapsedTime / duration;
        float scale = Interpolation.linear.apply(1, scaleFactorFinal, progress);
            float alpha = Interpolation.linear.apply(0, 1, progress); // Transparencia de 0 a 1
            float yPos = Interpolation.linear.apply(Gdx.graphics.getHeight() - planeta.getHeight(), finalYPosition, progress);            
            planeta.setScale(scale);
            planeta.setAlpha(alpha);
            planeta.setY(yPos);
        }
    }

    public void dispose() {
        planeta.getTexture().dispose();
    }
    

}

