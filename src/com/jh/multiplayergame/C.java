package com.jh.multiplayergame;

import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.color.Color;

public class C
{
	private static final int BLACK_BAR_HEIGHT = 96;
	
	public static final int SCREEN_WIDTH = 2560;
	public static final int SCREEN_HEIGHT = 1600 - BLACK_BAR_HEIGHT;
		
	public static VertexBufferObjectManager VMANAGER;
	
	public static Scene2 SCENE;
	
	public static MainActivity ACTIVITY;
	
	public static Color[] COLORS = { Color.RED, Color.BLUE, Color.GREEN, Color.WHITE, Color.YELLOW, Color.CYAN, Color.PINK };
}
