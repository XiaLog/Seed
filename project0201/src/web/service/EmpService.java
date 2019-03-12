package web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import web.dao.Empdao;
import web.vo.Emp;
import web.vo.MybatisUtil;
import web.vo.PageInfo;

public class EmpService {
	public List<Emp> getallEmp() {
		List<Emp> list=null;
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Empdao dao=session.getMapper(Empdao.class);
			list=dao.getAll();
		}
		return list;
	}
	
	public Emp getoneEmp(String empname,String password) {
		Emp emp=null;
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Empdao dao=session.getMapper(Empdao.class);
			emp=dao.getEmp(empname, password);
		}
		return emp;
	}
	
	public List<Map<String,Object>> getMessage(Integer empid){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Empdao dao=session.getMapper(Empdao.class);
			list=dao.getmessagelist(empid);
		}
		return list;
	}
	
	public Map<String,Object> getDetails(Integer sendid,Integer receiveid){
		Map<String,Object> map=new HashMap<String,Object>();
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Empdao dao=session.getMapper(Empdao.class);
			map=dao.getmessageDetails(sendid, receiveid);
		}
		return map;
	}
	
	public void delete(Integer sendid,Integer receiveid) {
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Empdao dao=session.getMapper(Empdao.class);
			dao.deleteByReceiveid(receiveid);
			dao.deleteBySendid(sendid);
			session.commit();
		}
	}
	
	public void deletes(Integer[] sendids,Integer[] receiveids) {
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Empdao dao=session.getMapper(Empdao.class);
			dao.deleteByReceiveids(receiveids);
			dao.deleteBySendids(sendids);
			session.commit();
		}
	}
	
	
	public List<Map<String,Object>> getPage(PageInfo pageinfo,int empid) {
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Empdao dao=session.getMapper(Empdao.class);
			list=dao.getPageList(pageinfo,empid);
			pageinfo.setList(list);
			int count=dao.getCount(empid);
			pageinfo.setRecordcount(count);
		}
		return list;
	}
	
	public void insertEmp(Emp emp) {
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Empdao dao=session.getMapper(Empdao.class);
			dao.insert(emp);
			session.commit();
		}
	}
	
	public List<Emp> getPageEmp(PageInfo pageinfo) {
		List<Emp> list=new ArrayList<Emp>();
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Empdao dao=session.getMapper(Empdao.class);
			list=dao.getEmpPage(pageinfo);
			pageinfo.setElist(list);
			int count=dao.getnumber();
			pageinfo.setRecordcount(count);
		}
		return list;
	}
	
	public Emp getEmpdetails(Integer empid) {
		Emp emp=null;
		try(SqlSession session=MybatisUtil.openSqlsession();){
			Empdao dao=session.getMapper(Empdao.class);
			emp=dao.getEmpById(empid);
		}
		return emp;
	}
	
	public void changeEmp(Emp emp,Integer empid) {

		try(SqlSession session=MybatisUtil.openSqlsession();){
			Empdao dao=session.getMapper(Empdao.class);
			dao.change(emp, empid);
			session.commit();
		}
	
	}
	
	public void deleteEmp(Integer[] empid) {

		try(SqlSession session=MybatisUtil.openSqlsession();){
			Empdao dao=session.getMapper(Empdao.class);
			dao.delete(empid);
			session.commit();
		}
	
	}
	
}
