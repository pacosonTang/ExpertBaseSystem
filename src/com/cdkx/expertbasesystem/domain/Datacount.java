package com.cdkx.expertbasesystem.domain;

public class Datacount {

	//学科统计编号
	private int id;

	//学科名称
	private String subName;

	//项目总数量
	private int projectNum;

	//国家级项目数量
	private int levelNationNum;
	
	//省级项目数量
	private int levelProvinceNum;
	
	//市级项目数量
	private int levelCityNum;
	
	//奖励总数量
	private int awardNum;
	
	//排名第一奖励数量
	private int rankFirstNum;
	
	//排名第二奖励数量
	private int rankSecondNum;
	
	//排名第三奖励数量
	private int rankThirdNum;
	
	//论文总数量
	private int thesisNum;
	
	//专利总数量
	private int patentNum;
	
	//会员总数量
	private int memberNum;
	
	//博士会员数量 
	private int doctorNum;
	
	public Datacount(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getProjectNum() {
		return projectNum;
	}

	public void setProjectNum(int projectNum) {
		this.projectNum = projectNum;
	}

	public int getLevelNationNum() {
		return levelNationNum;
	}

	public void setLevelNationNum(int levelNationNum) {
		this.levelNationNum = levelNationNum;
	}

	public int getLevelProvinceNum() {
		return levelProvinceNum;
	}

	public void setLevelProvinceNum(int levelProvinceNum) {
		this.levelProvinceNum = levelProvinceNum;
	}

	public int getLevelCityNum() {
		return levelCityNum;
	}

	public void setLevelCityNum(int levelCityNum) {
		this.levelCityNum = levelCityNum;
	}

	public int getAwardNum() {
		return awardNum;
	}

	public void setAwardNum(int awardNum) {
		this.awardNum = awardNum;
	}

	public int getRankFirstNum() {
		return rankFirstNum;
	}

	public void setRankFirstNum(int rankFirstNum) {
		this.rankFirstNum = rankFirstNum;
	}

	public int getRankSecondNum() {
		return rankSecondNum;
	}

	public void setRankSecondNum(int rankSecondNum) {
		this.rankSecondNum = rankSecondNum;
	}

	public int getRankThirdNum() {
		return rankThirdNum;
	}

	public void setRankThirdNum(int rankThirdNum) {
		this.rankThirdNum = rankThirdNum;
	}

	public int getThesisNum() {
		return thesisNum;
	}

	public void setThesisNum(int thesisNum) {
		this.thesisNum = thesisNum;
	}

	public int getPatentNum() {
		return patentNum;
	}

	public void setPatentNum(int patentNum) {
		this.patentNum = patentNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getDoctorNum() {
		return doctorNum;
	}

	public void setDoctorNum(int doctorNum) {
		this.doctorNum = doctorNum;
	}
	
	

}
