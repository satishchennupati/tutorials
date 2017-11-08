package org.baeldung.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.baeldung.model.UserEvaluation;
import org.baeldung.service.UserServiceEvaluation;

@RestController
@RequestMapping("/user")
public class UserControllerEvaluation {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerEvaluation.class);

    //depndency injection through autowiring of beans
    @Autowired
    private UserServiceEvaluation userService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserEvaluation> findAll() {
        LOGGER.info("Finding all User entries");
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserEvaluation findById(@PathVariable(value = "userId") String userId) {
        LOGGER.info("Getting the user with the id: " + userId);
        return userService.findUserWithId(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "userId") String userId) {
        LOGGER.info("Deleting the user with the id: " + userId);
        userService.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserEvaluation create(@RequestBody @Valid UserEvaluation user, BindingResult result) throws Exception {
        LOGGER.info("Creating or Updating a user with the following informations: " + user);
        if (result.hasErrors()) {
            throw new Exception("Error in request");
        }
        return userService.createOrUpdateUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UserEvaluation update(@RequestBody @Valid UserEvaluation user) throws Exception {
        LOGGER.info("Updating the user with the following informations: " + user);
        return userService.createOrUpdateUser(user);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleUserNotFound(Exception exception) {
        LOGGER.info("An Exception occured in controller " + exception.getMessage());
    }
}