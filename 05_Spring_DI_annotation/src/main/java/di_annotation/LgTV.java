package di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//(실습) Speaker 추가하고 @Component, @Autowired, @Qualifier 추가해서 설정
@Component //명시적으로 주지 않으면 lgTV 명칭으로 객체 생성(첫글자 소문자)
public class LgTV implements TV{
	//필드에 어노테이션 설정
	@Autowired
	//@Qualifier("apple") //sony 주석처리했음
	private Speaker speaker;
	private int price;
	private int width;
	private int height;
	
	public LgTV() {
		System.out.println(">> LgTV() 객체 생성");
	}
	
	//생성자에 어노테이션 설정
	//@Autowired
	public LgTV(Speaker speaker) {
		System.out.println(">> LgTV(speaker) 객체 생성");
		this.speaker = speaker;
	}
	
	public LgTV(Speaker speaker, int price, int width, int height) {
		this.speaker = speaker;
		this.price = price;
		this.width = width;
		this.height = height;
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원ON");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원OFF");
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV - 소리크게~~~");
		speaker.volumnUp();
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV - 소리작게~~~");
		speaker.volumnDown();
	}

	//======== getter, setter ===========
	public Speaker getSpeaker() {
		return speaker;
	}
	
	public void setSpeaker(Speaker speaker) {
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
