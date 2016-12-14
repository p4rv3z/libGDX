package com.parvez.rainbowflower;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


public class MyFlower extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;
    int steps =20;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render() {
        //clear screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float width = Gdx.graphics.getWidth();//get Screen Width
        float height = Gdx.graphics.getHeight();//get Screen Height

        float rX = 100;//rectangle width
        float rY = 100;//rectangle height

        float x = (width/2)-(rX/2);//middle of x position
        float y = (height/2)-(rY/2);//middle of y position

        Color color = new Color();//create a color object of badlogic
        //set shaperenderer type as filled
        shapeRenderer.begin(ShapeType.Filled);

        //set color of stick
        shapeRenderer.setColor(0, 1, 0, 1);
        //make a stick for flower
        shapeRenderer.rectLine((width / 2) - 5, y, (width / 2) - 5, 0, 10);
        //leaf of flower
        shapeRenderer.rect((width/2)-5,(height/4)-10,0,0,20,20,1,2,45);
        shapeRenderer.rect((width/2)-5,(height/4)-10,0,0,20,20,2,1,45);

        //make a rainbow flower using for loop
        for (int i =0;i<steps;i++){
            //create a single color every loop
            Color.argb8888ToColor(color, java.awt.Color.HSBtoRGB(1.0f * i / steps, 1, 1));

            /*rect (float x, float y, float originX, float originY, float width, float height, float scaleX, float scaleY,
		    float degrees, Color col1, Color col2, Color col3, Color col4)*/
            shapeRenderer.rect(x, y, 50, 50, 100, 100, 1, 1, i * 90 / steps, color, color, color,color);
        }
        shapeRenderer.end();//end the shape renderer  every render

    }
}
