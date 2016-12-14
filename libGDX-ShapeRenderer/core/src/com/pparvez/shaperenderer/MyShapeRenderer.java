package com.pparvez.shaperenderer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class MyShapeRenderer extends ApplicationAdapter {

	private ShapeRenderer shapeRenderer;
	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void render () {
		// Set the background color to opaque black
		Gdx.gl.glClearColor(0, 0, 0, 1);
		// Actually tell OpenGL to clear the screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//Shape Type: Point
		shapePoint();
		//Shape Type: Line
		shapeLine();
		//Shape Type: Filled
		shapeFilled();
		// TODO Transformation Matrix

	}


	private void shapeFilled() {
		shapeRenderer.begin(ShapeType.Filled);
		//set Color of the Filled
		shapeRenderer.setColor(1, 1, 0, 1);
		//create a Rectangle with Shape Type: Filled
		shapeRenderer.rect(300, 200, 50, 50);//rect(x,y,width,height);
		//create a rectangle with corner mixed color
		shapeRenderer.rect(500,0,50,50, Color.BLUE,Color.CYAN,Color.RED,Color.ORANGE);
		//create a rectangle with scale and angle
		shapeRenderer.rect(500,100,100,50,100,100,1,0.5f,45);/*rect (float x, float y, float originX,
			 float originY, float width, float height, float scaleX, float scaleY,float degrees)*/

		//create rectangle Line
		shapeRenderer.rectLine(300, 400, 200,250,25);//rectLine (float x1, float y1, float x2, float y2, float width)
		//create circle with shape type: filled
		shapeRenderer.circle(450, 250, 50);// circle(x,y,radius);
		// And make sure we end the batch
		shapeRenderer.end();
	}

	private void shapeLine() {
		shapeRenderer.begin(ShapeType.Line);
		//setColor of the line
		shapeRenderer.setColor(1, 0, 1, 1);
		//set position of start and end
		shapeRenderer.line(200, 200, 500, 200);//line(x1,y1,x2,y2);
		//create a Rectangle with Shape Type: Line
		shapeRenderer.rect(200, 300, 100, 150);//rect(x,y,width,height);
		//create circle with shape type: Line
		shapeRenderer.circle(400, 200, 50);// circle(x,y,radius);
		//create circle with segment and shape type: Line
		shapeRenderer.circle(100, 200, 50,6);
		//polyline
		float []vertices ={300,300,500,300,400,400,300,300};
		shapeRenderer.setColor(1, 0, 0, 1);
		shapeRenderer.polyline(vertices);
		//create arc (angle)
		shapeRenderer.setColor(0, 0, 1, 1);
		shapeRenderer.arc(10, 10, 100, 0, 90);//arc(x,y,radios,starting degree,degree);
		//todo try this arc
		// shapeRenderer.arc(10,10,100,0,90,2);//arc(x,y,radios,starting degree,degree,segment(just try ));

		//create box 2d view z=0
		shapeRenderer.box(200,50,0,50,50,100);//box (float x, float y, float z, float width, float height, float depth);

		//create a cone only 3d view you can see properly
		shapeRenderer.setColor(0.5f, 0, 1, 1);
		shapeRenderer.cone(400,100,0,30,5);//cone (float x, float y, float z, float radius, float height)
		//todo try this cone
		//shapeRenderer.cone(400,100,0,30,5,6);//cone (float x, float y, float z, float radius, float height,segment)

		//create a curve
		shapeRenderer.curve(10, 10, 50, 50, 90, 50, 150, 90, 10);//curve (float x1, float y1, float cx1, float cy1, float cx2, float cy2, float x2, float y2, int segments)

		//create a Ellipse
		shapeRenderer.ellipse(50,300,100,80);//ellipse (float x, float y, float width, float height)
		//todo try this ellipse
		//shapeRenderer.ellipse(50,300,100,80,6);//ellipse (float x, float y, float width, float height,segment)

		//create a triangle
		shapeRenderer.triangle(300,10,400,10,200,350);

		// And make sure we end the batch
		shapeRenderer.end();
	}

	private void shapePoint() {
		shapeRenderer.begin(ShapeType.Point);
		//Set Color of the point:: rgba();
		shapeRenderer.setColor(1, 1, 0, 1);//setColor(red,green,blue,alpha);
		// Then we draw a point
		shapeRenderer.point(100, 100, 0);//point(x,y,z);
		// And make sure we end the batch
		shapeRenderer.end();
	}

	@Override
	public void dispose() {
		shapeRenderer.dispose();
		super.dispose();
	}
}
