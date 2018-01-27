package com.etc.dao;

import java.util.List;

import com.etc.entity.QCloth;

/**
 * ��QCloth��Ĳ���
 * @author 14322
 *
 */

public interface QClothDao1 {
	/**
	 * ����ҳ���ҳ������Ʒ���ҳ��ѯ
	 * @param pagenum ҳ��
	 * @param pagecount ҳ��
	 * @return
	 */
public List<QCloth> getQClothByPage(int pagenum,int pagecount); 

   /**
    * ��ȡ������
    * @return
    */
public int getQClothCount();
   /**
    * ��������
    * @param qCloth
    * @return
    */
public int insertQCloth(QCloth qCloth);
  /**
   * ɾ������
   * @param cloid
   * @return
   */
public int deleteQCloth(int cloid);
}
