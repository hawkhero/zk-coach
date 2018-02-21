package zkcoach.mvvm;

import org.zkoss.bind.annotation.*;


public class HelloVM {
	private String hello = "hello";

	//TODO, 3, getter
	public String getHello() {
		return hello;
	}

	//TODO, 4, command method
	@Command @NotifyChange("hello")
	public void helloWorld(){
		hello = "hello world";
	}

}
