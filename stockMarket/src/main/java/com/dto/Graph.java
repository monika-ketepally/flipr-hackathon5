package com.dto;

import java.sql.Date;

public class Graph {
	private Date date;
	private double open;
	
	public Graph(Date date, double open) {
		super();
		this.date = date;
		this.open = open;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
}
