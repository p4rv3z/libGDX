package com.parvez.tag;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyTag extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	boolean key = true;
	private static final String TAG = MyTag.class.getName();
	@Override
	public void create () {
		//Tag initialization
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		//Gdx.app.setLogLevel(Application.LOG_ERROR);
		//Gdx.app.setLogLevel(Application.LOG_INFO);
		//Gdx.app.setLogLevel(Application.LOG_NONE);

		//Debug Tag
		Gdx.app.debug(TAG, "create method called");
		//Gdx.app.error(TAG,"create method called");
		//Gdx.app.log(TAG,"create method called");
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		if (key){
			key=false;
			Gdx.app.debug(TAG,"render method called and its running....");
		}
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void pause() {
		Gdx.app.debug(TAG,"pause method called");
		super.pause();
	}

	@Override
	public void resume() {
		Gdx.app.debug(TAG,"resume method called");
		if (!key){
			key=true;
		}
		super.resume();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.debug(TAG,"resize method called. width: "+width+" height: "+height);
		super.resize(width, height);
	}

	@Override
	public void dispose() {
		Gdx.app.debug(TAG,"dispose method called");
		batch.dispose();
		img.dispose();
		super.dispose();
	}
}
