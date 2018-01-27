package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.SingleBiz;

import com.etc.entity.QCloth;
import com.etc.entity.QComment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * ��ȡ�·�����
 * @author dzt
 *
 */
public class SingleAction {
	
	@Autowired
	private SingleBiz singleBiz;
	
	
	private int clothid;
	private int pagecount;
	private int pagenum;


	private String loadflag;

	private String cloname;
	private String clotype;
	private String clodetail;
	private String cloprice;
	private String closale;
	
	public String getClosale() {
		return closale;
	}
	public void setClosale(String closale) throws UnsupportedEncodingException {
		this.closale = new String(closale.getBytes("iso-8859-1"),"utf-8");
	}
	public String getCloprice() {
		return cloprice;
	}
	public void setCloprice(String cloprice) throws UnsupportedEncodingException {
		this.cloprice = new String(cloprice.getBytes("iso-8859-1"),"utf-8");
	}
	public String getLoadflag() {
		return loadflag;
	}
	public void setLoadflag(String loadflag) throws UnsupportedEncodingException {
		this.loadflag = new String(loadflag.getBytes("iso-8859-1"),"utf-8");
	}

	public String getClotype() {
		return clotype;
	}
	public void setClotype(String clotype) throws UnsupportedEncodingException {
		this.clotype = new String(clotype.getBytes("iso-8859-1"),"utf-8");
	}
	public String getClodetail() {
		return clodetail;
	}
	public void setClodetail(String clodetail) throws UnsupportedEncodingException {
		this.clodetail = new String(clodetail.getBytes("iso-8859-1"),"utf-8");
	}
	public String getCloname() {
		return cloname;
	}
	public void setCloname(String cloname) throws UnsupportedEncodingException {
		this.cloname = new String(cloname.getBytes("iso-8859-1"), "utf-8");
	}
	
	
	public int getClothid() {
		return clothid;
	}


	public void setClothid(int clothid) {
		this.clothid = clothid;
	}


