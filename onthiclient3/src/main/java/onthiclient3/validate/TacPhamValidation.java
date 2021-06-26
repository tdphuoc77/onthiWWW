package onthiclient3.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import onthiclient3.entity.TacPham;

@Component
public class TacPhamValidation implements Validator {

	public boolean supports(Class<?> clazz) {
		return TacPham.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		if(!supports(target.getClass())) {
			return;
		}
		TacPham tacPham=(TacPham) target;
		
		 String tenTP =tacPham.getTenTP();
		 if(tenTP.length()==0) {
				errors.rejectValue("tenTP", null, "Khong hop le");
			}
		 String loaiTP=tacPham.getLoaiTP();
		 if(loaiTP.length()==0) {
				errors.rejectValue("loaiTP", null, "Khong hop le");
			}
		 int soTrang=tacPham.getSoTrang();
		 if(soTrang<=0) {
			 errors.rejectValue("soTrang", null, "Khong hop le");
		 }
		 double gia=tacPham.getGia();
		 if(gia<=0) {
			 errors.rejectValue("gia", null, "Khong hop le");
		 }
		 String tomtat=tacPham.getTomtat();
		 if(tomtat.length()==0) {
				errors.rejectValue("tomtat", null, "Khong hop le");
			}
		 String hinh=tacPham.getHinh();
		 if(hinh.length()==0) {
				errors.rejectValue("hinh", null, "Khong hop le");
			}
	}

}
