package com.yc.bean;

public class TagFavorite implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer tid;
    private Integer fid;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	@Override
	public String toString() {
		return "Tagfavorite [tid=" + tid + ", fid=" + fid + "]";
	}
   
    
    
}
