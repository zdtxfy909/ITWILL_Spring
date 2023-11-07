package polymorphism03;

public class SamsungTV implements TV {
	private SonySpeaker speaker; 
	private int price;
	private int width;
	private int height;
	
	public SamsungTV() {
		System.out.println(">> SamsungTV() 객체 생성");
	}
	public SamsungTV(SonySpeaker speaker) {
		System.out.println(">> SamsungTV(speaker) 객체 생성");
		this.speaker = speaker; //생성자를 통한 주입
	}
	public SamsungTV(SonySpeaker speaker, int price) {
		System.out.println(">> SamsungTV(speaker, price) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	public SamsungTV(SonySpeaker speaker, int width, int height) {
		System.out.println(">> SamsungTV(speaker, width, height) 객체 생성");
		this.speaker = speaker;
		this.width = width;
		this.height = height;
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
	
	@Override
	public String toString() {
		return "SamsungTV [speaker=" + speaker + ", price=" + price + ", width=" + width + ", height=" + height + "]";
	}
	
	//======== getter, setter ===========
	public SonySpeaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(SonySpeaker speaker) {
		this.speaker = speaker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	
}
