package ca.ubc.cpsc310.gitlab.server;

import java.util.Collections;
import java.util.List;

import ca.ubc.cpsc310.gitlab.client.service.LoadUsersService;
import ca.ubc.cpsc310.gitlab.client.user.IUser;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoadUserServiceImpl extends RemoteServiceServlet implements
		LoadUsersService {

	@Override
	public List<IUser> getUsers() {
		return Collections.emptyList();
	}

}
