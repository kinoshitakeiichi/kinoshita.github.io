package com.itheima.core.po;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Category {

    private int cate_id;
    private String cate_name;

    private int parentid;
    
    private String  cate_desc;
	public int getCate_id() {
		return cate_id;
	}
	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getCate_desc() {
		return cate_desc;
	}
	public void setCate_desc(String cate_desc) {
		this.cate_desc = cate_desc;
	}
	

	@Override
	public String toString() {
		return "Category [cate_id=" + cate_id + ", cate_name=" + cate_name
				+ ", parentid=" + parentid + ", cate_desc=" + cate_desc  + "]";
	}


}
