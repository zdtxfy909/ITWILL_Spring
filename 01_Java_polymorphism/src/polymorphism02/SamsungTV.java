package polymorphism02;

public class SamsungTV implements TV {
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
	}
	@Override
	public void volumeDown() {
		System.out.println("SamsungTv - 소리작게");
	}
}
