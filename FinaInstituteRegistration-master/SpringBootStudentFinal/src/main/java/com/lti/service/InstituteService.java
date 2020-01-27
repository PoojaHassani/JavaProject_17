package com.lti.service;

import com.lti.model.Institute;

public interface InstituteService {
	public boolean addInstitute(Institute institute);
	public boolean loginInstitute(int instituteCode,String setPassword);
}
