package com.etc.dao;

import java.util.List;

import com.etc.entity.QCloth;
import com.etc.entity.QComment;

/**
 * ���ڴ��·������ݷ��ʲ�
 * @author asus
 *
 */
public interface ClothDetailDao {

	/**
	 * �����·���id��ȡ���·�
	 * @param clothid �·�id
	 * @return  ���·�
	 */
	public QCloth getClothbyID(int clothid);
	
	/**
	 * �����·�id��ȡ���·�����������
	 * @param clothid �·�id
	 * @return ���·�����������
	 */
	public long gettotalcom(int clothid);
	
	/**
	 * ��ȡ����������
	 * @param clothid
	 * @param pagecount
	 * @param pagenum
	 * @return
	 */
	public List<QComment> getcombypage(int clothid,int pagecount,int pagenum);
	
	/**
	 * �����·�id��ȡ���·�������ƽ����
	 * @param clothid �·�id
	 * @return ���·�������ƽ����
	 */
	public double getavg(int clothid);
	
	//WJZ
	/**
	 *��ʼҳ�����9����Ʒ��Ϣ
	 * @return
	 */
	public List<QCloth> seachLoad();
	/**
	 * �������������·�
	 * @return
	 */
	public List<QCloth> seachByName(String cloname);
	/**
	 * ���ݲ������� �����·�
	 * @return
	 */
	public List<QCloth> seachByType(String clotype);
	/**
	 * �������������·�
	 * @return
	 */
	public List<QCloth> seachByDetail(String clodetail);
	
	/**
	 * ���ݼ۸������·�
	 * @return
	 */
	public List<QCloth> seachByPrice(int low,int high);
	
	/**
	 * �������������·�
	 * @return
	 */
	public List<QCloth> seachBySale(int low,int high);
	
}
