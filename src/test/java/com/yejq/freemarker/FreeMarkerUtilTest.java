package com.yejq.freemarker;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class FreeMarkerUtilTest {

	private FreeMarkerUtil util;
	
	@Before
	public void setUp(){
		util = new FreeMarkerUtil();
	}
	
	@Test
	public void printTest(){
		Map<String, Object> root = new HashMap<String, Object>();
		//root.put("username", "zhangsan");
		root.put("username", "张三");
		util.print("01.ftl", root);
		util.fPrint("02.ftl", root, "01.html");
	}
}
