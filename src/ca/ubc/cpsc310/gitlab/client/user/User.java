package ca.ubc.cpsc310.gitlab.client.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.ubc.cpsc310.gitlab.client.products.ProductItem;

@SuppressWarnings("unchecked")
public class User implements IUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6968277136462621810L;
	private final String LANG = "LANG";
	private final String NAME = "NAME";
	private final String WISHLIST = "WISHLIST";
	private final String SHOPPINGCART = "SHOPPINGCART";
	
	private Map<String, Object> data = new HashMap<String, Object>();
	public User()
	{
		data.put(WISHLIST, new ArrayList<Object>());
		data.put(SHOPPINGCART, new ArrayList<Object>());
	}
	
	@Override
	public String getLanguage() {
		return (String) data.get(LANG);
	}

	@Override
	public String getName() {
		return (String) data.get(NAME);
	}

	@Override
	public List<ProductItem> getWishList() {
		return (List<ProductItem>) data.get(WISHLIST);
	}

	@Override
	public List<ProductItem> getShoppingCart() {
		return (List<ProductItem>) data.get(SHOPPINGCART);
	}

	@Override
	public void setLanguage(String language) {
		data.put(LANG,language);
		
	}

	@Override
	public void setName(String name) {
		data.put(NAME, name);
		
	}

	@Override
	public void addItemToWishList(ProductItem o) {
		((List<ProductItem>) data.get(WISHLIST)).add(o);
	}

	@Override
	public void addItemToShoppingCart(ProductItem o) {
		((List<ProductItem>) data.get(SHOPPINGCART)).add(o);
		
	}

	@Override
	public void removeItemFromWishList(ProductItem o) {
		((List<ProductItem>) data.get(WISHLIST)).remove(o);
	}

	@Override
	public void removeItemFromShoppingCart(ProductItem o) {
		((List<ProductItem>) data.get(SHOPPINGCART)).add(o);
	}

	
}
