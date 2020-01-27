package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.model.Institute;
@Repository
public class InstituteDaoImpl implements InstituteDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public int createInstitute(Institute institute) {
		entityManager.persist(institute);
		return 1;
	}

	@Override
	public int loginInstitute(int instituteCode, String setPassword) {

		System.out.println(instituteCode + " " + setPassword);
		String jpql="Select i from Institute i where i.instituteCode=:instituteCode and i.setPassword=:password ";
		TypedQuery<Institute> typedquery=entityManager.createQuery(jpql,Institute.class);
		typedquery.setParameter("instituteCode", instituteCode);
		typedquery.setParameter("password", setPassword);
//		Institute institute=null;
		
		//typedquery.setParameter("setPassword", setPassword);
//		institute =typedquery.getSingleResult();
		List<Institute> list = typedquery.getResultList();
		
//		for(Institute i : list){
//			System.out.println(i);
//		}

		System.out.println("Size: " + list.size());
		
//		int code=institute.getInstituteCode();
		//String pass=institute.getSetPassword();
		return list.size();
	}

	
}
