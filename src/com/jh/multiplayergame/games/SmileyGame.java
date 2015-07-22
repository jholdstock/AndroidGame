package com.jh.multiplayergame.games;

import java.util.Random;

import com.jh.multiplayergame.TimeCounter;
import com.jh.multiplayergame.ui.SmileyArea;
import com.jh.multiplayergame.ui.playareas.WinnablePlayArea;

public class SmileyGame extends BaseMultiplayerGame
{
	private SmileyArea smileyArea = new SmileyArea();
	private int counter;
	
	public SmileyGame()
	{
		super();
		playAreas[0] = new WinnablePlayArea(0, this);
		playAreas[1] = new WinnablePlayArea(1, this);
	}
	
	@Override
	public String getDescription()
	{
		return "Is there a sad face?";
	}
	
	@Override
	public void startGame()
	{
		super.startGame();
		counter = new Random().nextInt(4) + 3;
		cycle();
	}
	
	private void cycle()
	{
		new TimeCounter(1.6f)
		{
			@Override
			public void onFinish()
			{
				counter--;
				if (counter == 0)
				{
					smileyArea.addSadFace();
					WinnablePlayArea.winnable = true;
				}
				smileyArea.update();
				if (gameStopped)
				{
					return;
				}
				
				cycle();
			}
		};
	}
}
