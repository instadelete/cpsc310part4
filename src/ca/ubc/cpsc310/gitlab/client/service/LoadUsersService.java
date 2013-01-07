package ca.ubc.cpsc310.gitlab.client.service;

import java.util.List;

import ca.ubc.cpsc310.gitlab.client.user.IUser;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("loadUsers")
public interface LoadUsersService extends RemoteService {
	
	/**
	 * Retrieves a list of users from the server
	 * @return
	 */
	public List<IUser> getUsers();
}
