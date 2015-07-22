package com.jh.multiplayergame.games;

import org.andengine.input.touch.TouchEvent;

import com.jh.multiplayergame.ui.GameText;
import com.jh.multiplayergame.ui.playareas.TappingPlayArea;

public class TappingGame extends BaseMultiplayerGame
{
	private GameText gameText;
	
	public TappingGame()
	{
		super();
		gameText = new GameText();
		gameText.setText("Score: 0");
				
		playAreas[0] = new TappingPlayArea(0, this)
		{
			private int score = 0;
			
			@Override
			public void pressed(TouchEvent touchEvent)
			{
				score++;
				gameText.setOneText(player.getIndex(), "Score: " + score);
				if (score == 30)
				{
					game.endAndDisplayResult(GameResult.winner(player.getIndex(), "You win!", "You lose!"));
				}				
			}
			
		};
		playAreas[1] = new TappingPlayArea(1, this)
		{
			private int score = 0;
			
			@Override
			public void pressed(TouchEvent touchEvent)
			{
				score++;
				gameText.setOneText(player.getIndex(), "Score: " + score);
				if (score == 30)
				{
					game.endAndDisplayResult(GameResult.winner(player.getIndex(), "You win!", "You lose!"));
				}
			}
		};
	}
	
	@Override
	public String getDescription()
	{
		return "Tap as fast as possible";
	}
}
