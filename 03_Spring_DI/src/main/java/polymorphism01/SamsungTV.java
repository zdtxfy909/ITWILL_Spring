package polymorphism01;

public class SamsungTV implements TV {
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println(">> SamsungTV() 객체 생성");
		// 필드 SonySpeaker에 객체 주입 -> 안되어있으면 널포인트익셉션
		speaker = new SonySpeaker();
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTv - 전원ON");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTv - 전원OFF");
	}
	@Override
	public void volumeUp() {
		System.out.println("SamsungTv - 소리크게");
		speaker.volumnUp();
	}
	@Override
	public void volumeDown() {
		System.out.println("SamsungTv - 소리작게");
		speaker.volumnDown();
	}
}
