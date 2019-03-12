package web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import web.vo.Receivemessage;

public interface Receivemessagedao {
    public void insert(Receivemessage rm);
    
    public Map<String,Object> getmessagedetails(@Param("receiveid")Integer receiveid);
    
    public void delete(@Param("receiveid")Integer receiveid);
    
    public void deletes(Integer[] receiveids);
    
    public void updateMessagestate(@Param("receiveid")Integer receiveid);
}
