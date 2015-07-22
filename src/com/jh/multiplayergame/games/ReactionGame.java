package com.jh.multiplayergame.games;

import java.util.Random;

import org.andengine.util.color.Color;

import com.jh.multiplayergame.TimeCounter;
import com.jh.multiplayergame.ui.ColorArea;
import com.jh.multiplayergame.ui.playareas.WinnablePlayArea;

public class ReactionGame extends BaseMultiplayerGame
{
	private ColorArea colorArea = new ColorArea();
	
	public ReactionGame()
	{
		super();
		playAreas[0] = new WinnablePlayArea(0, this);
		playAreas[1] = new WinnablePlayArea(1, this);
	}
	
	@Override
	public String getDescription() 
	{
		return "Tap after green";
	}

	@Override
	public void startGame()
	{
		super.startGame();
		
		int x = new Random().nextInt(3) + 5;
		new TimeCounter(x)
		{
			@Override
			public void onFinish()
			{
				if (gameStopped)
				{
					return;
				}
				colorArea.setColor(Color.GREEN);
				WinnablePlayArea.winnable = true;
			}
		};
	}
}
