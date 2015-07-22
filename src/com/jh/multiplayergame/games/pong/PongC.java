package com.jh.multiplayergame.games.pong;

import com.jh.multiplayergame.C;

class PongC
{
	private static final float SCALE = 0.465f;
	public static final float BOTTOM_SPACE = 200 * SCALE;
	public static final float BALL_SIZE = 50 * SCALE;
	public static final float PADDLE_WIDTH = 50 * SCALE;
	public static final float PADDLE_HEIGHT = 250 * SCALE;
	public static final float BALL_SPEED = 25 * PongC.SCALE;
	
	public static final float GAME_WIDTH = C.SCREEN_WIDTH * SCALE;
	public static final float GAME_HEIGHT = C.SCREEN_HEIGHT * SCALE;
	public static final float GAME_X = (C.SCREEN_WIDTH/2) - (GAME_WIDTH/2);
	public static final float GAME_Y = (C.SCREEN_HEIGHT/2) - (GAME_HEIGHT /2);
}
