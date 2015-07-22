package com.jh.multiplayergame.games.balance;

import com.jh.multiplayergame.C;

class BalanceC
{
	private static final float SCALE = 0.9f;
	public static final float BOTTOM_SPACE = 200 * SCALE;
	public static final float BALL_SIZE = 50 * SCALE;
	public static final float DEATH_HEIGHT = 75 * SCALE;
	public static final float SAFE_ZONE_HEIGHT = 250 * SCALE;
	public static final float GAME_WIDTH = C.SCREEN_WIDTH / 2 * SCALE;
	public static final float GAME_HEIGHT = C.SCREEN_HEIGHT * SCALE;
	public static final float GAME_X = (C.SCREEN_WIDTH/2) - (GAME_WIDTH/2);
	public static final float GAME_Y = (C.SCREEN_HEIGHT/2) - (GAME_HEIGHT /2);
}
