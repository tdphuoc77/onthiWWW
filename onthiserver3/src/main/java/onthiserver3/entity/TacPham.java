package onthiserver3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TacPham {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int maTP;
	private String tenTP;
	private String loaiTP;
	private int soTrang;
	private double gia;
	private String tomtat;
	private String hinh;
	
	@ManyToOne
	@JoinColumn(name = "tacgiaID")
	private TacGia tacGia;

	public int getMaTP() {
		return maTP;
	}

	public void setMaTP(int maTP) {
		this.maTP = maTP;
	}

	public String getTenTP() {
		return tenTP;
	}

	public void setTenTP(String tenTP) {
		this.tenTP = tenTP;
	}

	public String getLoaiTP() {
		return loaiTP;
	}

	public void setLoaiTP(String loaiTP) {
		this.loaiTP = loaiTP;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getTomtat() {
		return tomtat;
	}

	public void setTomtat(String tomtat) {
		this.tomtat = tomtat;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public TacGia getTacGia() {
		return tacGia;
	}

	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}

	public TacPham(int maTP, String tenTP, String loaiTP, int soTrang, double gia, String tomtat, String hinh) {
		super();
		this.maTP = maTP;
		this.tenTP = tenTP;
		this.loaiTP = loaiTP;
		this.soTrang = soTrang;
		this.gia = gia;
		this.tomtat = tomtat;
		this.hinh = hinh;
	}

	public TacPham(String tenTP, String loaiTP, int soTrang, double gia, String tomtat, String hinh) {
		super();
		this.tenTP = tenTP;
		this.loaiTP = loaiTP;
		this.soTrang = soTrang;
		this.gia = gia;
		this.tomtat = tomtat;
		this.hinh = hinh;
	}

	public TacPham() {
		super();
	}

	@Override
	public String toString() {
		return "TacPham [maTP=" + maTP + ", tenTP=" + tenTP + ", loaiTP=" + loaiTP + ", soTrang=" + soTrang + ", gia="
				+ gia + ", tomtat=" + tomtat + ", hinh=" + hinh + "]";
	}

	
	
}
