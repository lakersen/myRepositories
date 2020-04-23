package com.jony.bus.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jony.sys.constast.SysConstast;
import com.jony.sys.utils.AppFileUtils;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.utils.RandomUtils;


/**
 * �ļ��ϴ����صĿ�����
 * 
 * @author LJH
 *
 */
@Controller
@RequestMapping("file")
public class FileController {

	/**
	 * ���
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping("uploadFile")
	@ResponseBody
	public DataGridView uploadFile(MultipartFile mf) throws IllegalStateException, IOException {
		// �ļ��ϴ��ĸ�Ŀ¼
		String parentPath = AppFileUtils.PATH;
		// �õ���ǰ������Ϊ�ļ�������
		String dirName = RandomUtils.getCurrentDateForString();
		// �����ļ��ж���
		File dirFile = new File(parentPath, dirName);
		if (!dirFile.exists()) {
			dirFile.mkdirs();// �����ļ���
		}
		// �õ��ļ�ԭ��
		String oldName = mf.getOriginalFilename();
		// �����ļ�ԭ���õ�����
		String newName = RandomUtils.createFileNameUseTime(oldName,SysConstast.FILE_UPLOAD_TEMP);
		File dest = new File(dirFile, newName);
		mf.transferTo(dest);
		
		Map<String,Object> map=new HashMap<>();
		map.put("src", dirName+"/"+newName);
		return new DataGridView(map);
		
	}
	/**
	 * ������ֻ��ʾ
	 */
	@RequestMapping("downloadShowFile")
	public ResponseEntity<Object> downloadShowFile(String path, HttpServletResponse response) {
		return AppFileUtils.downloadFile(response, path, "");	
	}
	
	/**
	 * ����ͼƬ
	 * @param path
	 * @param response
	 * @return
	 */
	@RequestMapping("downloadFile")
	public ResponseEntity<Object> downloadFile(String path, HttpServletResponse response) {
		String oldName="";
		return AppFileUtils.downloadFile(response, path, oldName);	
	}

}
