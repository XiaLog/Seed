package web.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class PageInfo {
    List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
    List<Emp> elist=new ArrayList<Emp>();
    int currentpage=1;
    int topnumber=0;
    int pagesize=5;
    int recordcount=0;
    String url=null;
	
    
	public List<Emp> getElist() {
		return elist;
	}
	public void setElist(List<Emp> elist) {
		this.elist = elist;
	}
	public List<Map<String, Object>> getList() {
		return list;
	}
	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	
	public int getTopnumber() {
		return topnumber;
	}
	public void setTopnumber(int topnumber) {
		this.topnumber = topnumber;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	public int getRecordcount() {
		return recordcount;
	}
	public void setRecordcount(int recordcount) {
		this.recordcount = recordcount;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
    public int getPagecount() {
    	return this.recordcount%this.pagesize==0?this.recordcount/this.pagesize:this.recordcount/this.pagesize+1;
    }
    
    public PageInfo(HttpServletRequest request) {
    	if(request.getParameter("currentpage")!=null) {
    		this.currentpage=Integer.valueOf(request.getParameter("currentpage"));
    		this.topnumber=(this.currentpage-1)*this.pagesize;
    	}
    	if(request.getParameter("url")!=null) {
    		this.url=request.getParameter("url");
    	}
    	request.setAttribute("pageinfo", this);
    }
	public PageInfo() {
		super();
	}
    
    
}
