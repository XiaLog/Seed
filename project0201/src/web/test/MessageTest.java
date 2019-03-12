package web.test;



import java.util.List;
import java.util.Map;

import web.service.MessageService;
import web.vo.PagedoSR;
import web.vo.Receivemessage;
import web.vo.Sendmessage;

public class MessageTest {

	public static void main(String[] args) {
		MessageService service=new MessageService();
//		Sendmessage sm=new Sendmessage();
//		sm.setSendid(1);
//		sm.setEmpid(1);
//		sm.setMessagetitle("first");
//		sm.setMessagecontext("how are you");
//		sm.setPriority(1);
//		int[] n= {2,3,4};
//		service.messageSend(sm,n);
//		List<Sendmessage> list=service.getReceive(1);
//		for(Sendmessage s:list)
//			System.out.println(s);
//		Map<String,Object> map=service.getreceiveDetails(4);
//		System.out.println(map.get("MessageContent"));
//			System.out.println(map);
//		service.receiveDelete(4);
//		System.out.println("³É¹¦");
//		PagedoSR pagedosr=new PagedoSR();
//		List<Sendmessage> list=service.getsendPage(pagedosr, 1);
//		for(Sendmessage s:list) {
//			System.out.println(s);
//			List<Receivemessage> rlist=s.getList();
//			for(Receivemessage j:rlist)
//				System.out.println(j);
		//}
		Integer[] a= {4,5};
		
		service.receiveDeletes(a);
		
		
	}

}
