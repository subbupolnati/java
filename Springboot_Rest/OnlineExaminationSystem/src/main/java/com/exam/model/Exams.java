package com.exam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.sql.ordering.antlr.GeneratedOrderByFragmentRendererTokenTypes;

@Entity
public class Exams {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int examId;
    private int tmarks;
    private String cName,obtMarks,date,startTime,endTime,examTime,status;

    public Exams() {
    }

    public Exams(int examId,String cName, int tMarks, String obtMarks, String date, String startTime, String endTime, String examTime, String status) {
        this.examId = examId;
        this.cName=cName;
        this.tmarks = tmarks;
        this.obtMarks = obtMarks;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.examTime = examTime;
        this.status = status;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getTmarks() {
		return tmarks;
	}

	public void setTmarks(int tmarks) {
		this.tmarks = tmarks;
	}

	public String getObtMarks() {
        return obtMarks;
    }

    public void setObtMarks(String obtMarks) {
        this.obtMarks = obtMarks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
