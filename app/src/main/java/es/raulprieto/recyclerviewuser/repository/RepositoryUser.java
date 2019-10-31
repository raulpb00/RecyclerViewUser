package es.raulprieto.recyclerviewuser.repository;

import java.util.ArrayList;
import java.util.Collection;

import es.raulprieto.recyclerviewuser.model.User;

/**
 * Singleton class which contains the list of
 * user/contacts of our App
 */
public class RepositoryUser {

    // private DAOSqlite;
    // private DAOFirebase;
    // private DAOLaravel;

    private Collection<User> userCollection;

    /**
     * 1. Object of the class itself
     */
    private static RepositoryUser instance;

    /**
     * 2. Private constructor
     * Respecting the singleton pattern
     */
    private RepositoryUser() {
        this.userCollection = new ArrayList<User>();
        initialize();
    }

    /**
     * 3. getInstance method creation
     * @return singleton instance of RepositoryUser
     */
    public static RepositoryUser getInstance() {
        if (instance == null)
            instance = new RepositoryUser();
        return instance;
    }

    /**
     * Method which return our repository's User Collection
     * @return User Collection
     */
    public Collection<User> getAll(){
        return userCollection;
    }

    /**
     * Initializes our User Collection
     * This won't be necessary if we were using a DAO,
     * for that's where we would get our collection
     */
    private void initialize() {
        userCollection.add(new User("raulsao","emailsao@gmailsao.com"));
        userCollection.add(new User("guillesao","guillesao@gmailsao.com"));
        userCollection.add(new User("fransao","fransao@gmailsao.com"));
        userCollection.add(new User("bilalsao","bilalsao@gmailsao.com"));
        userCollection.add(new User("mariosao","mariosao@gmailsao.com"));
        userCollection.add(new User("sergiosao","sergiosao@gmailsao.com"));
        userCollection.add(new User("cabesasao","cabesasao@gmailsao.com"));
        userCollection.add(new User("juanmasao","juanmasao@gmailsao.com"));
        userCollection.add(new User("petismesao","petismesao@gmailsao.com"));
        userCollection.add(new User("lucariosao","lucariosao@gmailsao.com"));
        userCollection.add(new User("hugosao","hugosao@gmailsao.com"));
        userCollection.add(new User("albertosao","albertosao@gmailsao.com"));
        userCollection.add(new User("bertosao","bertosao@gmailsao.com"));

    }

}
