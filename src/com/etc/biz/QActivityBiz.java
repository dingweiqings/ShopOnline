package com.etc.biz;
import java.util.List;

import com.etc.entity.QActivity;
public interface QActivityBiz {

	public List<QActivity>  getAllActivity();
	public  boolean upLoadisOK(QActivity qActivity);
	public int insertQActivity(QActivity qActivity);
}
