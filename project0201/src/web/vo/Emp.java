package web.vo;

import java.sql.Date;

public class Emp {
     private Integer empid;
     private String empno;
     private String password;
     private String empname;
     private String sex;
     private Date birth;
     private String idcard;
     private String email;
     private String tel;
     private String address;
     private String emptype;
     private String bankname;
     private String bankno;
     private Integer sal;
     private Integer comm;
     private Integer subsidy;
     private Date hiredate;
     private String descript;
     
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmptype() {
		return emptype;
	}
	public void setEmptype(String emptype) {
		this.emptype = emptype;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBankno() {
		return bankno;
	}
	public void setBankno(String bankno) {
		this.bankno = bankno;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	public Integer getComm() {
		return comm;
	}
	public void setComm(Integer comm) {
		this.comm = comm;
	}
	public Integer getSubsidy() {
		return subsidy;
	}
	public void setSubsidy(Integer subsidy) {
		this.subsidy = subsidy;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	public Emp(Integer empid, String empno, String password, String empname, String sex, Date birth, String idcard,
			String email, String tel, String address, String emptype, String bankname, String bankno, Integer sal,
			Integer comm, Integer subsidy, Date hiredate, String descript) {
		super();
		this.empid = empid;
		this.empno = empno;
		this.password = password;
		this.empname = empname;
		this.sex = sex;
		this.birth = birth;
		this.idcard = idcard;
		this.email = email;
		this.tel = tel;
		this.address = address;
		this.emptype = emptype;
		this.bankname = bankname;
		this.bankno = bankno;
		this.sal = sal;
		this.comm = comm;
		this.subsidy = subsidy;
		this.hiredate = hiredate;
		this.descript = descript;
	}
	public Emp() {
		super();
	}
	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", empno=" + empno + ", password=" + password + ", empname=" + empname + ", sex="
				+ sex + ", birth=" + birth + ", idcard=" + idcard + ", email=" + email + ", tel=" + tel + ", address="
				+ address + ", emptype=" + emptype + ", bankname=" + bankname + ", bankno=" + bankno + ", sal=" + sal
				+ ", comm=" + comm + ", subsidy=" + subsidy + ", hiredate=" + hiredate + ", descript=" + descript + "]";
	}
	
}
