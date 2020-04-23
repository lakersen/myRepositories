package com.jony.sys.service;

import com.jony.sys.domain.News;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.vo.NewsVo;

public interface NewsService {
	
	/*
	 * 查询所有公告
	 */
	public DataGridView queryAllNews(NewsVo News);
	/*
	 * 添加公告
	 */
	public void addNews(NewsVo News);
	/*
	 * 修改公告
	 */
	public void updateNews(NewsVo newsVo);
	/*
	 * 根据id删除公告
	 */
	public void deleteNews(Integer Newsid);
	/*
	 * 批量删除公告
	 */
	public void deleteBatchNews(Integer []ids);
	
	/*
	 * 查询一个公告
	 */
	public News queryNewsById(Integer id);
	

}
