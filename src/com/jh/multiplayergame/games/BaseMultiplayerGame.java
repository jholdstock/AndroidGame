package com.jh.multiplayergame.games;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.ui.ScoresAndDesc;
import com.jh.multiplayergame.ui.WinnerLoserMessage;
import com.jh.multiplayergame.ui.playareas.BasePlayArea;

public abstract class BaseMultiplayerGame
{
	public static Player[] players = { new Player(0), new Player(1) };
	
	protected BasePlayArea[] playAreas = new BasePlayArea[2];
	
	public abstract String getDescription();
	
	protected boolean gameStopped = false;
	
	public BaseMultiplayerGame()
	{
		new ScoresAndDesc(players, getDescription());
	}
	
	public void startGame()
	{
		playAreas[0].attachTouchAreas();
		playAreas[1].attachTouchAreas();
	}
	
	public void endAndDisplayResult(GameResult result)
	{
		C.SCENE.clearTouchAreas();
		C.SCENE.clearUpdateHandlers();
		gameStopped = true;
		
		highlightWinnerOrLoser(result);
		
		new WinnerLoserMessage(result);
		C.ACTIVITY.gameoverCallback();
	}
	
	private void highlightWinnerOrLoser(GameResult result)
	{
		if (playAreas[0] == null) return;
		if (result.wasGameLost())
		{
			highlightRed(result.getLoserIndex());
			BaseMultiplayerGame.players[result.getLoserIndex()].removePoint();
		}
		else
		{
			highlightGreen(result.getWinnerIndex());
			BaseMultiplayerGame.players[result.getWinnerIndex()].addPoint();
		}
	}
	
	private void highlightGreen(int winnerIndex)
	{
		playAreas[winnerIndex].setColor(0f, 0.5f, 0f);
	}
	
	private void highlightRed(int loserIndex)
	{
		playAreas[loserIndex].setColor(0.5f, 0f, 0f);
	}
}
