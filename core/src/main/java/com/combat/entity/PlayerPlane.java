package com.combat.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class PlayerPlane {
	private Vector2 position;
	private Sprite sprite;
	private final float speed = 200;
	
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
		
}
