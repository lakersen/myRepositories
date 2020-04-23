package com.jony.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jony.bus.domain.Book;
import com.jony.bus.mapper.BookMapper;
import com.jony.bus.service.BookService;
import com.jony.bus.vo.BookVo;
import com.jony.sys.constast.SysConstast;
import com.jony.sys.utils.AppFileUtils;
import com.jony.sys.utils.DataGridView;


@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper carMapper;

	@Override
	public DataGridView queryAllCar(BookVo carVo) {
		Page<Object> page=PageHelper.startPage(carVo.getPage(), carVo.getLimit());
		List<Book> data = this.carMapper.queryAllCar(carVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public void addCar(BookVo carVo) {
		this.carMapper.insertSelective(carVo);
	}

	@Override
	public void deleteCar(String carnumber) {
		//先删除图片
		Book car=this.carMapper.selectByPrimaryKey(carnumber);
		//如果不是默认图片就删除
		if(!car.getCarimg().equals(SysConstast.DEFAULT_CAR_IMG)) {
			AppFileUtils.deleteFileUsePath(car.getCarimg());
		}
		//删除数据库的数据
		this.carMapper.deleteByPrimaryKey(carnumber);
		
	}

	@Override
	public void deleteBatchCar(String[] carnumbers) {
		for (String carnumber : carnumbers) {
			this.deleteCar(carnumber);
		}
	}

	@Override
	public void updateCar(BookVo carVo) {
		this.carMapper.updateByPrimaryKeySelective(carVo);
	}

	@Override
	public Book queryCarByCarNumber(String carnumber) {
		return this.carMapper.selectByPrimaryKey(carnumber);
	}


}
