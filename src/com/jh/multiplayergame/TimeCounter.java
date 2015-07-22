package com.jh.multiplayergame;

import org.andengine.engine.handler.IUpdateHandler;

public abstract class TimeCounter implements IUpdateHandler
{
	private float remaining;

	public TimeCounter(float remaining)
	{
		this.remaining = remaining;
		C.SCENE.registerUpdateHandler(this);
	}

	@Override
	public void onUpdate(float pSecondsElapsed)
	{
		remaining -= pSecondsElapsed;

		if (remaining <= 0)
		{
			onFinish();
			C.SCENE.unregisterUpdateHandler(this);
		}
	}

	@Override
	public void reset()
	{
	}

	public abstract void onFinish();
}
