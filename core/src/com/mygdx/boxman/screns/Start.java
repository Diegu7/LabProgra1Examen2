package com.mygdx.boxman.screns;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.boxman.tween.SpriteAccessor;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

public class Start implements Screen {
	
	private SpriteBatch batch;
	private Sprite start, logosp;
	private TweenManager tweenManager;
	private Music intro;
	
	@Override
	public void show() {
		
		intro = Gdx.audio.newMusic(Gdx.files.internal("hltrim.mp3"));
		intro.play();
		
		batch = new SpriteBatch();
		
		
		Texture startTexture = new Texture("1.jpg");
		
		
		Texture startLogo = new Texture("2.png");
		logosp = new Sprite(startLogo);
		logosp.setSize(380, 185);
		logosp.setPosition(450, 267.5f);
		
		tweenManager = new TweenManager();
		
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		
		start = new Sprite(startTexture);
		start.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		Tween.set(start, SpriteAccessor.ALPHA).target(0).start(tweenManager);
		Tween.to(start, SpriteAccessor.ALPHA, 3f).target(1).repeatYoyo(1, 3f).setCallback(new TweenCallback() {

			@Override
			public void onEvent(int type, BaseTween<?> source) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainGame());
			}
		}).start(tweenManager);

		tweenManager.update(Float.MIN_VALUE);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		
		
		
		batch.begin();
		start.draw(batch);
		logosp.draw(batch);
		batch.end();
		
		
		tweenManager.update(delta);
		
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
	}

}
