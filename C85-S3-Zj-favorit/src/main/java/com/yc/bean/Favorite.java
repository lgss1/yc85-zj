package com.yc.bean;

public class Favorite implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer fid;
    private String flabel;
    private String furl;
    private String fdesc;
    private String ftages;
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFlabel() {
		return flabel;
	}
	public void setFlabel(String flabel) {
		this.flabel = flabel;
	}
	public String getFurl() {
		return furl;
	}
	public void setFurl(String furl) {
		this.furl = furl;
	}
	public String getFdesc() {
		return fdesc;
	}
	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
	public String getFtages() {
		return ftages;
	}
	public void setFtages(String ftages) {
		this.ftages = ftages;
	}
	@Override
	public String toString() {
		return "favorite [fid=" + fid + ", flabel=" + flabel + ", furl=" + furl + ", fdesc=" + fdesc + ", ftages="
				+ ftages + "]";
	}
    
    
    
}