	public int getPagecount() {
		return pagecount;
	}


	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}


	public int getPagenum() {
		return pagenum;
	}


	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}


	/**
	 * ��ȡ�·���չʾͼƬ
	 * @author dzt
	 */
	public void getInfo(){
		System.out.println("Action-----");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		
		//int clothid=Integer.parseInt(request.getParameter("clothid"));
		
		QCloth cloth=singleBiz.getClothbyID(clothid);
		
		Gson gson=new Gson();
		String clothdetail= gson.toJson(cloth);
		
		System.out.println("SingleAction-----"+clothdetail);
		
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		out.write(clothdetail);
		
		out.flush();
		out.close();
	}
	
	
	public void gettotal(){
		
		HttpServletResponse response=ServletActionContext.getResponse();
		
		/*int clothid=Integer.parseInt(request.getParameter("clothid"));
		int pagecount=Integer.parseInt(request.getParameter("pagecount"));*/
		
		int temp= singleBiz.getcompage(clothid, pagecount);
		
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.write(temp+"");
		
		out.flush();
		out.close();
	}
	
	public void getcombypage(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		
		/*int clothid=Integer.parseInt(request.getParameter("clothid"));
		int pagecount=Integer.parseInt(request.getParameter("pagecount"));
		int pagenum=Integer.parseInt(request.getParameter("pagenum"));*/
		
		List<QComment> coms= singleBiz.getcomsbypage(clothid, pagecount, pagenum);
		//System.out.println(coms.size()+"sizeeeeeeeeeee");
		 //gson=new Gson();
		
		
		Gson gson=new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
		String temp=gson.toJson(coms);
		System.out.println(temp);
		
		
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.write(temp);
		
		out.flush();
		out.close();
		
	}
	
	
	public void gettotalcoms(){
		ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		
		//int clothid=Integer.parseInt(request.getParameter("clothid"));
		
		

		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.write(singleBiz.gettotalcoms(clothid)+"");
		
		out.flush();
		out.close();
	}
	
	
	public void getavggrade(){
		ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		
		//int clothid=Integer.parseInt(request.getParameter("clothid"));
		
		System.out.println("pingjunfen        eeeeeeeeeeeeeee");

		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.write(singleBiz.getavggra(clothid)+"");
		
		out.flush();
		out.close();
		
	}
	
	//WJZ
	

	
	//��ʼҳ����أ�
	public void seachLoad(){
		System.out.println("loadflag:"+loadflag);
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {			
			e1.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		
		List<QCloth> list=null ;
		
		if("load".equals(loadflag)){		
		
		}
		try {
			list=singleBiz.seachLoadBiz();	
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		Gson gson=new Gson();
		String temp=gson.toJson(list);
		System.out.println(" singleAction 291  temp:"+temp);
		
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
      out.write(temp);
		
		out.flush();
		out.close();
		
		
		
	}

	//����nameģ����ѯ��
	public void seachCloByName(){

		System.out.println(cloname);

		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {			
			e1.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		
		List<QCloth> list=null ;
				try {
					list=singleBiz.seachByNameBiz(cloname);	
				} catch (Exception e) {
					System.out.println("����쳣������������");
					System.out.println(e);
				}
		
		Gson gson=new Gson();
		String temp=gson.toJson(list);
		System.out.println("temp"+temp);
		
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
      out.write(temp);
		
		out.flush();
		out.close();
	
	}
	
	
	
		//����typeģ����ѯ��
		public void seachCloByType(){
			
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e1) {			
				e1.printStackTrace();
			}
			response.setCharacterEncoding("utf-8");
			
			List<QCloth> list=null ;
					try {
						list=singleBiz.seachByTypeBiz(clotype);	
					} catch (Exception e) {
						
						System.out.println(e);
					}
					
			System.out.println(clotype+"wwwwwwwwwwwwwwwwww");
			System.out.println("ִ�е�����2    8888888888888888888888888888888888");
			Gson gson=new Gson();
			String temp=gson.toJson(list);	
			PrintWriter out=null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				
				e.printStackTrace();
			}	
		out.write(temp);
		
		System.out.println("temp"+temp);
		out.flush();
		out.close();
		
	}
		
		//����detailģ����ѯ��
				public void seachCloByDetail(){
					
					HttpServletRequest request=ServletActionContext.getRequest();
					HttpServletResponse response=ServletActionContext.getResponse();
					try {
						request.setCharacterEncoding("utf-8");
					} catch (UnsupportedEncodingException e1) {			
						e1.printStackTrace();
					}
					response.setCharacterEncoding("utf-8");				
					List<QCloth> list=null ;
							try {
								list=singleBiz.seachByDetailBiz(clodetail);	
							} catch (Exception e) {
								
								System.out.println(e);
							}
							
					
					System.out.println(clodetail+"ִ�е�����2    8888888888888888888888888888888888");
					Gson gson=new Gson();
					String temp=gson.toJson(list);
					
					PrintWriter out=null;
					try {
						out = response.getWriter();
					} catch (IOException e) {
						
						e.printStackTrace();
					}		
				out.write(temp);				
				System.out.println("temp"+temp);
				out.flush();
				out.close();
				
			}
			//���ݼ۸�����������
			public void seachByprice(){
				System.out.println("ִ�е���һ����");
				System.out.println(cloprice);
				String price[]=cloprice.split("-");
				System.out.println(cloprice+"22222222");
				//int i=0;
				int low=Integer.parseInt(price[0]);
				int high=Integer.parseInt(price[1]);
			
				HttpServletRequest request=ServletActionContext.getRequest();
				HttpServletResponse response=ServletActionContext.getResponse();
				try {
					request.setCharacterEncoding("utf-8");
				} catch (UnsupportedEncodingException e1) {			
					e1.printStackTrace();
				}
				response.setCharacterEncoding("utf-8");				
				List<QCloth> list=null ;
						try {
							list=singleBiz.seachByPriceBiz(low, high);
						} catch (Exception e) {
							
							System.out.println(e);
						}
				
				Gson gson=new Gson();
				String temp=gson.toJson(list);
				
				PrintWriter out=null;
				try {
					out = response.getWriter();
				} catch (IOException e) {
					
					e.printStackTrace();
				}		
			out.write(temp);				
			System.out.println("�۸񣺣�������"+temp);
			out.flush();
			out.close();
				
				
			}
			
			//������������������
			public void seachBySale(){
				
				String sale[]=closale.split("-");
				
				int low=Integer.parseInt(sale[0]);
				int high=Integer.parseInt(sale[1]);
			
				HttpServletRequest request=ServletActionContext.getRequest();
				HttpServletResponse response=ServletActionContext.getResponse();
				try {
					request.setCharacterEncoding("utf-8");
				} catch (UnsupportedEncodingException e1) {			
					e1.printStackTrace();
				}
				response.setCharacterEncoding("utf-8");				
				List<QCloth> list=null ;
						try {
							list=singleBiz.seachBySaleBiz(low, high);
						} catch (Exception e) {
							
							System.out.println(e);
						}
				
				Gson gson=new Gson();
				String temp=gson.toJson(list);
				
				PrintWriter out=null;
				try {
					out = response.getWriter();
				} catch (IOException e) {
					
					e.printStackTrace();
				}		
			out.write(temp);				
			System.out.println("�۸񣺣�������"+temp);
			out.flush();
			out.close();
				
				
			}
	
	
	
	
}
