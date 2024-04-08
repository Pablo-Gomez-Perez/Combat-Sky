package com.combat.app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.combat.entity.PlayerPlane;
import com.combat.tools.ScreenApplicationAdapter;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class App extends ScreenApplicationAdapter {
	private MainGame game;
    private SpriteBatch batch;
    private Texture backGround;
    private PlayerPlane playerPlane;
    private float y1, y2; //the y axis positions fo the background images
    private final float generalMovemetSpeed = 80; //backgound velocity
    
    
    public App(MainGame game) {
    	this.game = game;
    }
    
    @Override
    public void show() {
    	super.show();
    	this.batch = new SpriteBatch();
    	this.backGround = new Texture("game_screen_back.png");
    	this.y1 = 0;
    	this.y2 = this.backGround.getHeight();
    }        
    
    @Override
    public void render(float delta) {
    	super.render(delta);
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        this.backGroundMovement();
        
        batch.begin();
        batch.draw(backGround, 0, y1);
        batch.draw(backGround, 0, y2);
        batch.end();
        
    }

    @Override
    public void dispose() {
        batch.dispose();
        backGround.dispose();
    }
    
    
    private void backGroundMovement() {
    	this.y1 -= this.generalMovemetSpeed * Gdx.graphics.getDeltaTime();
        this.y2 -= this.generalMovemetSpeed * Gdx.graphics.getDeltaTime();
        
        if (y1 + backGround.getHeight() <= 0) y1 = y2 + backGround.getHeight();
        if (y2 + backGround.getHeight() <= 0) y2 = y1 + backGround.getHeight();
    }
    
    private void builPlayerPlane() {
    	var planeImage = new Texture("Colorable_blenheim_2.png");
    	var initialPosition = new Vector2(200,110);
    }
}
