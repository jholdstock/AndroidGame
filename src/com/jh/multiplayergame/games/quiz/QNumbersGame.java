package com.jh.multiplayergame.games.quiz;

import java.util.Random;

import org.andengine.util.math.MathUtils;

public class QNumbersGame extends BaseQuizGame
{
	private int[] NUMBERS = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			
	@Override
	public String getDescription()
	{
		return "Is maths correct?";
	}
	
	@Override	
	public QuestionAndAnswer getQuestionAndAnswer()
	{
		int number1 = new Random().nextInt(NUMBERS.length) + 1;
		int number2 = new Random().nextInt(NUMBERS.length) + 1;
		
		int result = -1;
		char sign = ' ';
		switch (new Random().nextInt(3))
		{
			case 0:
				result = number1 + number2;
				sign = '+';
				break;
				
			case 1:
				result = number1 - number2;
				sign = '-';
				break;
			
			case 2:
				result = number1 * number2;
				sign = '*';
				break;
		}
		
		boolean answer = new Random().nextInt(3) == 0; 
		if (answer == false)
		{
			result += (MathUtils.randomSign() * (new Random().nextInt(6) + 1));
		}
		
		String question = number1 + " " + sign + " " + number2 + " = " + result;
		
		return new QuestionAndAnswer(question, answer);
	}
}
