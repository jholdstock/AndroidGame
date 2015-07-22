package com.jh.multiplayergame.games.balance;

import java.util.Random;

class DeathZones
{
	private float[] deathTops = new float[2];
	private boolean shrinking = true;
	private float[] deathDirections = new float[]{ 4f, -4f };
	private float deathHeight;
	private float safeHeight;
	
	public DeathZones(float deathHeight, float safeHeight)
	{
		this.deathHeight = deathHeight;
		this.safeHeight = safeHeight;
		
		deathTops[0] = (0) / 32;
		deathTops[1] = (BalanceC.GAME_HEIGHT - deathHeight/2) / 32;
	}
	
	public void updatePositions(float secondsElapsed)
	{
		if (shrinking)
		{
			float deathBottom = getDeathBottom(0);
			float deathTop = deathTops[1];
			if (deathTop - deathBottom <= safeHeight/32)
			{
				deathDirections[new Random().nextInt(2)] *= -1;
				shrinking = false;
			}
		}
		else if (deathTops[0] <= 0) 
			// Change direction down
		{
			deathDirections[0] = Math.abs(deathDirections[0]);
			deathDirections[1] = Math.abs(deathDirections[1]);
		}
		else if (getDeathBottom(1) >= BalanceC.GAME_HEIGHT/32) 
			// Change direction up
		{
			deathDirections[0] = -Math.abs(deathDirections[0]);
			deathDirections[1] = -Math.abs(deathDirections[1]);
		}
		else
			// Increase speed slightly
		{
			deathDirections[0] *= 1.002f;
			deathDirections[1] *= 1.002f;
		}
		deathTops[0] += deathDirections[0] * secondsElapsed;
		deathTops[1] += deathDirections[1] * secondsElapsed;
	}
	
	public float[] getHeights()
	{
		return deathTops;
	}
	
	public boolean isPlayerColliding(float playerY)
	{
		float ballTop = playerY - (BalanceC.BALL_SIZE/32/2);
		float deathBottom = getDeathBottom(0);
		float ballBottom = playerY + (BalanceC.BALL_SIZE/32/2);
		float deathTop = deathTops[1];
		if (ballTop < deathBottom || ballBottom > deathTop)
		{
			return true;
		}
		
		return false;
	}
	
	private float getDeathBottom(int index)
	{
		return deathTops[index] + (deathHeight/32);
	}
}
