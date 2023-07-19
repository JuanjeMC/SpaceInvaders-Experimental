package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

public class GDXSpaceInvaders extends ApplicationAdapter {

	//ESTADO
	private SpriteBatch batch;
	//private ObjetoVolador ovni;
	private NaveEspacial nave;
	//private ArrayList<ObjetoVolador> miListaDeElementosPantalla;
	private EfectoVelocidad efectoVelocidad;
	private Batallon batallon;
	private Fondo fondo1;
	private Meteorito meteoro;
	private Fondo nebula;
	

	//COMPORTAMIENTO

	//RESTO COMPORTAMIENTOS

	//¿CONSTRUCTOR? NO TENGO, pero me dicen que create hace las veces de contructor
	@Override
	public void create () {

		batch = new SpriteBatch();
		
		nave = new NaveEspacial(Gdx.graphics.getWidth()/2,100,"NaveAmiga.png",0,0,70,70);
		//miListaDeElementosPantalla = new ArrayList<ObjetoVolador>();
		efectoVelocidad = new EfectoVelocidad();
		fondo1 = new Fondo(0,0.05f,Gdx.graphics.getWidth(),(Gdx.graphics.getHeight()/3),new Texture("Tierra.png"),0);
		nebula = new Fondo(300, 0.01f,Gdx.graphics.getWidth(),1900,new Texture("nebulac.png"),0);
		meteoro = new Meteorito (MathUtils.random(0,Gdx.graphics.getWidth()-100),Gdx.graphics.getHeight()+100);
		
		//public Escuadron(byte numNaves, int anchoPantalla, int anchoDisponible, float posicionx, float posiciony,float velx,float vely, int w, int h, String imgStr) {
		batallon = new Batallon((byte) 2, (byte) 8, Gdx.graphics.getWidth(), Gdx.graphics.getWidth() - 60, 0, Gdx.graphics.getHeight() - 80, 0.2f, 0, 60, 60, "naveEnemiga.png");
		//Primero se divide el ancho de la pantalla entre el numero de naves +1
		//Este numero lo ponemos en segmento
		//float segmento = Gdx.graphics.getWidth()/6;
		//int posicion = 0;
		//Bucle Ahora se inicializa la primera nave en la posicion 0
		//Y repetimos: crear la nave, en la posicion += segmento tantas veces como naves.

		/*for (int i = 0; i < 5; i++) {
			posicion += segmento;
			 miListaDeElementosPantalla.add(new NaveEspacial(posicion-30,Gdx.graphics.getHeight()-100,"naveEnemiga.png",0,0,60,60));
			}*/
	}

	@Override
	public void render () {

		//Controlar lo que pasa
		
		//Si la naveEspacial se sale de la pantalla por la derecha, que se mueva hacia la izquierda
		if (nave.getPosX() > Gdx.graphics.getWidth() - nave.getWidth()) {
			nave.setVelX(-nave.getVelX());

		}
		//Si la naveEspacial se sale de la pantalla por la izquierda, que se mueva hacia la derecha
		if (nave.getPosX() < 0) {
			nave.setVelX(-nave.getVelX());
		}

		//Si miListaDeElementosPantalla se sale de la pantalla por la derecha, que se mueva hacia la izquierda
		/*for (ObjetoVolador ov : miListaDeElementosPantalla) {
			if (ov.getPosX() >= Gdx.graphics.getWidth() - ov.getWidth()) {
				ov.setVelX(-ov.getVelX());
			}
		//Si miListaDeElementosPantalla se sale de la pantalla por la izquierda, que se mueva hacia la derecha
			if (ov.getPosX() <= 0) {
				ov.setVelX(-ov.getVelX());
			}
		}*/




		nave.moverse();
		fondo1.moverse();
		nebula.moverse();
		
		batallon.moverse();
	
		meteoro.moverse();
		meteoro.rotar();
		
		//dibujar despues
		
		ScreenUtils.clear(0f, 0f, 0f, 1);
		batch.begin();
		nebula.render(batch);
		efectoVelocidad.dibujar(batch);
		
		fondo1.render(batch);
		
		efectoVelocidad.actualizar();
		meteoro.pintar(batch);
		nave.render(batch);
		
		batallon.pintar(batch);

		batch.end();
		

		/*for (ObjetoVolador ov : miListaDeElementosPantalla) {
			ov.moverse();
		}
	
		batch.begin();
		for (ObjetoVolador ov : miListaDeElementosPantalla) {
			ov.render(batch);
		}*/
		

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		nebula.dispose();
		nave.dispose();
		
		efectoVelocidad.dispose();
		batallon.dispose();

		meteoro.dispose();
		fondo1.dispose();
		/*for(ObjetoVolador ov:miListaDeElementosPantalla){
			ov.dispose();
		}*/


	}

}