package dao;

import java.util.ArrayList;

import model.User;

public class Users {
	
	private static final String SELECT_USER_BY_ID = "select id,name,email,country from user where id =?";
	private static final String SELECT_ALL_USERS = "select * from user";
	private static final String DELETE_USERS_SQL = "delete from user where id = ?;";
	private static final String UPDATE_USERS_SQL = "update user set name = ?,id= ?, country =? where id = ?;";
	
	private ArrayList<User> users ;
	public User getUser(String Id) {
		return null;
	}
	public ArrayList<User> load(){
		return null;
	}
	public boolean update(String Id, String pass) {
		return true;
	}

}