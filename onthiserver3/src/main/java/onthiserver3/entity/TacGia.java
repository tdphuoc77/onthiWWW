package onthiserver3.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TacGia {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int maTG;
	private String hoTen;
	private String linhVuc;
	private String tieuSu;

	@OneToMany(mappedBy = "tacGia",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<TacPham> list= new ArrayList<TacPham>();

	public int getMaTG() {
		return maTG;
	}

	public void setMaTG(int maTG) {
		this.maTG = maTG;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getLinhVuc() {
		return linhVuc;
	}

	public void setLinhVuc(String linhVuc) {
		this.linhVuc = linhVuc;
	}

	public String getTieuSu() {
		return tieuSu;
	}

	public void setTieuSu(String tieuSu) {
		this.tieuSu = tieuSu;
	}

	public List<TacPham> getList() {
		return list;
	}

	public void setList(List<TacPham> list) {
		this.list = list;
	}

	public TacGia(int maTG, String hoTen, String linhVuc, String tieuSu) {
		super();
		this.maTG = maTG;
		this.hoTen = hoTen;
		this.linhVuc = linhVuc;
		this.tieuSu = tieuSu;
	}

	

	@Override
	public String toString() {
		return "TacGia [maTG=" + maTG + ", hoTen=" + hoTen + ", linhVuc=" + linhVuc + ", tieuSu=" + tieuSu + "]";
	}

	public TacGia() {
		super();
	}

	public TacGia(String hoTen, String linhVuc, String tieuSu) {
		super();
		this.hoTen = hoTen;
		this.linhVuc = linhVuc;
		this.tieuSu = tieuSu;
	}
	
}
