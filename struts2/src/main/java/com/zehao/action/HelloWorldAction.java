package com.zehao.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class HelloWorldAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String name;

	public String execute() throws Exception {
		ValueStack stack = ActionContext.getContext().getValueStack();
		System.out.println("stack.findString(\"name\") "+stack.findString("name"));
		System.out.println("stack.size() "+stack.size());
		if ("zehao".equals(name)) {
			System.out.println("验证通过！");
			return Action.SUCCESS;
		} else{
			System.out.println("验证不通过===>"+name);
			return Action.ERROR;}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
