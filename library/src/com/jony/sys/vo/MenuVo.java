package com.jony.sys.vo;

import com.jony.sys.domain.Menu;

public class MenuVo extends Menu{
	
	//·ÖÒ³²ÎÊı
	private Integer page;
	private Integer limit;
	
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
	public MenuVo() {super();}

	public MenuVo(Integer id, Integer pid, String title, String href, Integer spread, String target, String icon,
			Integer available) {
		super(id, pid, title, href, spread, target, icon, available);
		// TODO Auto-generated constructor stub
	}

}
