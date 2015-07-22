package com.jh.multiplayergame.ui;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.games.GameResult;

public class WinnerLoserMessage
{
	private final float X = 575;
	private final float Y = C.SCREEN_HEIGHT / 2;
	private final float SCALE = 0.8f;
	
	public WinnerLoserMessage(GameResult result)
	{
		TextPair tp;
		if (result.getWinnerIndex() == 0)
		{
			tp = new TextPair(result.getWinnerMessage(), result.getLoserMessage(), X, Y);
		}
		else
		{
			tp = new TextPair(result.getLoserMessage(), result.getWinnerMessage(), X, Y);
		}
		
		tp.setScale(SCALE);
	}
}
