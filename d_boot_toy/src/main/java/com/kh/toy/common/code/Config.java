package com.kh.toy.common.code;

public enum Config {
	
	//DOMAIN("https://pclass.ga"),
	DOMAIN("http://localhost:9090"),
	COMPANY_EMAIL("alssgo70051@gmail.com"),
	SMTP_AUTHENTICATION_ID("alssgo70051@gmail.com"),
	SMTP_AUTHENTICATION_PASSWORD("1234"),
	//UPLOAD_PATH("C:\\CODE\\before\\"),
	UPLOAD_PATH("C:\\CODE\\before\\upload\\");

	public final String DESC;
	
	Config(String desc) {
		this.DESC = desc;
	}

	
	
}
