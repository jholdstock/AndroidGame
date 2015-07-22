package com.jh.multiplayergame.ui.playareas;

import org.andengine.input.touch.TouchEvent;

import com.jh.multiplayergame.Textures;
import com.jh.multiplayergame.games.BaseMultiplayerGame;
import com.jh.multiplayergame.games.GameResult;

public class WinnablePlayArea extends BasePlayArea
{
	public static boolean winnable;
		
	public WinnablePlayArea(int playerIndex, BaseMultiplayerGame game)
	{
		super(playerIndex, game, Textures.playAreaTexture);
		winnable = false;
	}

	@Override
	public void pressed(TouchEvent touchEvent)
	{
		if (winnable)
		{
			game.endAndDisplayResult(GameResult.winner(player.getIndex(), "You win!", "You lose!"));
		}
		else
		{
			game.endAndDisplayResult(GameResult.loser(player.getIndex(), "You win!", "You lose!"));
		}
	}

	@Override
	public void moving(TouchEvent touchEvent) {}
}
