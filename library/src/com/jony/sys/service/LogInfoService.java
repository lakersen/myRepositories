package com.jony.sys.service;

import com.jony.sys.utils.DataGridView;
import com.jony.sys.vo.LogInfoVo;

public interface LogInfoService {
	
	/*
	 * ��ѯ������־
	 */
	public DataGridView queryAllLogInfo(LogInfoVo logInfo);
	/*
	 * �����־
	 */
	public void addLogInfo(LogInfoVo logInfo);
	/*
	 * ����idɾ����־
	 */
	public void deleteLogInfo(Integer logInfoid);
	/*
	 * ����ɾ����־
	 */
	public void deleteBatchLogInfo(Integer []ids);

}
