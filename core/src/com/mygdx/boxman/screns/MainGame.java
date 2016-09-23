package com.mygdx.boxman.screns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.boxman.stuff.Box;
import com.mygdx.boxman.stuff.Rank;

public class MainGame implements Screen {

	private SpriteBatch batch;
	private Box boxxy;
	private Rank silver;
	private Sprite background;
	private Texture bg;
	private Music csgo;
	private Sound blip;
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		csgo = Gdx.audio.newMusic(Gdx.files.internal("csgo.mp3"));
		csgo.setLooping(true);
		csgo.setVolume(0.3f);
		csgo.play();
		
		blip = Gdx.audio.newSound(Gdx.files.internal("Shine.mp3"));
		
		
		batch = new SpriteBatch();
		
		bg = new Texture("4.jpg");
		background = new Sprite(bg);
		background.setSize(1280, 720);
		
		boxxy = new Box();
		silver = new Rank();
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		BitmapFont font = new BitmapFont();
		font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		font.getData().setScale(3, 3);
		CharSequence score = "Score: " + boxxy.score;
		
		
		
		
		batch.begin();
		background.draw(batch);
		silver.draw(batch);
		boxxy.draw(batch);
		font.draw(batch, score, 100f, 670f);
		batch.end();
		
		Rectangle floor = new Rectangle(0, 0, 1280, 5);
		Rectangle roof = new Rectangle(0, 715, 1280, 5);
		Rectangle rwall = new Rectangle(1275, 0, 5, 720);
		Rectangle lwall = new Rectangle(0, 0, 5, 720);
		
		if(boxxy.hits(floor) != -1){
			boxxy.action(1, 0, 5);
		}
		if(boxxy.hits(roof) != -1){
			boxxy.action(1, 0, 685);
		}
		if(boxxy.hits(rwall) != -1){
			boxxy.action(2, 1245, 0);
		}
		if(boxxy.hits(lwall) != -1){
			boxxy.action(2, 5, 0);
		}
		
		if(boxxy.hits(silver.bottom) != -1){
			blip.play(1f);
			silver.randSpawn();
			boxxy.score++;
		}
		
		
		
		//controls
		
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			boxxy.moveLeft(Gdx.graphics.getDeltaTime());
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			boxxy.moveRight(Gdx.graphics.getDeltaTime());
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			boxxy.moveUp(Gdx.graphics.getDeltaTime());
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			boxxy.moveDown(Gdx.graphics.getDeltaTime());
		}
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		batch.dispose();
		csgo.dispose();
		blip.dispose();
		
	}

}
