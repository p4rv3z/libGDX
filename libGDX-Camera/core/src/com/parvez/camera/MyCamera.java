package com.parvez.camera;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class MyCamera extends ApplicationAdapter {
	OrthographicCamera camera;
	ShapeRenderer renderer;

	@Override
	public void create () {
		//create a OrthographicCamera
		camera = new OrthographicCamera();
		//create a ShapeRenderer Object
		renderer = new ShapeRenderer();
	}

	@Override
	public void dispose() {
		super.dispose();
		renderer.dispose();//dispose ShapeRenderer
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//update camera
		camera.update();
		//camera combined with screen
		renderer.setProjectionMatrix(camera.combined);
		//ShapeRenderer type filled
		renderer.begin(ShapeType.Filled);
		//select circle color as blue
		renderer.setColor(Color.BLUE);
		renderer.circle(100, 100, 50);//circle (float x, float y, float radius)
		//select circle color as green
		renderer.setColor(Color.GREEN);
		renderer.circle(200, 200, 50, 10);//circle (float x, float y, float radius, int segments)
		//select rectangle color as orange
		renderer.setColor(Color.ORANGE);
		renderer.rect(300,300,50,40);//rect (float x, float y, float width, float height)
		renderer.end();

	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		//if screen size change camera will update with new size
		camera.setToOrtho(false,width,height);
		//todo try this
		//detectObject(width, height);//detect a object
	}

	/*
	* view a object of full screen
	*/
	private void detectObject(int width, int height) {
		float aspectRatio  = 1.0f*width/height;//aspect ratio
		camera.viewportHeight = 2*50;//camera viewport height
		camera.viewportWidth = aspectRatio*camera.viewportHeight;//camera viewport weight
		//set camera position
		camera.position.set(200,200,0);
		//todo if you need camera rotate try this
		//camera.rotate(45);//camera roation
	}
}
