package com.dao;

import java.sql.Date;

import com.db.Hibernate;
import com.dto.BSE;
import com.dto.NSE;

public class NseNBseao {

	public NSE getNse(Date date) {
		// TODO Auto-generated method stub
		return Hibernate.nseData(date);
	}
	public BSE getBse(Date date) {
		// TODO Auto-generated method stub
		return Hibernate.bseData(date);
	}

}
