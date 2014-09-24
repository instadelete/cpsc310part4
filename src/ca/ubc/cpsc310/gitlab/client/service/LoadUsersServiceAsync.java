package ca.ubc.cpsc310.gitlab.client.service;

import java.util.List;

import ca.ubc.cpsc310.gitlab.client.user.IUser;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoadUsersServiceAsync {

	void getUsers(AsyncCallback<List<IUser>> callback);

}
