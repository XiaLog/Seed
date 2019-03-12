package web.vo;

import java.sql.Date;
import java.util.List;

public class Sendmessage {
   private  Integer sendid;
   private  Integer empid;
   private  String messagetitle;
   private  String messagecontent;
   private  Date createdate;
   private  Integer priority;
   private  Integer messagestate;
   
   List<Receivemessage> list;
   
public List<Receivemessage> getList() {
	return list;
}
public void setList(List<Receivemessage> list) {
	this.list = list;
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
public String getMessagetitle() {
	return messagetitle;
}
public void setMessagetitle(String messagetitle) {
	this.messagetitle = messagetitle;
}
public String getMessagecontent() {
	return messagecontent;
}
public void setMessagecontent(String messagecontent) {
	this.messagecontent = messagecontent;
}
public Date getCreatedate() {
	return createdate;
}
public void setCreatedate(Date createdate) {
	this.createdate = createdate;
}
public Integer getPriority() {
	return priority;
}
public void setPriority(Integer priority) {
	this.priority = priority;
}
public Integer getMessagestate() {
	return messagestate;
}
public void setMessagestate(Integer messagestate) {
	this.messagestate = messagestate;
}
public Sendmessage(Integer sendid, Integer empid, String messagetitle, String messagecontent, Date createdate,
		Integer priority, Integer messagestate) {
	super();
	this.sendid = sendid;
	this.empid = empid;
	this.messagetitle = messagetitle;
	this.messagecontent = messagecontent;
	this.createdate = createdate;
	this.priority = priority;
	this.messagestate = messagestate;
}
public Sendmessage() {
	super();
}
@Override
public String toString() {
	return "Sendmessage [sendid=" + sendid + ", empid=" + empid + ", messagetitle=" + messagetitle + ", messagecontent="
			+ messagecontent + ", createdate=" + createdate + ", priority=" + priority + ", messagestate="
			+ messagestate + "]";
}
   
     
}
