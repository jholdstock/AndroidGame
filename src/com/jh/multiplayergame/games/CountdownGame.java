package com.jh.multiplayergame.games;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.util.color.Color;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.ui.GameText;
import com.jh.multiplayergame.ui.playareas.WinnablePlayArea;

public class CountdownGame extends BaseMultiplayerGame
{
	private GameText gameText;
	private float seconds = 10;
	
	public CountdownGame()
	{
		super();
		gameText = new GameText(); 
		gameText.setScale(3.0f);
		playAreas[0] = new WinnablePlayArea(0, this);
		playAreas[1] = new WinnablePlayArea(1, this);
	}
		
	@Override
	public String getDescription()
	{
		return "Tap after 0";
	}
	
	@Override
	public void endAndDisplayResult(GameResult result)
	{
		super.endAndDisplayResult(result);
		if (seconds <= 0)
		{
			gameText.setText(Float.toString(seconds).substring(0, 5));
			gameText.setColor(Color.GREEN);
		}
		else
		{
			gameText.setText("+" + Float.toString(seconds).substring(0, 4));
			gameText.setColor(Color.RED);
		}
	}
	
	@Override
	public void startGame()
	{
		super.startGame();
		
		C.SCENE.registerUpdateHandler(new IUpdateHandler()
		{
			public void onUpdate(float pSecondsElapsed)
			{
				seconds -= pSecondsElapsed;
				cycle();
			}
			public void reset() {}
		});
		
	}
	
	public void cycle()
	{
		if (seconds >= 4)
		{
			gameText.setText(Float.toString(seconds).substring(0, 4));
		}
		else
		{
			gameText.setText("");
		}
		
		if(seconds <= 0)
		{
			WinnablePlayArea.winnable = true;
		}
	}
}
