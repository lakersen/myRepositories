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
 * ͼ����������
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
	 * ����ͼ���б���DataGridView
	 */
	@RequestMapping("loadAllCar")
	public DataGridView loadAllCar(BookVo carVo) {
		return this.carService.queryAllCar(carVo);
	}

	/**
	 * ���ͼ��
	 */
	@RequestMapping("addCar")
	public ResultObj addCar(BookVo carVo) {
		try {
			carVo.setCreatetime(new Date());
			//�������Ĭ��ͼƬ��ȥ��ͼƬ��_temp�ĺ�׺
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
	 * �޸�ͼ��
	 */
	@RequestMapping("updateCar")
	public ResultObj updateCar(BookVo carVo) {
		try {
			String carimg = carVo.getCarimg();
			if(carimg.endsWith(SysConstast.FILE_UPLOAD_TEMP)) {
				String filePath=AppFileUtils.updateFileName(carVo.getCarimg(),SysConstast.FILE_UPLOAD_TEMP);
				carVo.setCarimg(filePath);
				//��ԭ����ɾ��
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
	 * ɾ��ͼ��
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
	 * ����ɾ��ͼ��
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
