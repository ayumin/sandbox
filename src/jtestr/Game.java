package jtestr;

public class Game
{
  private int[] scores;
  private int scoreIndex;
  private int i;
  private static final int FRAME_NUMBER = 21;

  public Game()
  {
    scores = new int[FRAME_NUMBER];
    scoreIndex = 0;
  }

  public void roll(int n)
  {
    if(scoreIndex < FRAME_NUMBER)
    {
      scores[scoreIndex] = n;
      scoreIndex++;
    }
  }
  public int score()
  {
    int result = 0;
    i = 0;
    while(i<scoreIndex)
    {
      if(isStrike()) {
        result += scores[i] + strikeBonus();
        i++;
      }else if(isSpair()) {
        result += scores[i] + scores[i+1] + spairBonus();
        i+=2;
      }else {
        result += scores[i] + scores[i+1];
        i+=2;
      }
    }
    return result;
  }
  private int frameTotal()
  {
    return isStrike()? 10 : scores[i] + scores[i+1];
  }
  private boolean isStrike()
  {
    return scores[i] == 10;
  }
  private boolean isSpair()
  {
    return scores[i] + scores[i+1] == 10;
  }

  private int strikeBonus()
  {
    return scores[i+1] + scores[i+2];
  }
  private int spairBonus()
  {
    return scores[i+2];
  }
}
