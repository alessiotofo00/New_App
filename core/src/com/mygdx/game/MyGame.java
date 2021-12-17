package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame extends Game {

	public static final int V_WIDTH = 960;
	public static final int V_HEIGHT = 540;
	//pixel per meter
	public static final float PPM = 100;

	//valori BIT per capire che tipo di collisione ho avuto
	public static final short GROUND_BIT =1;
	public static final short PLAYER_BIT=2;
	public static final short COIN_BIT=4;
	public static final short DESTROYED_BIT=8;
	public static final short OBJECT_BIT=16;
	public static final short ENEMY_BIT=32;
	public static final short BULLET_BIT =64;

	public SpriteBatch batch;

	public MenuScreen menuScreen;
	public PreferencesScreen preferencesScreen;
	public PlayScreen playScreen;
	public PauseScreen pauseScreen;
	public GameOverScreen goScreen;
	public ShopScreen shopScreen;


	//variabili per lo switch case dei vari screen
	public final static int MENU = 0;
	public final static int PREFERENCES = 1;
	public final static int APPLICATION = 2;
	public final static int PAUSE = 3;
	public final static int GAMEOVER = 4;
	public final static int SHOP = 5;
	//salvo lo schermo precedente a quello attuale e lo schermo attuale
	//(serve al PreferencesScreen per distinguere se è stato chiamato dal MenuScreen o dal PauseScreen)
	public static int previousScreen;
	public static int currentScreen;
	//manager per i suoni e la musica
	public static AssetManager manager;


	@Override
	public void create () {
		batch = new SpriteBatch();

		manager = new AssetManager();

		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
	}

	@Override
	public void render () {
		super.render();
	}

	//metodo per switchare gli schermi
	public void changeScreen(int screen){
		switch(screen){
			case MENU:
				currentScreen = MENU;
				if(menuScreen == null) menuScreen = new MenuScreen(this);
				this.setScreen(menuScreen);
				break;
			case PREFERENCES:
				currentScreen = PREFERENCES;
				if(preferencesScreen == null) preferencesScreen = new PreferencesScreen(this);
				this.setScreen(preferencesScreen);
				break;
			case APPLICATION:
				currentScreen = APPLICATION;
				if(playScreen == null) playScreen = new PlayScreen(this);
				this.setScreen(playScreen);
				break;
			case PAUSE:
				currentScreen = PAUSE;
				if(pauseScreen == null) pauseScreen = new PauseScreen(this);
				this.setScreen(pauseScreen);
				break;
			case GAMEOVER:
				currentScreen = GAMEOVER;
				if(goScreen == null) goScreen = new GameOverScreen(this);
				this.setScreen(goScreen);
				break;
			case SHOP:
				currentScreen = SHOP;
				if(shopScreen == null) shopScreen = new ShopScreen(this);
				this.setScreen(shopScreen);
				break;
		}
	}

}
