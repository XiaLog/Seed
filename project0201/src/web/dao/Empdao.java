package web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import web.vo.Emp;
import web.vo.PageInfo;

public interface Empdao {
       public List<Emp> getAll();
       
       public Emp getEmp(@Param("empname")  String empname, @Param("password")  String password);
       
       public List<Map<String,Object>> getmessagelist(@Param("empid") Integer empid);
       
       public Map<String,Object> getmessageDetails(@Param("sendid") Integer sendid, @Param("receiveid") Integer receiveid);
       
       public void deleteBySendid(@Param("sendid") Integer sendid);
       public void deleteByReceiveid(@Param("receiveid") Integer receiveid);
       
       public List<Map<String,Object>> getPageList(@Param("PageInfo") PageInfo pageinfo,@Param("empid") Integer empid);
       
       public int getCount(@Param("empid") int empid);
       
       public void deleteBySendids(Integer[] sendids);
       public void deleteByReceiveids(Integer[] receiveids);
       
       public void insert(Emp emp);
       
       public List<Emp> getEmpPage(PageInfo pageinfo);
       
       public int getnumber();
       
       public Emp getEmpById(@Param("empid") Integer empid);
       
       public void change(@Param("emp") Emp emp,@Param("empid") Integer empid);
       
       public void delete(Integer[] empid);
        
}
