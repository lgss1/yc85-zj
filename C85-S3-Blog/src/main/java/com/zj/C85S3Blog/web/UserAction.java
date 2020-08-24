package com.zj.C85S3Blog.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.zj.C85S3Blog.bean.User;
import com.zj.C85S3Blog.biz.BizException;
import com.zj.C85S3Blog.biz.UserBiz;
import com.zj.C85S3Blog.util.Result;

@Controller
public class UserAction {

	@Resource
	private UserBiz ubiz;

	/**
	 * 	注册 : 表单提交 ==> 页面跳转
	 * 	Errors 报错所有的验证错误信息,   默认会被推送页面
	 */
	@PostMapping("reg.do")
	public String register(@Valid User user, Errors errors, Model m) {
		if (errors.hasErrors()) {
			m.addAttribute("errors", asMap(errors));
			m.addAttribute("user", user);
			System.out.println(asMap(errors));
			return "reg";
		}
		try {
			ubiz.register(user);
		} catch (BizException e) {
			e.printStackTrace();
			errors.rejectValue("account", "account", e.getMessage());
			m.addAttribute("errors", asMap(errors));
			m.addAttribute("user", user);
			return "reg";
		}
		// index 请求转发方式跳转到 index
		// 使用响应重定向方式跳转
		return "redirect:/"; 
		//return "index";
	}

	@GetMapping("toreg")
	public String toreg() {
		return "reg";
	}

	/**
	 * 	登录: Ajax提交 ==> Vue
	 */
	@PostMapping("login.do")
	public Result login(User user, HttpSession session) {
		try {
			User dbuser = ubiz.Login(user);
			session.setAttribute("loginedUser", dbuser);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(e.getMessage());
		}
		return new Result(1, "登录成功!");
	}

	/**
	 * 	将所有的字段验证错写入到一个map
	 * @param errors
	 * @return
	 */
	private Map<String, String> asMap(Errors errors) {
		if (errors.hasErrors()) {
			Map<String, String> ret = new HashMap<String, String>();
			for (FieldError fe : errors.getFieldErrors()) {
				ret.put(fe.getField(), fe.getDefaultMessage());
			}
			return ret;
		} else {
			return null;
		}
	}

}
