package com.kuang135.easyui.bean;

import java.util.List;


public class TreeGrid {

	private String id;
	private String name;
	private String pid;
	// other fields
	private List<TreeGrid> children;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public List<TreeGrid> getChildren() {
		return children;
	}
	public void setChildren(List<TreeGrid> children) {
		this.children = children;
	}
}
