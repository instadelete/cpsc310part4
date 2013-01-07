package ca.ubc.cpsc310.gitlab.client.user;

import java.io.Serializable;
import java.util.List;

import ca.ubc.cpsc310.gitlab.client.products.ProductItem;

public interface IUser extends Serializable {

	public String getLanguage();
	
	public String getName();
	
	public List<ProductItem> getWishList();
	
	public List<ProductItem> getShoppingCart();
	
	public void setLanguage(String language);
	
	public void setName(String name);
	
	public void addItemToWishList(ProductItem o);
	
	public void addItemToShoppingCart(ProductItem o);
	
	public void removeItemFromWishList(ProductItem o);
	
	public void removeItemFromShoppingCart(ProductItem o);
	
}
