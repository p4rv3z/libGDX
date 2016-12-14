package bd.parvez.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by ParveZ on 07-Jun-16.
 */
public class Controller extends InputAdapter {
    Texture img;
    SpriteBatch batch;
    float x;
    float y;
    public Controller(Texture img, SpriteBatch batch) {
        this.img = img;
        this.batch = batch;
        x = Gdx.graphics.getWidth() / 2 - img.getWidth() / 2;
        y = 0;
    }

    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return super.keyUp(keycode);
    }

    @Override
    public boolean keyTyped(char character) {
        return super.keyTyped(character);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        x=screenX;
        y=screenY;
        return super.touchDown(screenX, screenY, pointer, button);
    }

    public void move() {
        batch.begin();
        batch.draw(img, x- img.getWidth() / 2, Gdx.graphics.getHeight()- y- img.getWidth() / 2);
        batch.end();
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        x=screenX;
        y=screenY;
        return super.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        x=screenX;
        y=screenY;
        return super.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        x=screenX;
        y=screenY;
        return super.mouseMoved(screenX, screenY);
    }

    @Override
    public boolean scrolled(int amount) {
        return super.scrolled(amount);
    }
}
