package com.etc.biz;

import java.util.List;

import com.etc.entity.QCloth;

public interface QClothBiz {
	/**
	 * ��ҳ��ʾ��װ
	 * @param pagenum
	 * @param pagecount
	 * @return 
	 */
   public List<QCloth> getClothByPage(int pagenum,int pagecount);
   /**
    * ��ȡ��ҳ��
    * @param pagecount
    */
   public int getTotalPages(int pagecount);
   
  
}
