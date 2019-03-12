package web.service;


import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import web.dao.Receivemessagedao;
import web.dao.Sendmessagedao;

import web.vo.MybatisUtil;
import web.vo.PagedoSR;
import web.vo.Receivemessage;
import web.vo.Sendmessage;

public class MessageService {

	public void messageSend(Sendmessage sm,int[] empid) {
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Sendmessagedao sdao=session.getMapper(Sendmessagedao.class);
			Receivemessagedao rdao=session.getMapper(Receivemessagedao.class);
			sdao.insert(sm);
			Receivemessage rm=new Receivemessage();
			rm.setSendid(sm.getSendid());
		    for(int i=0;i<empid.length;i++) {
		        rm.setEmpid(empid[i]);
                rdao.insert(rm);
		    }
		    session.commit();
		}
	}
	
	public List<Sendmessage> getsendPage(PagedoSR pagedosr,Integer empid){
		List<Sendmessage> list=new ArrayList<Sendmessage>();
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Sendmessagedao dao=session.getMapper(Sendmessagedao.class);
			list=dao.getsendPageList(pagedosr,empid);
			pagedosr.setList(list);
			int count=dao.getsendCount(empid);
			pagedosr.setRecordcount(count);
		 }
		return list;
	}
	
	public List<Sendmessage> getreceivePage(PagedoSR pagedosr,Integer empid){
		List<Sendmessage> list=new ArrayList<Sendmessage>();
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Sendmessagedao dao=session.getMapper(Sendmessagedao.class);
			list=dao.getreceivePageList(pagedosr,empid);
			pagedosr.setList(list);
			int count=dao.getreceiveCount(empid);
			pagedosr.setRecordcount(count);
		 }
		return list;
	}
	
	public List<Sendmessage> getSend(Integer empid){
		List<Sendmessage> list=new ArrayList<Sendmessage>();
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Sendmessagedao dao=session.getMapper(Sendmessagedao.class);
			list=dao.getsendList(empid);
		 }
		return list;
	}
	
	public List<Sendmessage> getReceive(Integer empid){
		List<Sendmessage> list=new ArrayList<Sendmessage>();
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Sendmessagedao dao=session.getMapper(Sendmessagedao.class);
			list=dao.getreceiveList(empid);
		 }
		return list;
	}
	
	public List<Map<String,Object>> getsendDetails(Integer sendid,Integer empid){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Sendmessagedao dao=session.getMapper(Sendmessagedao.class);
			list=dao.getmessagedetails(sendid, empid);
		 }
		return list;
	}
	
	public Map<String,Object> getreceiveDetails(Integer receiveid){
		Map<String,Object> map=new HashMap<String,Object>();
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Receivemessagedao dao=session.getMapper(Receivemessagedao.class);
			map=dao.getmessagedetails(receiveid);
			dao.updateMessagestate(receiveid);
			session.commit();
		 }
		return map;
	}
	
	public void sendDelete(Integer sendid) {
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Sendmessagedao dao=session.getMapper(Sendmessagedao.class);
			dao.delete(sendid);
			session.commit();
		 }
		
	}
	
	public void sendDeletes(Integer[] sendids) {
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Sendmessagedao dao=session.getMapper(Sendmessagedao.class);
			dao.deletes(sendids);
			session.commit();
		 }
		
	}
	
	
	public void receiveDelete(Integer receiveid) {
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Receivemessagedao dao=session.getMapper(Receivemessagedao.class);
			dao.delete(receiveid);
			session.commit();
		 }
		
	}
	
	public void receiveDeletes(Integer[] receiveids) {
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Receivemessagedao dao=session.getMapper(Receivemessagedao.class);
			dao.deletes(receiveids);
			session.commit();
		 }
		
	}
	
}
