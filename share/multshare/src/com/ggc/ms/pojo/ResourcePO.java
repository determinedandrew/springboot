package com.ggc.ms.pojo;

/**
 * @description playmovie的实体类PO持久化对象也用来传值（简便起见）
 * @author eleven
 *
 */
public class ResourcePO extends PageVO{
	  /* `reid` varchar(11) NOT NULL,
  `showname` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `retype` varchar(255) DEFAULT NULL COMMENT 'movie\\music\\document\\other\\play-movie',
  `repath` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `picpath` varchar(255) DEFAULT NULL COMMENT '缩略图路径',
  `readgrade` int(11) DEFAULT NULL COMMENT '0任何人可读、1登录可读、2会员可读、3管理员可读、4任何人不可读（伪删除）',
  `orderno` int(11) DEFAULT NULL COMMENT '排序字段',
  `reinfo` varchar(255) DEFAULT NULL COMMENT '大小、时长',
  `searchkey` varchar(255) DEFAULT NULL COMMENT '搜索字段：国家、导演、主演、类型、年度、歌手',
  `info` varchar(255) DEFAULT NULL COMMENT '详细信息，介绍',
  `specialmark` varchar(255) DEFAULT NULL COMMENT '特殊标记：推荐影片、最新资源等',
  `author` varchar(255) DEFAULT NULL COMMENT '上传者',
  `inserttime` varchar(255) DEFAULT NULL COMMENT '上传时间',
  `updatetime` varchar(255) DEFAULT NULL COMMENT '修改时间',*/
	  
	  private String reid;
	  private String showname;
	  private String retype;
	  private String repath;
	  private String picpath;
	  private Integer readgrade;
	  private Integer orderno;
	  private String reinfo;
	  private String searchkey;
	  private String info;
	  private String inserttime;
	  private String updatetime;
	  private String author;
	  private String specialmark;//2017-1-27新增
	
	  
	
	
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getSearchkey() {
		return searchkey;
	}
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}
	  public String getSpecialmark() {
		return specialmark;
	}
	public void setSpecialmark(String specialmark) {
		this.specialmark = specialmark;
	}
	  
	public String getReid() {
		return reid;
	}
	public void setReid(String reid) {
		this.reid = reid;
	}
	public String getShowname() {
		return showname;
	}
	public void setShowname(String showname) {
		this.showname = showname;
	}
	public String getRetype() {
		return retype;
	}
	public void setRetype(String retype) {
		this.retype = retype;
	}
	public String getRepath() {
		return repath;
	}
	public void setRepath(String repath) {
		this.repath = repath;
	}
	public Integer getReadgrade() {
		return readgrade;
	}
	public void setReadgrade(Integer readgrade) {
		this.readgrade = readgrade;
	}
	public Integer getOrderno() {
		return orderno;
	}
	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}
	public String getReinfo() {
		return reinfo;
	}
	public void setReinfo(String reinfo) {
		this.reinfo = reinfo;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getInserttime() {
		return inserttime;
	}
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	  
	

}
