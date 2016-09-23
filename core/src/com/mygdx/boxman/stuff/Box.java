package com.mygdx.boxman.stuff;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Box {
	Rectangle bottom, left, right, top;
	Sprite box;
	Texture texture;
	int action;
	public int score = 0;
	float velocity;
	
	public Box(){
		bottom = new Rectangle(100, 100, 30, 30);
		texture = new Texture("3.png");
		box = new Sprite(texture);
		box.setSize(30, 30);
		
		this.setPosition(100, 100);
		
	}
	
	public int hits(Rectangle r){
		if(bottom.overlaps(r)){
			return 1;
		}
		return -1;
	}
	
	public void action(int type,float x, float y){
		if(type == 1){
			setPosition(bottom.x, y);
		}
		if(type == 2){
			setPosition(x, bottom.y);
		}
	}
	
	public void setPosition(float x, float y){
		bottom.x = x;
		bottom.y = y;
		box.setPosition(x, y);
		
	}
	
	public void moveLeft(float delta){
		bottom.x -= (200*delta);
		this.setPosition(bottom.x, bottom.y);
	}
	
	public void moveRight(float delta){
		bottom.x += (200*delta);
		this.setPosition(bottom.x, bottom.y);
	}
	
	public void moveUp(float delta){
		bottom.y += (200*delta);
		this.setPosition(bottom.x, bottom.y);
	}
	
	public void moveDown(float delta){
		bottom.y -= (200*delta);
		this.setPosition(bottom.x, bottom.y);
	}
	
	public void draw(SpriteBatch batch){
		box.draw(batch);
	}
	
}
