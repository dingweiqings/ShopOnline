package com.etc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.etc.util.MySessionContext;

public class LoginListener implements HttpSessionListener,HttpSessionAttributeListener{
	 private   MySessionContext myc=MySessionContext.getInstance();  
	// private static Map<String,String> loginUsers = new HashMap<String,String>();
	 private static Map<String,String> Users=new HashMap<String,String>();
	 //key为i Value为qname
	 private static Map<String,String> Sesss=new HashMap<String,String>();
	 //key为i Value为sid
	 private static int flag=0;
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		int qid=0;
		try {
			qid = (Integer)arg0.getSession().getAttribute("userid");
			System.out.println("kank"+(Integer)arg0.getSession().getAttribute("userid"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("qid为空，未登陆");
		}
		System.out.println("ADDuserid:"+qid);
		String sid=(String)arg0.getSession().getAttribute("sid");
		System.out.println("ADDsid:"+sid);
		//根据ip地址的不同实现单点登录
		/*String uip=(String)arg0.getSession().getAttribute("uip");
		System.out.println("ADDuip:"+uip);*/
		//根据SessionID的不同实现单点登录
		//long random=System.currentTimeMillis();
		//String i=random+"";
		String i=flag+"";
		System.out.println("i"+i);
		if(qid!=0&&sid!=null){
			String j=null;
			System.out.println("qid:"+qid+"是否存在在Users中");
			System.out.println(Users.containsValue((qid+"")));
			if(Users.containsValue((qid+""))){
				for(Map.Entry entry:Users.entrySet()){
				    if((qid+"").equals(entry.getValue())){
				    		j=(String) entry.getKey();
				    		System.out.println("users中qid对应的i"+j);
				    }
				    String sids=(String)Sesss.get(j);
				    System.out.println(j+"在Sesss中对应的sessid"+sids);
				    MySessionContext myc= MySessionContext.getInstance();  
					   HttpSession sess = myc.getSession(sids); 
					   sess.removeAttribute("userid");
					   sess.invalidate();
					   flag=flag-1;
					   String w=flag+"";
					   Sesss.put(w,sid); 
			  }
			} else {
				Users.put(i, (qid+""));
				Sesss.put(i, sid);
				flag++;
				
			}
			Set<String> key = Users.keySet();
			for (String k : key) {
				System.out.println("Users中i:" + k + " qid:"
						+ Users.get(k));
			}
			Set<String> key1 = Sesss.keySet();
			for (String k1 : key1) {
				System.out.println("Sesss中i:" + k1 + " sid:"
						+ Sesss.get(k1));
			}
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void sessionCreated(HttpSessionEvent se) { 
	   myc.AddSession(se.getSession());  
	   /* String qname=(String) se.getSession().getAttribute("qname");
	       if( loginUsers.containsKey(qname) ){
		   String sip=loginUsers.get(qname);
		   System.out.println("起初登陆的Session"+sip);
		   MySessionContext myc= MySessionContext.getInstance();  
		   HttpSession sess = myc.getSession(sip); 
		   String q=(String)sess.getAttribute("qname");
		   System.out.println("SessionContext中的sess的Attribute"+q);
		   sess.removeAttribute("qname");
		   sess.invalidate();
	   }*/
	
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession session = se.getSession();  
		System.out.println("sessionId"+session.getId()+"正在被销毁");
		myc.DelSession(session);  
	}

}
