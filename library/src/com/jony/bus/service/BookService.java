package com.jony.bus.service;

import com.jony.bus.domain.Book;
import com.jony.bus.vo.BookVo;
import com.jony.sys.utils.DataGridView;

/**
 * 图书管理的服务接口
 * @author LJH
 *
 */
public interface BookService {
	/**
	 * 查询所有图书
	 * @param CarVo
	 * @return
	 */
	public DataGridView queryAllCar(BookVo carVo);
	/**
	 * 添加图书
	 * @param CarVo
	 */
	public void addCar(BookVo carVo);
	/**
	 * 修改图书
	 * @param CarVo
	 */
	public void updateCar(BookVo carVo);
	/**
	 * 根据id删除图书
	 * @param Carid
	 */
	public void deleteCar(String carnumber);
	/**
	 * 批量删除图书
	 * @param CarVo
	 */
	public void deleteBatchCar(String [] carnumbers);
	
	public Book queryCarByCarNumber(String carnumber);

}
