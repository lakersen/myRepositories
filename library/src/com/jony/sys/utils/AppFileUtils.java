package com.jony.sys.utils;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;



public class AppFileUtils {
	
	/**
	 * �õ��ļ��ϴ���·��
	 */
	public static String PATH="D:/upload/";
	static {
		InputStream stream = AppFileUtils.class.getClassLoader().getResourceAsStream("file.properties");
		Properties properties=new Properties();
		try {
			properties.load(stream);
			PATH=properties.getProperty("path");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * �ļ�����
	 * @param response
	 * @param path
	 * @param oldName
	 * @return
	 */
	public static  ResponseEntity<Object> downloadFile(HttpServletResponse response, String path, String oldName) {
		//4,ʹ�þ���·��+���·��ȥ�ҵ��ļ�����
		File file=new File(AppFileUtils.PATH,path);
		//5,�ж��ļ��Ƿ����
		if(file.exists()) {
			try {
				try {
					//������������� Ҫ�������
					oldName=URLEncoder.encode(oldName, "UTF-8");
				} catch (Exception e) {
					e.printStackTrace();
				}
				//��fileת��һ��bytes
				byte [] bytes=FileUtils.readFileToByteArray(file);
				HttpHeaders header=new HttpHeaders();
				//��װ��Ӧ��������(APPLICATION_OCTET_STREAM ��Ӧ�����ݲ��޶�)
				header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				//�������ص��ļ�������
				header.setContentDispositionFormData("attachment", oldName);
				//����ResponseEntity����
				ResponseEntity<Object> entity=
						new ResponseEntity<Object>(bytes, header, HttpStatus.CREATED);
				return entity;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}else {
			PrintWriter out;
			try {
				out = response.getWriter();
				out.write("�ļ�������");
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}


	/**
	 * �������·��ɾ��Ӳ�����ļ�
	 * @param path2
	 */
	public static void deleteFileUsePath(String path) {
		String realPath=PATH+path;
		//�����ļ�
		File file=new File(realPath);
		if(file.exists()) {
			file.delete();
		}
	}


	/**
	 * �����ļ���
	 * @param carimg
	 */
	public static String updateFileName(String carimg,String suffix) {
		//�ҵ��ļ�
		try {
			File file=new File(PATH,carimg);
			if(file.exists()) {
				file.renameTo(new File(PATH,carimg.replace(suffix, "")));
				return carimg.replace(suffix, "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * ����·�� ɾ��ͼƬ
	 * @param carimg
	 */
	public static void removeFileByPath(String carimg) {
		try {
			File file=new File(PATH,carimg);
			if(file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
