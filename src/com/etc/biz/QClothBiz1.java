package com.etc.biz;

import java.util.List;

import com.etc.entity.QCloth;

public interface QClothBiz1 {
	/**
	 * ����ҳ���ҳ��ȥ����ҳ��ѯ
	 * @param pagenum   ҳ��
	 * @param pagecount   ҳ��
	 * @return
	 */

	public  List<QCloth>  getQClothByPage(int  pagenum,int pagecount);
	
	public  int   getPageCounts(int pagecount);
	
	public boolean upLoadisOK(QCloth qCloth);
	
	public boolean deleteQClothisOK(int cloid);
}
