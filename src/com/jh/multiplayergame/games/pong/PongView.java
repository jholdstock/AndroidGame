package com.jh.multiplayergame.games.pong;

import org.andengine.entity.primitive.Line;
import org.andengine.entity.primitive.Rectangle;

import com.badlogic.gdx.math.Vector2;
import com.jh.multiplayergame.C;

class PongView
{
	private Rectangle ballDrawing;
	private Rectangle[] paddleDrawings;
	
	private PongModel phys;
	
	public PongView(PongModel phys)
	{
		this.phys = phys;
		firstDraw();
	}
	
	public void firstDraw()
	{
		ballDrawing = new Rectangle(0, 0, PongC.BALL_SIZE, PongC.BALL_SIZE, C.VMANAGER);
		C.SCENE.attachChild(ballDrawing);
		
		paddleDrawings = new Rectangle[2];
		for(int j = 0; j < paddleDrawings.length; j++)
		{
			paddleDrawings[j] = new Rectangle(0, 0, PongC.PADDLE_WIDTH, PongC.PADDLE_HEIGHT, C.VMANAGER);
			C.SCENE.attachChild(paddleDrawings[j]);
		}
		drawLines();
		
		drawBallAndPaddles();
	}
	
	private void drawLines()
	{
		float top = PongC.GAME_Y + 1;
		float bottom = PongC.GAME_Y + PongC.GAME_HEIGHT;
		float left = PongC.GAME_X + 1;
		float right = PongC.GAME_X + PongC.GAME_WIDTH;
		float middle = PongC.GAME_X + (PongC.GAME_WIDTH /2);

		C.SCENE.attachChild(new Line(left,   top,    left,   bottom, C.VMANAGER)); // Left
		C.SCENE.attachChild(new Line(right,	 top,    right,	 bottom, C.VMANAGER)); // Right
		C.SCENE.attachChild(new Line(left,   top,    right,  top, C.VMANAGER)); // Top
		C.SCENE.attachChild(new Line(left,   bottom, right,  bottom, C.VMANAGER)); // Bottom
		C.SCENE.attachChild(new Line(middle, top,    middle, bottom, C.VMANAGER)); // Middle
	}
	
	public void drawBallAndPaddles()
	{
		drawBall();
		drawPaddles();
	}
	
	private void drawBall()
	{
		float ballX = phys.getBallPosition().x;
		float ballY = phys.getBallPosition().y;
		ballDrawing.setPosition(PongC.GAME_X + ballX * 32 - PongC.BALL_SIZE/2, PongC.GAME_Y + ballY * 32 - PongC.BALL_SIZE/2);
	}
	
	private void drawPaddles()
	{
		Vector2[] paddlePositions = phys.getPaddlePositions();
		for(int j = 0; j < paddlePositions.length; j++)
		{
			paddleDrawings[j].setPosition(PongC.GAME_X + (paddlePositions[j].x * 32 - (PongC.PADDLE_WIDTH/2)), PongC.GAME_Y + (paddlePositions[j].y * 32 - (PongC.PADDLE_HEIGHT/2)));
		}
	}
}
