package com.combat.app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.combat.tools.ScreenApplicationAdapter;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class App extends ScreenApplicationAdapter {
	private MainGame game;
    private SpriteBatch batch;
    private Texture backGround;
    
    public App(MainGame game) {
    	this.game = game;    		
    }
    
    @Override
    public void show() {
    	super.show();
    	this.batch = new SpriteBatch();
    	this.backGround = new Texture("libgdx.png");
    }
    
    @Override
    public void render(float delta) {
    	super.render(delta);
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
        batch.draw(backGround, 140, 210);
        batch.end();
        
    }

    @Override
    public void dispose() {
        batch.dispose();
        backGround.dispose();
    }
}
