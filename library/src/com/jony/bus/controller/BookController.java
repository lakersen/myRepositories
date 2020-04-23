package com.jony.bus.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jony.bus.domain.Book;
import com.jony.bus.service.BookService;
import com.jony.bus.vo.BookVo;
import com.jony.sys.constast.SysConstast;
import com.jony.sys.utils.AppFileUtils;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.utils.ResultObj;



/**
 * 图书管理控制器
 * 
 * @author LJH
 *
 */
@RestController
@RequestMapping("car")
public class BookController {

	@Autowired
	private BookService carService;

	/**
	 * 加载图书列表返回DataGridView
	 */
	@RequestMapping("loadAllCar")
	public DataGridView loadAllCar(BookVo carVo) {
		return this.carService.queryAllCar(carVo);
	}

	/**
	 * 添加图书
	 */
	@RequestMapping("addCar")
	public ResultObj addCar(BookVo carVo) {
		try {
			carVo.setCreatetime(new Date());
			//如果不是默认图片就去掉图片的_temp的后缀
			if(!carVo.getCarimg().equals(SysConstast.DEFAULT_CAR_IMG)) {
				String filePath=AppFileUtils.updateFileName(carVo.getCarimg(),SysConstast.FILE_UPLOAD_TEMP);
				carVo.setCarimg(filePath);
			}
			this.carService.addCar(carVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}

	/**
	 * 修改图书
	 */
	@RequestMapping("updateCar")
	public ResultObj updateCar(BookVo carVo) {
		try {
			String carimg = carVo.getCarimg();
			if(carimg.endsWith(SysConstast.FILE_UPLOAD_TEMP)) {
				String filePath=AppFileUtils.updateFileName(carVo.getCarimg(),SysConstast.FILE_UPLOAD_TEMP);
				carVo.setCarimg(filePath);
				//把原来的删除
				Book car=this.carService.queryCarByCarNumber(carVo.getCarnumber());
				AppFileUtils.removeFileByPath(car.getCarimg());
			}
			this.carService.updateCar(carVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}

	/**
	 * 删除图书
	 */
	@RequestMapping("deleteCar")
	public ResultObj deleteCar(BookVo carVo) {
		try {
			this.carService.deleteCar(carVo.getCarnumber());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}

	/**
	 * 批量删除图书
	 */
	@RequestMapping("deleteBatchCar")
	public ResultObj deleteBatchCar(BookVo carVo) {
		try {
			this.carService.deleteBatchCar(carVo.getIds());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
}
