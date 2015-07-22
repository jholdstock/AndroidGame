package com.jh.multiplayergame.games;

import com.jh.multiplayergame.TimeCounter;
import com.jh.multiplayergame.ui.Shapes;
import com.jh.multiplayergame.ui.playareas.WinnablePlayArea;

public class CollisionGame extends BaseMultiplayerGame
{
	private Shapes shapes;
	
	public CollisionGame()
	{
		super();
		playAreas[0] = new WinnablePlayArea(0, this);
		playAreas[1] = new WinnablePlayArea(1, this);
	}
	
	@Override
	public String getDescription()
	{
		return "Tap when shapes collide";
	}

	@Override
	public void startGame()
	{
		super.startGame();
		shapes = new Shapes();
		cycle();
	}
	
	private void cycle()
	{
		new TimeCounter(0.01f)
		{
			@Override
			public void onFinish()
			{
				WinnablePlayArea.winnable = shapes.areColliding();
				if (gameStopped)
				{
					return;
				}
				cycle();
			}
		};
	}
}
