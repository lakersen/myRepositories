package com.jony.sys.service;

import com.jony.sys.utils.DataGridView;
import com.jony.sys.vo.LogInfoVo;

public interface LogInfoService {
	
	/*
	 * 查询所有日志
	 */
	public DataGridView queryAllLogInfo(LogInfoVo logInfo);
	/*
	 * 添加日志
	 */
	public void addLogInfo(LogInfoVo logInfo);
	/*
	 * 根据id删除日志
	 */
	public void deleteLogInfo(Integer logInfoid);
	/*
	 * 批量删除日志
	 */
	public void deleteBatchLogInfo(Integer []ids);

}
