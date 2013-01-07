package ca.ubc.cpsc310.gitlab.client;

import java.util.List;

import ca.ubc.cpsc310.gitlab.client.service.LoadUsersService;
import ca.ubc.cpsc310.gitlab.client.service.LoadUsersServiceAsync;
import ca.ubc.cpsc310.gitlab.client.user.IUser;
import ca.ubc.cpsc310.gitlab.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GitLab implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";


	final LoadUsersServiceAsync service = GWT.create(LoadUsersService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() 
	{
		
		service.getUsers(new AsyncCallback<List<IUser>>(){

			@Override
			public void onFailure(Throwable caught) {
					Window.alert("Error occured " + caught.getClass() + " : " + caught.getMessage());
				
			}

			@Override
			public void onSuccess(List<IUser> result) {
				Window.alert("Got list back with " +  result.size() + " entries");
				
			}});
	
	}
}
