package com.kuang135.easyui.util;

import java.util.ArrayList;
import java.util.List;

import com.kuang135.easyui.bean.TreeGrid;



public class TreeGridUtil {

	/**
	 * 将所有没有层级关系的TreeGrid 组织成有层级关系的TreeGrid
	 * @param beans
	 * @param topPid
	 * @return
	 */
	public static List<TreeGrid> recurse2tree(List<TreeGrid> beans, String topPid) {
		ArrayList<TreeGrid> list = new ArrayList<TreeGrid>();
		if (beans == null || beans.size() == 0)
			return list;
		for (TreeGrid bean : beans) {
			if (topPid == null) {
				if (bean.getPid() == null){
					list.add(bean);
				}
			} else {
				if (topPid.equals(bean.getPid())) {
					list.add(bean);
				}
			}
		}
		beans.removeAll(list);
		for (TreeGrid topBean : list) {
			setChildren2ParentBean(beans, topBean);
		}
		return list;
	}
	private static void setChildren2ParentBean(List<TreeGrid> beans, TreeGrid parent) {
		if (beans == null || beans.size() == 0 || parent == null)
			return;
		List<TreeGrid> tmp = new ArrayList<TreeGrid>();
		for (TreeGrid bean : beans) {
			if ((parent.getId()).equals(bean.getPid())) {
				tmp.add(bean);
			}
		}
		beans.removeAll(tmp);
		parent.setChildren(tmp);
		if (tmp.size()>0) {
			for (TreeGrid p : tmp) {
				setChildren2ParentBean(beans, p);
			}
		}
	}
}
