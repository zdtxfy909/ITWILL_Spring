package polymorphism03;

import java.util.Arrays;

public class TVUser {

	public static void main(String[] args) {
		System.out.println("args : " + Arrays.toString(args));
		BeanFactory factory = new BeanFactory();
		
		//samsungTV, LgTV 사용 (물리적으로 코드 수정)
		//TV tv = (TV)factory.getBean("lg");
		
		TV tv = (TV)factory.getBean(args[0]); 
		//설정만 바꿔주면 바뀐 설정에 따라 삼성이 됐다가 엘지가 됐다가 함
		System.out.println("tv : " + tv);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
	}

}
