package com.yc.damai.been;

import java.util.List;

public class DmCategory {
    private Integer id;

    private String cname;

    private Integer pid;
    
    private List<DmCategory> listCategroy;

    
    public List<DmCategory> getListCategroy() {
		return listCategroy;
	}

	public void setListCategroy(List<DmCategory> listCategroy) {
		this.listCategroy = listCategroy;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}