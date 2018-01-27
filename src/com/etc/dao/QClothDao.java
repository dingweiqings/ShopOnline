package com.etc.dao;

import java.util.List;

import com.etc.entity.QCloth;

public interface QClothDao {
	/**
	 * 分页显示服装
	 * @param pagenum
	 * @param pagecount
	 */
   public List<QCloth> getClothByPage(int pagenum,int pagecount);
   /**
    * 获取总页数
    * @param pagecount
    */
   public int getTotalPages(int pagecount);
   
   /**
	 * 根据页码和页数对商品表分页查询
	 * @param pagenum 页码
	 * @param pagecount 页数
	 * @return
	 *//*
public List<QCloth> getQClothByPage(int pagenum,int pagecount); 

  *//**
   * 获取总数量
   * @return
   *//*
public int getQClothCount();
  *//**
   * 插入数据
   * @param qCloth
   * @return
   *//*
public int insertQCloth(QCloth qCloth);
 *//**
  * 删除数据
  * @param cloid
  * @return
  *//*
public int deleteQCloth(int cloid);*/
}
