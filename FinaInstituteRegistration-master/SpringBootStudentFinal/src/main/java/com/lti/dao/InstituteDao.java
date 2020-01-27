package com.lti.dao;

import com.lti.model.Institute;

public interface InstituteDao {
	public int createInstitute(Institute institute);
	public int loginInstitute(int instituteCode,String setPassword);
}
