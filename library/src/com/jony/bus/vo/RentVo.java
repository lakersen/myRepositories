package com.jony.bus.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.jony.bus.domain.Rent;

public class RentVo extends Rent{
	
	/*
	 * ʱ��
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	/*
	 * ��ҳ����
	 */
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

}
