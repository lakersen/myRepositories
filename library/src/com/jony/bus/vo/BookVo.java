package com.jony.bus.vo;

import com.jony.bus.domain.Book;

public class BookVo extends Book{
		/*
		 * 分页参数
		 */
		private Integer page;

		
		private Integer limit;
		
		
		// 接收多个id
		private String[] ids;
		
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


		public String[] getIds() {
			return ids;
		}


		public void setIds(String[] ids) {
			this.ids = ids;
		}


}
