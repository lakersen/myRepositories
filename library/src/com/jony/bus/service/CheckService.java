package com.jony.bus.service;

import java.util.Map;

import com.jony.bus.vo.CheckVo;
import com.jony.sys.utils.DataGridView;



/**
 * ��鵥����ķ������ӿ�
 * @author LJH
 *
 */
public interface CheckService {
	/**
	 * ���ݳ��ⵥ�ż��ؼ�鵥�ı�����
	 * @param rentid
	 * @return
	 */
	Map<String, Object> initCheckFormData(String rentid);

	/**
	 * �����鵥����
	 * @param checkVo
	 */
	void addCheck(CheckVo checkVo);
	
	/**
	 * ��ѯ
	 */
	DataGridView queryAllCheck(CheckVo checkVo);

	/**
	 * �޸ļ�鵥
	 * @param checkVo
	 */
	void updateCheck(CheckVo checkVo);

}
