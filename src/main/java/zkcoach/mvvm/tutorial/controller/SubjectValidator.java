package zkcoach.mvvm.tutorial.controller;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.util.Clients;

public class SubjectValidator extends AbstractValidator {

	@Override
	public void validate(ValidationContext ctx) {
		//取得驗證目標值
		String subject = (String)ctx.getProperty().getValue();

		if(Strings.isBlank(subject)){
			Clients.showNotification("必須輸入待辦內容喔！",ctx.getBindContext().getComponent());
			//設定驗證結果為不合法，因此：
			//使用者輸入不會存入 ViewModel 中
			//不會執行相關的 command 
			ctx.setInvalid();
		}
	}

}
