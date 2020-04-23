package com.jony.bus.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jony.bus.domain.Customer;
import com.jony.bus.service.CustomerService;
import com.jony.bus.service.RentService;
import com.jony.bus.vo.RentVo;
import com.jony.sys.constast.SysConstast;
import com.jony.sys.domain.User;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.utils.RandomUtils;
import com.jony.sys.utils.ResultObj;
import com.jony.sys.utils.WebUtils;



/**
 * �����������Ŀ�����
 * @author LJH
 *
 */
@RestController
@RequestMapping("rent")
public class RentController {

	@Autowired
	private RentService rentService;
	
	@Autowired
	private CustomerService customerService;
	
	
	/**
	 * ������֤���Ƿ����
	 */
	@RequestMapping("checkCustomerExist")
	public ResultObj checkCustomerExist(RentVo rentVo) {
		Customer customer=customerService.queryCustomerByIdentity(rentVo.getIdentity());
		if(null!=customer) {
			return ResultObj.STATUS_TRUE;
		}else {
			return ResultObj.STATUS_FALSE;
		}
	}
	
	/**
	 * ��ʼ����ӳ��ⵥ�ı�����
	 */
	@RequestMapping("initRentFrom")
	public RentVo initRentFrom(RentVo rentVo) {
		//���ɳ��ⵥ��
		rentVo.setRentid(RandomUtils.createRandomStringUseTime(SysConstast.CAR_ORDER_CZ));
		//��������ʱ��
		rentVo.setBegindate(new Date());
		User user=(User) WebUtils.getHttpSession().getAttribute("user");
		//�������֤
		rentVo.setIdentity(rentVo.getIdentity());
		//���ò���Ա
		rentVo.setOpername(user.getRealname());
		return rentVo;
	}
	
	/**
	 * ������ⵥ��Ϣ
	 */
	@RequestMapping("saveRent")
	public ResultObj saveRent(RentVo rentVo) {
		try {
			//���ô���ʱ��
			rentVo.setCreatetime(new Date());
			//���ù黹״̬
			rentVo.setRentflag(SysConstast.RENT_BACK_FALSE);
			
			//����
			this.rentService.addRent(rentVo);
			
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	
	
	/***************���ⵥ����*****************/
	
	/**
	 * ��ѯ
	 */
	@RequestMapping("loadAllRent")
	public DataGridView loadAllRent(RentVo rentVo) {
		return this.rentService.queryAllRent(rentVo);
	}
	
	
	/**
	 * �޸ĳ��ⵥ��Ϣ
	 */
	@RequestMapping("updateRent")
	public ResultObj updateRent(RentVo rentVo) {
		try {
			//����
			this.rentService.updateRent(rentVo);
			
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}
	

	/**
	 * ɾ���ⵥ��Ϣ
	 */
	@RequestMapping("deleteRent")
	public ResultObj deleteRent(RentVo rentVo) {
		try {
			this.rentService.deleteRent(rentVo.getRentid());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
	
	
	
	
}
