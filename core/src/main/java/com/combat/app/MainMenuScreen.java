package com.combat.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.combat.tools.ScreenApplicationAdapter;

public class MainMenuScreen extends ScreenApplicationAdapter {
	
	private MainGame game;
	private SpriteBatch batch;
	//private BitmapFont font;
	private static Gdx gTool;
	private Texture backGroud;
	private Stage stage;
	private Skin skin;	
	private TextButton playButton;
	private TextButton exitButton;
	
	public MainMenuScreen(MainGame game) {	
		this.game = game;
	}
	
	private void drawPlayButton() {
		this.playButton = new TextButton("Play", skin);
		playButton.setPosition(Gdx.graphics.getWidth() / 2f - playButton.getWidth() / 2, Gdx.graphics.getHeight() / 2f);
		playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new App(game));
                //dispose();
            }
        });
	}
	
	private void drawExitButton() {
		
		this.exitButton = new TextButton("Exit", skin);		
        exitButton.setPosition(Gdx.graphics.getWidth() / 2f - exitButton.getWidth() / 2, Gdx.graphics.getHeight() / 2f - 50);					
		exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
	}
	
	@Override
	public void show() {
		super.show();
		batch = new SpriteBatch();
		//font = new BitmapFont();
		this.backGroud = new Texture("main_menu_image.png");
		stage = new Stage(new ScreenViewport());
		gTool.input.setInputProcessor(stage);
		skin = new Skin(gTool.files.internal("uiskin.json"));
		this.drawPlayButton();		
		this.drawExitButton();
		stage.addActor(playButton);
		stage.addActor(exitButton);
	}
	
	@Override
	public void render(float delta) {
		gTool.gl.glClearColor(0, 0, 0, 0);
		gTool.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		this.batch.draw(backGroud, 0, 0);		
		
		batch.end();
		
		stage.act(Math.min(gTool.graphics.getDeltaTime(), 1/30f));
		stage.draw();
	}

	@Override
	public void dispose() {
		super.dispose();
		this.backGroud.dispose();
		this.skin.dispose();
		this.stage.dispose();
		this.batch.dispose();
	}
}
