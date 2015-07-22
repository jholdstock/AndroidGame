package com.jh.multiplayergame.games;

import java.util.Random;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.TimeCounter;
import com.jh.multiplayergame.ui.ColorArea;
import com.jh.multiplayergame.ui.playareas.WinnablePlayArea;

public class ColorGame extends BaseMultiplayerGame
{
	private ColorArea colorArea = new ColorArea();
	
	private static final float WIN_INDEX = 0;
	
	public ColorGame()
	{
		super();
		playAreas[0] = new WinnablePlayArea(0, this);
		playAreas[1] = new WinnablePlayArea(1, this);
	}
	
	@Override
	public String getDescription()
	{
		return "Tap when red";
	}
	
	@Override
	public void startGame()
	{
		super.startGame();
		cycle();
	}
	
	private void cycle()
	{
		int i = new Random().nextInt(C.COLORS.length);
		colorArea.setColor(C.COLORS[i]);
		WinnablePlayArea.winnable = i == WIN_INDEX;
		
		new TimeCounter(1)
		{
			@Override
			public void onFinish()
			{
				if (gameStopped)
				{
					return;
				}
				
				cycle();
			}
		};
	}
}
