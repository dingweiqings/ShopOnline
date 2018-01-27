package com.etc.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class FileUpUtilActivity {

	private String  realpath;//文件上传存放的路径
	private  File  newfile;
//	private String  filenameFileName;//前端文件名
	private String newfilename;

	//根据一个路径生成一个路径/upload
	private  void geneRealPath(String path){
		realpath=ServletActionContext.getServletContext().getRealPath(path);
		System.out.println(" FileUpUtil 18"+realpath);
		//根据这个realPath去创建目录		
		
	}
	
	//根据realpath去创建一个file
	private  void setFile(){
		newfile=new File(realpath);
		if(!newfile.exists()){   //如果在硬盘中这个目录文件所代表的真实路径不存在
			newfile.mkdirs();//在硬盘中创建真实的路径
		}
		
	}
	
	//生成新的文件名
	private  void  getNewFilename(String oldname){
	    System.out.println("FileUpUtilActivity "+oldname);
		int index1=oldname.lastIndexOf(".");
		String houzui= oldname.substring(index1);	
	   //从点开始取,但不包括点
		newfilename=System.currentTimeMillis()+houzui;
		//newfilename=System.currentTimeMillis()+"";
	}
	
	//将file传到newfile中去
	public  String uploadActivity(File oldfile,String realpath,String oldname){
		//
		try {
			geneRealPath(realpath);
			setFile();
			getNewFilename(oldname);//把oldName转为服务器上文件的名字
			try {
				//FileUtils.copyFileToDirectory(oldfile, new File(newfile, newfilename));
				FileUtils.copyFile(oldfile, new File(newfile, newfilename));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return newfilename;
		
	}

	
	
}
