package com.jh.multiplayergame.games;

import java.util.Random;

import com.jh.multiplayergame.TimeCounter;
import com.jh.multiplayergame.ui.GameText;
import com.jh.multiplayergame.ui.playareas.WinnablePlayArea;

public class NumbersGame extends BaseMultiplayerGame
{
	private GameText gameText;
	private String[] strings = { "1", "2", "3", "4", "5" };
	private final static float WIN_INDEX = 4;
	
	public NumbersGame()
	{
		super();
		gameText = new GameText(); 
		playAreas[0] = new WinnablePlayArea(0, this);
		playAreas[1] = new WinnablePlayArea(1, this);
	}
		
	@Override
	public String getDescription()
	{
		return "Tap on 5";
	}
	
	@Override
	public void startGame()
	{
		super.startGame();
		cycle();
	}
	
	public void cycle()
	{
		int i = new Random().nextInt(strings.length);
		
		WinnablePlayArea.winnable = i == WIN_INDEX;
		
		gameText.setText(strings[i]);
		
		new TimeCounter(0.9f)
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
