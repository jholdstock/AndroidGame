package com.jh.multiplayergame.games.balance;

import org.andengine.entity.primitive.Line;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.util.color.Color;

import com.badlogic.gdx.math.Vector2;
import com.jh.multiplayergame.C;

class BalanceView
{
	private Rectangle[] ballDrawings;
	private Rectangle[] deathDrawings;
	
	private BalanceModel model;
	
	public BalanceView(BalanceModel model)
	{
		this.model = model;
		firstDraw();
	}
	
	public void firstDraw()
	{
		ballDrawings = new Rectangle[2];
		for(int j = 0; j < ballDrawings.length; j++)
		{
			ballDrawings[j] = new Rectangle(0, 0, BalanceC.BALL_SIZE, BalanceC.BALL_SIZE, C.VMANAGER);
			C.SCENE.attachChild(ballDrawings[j]);
		}
		
		deathDrawings = new Rectangle[2];
		for(int j = 0; j < deathDrawings.length; j++)
		{
			deathDrawings[j] = new Rectangle(0, 0, BalanceC.GAME_WIDTH, BalanceC.DEATH_HEIGHT, C.VMANAGER);
			C.SCENE.attachChild(deathDrawings[j]);
		}
		drawLines();
		drawGame();
	}
	
	private void drawDeath()
	{
		float[] deathPos = model.getDeathHeights();
		for(int j = 0; j < deathPos.length; j++)
		{
			deathDrawings[j].setPosition(
					BalanceC.GAME_X,
					BalanceC.GAME_Y + (deathPos[j] * 32));// - (BalanceC.DEATH_HEIGHT/2)));
		}
	}

	private void drawBalls()
	{
		Vector2[] ballPos = model.getBallPositions();
		for(int j = 0; j < ballPos.length; j++)
		{
			ballDrawings[j].setPosition(
					BalanceC.GAME_X + (ballPos[j].x * 32 - (BalanceC.BALL_SIZE/2)), 
					BalanceC.GAME_Y + (ballPos[j].y * 32 - (BalanceC.BALL_SIZE/2)));
		}
	}

	public void drawGame()
	{
		drawBalls();
		drawDeath();
		if (model.getCollidingIndex() != -1)
		{
			ballDrawings[model.getCollidingIndex()].setColor(Color.RED);
		}
	}
	
	private void drawLines()
	{
		float top = BalanceC.GAME_Y + 1;
		float bottom = BalanceC.GAME_Y + BalanceC.GAME_HEIGHT;
		float left = BalanceC.GAME_X + 1;
		float right = BalanceC.GAME_X + BalanceC.GAME_WIDTH;

		C.SCENE.attachChild(new Line(left,   top,    left,   bottom, C.VMANAGER)); // Left
		C.SCENE.attachChild(new Line(right,	 top,    right,	 bottom, C.VMANAGER)); // Right
		C.SCENE.attachChild(new Line(left,   top,    right,  top, C.VMANAGER)); // Top
		C.SCENE.attachChild(new Line(left,   bottom, right,  bottom, C.VMANAGER)); // Bottom
	}
}
