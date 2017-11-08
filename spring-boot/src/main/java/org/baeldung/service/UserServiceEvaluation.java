package org.baeldung.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.baeldung.model.UserEvaluation;
import org.baeldung.repo.UserRepoEvaluation;

@Service
public class UserServiceEvaluation {
	
	@Autowired
	UserRepoEvaluation repo;
	
	public List<UserEvaluation> findAllUsers(){
		return repo.findAllUsers();
	}
	
	public UserEvaluation findUserWithId(String uid){
		return repo.findUserWithId(uid);
	}
	
	public void deleteUser(String userId){
		repo.deleteUser(userId);
	}
	
	public UserEvaluation createOrUpdateUser(UserEvaluation user) throws Exception{
		return repo.createOrUpdateUser(user);
	}

}
