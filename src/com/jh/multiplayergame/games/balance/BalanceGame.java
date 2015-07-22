package com.jh.multiplayergame.games.balance;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.input.touch.TouchEvent;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.games.BaseMultiplayerGame;
import com.jh.multiplayergame.games.GameResult;
import com.jh.multiplayergame.ui.playareas.SlidingPlayArea;

public class BalanceGame extends BaseMultiplayerGame
{
	private BalanceModel model;
	private BalanceView view;
	
	public BalanceGame()
	{
		model = new BalanceModel();
		view = new BalanceView(model);
		
		playAreas[0] = new SlidingPlayArea(0, this)
		{
			@Override
			public void moving(TouchEvent touchEvent)
			{
				model.moveBall(player.getIndex(), getHeightFraction(touchEvent));
			}
		};
		playAreas[1] = new SlidingPlayArea(1, this)
		{
			@Override
			public void moving(TouchEvent touchEvent)
			{
				model.moveBall(player.getIndex(), getHeightFraction(touchEvent));
			}
		};
	}
	
	@Override
	public String getDescription()
	{
		return "Stay between the lines";
	}
	
	@Override
	public void startGame()
	{
		super.startGame();
			
		C.SCENE.registerUpdateHandler(new IUpdateHandler()
		{
			@Override
			public void onUpdate(float pSecondsElapsed)
			{
				if (gameStopped) return;
				model.update(pSecondsElapsed);
				view.drawGame();
				int collidingIndex = model.getCollidingIndex();
				if (collidingIndex != -1)
				{
					endAndDisplayResult(GameResult.loser(collidingIndex, "You Win!", "You Lose!"));
				}
			}

			@Override
			public void reset() {}
		});
	}
}
	