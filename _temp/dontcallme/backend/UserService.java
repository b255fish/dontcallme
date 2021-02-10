package com.practice.dontcallme.backend;

public class UserService {

    private UserRepository repository;
    private static UserService instance;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * @return a reference to an example facade for User objects.
     */
    public static UserService getInstance(UserRepository repository) {
		if (instance == null) {
			instance = new UserService(repository);
		}
        return instance;
    }


    /**
     * Deletes a user from a system
     *
     * @param user the User to be deleted
     */
    public synchronized void delete(User user) {
        if (user.getId() == null) {
            throw new NullPointerException("User Id is null");
        }
        repository.delete(user);
    }

    /**
     * Persists or updates user in the system. Also assigns an identifier
     * for new User instances.
     *
     * @param user
     */
    public synchronized boolean save(User user) {
        if (user.getId() == null) {
            throw new NullPointerException("User Id is null");
        }
        repository.save(user);
        return true;
    }
}