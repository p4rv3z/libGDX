package com.parvez.widthheight;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyScreenSize extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float width,height;
	float imgWidth,imgHeight;
	float x,y;
	OrthographicCamera camera;
	private static final String TAG = MyScreenSize.class.getName();
	
	@Override
	public void create () {
		//Tag initialization
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		camera = new OrthographicCamera();
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		Gdx.app.debug(TAG,"create method called.");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();// updating camera every render
		batch.setProjectionMatrix(camera.combined);// batch is combined with camera
		imgWidth = img.getWidth();// image width
		imgHeight = img.getHeight();// image height
		//width = Gdx.graphics.getWidth();//get screen width
		//height = Gdx.graphics.getHeight();//get screen height
		x=((width/2)-(imgWidth/2));//calculate the center of width and substraction with image width
		y=((height/2)-(imgHeight/2));//calculate the center of height and substraction with image height
		batch.begin();
		batch.draw(img, x, y);//draw(texture,x,y);
		batch.end();
		//Gdx.app.debug(TAG,"Screen Width: "+width+" Height: "+height+ " Image Width: " + imgWidth + " Height: " + imgHeight);
	}

	@Override
	public void dispose() {
		img.dispose();
		batch.dispose();
		super.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		this.width = width;
		this.height = height;
		camera.setToOrtho(false,width,height);//setToOrtho(inverse of camera,width,height);
	}
}
