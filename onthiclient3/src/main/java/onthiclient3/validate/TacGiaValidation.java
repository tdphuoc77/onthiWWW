package onthiclient3.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import onthiclient3.entity.TacGia;

@Component
public class TacGiaValidation implements Validator {

	public boolean supports(Class<?> clazz) {
		return TacGia.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		if(!supports(target.getClass())) {
			return;
		}
		TacGia tacGia= (TacGia) target;
		
		String hoTen= tacGia.getHoTen();
		if(hoTen.length()==0) {
			errors.rejectValue("hoTen", null, "Khong hop le");
		}
		 String linhVuc=tacGia.getLinhVuc();
		 if(linhVuc.length()==0) {
				errors.rejectValue("linhVuc", null, "Khong hop le");
			}
		  String tieuSu=tacGia.getTieuSu();
		  if(tieuSu.length()==0) {
				errors.rejectValue("tieuSu", null, "Khong hop le");
			}
	}

}
