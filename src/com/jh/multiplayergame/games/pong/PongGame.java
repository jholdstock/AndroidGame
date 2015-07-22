package com.jh.multiplayergame.games.pong;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.input.touch.TouchEvent;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.games.BaseMultiplayerGame;
import com.jh.multiplayergame.ui.playareas.SlidingPlayArea;

public class PongGame extends BaseMultiplayerGame
{
	private PongModel model;
	private PongView view;
	
	public PongGame()
	{
		model = new PongModel(this);
		view = new PongView(model);
		
		playAreas[0] = new SlidingPlayArea(0, this)
		{
			@Override
			public void moving(TouchEvent touchEvent)
			{
				model.movePaddle(player.getIndex(), getHeightFraction(touchEvent));
			}
		};
		playAreas[1] = new SlidingPlayArea(1, this)
		{
			@Override
			public void moving(TouchEvent touchEvent)
			{
				model.movePaddle(player.getIndex(), getHeightFraction(touchEvent));
			}
		};
	}
	
	@Override
	public String getDescription()
	{
		return "Win at Pong";
	}
	
	@Override
	public void startGame()
	{
		super.startGame();
		model.start();
			
		C.SCENE.registerUpdateHandler(new IUpdateHandler()
		{
			@Override
			public void onUpdate(float pSecondsElapsed)
			{
				if (gameStopped) return;
				model.update(pSecondsElapsed);
				view.drawBallAndPaddles();
			}

			@Override
			public void reset() {}
		});
	}
}
	