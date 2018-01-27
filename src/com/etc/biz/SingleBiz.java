package com.etc.biz;

import java.util.List;

import com.etc.entity.QCloth;
import com.etc.entity.QComment;

public interface SingleBiz {

	/**
	 * ���ݷ�װid��ȡ�÷�װ
	 * @param clothid ��װid
	 * @return �÷�װ
	 */
	public QCloth getClothbyID(int clothid);
	
	/**
	 * ��ȡ���۵���ҳ��
	 * @param clothid ��װid
	 * @param pagecount ÿҳ����Ϣ��
	 * @return ��ҳ��
	 */
	public int getcompage(int clothid,int pagecount);
	
	/**
	 * ����ҳ����ȡ��ҳ����������
	 * @param clothid ��װid
	 * @param pagecount ÿҳ����Ϣ��
	 * @param pagenum �ڼ�ҳ
	 * @return ���ۼ���
	 */
	public List<QComment> getcomsbypage(int clothid,int pagecount,int pagenum);
	
	/**
	 * �����·�id��ȡ���·�����������
	 * @param clothid �·�id
	 * @return ���·�����������
	 */
	public int gettotalcoms(int clothid);
	
	/**
	 * �����·�id��ȡ���·���ƽ������
	 * @param clothid �·�id
	 * @return ���·���ƽ������
	 */
	public int getavggra(int clothid);
	
	
	
	//WJZ
	

	
	/**
	 * ҳ�����9
	 * @return
	 */
	public List<QCloth> seachLoadBiz();
	

	/**
	 * �������������·�
	 * @return
	 */
	public List<QCloth> seachByNameBiz(String cloname);
	
	/**
	 * ���ݲ������� �����·�
	 * @return
	 */
	public List<QCloth> seachByTypeBiz(String clotype);
	/**
	 * �������������·�
	 * @return
	 */
	public List<QCloth> seachByDetailBiz(String clodetail);
	
	/**
	 * ���ݼ۸������·�
	 * @return
	 */
	public List<QCloth> seachByPriceBiz(int low,int high);
	/**
	 * ���ݼ۸������·�
	 * @return
	 */
	public List<QCloth> seachBySaleBiz(int low,int high);
	
}
