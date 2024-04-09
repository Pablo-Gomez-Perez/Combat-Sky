package com.combat.entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class PlayerPlane {
	private Vector2 position;
	private Sprite sprite;
	private float speed = 400;
	
	public static class Builder{
		private PlayerPlane plane;
		
		public Builder(Texture sprite) {
			this.plane = new PlayerPlane(new Sprite(sprite));
		}
		
		public Builder position(Vector2 position) {
			this.plane.sprite.setPosition(position.x,position.y);
			return this;
		}
		
		public Builder size(float width, float height) {
			this.plane.sprite.setSize(width, height);
			return this;
		}
		
		public PlayerPlane build() {
			return this.plane;
		}
	}
	
	public static Builder builder(Texture sprite) {
		return new Builder(sprite);
	}
	
	/**
	 * @param position
	 * @param sprite
	 */
	public PlayerPlane(Vector2 position, Sprite sprite) {
		super();
		this.position = position;
		this.sprite = sprite;
	}
	
	public PlayerPlane(Sprite sprite) {
		super();
		this.sprite = sprite;
		this.position = new Vector2(0,0);
	}
	
	/**
	 * @return the position
	 */
	public Vector2 getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	/**
	 * @return the sprite
	 */
	public Sprite getSprite() {
		return sprite;
	}
	/**
	 * @param sprite the sprite to set
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}
	
	public void render(SpriteBatch batch) {
		this.sprite.draw(batch);
	}
	
	public void setSize(float width, float height) {
		this.sprite.setSize(width, height);
	}
	
	public void dispose() {
		this.sprite.getTexture().dispose();
	}
	
	public void update(float delta) {
		float minX = 0; //coordenadas mínimas en el eje X y el eje Y
		float minY = 0; //garantiza que el avión no pueda salir de la pantalla hacia la izquierda o hacia abajo.
		float maxX = 480 - sprite.getWidth(); // ancho de la pantalla menos el ancho del avión
		float maxY = 700 - sprite.getHeight(); //altura de la pantalla menos la altura del avión

	

		if(Gdx.input.isKeyPressed(Input.Keys.UP) && position.y < maxY) {
			position.y +=  speed * delta;
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && position.y > minY) {
			position.y -=  speed * delta;
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && position.x > minX) {
			position.x -=  speed * delta;
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && position.x < maxX) {
			position.x +=  speed * delta;
		}
		
		// para que el avion no se salga del rango se utliza la libreria MathUtils
		position.x = MathUtils.clamp(position.x, minX, maxX);
		position.y = MathUtils.clamp(position.y, minY, maxY);
		
		sprite.setPosition(position.x, position.y);

	}
	
}
