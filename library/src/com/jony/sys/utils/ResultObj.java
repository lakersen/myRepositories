package com.jony.sys.utils;

import com.jony.sys.constast.SysConstast;

public class ResultObj {
	
	
	private Integer code=0;
	private String msg;
	
	/**
	 * ��ӳɹ�
	 */
	public static final ResultObj ADD_SUCCESS=new ResultObj(SysConstast.CODE_SUCCESS, SysConstast.ADD_SUCCESS); 
	/**
	 * ���ʧ��
	 */
	public static final ResultObj ADD_ERROR=new ResultObj(SysConstast.CODE_ERROR, SysConstast.ADD_ERROR); 
	/**
	 * ���³ɹ�
	 */
	public static final ResultObj UPDATE_SUCCESS=new ResultObj(SysConstast.CODE_SUCCESS, SysConstast.UPDATE_SUCCESS); 
	/**
	 * ����ʧ��
	 */
	public static final ResultObj UPDATE_ERROR=new ResultObj(SysConstast.CODE_ERROR, SysConstast.UPDATE_ERROR); 
	/**
	 * ɾ���ɹ�
	 */
	public static final ResultObj DELETE_SUCCESS=new ResultObj(SysConstast.CODE_SUCCESS, SysConstast.DELETE_SUCCESS); 
	/**
	 * ɾ��ʧ��
	 */
	public static final ResultObj DELETE_ERROR=new ResultObj(SysConstast.CODE_ERROR, SysConstast.DELETE_ERROR); 
	
	/**
	 * ���óɹ�
	 */
	public static final ResultObj RESET_SUCCESS=new ResultObj(SysConstast.CODE_SUCCESS, SysConstast.RESET_SUCCESS); 
	/**
	 * ����ʧ��
	 */
	public static final ResultObj RESET_ERROR=new ResultObj(SysConstast.CODE_ERROR, SysConstast.RESET_ERROR); 
	/**
	 * ����ɹ�
	 */
	public static final ResultObj DISPATCH_SUCCESS=new ResultObj(SysConstast.CODE_SUCCESS, SysConstast.DISPATCH_SUCCESS); 
	/**
	 * ����ʧ��
	 */
	public static final ResultObj DISPATCH_ERROR=new ResultObj(SysConstast.CODE_ERROR, SysConstast.DISPATCH_ERROR); 
	

	/**
	 * ״̬��0
	 */
	public static final ResultObj STATUS_TRUE=new ResultObj(SysConstast.CODE_SUCCESS); 
	/**
	 * ״̬��-1
	 */
	public static final ResultObj STATUS_FALSE=new ResultObj(SysConstast.CODE_ERROR); 

	
	
	private ResultObj(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	private ResultObj(Integer code) {
		super();
		this.code = code;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	

}
