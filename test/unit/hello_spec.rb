import 'jtestr.Hello'

describe Hello do
  before { @hello = Hello.new }

  it "should say hello." do
    @hello.say.should == "hello"
  end
end

