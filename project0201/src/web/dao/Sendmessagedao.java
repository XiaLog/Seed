package web.dao;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import web.vo.PagedoSR;
import web.vo.Sendmessage;

public interface Sendmessagedao {
    public void insert(Sendmessage sm);
    
    public List<Sendmessage> getsendList(@Param("empid") Integer empid);
      
    public List<Sendmessage> getreceiveList(@Param("empid") Integer empid);
    
    public List<Map<String,Object>> getmessagedetails(@Param("sendid") Integer sendid,@Param("empid") Integer empid);
    
    public void delete(@Param("sendid") Integer sendid);
    
    public void deletes(Integer[] sendids);
   
    
    public List<Sendmessage> getsendPageList(@Param("PagedoSR") PagedoSR pagedosr,@Param("empid") int empid);
    
    public int getsendCount(@Param("empid") int empid);
    
    public List<Sendmessage> getreceivePageList(@Param("PagedoSR") PagedoSR pagedosr,@Param("empid") int empid);
    
    public int getreceiveCount(@Param("empid") int empid);
}
