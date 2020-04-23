package com.jony.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bus")
public class BusController {
	
	/*
	 * ��ת���ͻ�����ҳ��
	 */
	@RequestMapping("toCustomerManager")
	public String toCustomerManager() {
		return "business/customer/customerManager";
	}
	
	/*
	 * ��ת����������ҳ��
	 */
	@RequestMapping("toCarManager")
	public String toCarManager() {
		return "business/car/carManager";
	}

	/*
	 * ��ת����������ҳ��
	 */
	@RequestMapping("toRentCarManager")
	public String toRentCarManager() {
		return "business/rent/rentCarManager";
	}
	
	/*
	 * ��ת�����ⵥ����ҳ��
	 */
	@RequestMapping("toRentManager")
	public String toRentManager() {
		return "business/rent/rentManager";
	}
	
	/*
	 * ��ת�������������ҳ��
	 */
	@RequestMapping("toCheckCarManager")
	public String toCheckCarManager() {
		return "business/check/checkCarManager";
	}
	
	/*
	 * ��ת����鵥�����ҳ��
	 */
	@RequestMapping("toCheckManager")
	public String toCheckManager() {
		return "business/check/checkManager";
	}
}
