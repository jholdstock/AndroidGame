package com.jh.multiplayergame;

import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.BaseGameActivity;

public class Textures
{
	public static ITextureRegion playAreaTexture;
	public static ITextureRegion longPlayAreaTexture;
	public static ITextureRegion questionAreaTexture;
	public static ITextureRegion backgroundTexture;
	public static ITextureRegion startTexture;
	public static ITextureRegion faceTexture;
	public static ITextureRegion sadFaceTexture;
	
	public static ITextureRegion circleTexture;
	public static ITextureRegion rectangleTexture;
	
	private static BaseGameActivity activity;
	private static TextureManager textureManager;
	
	public static void LoadTextures(BaseGameActivity activity2)
	{
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		
		activity = activity2;
		textureManager = activity.getTextureManager();
		
		playAreaTexture = loadTexture(507, 507, "play-area.png");
		longPlayAreaTexture = loadTexture(507, 1143, "long-play-area.png");
		questionAreaTexture = loadTexture(1180, 1404, "question-area.png");
		backgroundTexture = loadTexture(2560, 1504, "bg.png");
		startTexture = loadTexture(512, 128, "startbutton.png");
		faceTexture = loadTexture(200, 200, "face.png");
		sadFaceTexture = loadTexture(200, 200, "sadface.png");
		
		circleTexture = loadTexture(200, 200, "shapes/circle.png");
		rectangleTexture = loadTexture(350, 150, "shapes/rectangle.png");
	}
	
	private static ITextureRegion loadTexture(int x, int y, String path)
	{
		BitmapTextureAtlas textureAtlas = new BitmapTextureAtlas(textureManager, x, y); // powers of 2!
		ITextureRegion i = BitmapTextureAtlasTextureRegionFactory.createFromAsset(textureAtlas, activity, path, 0, 0);
		textureAtlas.load();
		return i;
	}
}
