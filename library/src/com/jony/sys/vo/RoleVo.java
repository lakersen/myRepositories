package com.jony.sys.vo;

import com.jony.sys.domain.Role;

public class RoleVo extends Role{

	/*
	 * ��ҳ����
	 */
	private Integer page;
	
	private Integer limit;
	
	//���ܶ����ɫid
	private Integer []ids;
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
}
