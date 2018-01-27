package com.etc.biz;

import java.util.List;

import com.etc.entity.QCloth;

public interface QClothBiz {
	/**
	 * 分页显示服装
	 * @param pagenum
	 * @param pagecount
	 * @return 
	 */
   public List<QCloth> getClothByPage(int pagenum,int pagecount);
   /**
    * 获取总页数
    * @param pagecount
    */
   public int getTotalPages(int pagecount);
   
  
}
