package com.jh.multiplayergame.games;

public class Player
{
	private int score = 0;
	private int index;

	public Player(int index)
	{
		this.index = index;
	} 
	
	public int getIndex()
	{
		return index;
	}
	
	public String getScore()
	{
		return Integer.toString(score);
	}
	
	public void addPoint()
	{
		score++;
	}

	public void removePoint()
	{
		score--;
	}
}
