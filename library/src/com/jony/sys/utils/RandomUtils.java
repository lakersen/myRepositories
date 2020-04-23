package com.jony.sys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * ���������
 * @author LJH
 *
 */
public class RandomUtils {
	
	
	private static SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private static SimpleDateFormat sdf3=new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
	private static Random random=new Random();
	
	/**
	 * �õ���ǰ����
	 */
	public static String getCurrentDateForString() {
		return sdf1.format(new Date());
	}
	
	
	/**
	 * �����ļ���ʹ��ʱ��+4λ�����
	 * @param suffix �ļ�����
	 */
	public static String createFileNameUseTime(String fileName) {
		String fileSuffix=fileName.substring(fileName.lastIndexOf("."),fileName.length());
		String time=sdf2.format(new Date());
		Integer num=random.nextInt(9000)+1000;
		return time+num+fileSuffix;
	}
	/**
	 * �����ļ���ʹ��ʱ��+4λ�����+��ʱ��׺
	 * @param fileName �ļ�����
	 * @param suffix   ��ʱ�ļ���׺
	 */
	public static String createFileNameUseTime(String fileName,String suffix) {
		String fileSuffix=fileName.substring(fileName.lastIndexOf("."),fileName.length());
		String time=sdf2.format(new Date());
		Integer num=random.nextInt(9000)+1000;
		return time+num+fileSuffix+suffix;
	}
	
	/**
	 * �����ļ���ʹ��UUID
	 * @param suffix �ļ�����
	 */
	public static String createFileNameUseUUID(String fileName) {
		String fileSuffix=fileName.substring(fileName.lastIndexOf("."),fileName.length());
		return UUID.randomUUID().toString().replace("-", "").toUpperCase()+fileSuffix;
	}


	/**
	 * ����ʱ��+��λ��������ַ���
	 * @param preffx
	 * @return
	 */
	public static String createRandomStringUseTime(String preffx) {
		return preffx+"_"+sdf3.format(new Date())+"_"+(random.nextInt(90000)+10000);
	}
	
}
