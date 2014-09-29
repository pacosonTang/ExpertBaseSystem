package com.cdkx.expertbasesystem.utils;

import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class JsonUtil {

	public static String jsonForSingle(Object clazz){
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("projects") || name.equals("awards") || name.equals("thesises") || name.equals("children")
						|| name.equals("patents") || name.equals("parent")|| name.equals("usersForMajor") || name.equals("users")
						|| name.equals("usersForCurrentMajor") || name.equals("usersForDegree") || name.equals("usersForEducation") || name.equals("user"))
					return true;
				else
					return false;
			}
			
		});
		
		JSONArray jsonData = JSONArray.fromObject(clazz, cfg);
		return "{success:true,totalCount:1,list:" + jsonData.toString() + "}";
	}
	
	public static String jsonForList(List clazz){
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("projects") || name.equals("awards") || name.equals("thesises") || name.equals("children")
						|| name.equals("patents") || name.equals("parent")|| name.equals("usersForMajor") || name.equals("users")
						|| name.equals("usersForCurrentMajor") || name.equals("usersForDegree") || name.equals("usersForEducation") || name.equals("user"))
					return true;
				else
					return false;
			}
			
		});
		
		JSONArray jsonData = JSONArray.fromObject(clazz, cfg);
		return "{success:true,totalCount:" + clazz.size() + ",list:" + jsonData.toString() + "}";
	}
	
	public static String jsonForSet(Set clazz){
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){

			@Override
			public boolean apply(Object source, String name, Object value) {
				if(name.equals("projects") || name.equals("awards") || name.equals("thesises") || name.equals("children")
						|| name.equals("patents") || name.equals("parent")|| name.equals("usersForMajor") || name.equals("users")
						|| name.equals("usersForCurrentMajor") || name.equals("usersForDegree") || name.equals("usersForEducation") || name.equals("user"))
					return true;
				else
					return false;
			}
			
		});
		
		JSONArray jsonData = JSONArray.fromObject(clazz, cfg);
		return "{success:true,totalCount:" + clazz.size() + ",list:" + jsonData.toString() + "}";
	}
}
