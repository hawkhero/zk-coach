package zkcoach.mvvm.tutorial.controller;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.util.Clients;

public class SubjectValidator extends AbstractValidator {

	//TODO, 6-12, 實作驗證邏輯
	@Override
	public void validate(ValidationContext ctx) {
		//取得驗證目標值
		String subject = (String)ctx.getProperty().getValue();

	}

}