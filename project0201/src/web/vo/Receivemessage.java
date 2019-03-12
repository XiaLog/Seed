package web.vo;

import java.sql.Date;

public class Receivemessage {
   private Integer receiveid;
   private Integer sendid;
   private Integer empid;
   private Integer messagestate;
   private Date opendate;
   Emp remp;
 
public Emp getRemp() {
	return remp;
}
public void setRemp(Emp remp) {
	this.remp = remp;
}
public Integer getReceiveid() {
	return receiveid;
}
public void setReceiveid(Integer receiveid) {
	this.receiveid = receiveid;
}
public Integer getSendid() {
	return sendid;
}
public void setSendid(Integer sendid) {
	this.sendid = sendid;
}
public Integer getEmpid() {
	return empid;
}
public void setEmpid(Integer empid) {
	this.empid = empid;
}
public Integer getMessagestate() {
	return messagestate;
}
public void setMessagestate(Integer messagestate) {
	this.messagestate = messagestate;
}
public Date getOpendate() {
	return opendate;
}
public void setOpendate(Date opendate) {
	this.opendate = opendate;
}
public Receivemessage(Integer sendid, Integer empid, Integer messagestate, Date opendate) {
	super();
	this.sendid = sendid;
	this.empid = empid;
	this.messagestate = messagestate;
	this.opendate = opendate;
}
public Receivemessage(Integer receiveid, Integer sendid, Integer empid, Integer messagestate, Date opendate) {
	super();
	this.receiveid = receiveid;
	this.sendid = sendid;
	this.empid = empid;
	this.messagestate = messagestate;
	this.opendate = opendate;
}
public Receivemessage() {
	super();
}
@Override
public String toString() {
	return "Receivemessage [receiveid=" + receiveid + ", sendid=" + sendid + ", empid=" + empid + ", messagestate="
			+ messagestate + ", opendate=" + opendate + "]";
}
   
   
}
