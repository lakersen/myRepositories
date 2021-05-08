package com.jony.sys.service;

import com.jony.sys.domain.News;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.vo.NewsVo;

public interface NewsService {
	
	/*
	 * ��ѯ���й���
	 */
	public DataGridView queryAllNews(NewsVo News);
	/*
	 * ���ӹ���
	 */
	public void addNews(NewsVo News);
	/*
	 * �޸Ĺ���
	 */
	public void updateNews(NewsVo newsVo);
	/*
	 * ����idɾ������
	 */
	public void deleteNews(Integer Newsid);
	/*
	 * ����ɾ������
	 */
	public void deleteBatchNews(Integer []ids);
	
	/*
	 * ��ѯһ������
	 */
	public News queryNewsById(Integer id);
	

}