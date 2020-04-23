package com.jony.bus.service;

import com.jony.bus.domain.Customer;
import com.jony.bus.vo.CustomerVo;
import com.jony.sys.utils.DataGridView;

/**
 * �ͻ�����ķ���ӿ�
 * @author LJH
 *
 */
public interface CustomerService {
	/**
	 * ��ѯ���пͻ�
	 * @param customerVo
	 * @return
	 */
	public DataGridView queryAllCustomer(CustomerVo customerVo);
	/**
	 * ��ӿͻ�
	 * @param customerVo
	 */
	public void addCustomer(CustomerVo customerVo);
	/**
	 * �޸Ŀͻ�
	 * @param customerVo
	 */
	public void updateCustomer(CustomerVo customerVo);
	/**
	 * ����idɾ���ͻ�
	 * @param customerid
	 */
	public void deleteCustomer(String identity);
	/**
	 * ����ɾ���ͻ�
	 * @param customerVo
	 */
	public void deleteBatchCustomer(String [] identitys);
	
	/*
	 *�������֤�Ų�ѯ�ͻ���Ϣ
	 */
	public Customer queryCustomerByIdentity(String identity);

}
