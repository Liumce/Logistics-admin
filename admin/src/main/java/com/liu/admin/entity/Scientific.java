package com.liu.admin.entity;

import java.sql.Date;

/**
 * 角色
 * @author liumce
 *
 */
public class Scientific {
	private long scientificId;
	private long authorId;
	private String authorName;
	private String authorGain;
	private String gainOrigin;
	private Date gainGettime;
	private String paperPhase;
	private String typeGrade;
	private String cooRanking;

	public Date getGainGettime() {
		return gainGettime;
	}

	public void setGainGettime(Date gainGettime) {
		this.gainGettime = gainGettime;
	}

	public String getPaperPhase() {
		return paperPhase;
	}

	public void setPaperPhase(String paperPhase) {
		this.paperPhase = paperPhase;
	}

	public String getTypeGrade() {
		return typeGrade;
	}

	public void setTypeGrade(String typeGrade) {
		this.typeGrade = typeGrade;
	}

	public String getCooRanking() {
		return cooRanking;
	}

	public void setCooRanking(String cooRanking) {
		this.cooRanking = cooRanking;
	}

	public long getScientificId() {
		return scientificId;
	}

	public void setScientificId(long scientificId) {
		this.scientificId = scientificId;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorGain() {
		return authorGain;
	}

	public void setAuthorGain(String authorGain) {
		this.authorGain = authorGain;
	}

	public String getGainOrigin() {
		return gainOrigin;
	}

	public void setGainOrigin(String gainOrigin) {
		this.gainOrigin = gainOrigin;
	}

	@Override
	public String toString() {
		return "Scientific{" +
				"scientificId=" + scientificId +
				", authorId=" + authorId +
				", authorName='" + authorName + '\'' +
				", authorGain='" + authorGain + '\'' +
				", gainOrigin='" + gainOrigin + '\'' +
				", gainGettime=" + gainGettime +
				", paperPhase='" + paperPhase + '\'' +
				", typeGrade='" + typeGrade + '\'' +
				", cooRanking='" + cooRanking + '\'' +
				'}';
	}
}
