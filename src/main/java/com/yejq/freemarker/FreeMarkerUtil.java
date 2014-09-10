package com.yejq.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtil {
	
	/**
	 * 获取模板
	 * @param name
	 * @return
	 */
	public Template getTemplate(String name){
		try {
			Configuration cfg = new Configuration();
			cfg.setClassForTemplateLoading(getClass(), "/ftl");
			return cfg.getTemplate(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 打印应用模板的结果到控制台
	 * @param name
	 * @param root
	 */
	public void print(String name, Map<String, Object> root){
		try {
			Template template = this.getTemplate(name);
			template.process(root, new PrintWriter(System.out));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fPrint(String name, Map<String, Object> root, String outFile){
		FileWriter writer = null;
		try {
			writer = new FileWriter(new File("G:\\" + outFile));
			Template template = getTemplate(name);
			template.process(root, writer);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally{
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
