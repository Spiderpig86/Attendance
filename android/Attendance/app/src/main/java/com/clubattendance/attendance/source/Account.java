package com.clubattendance.attendance.source;

/* ----------------------------- IMPORTS ----------------------------- */

// Java Imports
import java.util.ArrayList;
import java.io.Serializable;




/* ------------------------- CLASS DEFINITION ------------------------- */


public class Account implements Serializable {

    /* ----------------------- INSTANCE VAR ----------------------- */

    private String name;
    private Password password;
    private ArrayList<User> followers;
    private ArrayList<User> following;
    private ArrayList<String> stories;

    /* ----------------------- CONSTRUCTORS ----------------------- */

    /**
     * Default constructor for Account
     * @param  name          the real name of the user
     */
    public Account(String name){
        this.name = name;
        this.password = new Password();
        this.followers = new ArrayList<User>();
        this.following = new ArrayList<User>();
        this.stories = new ArrayList<String>();
    }

    /**
     * Modified constructor for Account
     * @param  name          the real name of the user
     * @param  password      the password of the user
     */
    public Account(String name, Password password){
        this.name = name;
        this.password = password;
        this.followers = new ArrayList<User>();
        this.following = new ArrayList<User>();
        this.stories = new ArrayList<String>();
    }


    /* ----------------------- METHODS ----------------------- */

    /**
     * Returns the user's real name.
     * @return the user's real name
     */
    public String getName() { return this.name; }

    /**
     * Retrieves the Password of the Account.
     * @return the Password wrapper of the Account
     */
    public Password getPassword(){ return this.password; }


    /**
     * Returns a list of the other users who are following the user.
     * @return a list of the users who are following the user
     */
    public ArrayList<User> getFollowers() { return this.followers; }


    /**
     * Returns a list of the other users that the user is following.
     * @return a list of the users who are followed
     */
    public ArrayList<User> getFollowing() { return this.following; }

    /**
     * Returns a list of the user's stories.
     * @return a list of the user's stories
     */
    public ArrayList<String> getStories() { return this.stories; }

    /**
     * Modifies the name of the account.
     * @param name desired name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Adds a user that the user is following.
     * @param followed following user
     */
    public void addFollowing(User followed) { this.following.add(followed); }

    /**
     * Remove the specified User from the list of Users that are being following.
     * @param followed the following user
     * @return         true if successful
     */
    public boolean removeFollowing(User followed){ return this.following.remove(followed); }

    /**
     * Add the specified User to list of Users who follow the Account.
     * @param follower the User who is following the Account
     */
    public void addFollower(User follower) { this.followers.add(follower); }

    /**
     * Remove thee specified User from the list of Users who follow the Account.
     * @param follower the User who follows the Account
     */
    public void removeFollower(User follower) { this.followers.remove(follower); }

    /**
     * Adds a story to the Account.
     * @param story the story to be added
     */
    public void addStory(String story){ this.stories.add(story); }

    /**
     * Edits a story.
     * @param originalStory the original story
     * @param editedStory   the new story
     */
    public void editStory(String originalStory, String editedStory){
        this.stories.set(stories.indexOf(originalStory),editedStory);
    }

    /**
     * Stringifies the Account information.
     * @return the Account as a String
     */
    public String toString(){
        String output = "";
        output+= "Account Name: " + name;
        return output;
    }



}
