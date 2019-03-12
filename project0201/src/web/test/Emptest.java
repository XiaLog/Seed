package web.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import web.dao.Empdao;
import web.service.EmpService;
import web.vo.Emp;
import web.vo.MybatisUtil;
import web.vo.PageInfo;

public class Emptest {

	public static void main(String[] args) {
		EmpService service=new EmpService();
//        List<Map<String,Object>> list=service.getMessage(4);
//        for(Map i:list)
//        	System.out.println(i);
//		Map<String,Object> map=service.getDetails(1, 4);
//		System.out.println(map);
//		PageInfo pageinfo=new PageInfo();
//		List<Emp> list=service.getPageEmp(pageinfo);
//		for(Emp i:list)
//			System.out.println(i);
//		Integer[] a =new Integer[3];
//		a[0]=1;
//		a[2]=2;
//		Integer[] b= {4,5};
//		System.out.println(a[0]==null);
		//service.deletes(a, b);
//		List<Emp> emp=service.getallEmp();
//		for(Emp i:emp)
//			System.out.println(i);
//	   Emp emp=new Emp(null,"001","011011","limei","Ů",null,null,null,null,null,null,null,null,null,null,null,null,null);
        Integer[] empid= {13};
		service.deleteEmp(empid);

	}
	

}
