package Clases;

public class Depart {
	private int deptNo;
	private String dnombre;
	private String loc;
	
	public Depart() {}
	public Depart(int deptNo, String dnombre, String loc) {
		this.deptNo=deptNo;
		this.dnombre=dnombre;
		this.loc=loc;
		
	}
	
	@Override
	public String toString() {
		return "Depart [Dnombre=" + dnombre + "]";
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDnombre() {
		return dnombre;
	}
	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	

}
