package com.niit.Model;

public class Errorclass {

	private int errorcode;
	private String errormsg;
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public Errorclass(int errorcode, String errormsg) {
		super();
		this.errorcode = errorcode;
		this.errormsg = errormsg;
	}
	
	
	
}


