package com.etc.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class FileUpUtilActivity {

	private String  realpath;//�ļ��ϴ���ŵ�·��
	private  File  newfile;
//	private String  filenameFileName;//ǰ���ļ���
	private String newfilename;

	//����һ��·������һ��·��/upload
	private  void geneRealPath(String path){
		realpath=ServletActionContext.getServletContext().getRealPath(path);
		System.out.println(" FileUpUtil 18"+realpath);
		//�������realPathȥ����Ŀ¼		
		
	}
	
	//����realpathȥ����һ��file
	private  void setFile(){
		newfile=new File(realpath);
		if(!newfile.exists()){   //�����Ӳ�������Ŀ¼�ļ����������ʵ·��������
			newfile.mkdirs();//��Ӳ���д�����ʵ��·��
		}
		
	}
	
	//�����µ��ļ���
	private  void  getNewFilename(String oldname){
	    System.out.println("FileUpUtilActivity "+oldname);
		int index1=oldname.lastIndexOf(".");
		String houzui= oldname.substring(index1);	
	   //�ӵ㿪ʼȡ,����������
		newfilename=System.currentTimeMillis()+houzui;
		//newfilename=System.currentTimeMillis()+"";
	}
	
	//��file����newfile��ȥ
	public  String uploadActivity(File oldfile,String realpath,String oldname){
		//
		try {
			geneRealPath(realpath);
			setFile();
			getNewFilename(oldname);//��oldNameתΪ���������ļ�������
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
