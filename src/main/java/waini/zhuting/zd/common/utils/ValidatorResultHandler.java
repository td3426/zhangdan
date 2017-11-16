package top.rreeff.common.utils;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ValidatorResultHandler {
	public static Response handle(BindingResult result) {
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			ObjectError oe = list.get(0);
			return Response.getInstance().failure(oe.getDefaultMessage());
		} else {
			return null;
		}

	}
}
