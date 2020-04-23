package com.jony.sys.utils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TreeNode {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Boolean getSpread() {
		return spread;
	}

	public void setSpread(Boolean spread) {
		this.spread = spread;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	

	public String getCheckArr() {
		return checkArr;
	}

	public void setCheckArr(String checkArr) {
		this.checkArr = checkArr;
	}

	public TreeNode( Integer id, Integer pid, String title, Boolean spread,String checkArr) {
		super();
		this.checkArr = checkArr;
		this.id = id;
		this.pid = pid;
		this.title = title;
		this.spread = spread;
	}

	//��ѡ���ı�Ҫ����
	private String checkArr="0";//ѡ�о���1
	private Integer id;
	
	@JsonProperty("parentId")
	private Integer pid;
	
	private String title;
	private String icon;
	private String href;
	private Boolean spread;
	private String target;
	private List<TreeNode> children = new ArrayList<>();

	/**
	 * ��ҳ��ߵ������Ĺ�����
	 * 
	 * @param id
	 * @param pid
	 * @param title
	 * @param icon
	 * @param href
	 * @param spread
	 * @param target
	 */
	public TreeNode(Integer id, Integer pid, String title, String icon, String href, Boolean spread, String target) {
		super();
		this.id = id;
		this.pid = pid;
		this.title = title;
		this.icon = icon;
		this.href = href;
		this.spread = spread;
		this.target = target;
	}

}
