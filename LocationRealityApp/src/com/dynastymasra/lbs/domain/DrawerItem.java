package com.dynastymasra.lbs.domain;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
public class DrawerItem {

	private String ItemName;
	private Integer imgResID;
	private String title;

	public DrawerItem(String itemName, Integer imgResID) {
		this.ItemName = itemName;
		this.imgResID = imgResID;
	}

	public DrawerItem(String title) {
		this.title = title;
	}

	public String getItemName() {
		return ItemName;
	}

	public Integer getImgResID() {
		return imgResID;
	}

	public String getTitle() {
		return title;
	}
}
