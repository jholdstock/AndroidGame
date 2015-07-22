package com.jh.multiplayergame.games.quiz;

import com.jh.multiplayergame.TimeCounter;
import com.jh.multiplayergame.games.BaseMultiplayerGame;
import com.jh.multiplayergame.ui.GameText;
import com.jh.multiplayergame.ui.playareas.WinnablePlayArea;

public abstract class BaseQuizGame extends BaseMultiplayerGame
{
	protected GameText gameText;
	
	public BaseQuizGame()
	{
		super();
		gameText = new GameText(); 
		playAreas[0] = new WinnablePlayArea(0, this);
		playAreas[1] = new WinnablePlayArea(1, this);
	}
		
	@Override
	public void startGame()
	{
		super.startGame();
		cycle();
	}
	
	private void cycle()
	{
		QuestionAndAnswer qa = getQuestionAndAnswer();
		gameText.setText(qa.question);
		WinnablePlayArea.winnable = qa.answer;
		
		new TimeCounter(2.0f)
		{
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
	
	public abstract QuestionAndAnswer getQuestionAndAnswer();
}
