package com.jony.sys.task;

import java.io.File;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jony.sys.constast.SysConstast;
import com.jony.sys.utils.AppFileUtils;

@Component
@EnableScheduling  //������ʱ����
public class RecyleTempFileTask {
	
	/**
	 * ÿ������12��ִ��
	 */
	@Scheduled(cron="0 0 0 * * ? ")
	public void recyleTempFile() {
		File file=new File(AppFileUtils.PATH);
		deleteFile(file);
	}
	
	/**
	 * ɾ��ͼƬ
	 * @param file
	 */
	public void deleteFile(File file) {
		if(null!=file) {
			File[] listFiles = file.listFiles();
			if(null!=listFiles&&listFiles.length>0) {
				for (File f : listFiles) {
					if(f.isFile()) {
						if(f.getName().endsWith(SysConstast.FILE_UPLOAD_TEMP)) {
							f.delete();
						}
					}else {
						//������ļ��У��ٵݹ�ɾ��
						deleteFile(f);
					}
				}
			}
		}
	}

}
