package com.jh.multiplayergame.ui;

import java.util.Random;

import org.andengine.entity.sprite.Sprite;
import org.andengine.util.color.Color;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.Textures;

public class Shapes
{
	private Color[] colors = { Color.RED, Color.BLUE, Color.GREEN, Color.WHITE, Color.YELLOW, Color.CYAN, Color.PINK };
	private Sprite rectangle;
	private Sprite circle;
	private int circleSpeed;
	private int squareSpeed;
	
	private final static float X = (C.SCREEN_WIDTH / 2) - 150;
	
	public Shapes()
	{
		createShapes();
	}
	
	private void createShapes()
	{
		circle = new Sprite(X, 50, Textures.circleTexture, C.VMANAGER);
		circle.setScale(1.5f);
		circle.setRotation(new Random().nextInt(360));
		circle.setColor(colors[new Random().nextInt(colors.length)]);
		C.SCENE.attachChild(circle);

		rectangle = new Sprite(X, 1100, Textures.rectangleTexture, C.VMANAGER);
		rectangle.setScale(3.0f);
		rectangle.setRotation(new Random().nextInt(360));
		rectangle.setColor(colors[new Random().nextInt(colors.length)]);
		C.SCENE.attachChild(rectangle);	
		
		squareSpeed = 7 + new Random().nextInt(5);
		circleSpeed = 7 + new Random().nextInt(5);
	}
	
	public boolean areColliding()
	{
		circle.setPosition(circle.getX(), circle.getY() + squareSpeed);
		rectangle.setPosition(rectangle.getX(), rectangle.getY() - circleSpeed);
		
		if (circle.getY() + circle.getHeight() > C.SCREEN_HEIGHT || rectangle.getY() < 0)
		{
			C.SCENE.detachChild(circle);
			C.SCENE.detachChild(rectangle);
			createShapes();
		}
		
		if(rectangle.collidesWith(circle)) {
		//if(PixelPerfectCollisionChecker.checkCollision(circle, null, square, null)) {
			//square.setColor(1, 0, 0);
			//circle.setColor(1, 0, 0);
		} else {
			//square.setColor(0, 1, 0);
			//circle.setColor(0, 1, 0);
		}
		
		return rectangle.collidesWith(circle);
	}
}

