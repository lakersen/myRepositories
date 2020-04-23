package com.jony.bus.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jony.bus.domain.Rent;
import com.jony.bus.service.CheckService;
import com.jony.bus.service.RentService;
import com.jony.bus.vo.CheckVo;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.utils.ResultObj;



/**
 * ��鵥����Ŀ�����
 * @author LJH
 *
 */
@RestController
@RequestMapping("check")
public class CheckController {
	
	@Autowired
	private RentService rentService;
	
	@Autowired
	private CheckService checkService;
	
	/***
	 * ���ݳ��ⵥ�Ų�ѯ���ⵥ��Ϣ
	 */
	@RequestMapping("checkRentExist")
	public Rent checkRentExist(String rentid) {
		Rent rent=rentService.queryRentByRentId(rentid);//null   ���ض���
		return rent;
	}
	
	
	/**
	 * ���ݳ��ⵥ�ż��ؼ�鵥�ı�����
	 */
	@RequestMapping("initCheckFormData")
	public Map<String,Object> initCheckFormData(String rentid){
		return this.checkService.initCheckFormData(rentid);
	}
	
	/**
	 * �����鵥����
	 */
	@RequestMapping("saveCheck")
	public ResultObj saveCheck(CheckVo checkVo) {
		try {
			checkVo.setCreatetime(new Date());
			this.checkService.addCheck(checkVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	
	/**
	 * ��ѯ
	 * @param checkVo
	 * @return
	 */
	@RequestMapping("loadAllCheck")
	public DataGridView loadAllCheck(CheckVo checkVo) {
		return this.checkService.queryAllCheck(checkVo);
	}
	
	/**
	 * �޸ļ�鵥����
	 */
	@RequestMapping("updateCheck")
	public ResultObj updateCheck(CheckVo checkVo) {
		try {
			this.checkService.updateCheck(checkVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}

}
