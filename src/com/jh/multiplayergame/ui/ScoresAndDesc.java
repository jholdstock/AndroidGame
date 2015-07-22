package com.jh.multiplayergame.ui;

import org.andengine.util.color.Color;

import com.jh.multiplayergame.C;
import com.jh.multiplayergame.games.Player;

public class ScoresAndDesc
{
	private final float X = C.SCREEN_WIDTH / 4;
	private final float SCORE_Y = 200;
	private final float DESC_Y = C.SCREEN_HEIGHT / 2;
	private final float SCALE = 0.75f;
	private final Color COLOR = Color.YELLOW;
		
	public ScoresAndDesc(Player[] players, String desc)
	{
		String leftScore = "YOU: " + players[0].getScore() + " THEM: " + players[1].getScore();
		String rightScore = "YOU: " + players[1].getScore() + " THEM: " + players[0].getScore();
		
		TextPair tp = new TextPair(leftScore, rightScore, X, SCORE_Y);
		tp.setScale(SCALE);
		tp.setColor(COLOR);
		
		TextPair tp2 = new TextPair(desc, X, DESC_Y);
		tp2.setScale(SCALE);
		tp2.setColor(COLOR);
	}
}
