package zkcoach.mvvm;

import org.zkoss.bind.annotation.*;


public class HelloVM {

	private String hello = "hello";

	public String getHello() {
		return hello;
	}

	@Command @NotifyChange("hello")
	public void helloWorld(){
		hello = "hello world";
	}

}
