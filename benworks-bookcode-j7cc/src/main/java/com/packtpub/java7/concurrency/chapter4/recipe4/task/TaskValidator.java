package com.packtpub.java7.concurrency.chapter4.recipe4.task;

import java.util.concurrent.Callable;

/**
 * This class encapsulate a user validation system to be executed as a Callable object.<br>
 * If the user is validated, it returns the name of the validation system. If not,<br>
 * it throws an Exception
 */
public class TaskValidator implements Callable<String> {

	/**
	 * The user validator used to validate the user.
	 */
	private UserValidator validator;
	/**
	 * The name of the user
	 */
	private String user;
	/**
	 * The password of the user
	 */
	private String password;

	/**
	 * Constructor of the class
	 * @param validator The user validator system used to validate it
	 * @param user The name of the user
	 * @param password The password of the user
	 */
	public TaskValidator(UserValidator validator, String user, String password) {
		this.validator = validator;
		this.user = user;
		this.password = password;
	}

	/**
	 * Core method of the Callable interface. Tries to validate the user using the user<br>
	 * validation system. If the user is validated, returns the name of the validation system. <br>
	 * If not, throws and Exception<br>
	 * @return The name of the user validation system.<br>
	 * @throws Exception An exception when the user is not validated<br>
	 */
	@Override
	public String call() throws Exception {
		if (!validator.validate(user, password)) {
			System.out.printf("%s: The user has not been found\n", validator.getName());
			throw new Exception("Error validating user");
		}
		System.out.printf("%s: The user has been found\n", validator.getName());
		return validator.getName();
	}

}
