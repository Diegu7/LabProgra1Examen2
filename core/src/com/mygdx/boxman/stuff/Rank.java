package com.mygdx.boxman.stuff;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Rank {
	Random ran = new Random();
	public Rectangle bottom;
	Rectangle left;
	Rectangle right;
	Rectangle top;
	Sprite rank;
	Texture texture;
	int action;
	float velocity;
	
	public Rank(){
		bottom = new Rectangle(847, 463, 50, 20);
		texture = new Texture("silver1.png");
		rank = new Sprite(texture);
		rank.setSize(50, 20);
		
		this.setPosition(847, 463);
	}
	
	public void action(int type, float y){
		if(type == 1){
			this.randSpawn();
		}
	}
	
	public void randSpawn(){
		float corx = ran.nextInt(1081) + 100;
		float cory = ran.nextInt(621) + 50;
		int png = ran.nextInt(7);
		switch(png){
		case 0:
			texture = new Texture("silver1.png");
			break;
		case 1:
			texture = new Texture("silver2.png");
			break;
		case 2:
			texture = new Texture("silver3.png");
			break;
		case 3:
			texture = new Texture("silver4.png");
			break;
		case 4:
			texture = new Texture("silvere.png");
			break;
		case 5:
			texture = new Texture("silverem.png");
			break;
		default:
			texture = new Texture("silver1.png");
			break;
		}
		rank = new Sprite(texture);
		rank.setSize(50, 20);
		this.setPosition(corx, cory);
	}
	
	public void setPosition(float x, float y){
		bottom.x = x;
		bottom.y = y;
		rank.setPosition(x, y);
	}

	public void draw(SpriteBatch batch){
		rank.draw(batch);
	}
}
