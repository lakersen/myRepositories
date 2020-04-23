package com.jony.bus.service;

import com.jony.bus.domain.Book;
import com.jony.bus.vo.BookVo;
import com.jony.sys.utils.DataGridView;

/**
 * ͼ�����ķ���ӿ�
 * @author LJH
 *
 */
public interface BookService {
	/**
	 * ��ѯ����ͼ��
	 * @param CarVo
	 * @return
	 */
	public DataGridView queryAllCar(BookVo carVo);
	/**
	 * ���ͼ��
	 * @param CarVo
	 */
	public void addCar(BookVo carVo);
	/**
	 * �޸�ͼ��
	 * @param CarVo
	 */
	public void updateCar(BookVo carVo);
	/**
	 * ����idɾ��ͼ��
	 * @param Carid
	 */
	public void deleteCar(String carnumber);
	/**
	 * ����ɾ��ͼ��
	 * @param CarVo
	 */
	public void deleteBatchCar(String [] carnumbers);
	
	public Book queryCarByCarNumber(String carnumber);

}
