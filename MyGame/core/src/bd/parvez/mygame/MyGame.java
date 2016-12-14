package bd.parvez.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Controller controller;
    OrthographicCamera camera;
    Viewport viewport;
    int x = 0;
    int y = 0;
    float WORLD_WIDTH;
    float WORLD_HEIGHT;
    @Override
    public void create() {
        WORLD_WIDTH = Gdx.graphics.getWidth();
        WORLD_HEIGHT = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        controller = new Controller(img, batch);
        Gdx.input.setInputProcessor(controller);
        camera = new OrthographicCamera();
        x = Gdx.graphics.getWidth() / 2 - img.getWidth() / 2;
        y = 0;//Gdx.graphics.getHeight()/2-img.getHeight()/2;
        // Makes the size of the world match the size of the screen
       // viewport = new ScreenViewport(camera);

        // Make the world fill the screen, regardless of aspect ratio
       // viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        // Make the world fill the screen, maintaining aspect ratio, but bits of the world may be cut off
        viewport = new FillViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        // Fit the world inside the screen, adding black bars to pad out the extra space, maintaining aspect ratio
        //viewport = new FitViewport(16, 9, camera);

        // Make the short axis of the world larger to fill the screen, maintaining aspect ratio
        //viewport = new ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);


        viewport.setScreenBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        viewport.apply();
       // camera.update();
        batch.setProjectionMatrix(camera.combined);
        controller.move();
//        batch.begin();
//
//        if (Gdx.input.isTouched()) {
//            x = Gdx.input.getX() - img.getWidth() / 2;
//            y = Gdx.graphics.getHeight() - Gdx.input.getY() - img.getWidth() / 2;
//            batch.draw(img, x, y);
//        } else {
//            batch.draw(img, x, y);
//        }
//        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        WORLD_WIDTH=width;
        WORLD_HEIGHT=height;
       // float aspectRatio = 1.0f*width/height;
        viewport.update(width, height, true);
       // camera.setToOrtho(false,width,height);
        super.resize(width, height);
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }
}