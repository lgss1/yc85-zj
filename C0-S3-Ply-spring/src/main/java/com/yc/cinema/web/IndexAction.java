package com.yc.cinema.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.yc.cinema.biz.HallBiz;
import com.yc.cinema.biz.MovieBiz;
import com.yc.cinema.biz.UserBiz;
@Controller
public class IndexAction {
	
	@Resource
	private UserBiz ubiz;
	@Resource
	private MovieBiz mbiz;
	@Resource
	private HallBiz hbiz;

	public UserBiz getUbiz() {
		return ubiz;
	}

	public void setUbiz(UserBiz ubiz) {
		this.ubiz = ubiz;
	}

	public MovieBiz getMbiz() {
		return mbiz;
	}

	public void setMbiz(MovieBiz mbiz) {
		this.mbiz = mbiz;
	}

	public HallBiz getHbiz() {
		return hbiz;
	}

	public void setHbiz(HallBiz hbiz) {
		this.hbiz = hbiz;
	}

}
