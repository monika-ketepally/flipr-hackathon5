package com.dao;

import java.sql.Date;
import java.util.List;

import com.db.Hibernate;
import com.dto.Graph;

public class Companydao {

	public List<Graph> graphDate() {
		// TODO Auto-generated method stub
		return Hibernate.graphData();
	}

	public List <Date> graphData() {
		// TODO Auto-generated method stub
		return Hibernate.graphDta();
	}
}
