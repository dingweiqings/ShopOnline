package com.etc.biz;

import java.util.List;

import com.etc.entity.QCloth;

public interface QClothBiz1 {
	/**
	 * 根据页码和页数去做分页查询
	 * @param pagenum   页码
	 * @param pagecount   页数
	 * @return
	 */

	public  List<QCloth>  getQClothByPage(int  pagenum,int pagecount);
	
	public  int   getPageCounts(int pagecount);
	
	public boolean upLoadisOK(QCloth qCloth);
	
	public boolean deleteQClothisOK(int cloid);
}
