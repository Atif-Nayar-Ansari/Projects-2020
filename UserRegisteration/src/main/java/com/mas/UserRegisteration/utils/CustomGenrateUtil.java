package com.mas.UserRegisteration.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomGenrateUtil implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix ="mas";
		Calendar calendar = Calendar.getInstance();
		int i = calendar.get(Calendar.YEAR);
		int j = calendar.get(Calendar.MONTH);
		int k = calendar.get(Calendar.DAY_OF_YEAR);
		
		String sql ="select sequence_mass.nextval from dual ";
		Connection connection=null;
		Statement createStatement = null;
		ResultSet executeQuery = null;
		Integer serfix= null;
		 try {
			connection = session.connection();
			createStatement = connection.createStatement();
			executeQuery = createStatement.executeQuery(sql);
			if(executeQuery.next()) {
				serfix=executeQuery.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return prefix+String.valueOf(i)+String.valueOf(j)+String.valueOf(k)+String.valueOf(serfix) ;
	}

}
