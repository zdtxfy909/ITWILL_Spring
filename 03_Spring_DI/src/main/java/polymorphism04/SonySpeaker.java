package polymorphism04;

public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("--->> SonySpeaker() 생성");
	}
	
	@Override
	public void volumnUp() {
		System.out.println(">> SonySpeaker - 소리크게");
	}
	@Override
	public void volumnDown() {
		System.out.println(">> SonySpeaker - 소리작게");
	}
	
	
}
