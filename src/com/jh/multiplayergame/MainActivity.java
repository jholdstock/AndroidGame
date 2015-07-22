package com.jh.multiplayergame;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import android.os.Vibrator;

import com.jh.multiplayergame.games.BaseMultiplayerGame;
import com.jh.multiplayergame.games.CollisionGame;
import com.jh.multiplayergame.games.ColorGame;
import com.jh.multiplayergame.games.CountdownGame;
import com.jh.multiplayergame.games.NumbersGame;
import com.jh.multiplayergame.games.ReactionGame;
import com.jh.multiplayergame.games.SmileyGame;
import com.jh.multiplayergame.games.TappingGame;
import com.jh.multiplayergame.games.balance.BalanceGame;
import com.jh.multiplayergame.games.pong.PongGame;
import com.jh.multiplayergame.games.quiz.QCountriesGame;
import com.jh.multiplayergame.games.quiz.QNumbersGame;
import com.jh.multiplayergame.ui.Countdown;
import com.jh.multiplayergame.ui.StartButton;

public class MainActivity extends BaseGameActivity
{
	private Class<?>[] games = 
	{
		CountdownGame.class
		,QNumbersGame.class
		,QCountriesGame.class
		,BalanceGame.class
		,PongGame.class
		,NumbersGame.class
		,ReactionGame.class
		,CollisionGame.class
		,TappingGame.class
		,SmileyGame.class
		,ColorGame.class
	};
	
	private int nextGame = 0;
			
	@Override
	public EngineOptions onCreateEngineOptions()
	{
		Camera camera = new Camera(0, 0, C.SCREEN_WIDTH, C.SCREEN_HEIGHT);

		EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(C.SCREEN_WIDTH, C.SCREEN_HEIGHT), camera);
		engineOptions.getTouchOptions().setNeedsMultiTouch(true);
		return engineOptions;
	}

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception
	{
		Textures.LoadTextures(this);
		Fonts.LoadFonts(this);
				
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception
	{
		C.ACTIVITY = this;
		C.VMANAGER = getVertexBufferObjectManager();
		C.SCENE = new Scene2();
		
		pOnCreateSceneCallback.onCreateSceneFinished(C.SCENE);
	}

	@Override
	public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception
	{
		new StartButton()
		{
			public void pressed()
			{
				C.SCENE.detachChild(this);
				startNextGame();
			}
		};
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}
	
	public void startNextGame()
	{
		C.SCENE.reset();
	
		final BaseMultiplayerGame game;
		try
		{
			game = (BaseMultiplayerGame) games[nextGame].getConstructor().newInstance();
		}
		catch (Exception e)
		{
			return;
		}
				
		nextGame++;
		nextGame = nextGame % games.length;
					
		new Countdown()
		{
			public void countdownFinish()
			{
				game.startGame();
			}
		};
	}
	
	public void gameoverCallback()
	{
		Vibrator s = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
		s.vibrate(200);
		
		new TimeCounter(1.5f)
		{
			public void onFinish()
			{
				startNextGame();
			}
		};
	}
}