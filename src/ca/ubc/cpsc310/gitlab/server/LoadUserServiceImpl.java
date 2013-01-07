package ca.ubc.cpsc310.gitlab.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.ubc.cpsc310.gitlab.client.products.ProductItem;
import ca.ubc.cpsc310.gitlab.client.service.LoadUsersService;
import ca.ubc.cpsc310.gitlab.client.user.IUser;
import ca.ubc.cpsc310.gitlab.client.user.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoadUserServiceImpl extends RemoteServiceServlet implements
		LoadUsersService {

	@Override
	public List<IUser> getUsers() {
		
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("userlist.txt");
		
		BufferedReader read = new BufferedReader(new InputStreamReader(in));
		
		String line = null;
		List<IUser> users = new ArrayList<IUser>();
		try {
			while( (line=read.readLine() ) != null)
			{
				//Skip empty lines
				if(line.trim().length() == 0 ) continue;
				
				String[] fields = line.split(",");
				if(fields.length != 4)
				{
					throw new IllegalArgumentException("Line is corrupt, expected 4 entries on line : " + line);
				}
				IUser user = new User();
				users.add(user);
				user.setName(fields[0]);
				user.setLanguage(fields[1]);
				
				//TODO: Support full list of entries Shopping Cart and Wishlist entries
				//For now I'll just use empty Objects.
				try { 
					
					for(int i=0; i < Integer.valueOf(fields[2]); i++)
					{
						user.addItemToShoppingCart(new ProductItem());
					}
						
					for(int i=0; i < Integer.valueOf(fields[3]); i++)
					{
						user.addItemToWishList(new ProductItem());
					}
				
				} catch(NumberFormatException e)
				{
					throw new IllegalArgumentException("Line is corrupt, expected the last two entries to be integers on line : " + line);
				}
			}
		} catch (IOException e) {
			throw new IllegalStateException("Unexpected Exception occurred", e);
		}
		
		
		
		return users;
	}

}
