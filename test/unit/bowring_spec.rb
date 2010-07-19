import 'jtestr.Game'

describe "ボーリングゲームのテスト", Game do
  before do
    @game = Game.new
  end
  describe "基本的なスコアに関するテスト" do
    it "should return zero, when gatter." do
      gatter
      @game.get_score.should == 0
    end
    it "should return 1, when 1." do
      @game.roll(1)
      @game.get_score.should == 1
    end
  end
  describe "一回のゲームのスコア" do
    it "should return zero, when gutter 20 times" do
      20.times do
        gatter
      end
    end
    it "should return 20, when has spair." do
      spair
      @game.roll(5);@game.roll(0)
      16.times { gatter }
      @game.get_score.should == 20
    end
    it "should return 24, when has strike." do
      strike # strike!
      @game.roll(5);@game.roll(2)
      17.times { gatter }
      @game.get_score.should == 24
    end
    it "should return 300, when perfect game." do
      11.times do
        strike
      end
      @game.get_score.should == 300
    end
  end
  describe "ユーザ受入テスト" do
    it "should return 113, when given UAT Case" do
      [ 5, 4, # => 9,9 
        3, 6, # => 9,18
        2, 8, # => 13,31
        3, 3, # => 6,37
        6, 1, # => 7,44
        0, 0, # => 0,44
        5, 2, # => 7,51 
        8, 2, # => 19,70
        9, 1, # => 13,83
        3, 7, 10 # => 30, 113
      ].each do |n|
       @game.roll(n.to_i)
      end
      @game.get_score.should == 113
    end
  end
  private
  def strike; @game.roll(10) end
  def spair; @game.roll(3);@game.roll(7) end
  def gatter; @game.roll(0) end
end

