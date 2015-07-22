package com.jh.multiplayergame.games;

public class GameResult
{
	private String winnerMessage;
	private String loserMessage;
	private int winnerIndex;
	private int loserIndex;
	
	private boolean wasGameLost;
	
	public static GameResult loser(int loserIndex, String winnerMessage, String loserMessage)
	{
		return new GameResult(opposite(loserIndex), loserIndex, winnerMessage, loserMessage, true);
	}
	
	public static GameResult winner(int winnerIndex, String winnerMessage, String loserMessage)
	{
		return new GameResult(winnerIndex, opposite(winnerIndex), winnerMessage, loserMessage, false);
	}
	
	private static int opposite(int i)
	{
		if (i == 1)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
	private GameResult(int winnerIndex, int loserIndex, String winnerMessage, String loserMessage, boolean wasGameLost)
	{
		this.winnerIndex = winnerIndex;
		this.loserIndex = loserIndex;
		this.winnerMessage = winnerMessage;
		this.loserMessage = loserMessage;
		this.wasGameLost = wasGameLost;
	}
	
	public String getWinnerMessage()
	{
		return winnerMessage;
	}

	public String getLoserMessage()
	{
		return loserMessage;
	}

	public int getWinnerIndex()
	{
		return winnerIndex;
	}

	public int getLoserIndex()
	{
		return loserIndex;
	}
	
	public boolean wasGameLost()
	{
		return wasGameLost;
	}
}
