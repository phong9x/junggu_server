package org.trams.junggu.rest.common;

public class ReturnValue {
	public Object value=null;
    public String message="";
    public Integer code=200;

    public void ReturningValue(Object value, String message,Integer code) {
        this.value = value;
        this.message = message;
        this.code = code;
    }
    public void ReturningObject(Object value)
    {
    	this.value = value;
        this.code =200;
        this.message="success";
    	
    }
    public void ReturningString(String message,Integer code)
    {
    	this.message = message;
    	this.code = code;
        value=null;
    }
    public void ReturningException()
    {
    	message = Message.EXCEPTION_ERROR;
    	code = Message.EXCEPTION_ERROR_CODE;
        value=null;
    }
}
