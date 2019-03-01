package com.itheima.core.po;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
	private Integer goods_id;
	private Integer cate_id;
	private String goods_name;
	private String goods_disc;
	private Float goods_price;
	private Integer goods_discount;
	private Integer goods_stock;
	private String goods_origin;
	private String goods_material;
	private Float goods_postalfee;
	private Date goods_date;
	private Integer goods_sales;
	private String goods_pic;
	private Integer istoday;
	
	
	private Integer start;            // 起始行
	private Integer rows;             // 所取行数
	
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getCate_id() {
		return cate_id;
	}
	public void setCate_id(Integer cate_id) {
		this.cate_id = cate_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_disc() {
		return goods_disc;
	}
	public void setGoods_disc(String goods_disc) {
		this.goods_disc = goods_disc;
	}
	public Float getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(Float goods_price) {
		this.goods_price = goods_price;
	}
	public Integer getGoods_discount() {
		return goods_discount;
	}
	public void setGoods_discount(Integer goods_discount) {
		this.goods_discount = goods_discount;
	}
	public Integer getGoods_stock() {
		return goods_stock;
	}
	public void setGoods_stock(Integer goods_stock) {
		this.goods_stock = goods_stock;
	}
	public String getGoods_origin() {
		return goods_origin;
	}
	public void setGoods_origin(String goods_origin) {
		this.goods_origin = goods_origin;
	}
	public String getGoods_material() {
		return goods_material;
	}
	public void setGoods_material(String goods_material) {
		this.goods_material = goods_material;
	}
	public Float getGoods_postalfee() {
		return goods_postalfee;
	}
	public void setGoods_postalfee(Float goods_postalfee) {
		this.goods_postalfee = goods_postalfee;
	}
	public Date getGoods_date() {
		return goods_date;
	}
	public void setGoods_date(Date goods_date) {
		this.goods_date = goods_date;
	}
	public Integer getGoods_sales() {
		return goods_sales;
	}
	public void setGoods_sales(Integer goods_sales) {
		this.goods_sales = goods_sales;
	}
	public String getGoods_pic() {
		return goods_pic;
	}
	public void setGoods_pic(String goods_pic) {
		this.goods_pic = goods_pic;
	}
	public Integer getIstoday() {
		return istoday;
	}
	public void setIstoday(Integer istoday) {
		this.istoday = istoday;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}


}
