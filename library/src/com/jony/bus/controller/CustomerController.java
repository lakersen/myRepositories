package com.jony.bus.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jony.bus.service.CustomerService;
import com.jony.bus.vo.CustomerVo;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.utils.ResultObj;

/**
 * �ͻ����������
 * 
 * @author LJH
 *
 */
@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * ���ؿͻ��б���DataGridView
	 */
	@RequestMapping("loadAllCustomer")
	public DataGridView loadAllCustomer(CustomerVo customerVo) {
		return this.customerService.queryAllCustomer(customerVo);
	}
	
	/**
	 * ��ӿͻ�
	 */
	@RequestMapping("addCustomer")
	public ResultObj addCustomer(CustomerVo customerVo) {
		try {
			customerVo.setCreatetime(new Date());
			this.customerService.addCustomer(customerVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	/**
	 * �޸Ŀͻ�
	 */
	@RequestMapping("updateCustomer")
	public ResultObj updateCustomer(CustomerVo customerVo) {
		try {
			this.customerService.updateCustomer(customerVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}

	/**
	 * ɾ���ͻ�
	 */
	@RequestMapping("deleteCustomer")
	public ResultObj deleteCustomer(CustomerVo customerVo) {
		try {
			this.customerService.deleteCustomer(customerVo.getIdentity());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}

	/**
	 * ����ɾ���ͻ�
	 */
	@RequestMapping("deleteBatchCustomer")
	public ResultObj deleteBatchCustomer(CustomerVo customerVo) {
		try {
			this.customerService.deleteBatchCustomer(customerVo.getIds());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
}
