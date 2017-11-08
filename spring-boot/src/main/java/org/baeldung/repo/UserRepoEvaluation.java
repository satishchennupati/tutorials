package org.baeldung.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import org.baeldung.model.UserEvaluation;

@Repository
public class UserRepoEvaluation {
	
	Logger logger = Logger.getLogger(UserRepoEvaluation.class);

	public List<UserEvaluation> findAllUsers(){
		logger.info("findAllUsers method invoked");
		return new ArrayList<UserEvaluation>();
	}
	
	public UserEvaluation findUserWithId(String uid){
		logger.info("findUserWithId method invoked");
		return new UserEvaluation();
		
		
	}
	
	public void deleteUser(String userId){
		logger.info("delete method invoked");
	}
	
	public UserEvaluation createOrUpdateUser(UserEvaluation user) throws Exception{
		logger.info("createOrUpdateUser method invoked");
		return new UserEvaluation();
	}
}
