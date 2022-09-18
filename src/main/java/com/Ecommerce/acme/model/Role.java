package com.Ecommerce.acme.model;


public enum Role {
	CLIENT("CLIENT"), ADMIN("ADMIN");

	private String text;

	private Role(String text) {

		this.text = text;
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	} 

}
