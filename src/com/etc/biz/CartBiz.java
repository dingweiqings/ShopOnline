package com.etc.biz;

public interface CartBiz {

	/**
	 * �����Ʒ�����ﳵ
	 * @param userid �û�id
	 * @param cloid ��Ʒid
	 * @param clonum ��Ʒ����
	 * @param closize ��Ʒ����
	 * @return ��ӽ��
	 */
	public String addclo(int userid,int cloid,int clonum,int closize);
}
