package jtestr;

public class Game {

  private int[] scores;
  private int scoreIndex;
  private int countIndex;
  private static final int FRAME_NUMBER = 23;

  public Game() {
    scores = new int[FRAME_NUMBER];
    scoreIndex = 0;
  }
  /*************************************
   * ピンを倒す
   * @param n:倒したピンの数
   ************************************/
  public void roll(int n) {
    if(scoreIndex < FRAME_NUMBER) {
      scores[scoreIndex] = n;
      scoreIndex++;
    }
  }
  /***********************************
   * スコアの計算
   * @result
   **********************************/
  public int getScore() {
    int result = 0;
    for(countIndex=0;countIndex<scoreIndex;countIndex++) {
      int i = countIndex;
      result += isStrike()? scores[i] + strikeBonus()
             :  isSpair()? (scores[i] + scores[i+1]) + spairBonus()
             :             (scores[i] + scores[i+1]);
      if(!isStrike()) countIndex++;
    }
    return result;
  }

  private boolean isStrike(){return scores[countIndex] == 10;}
  private boolean isSpair(){return scores[countIndex] + scores[countIndex+1] == 10;}
  private int strikeBonus(){return scores[countIndex+1] + scores[countIndex+2];}
  private int spairBonus(){return scores[countIndex+2];}
}
