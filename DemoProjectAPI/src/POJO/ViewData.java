package POJO;

public class ViewData {
String _id;
@Override
public String toString() {
	return "ViewData [_id=" + _id + ", orderById=" + orderById + ", orderBy=" + orderBy + ", productOrderedId="
			+ productOrderedId + ", productName=" + productName + ", country=" + country + ", productDescription="
			+ productDescription + ", productImage=" + productImage + ", orderPrice=" + orderPrice + ", __v=" + __v
			+ "]";
}
String orderById;
String orderBy;
String productOrderedId;
String productName;
String country;
String productDescription;
String productImage;
String orderPrice;
String __v;
public String get_id() {
	return _id;
}
public void set_id(String _id) {
	this._id = _id;
}
public String getOrderById() {
	return orderById;
}
public void setOrderById(String orderById) {
	this.orderById = orderById;
}
public String getOrderBy() {
	return orderBy;
}
public void setOrderBy(String orderBy) {
	this.orderBy = orderBy;
}
public String getProductOrderedId() {
	return productOrderedId;
}
public void setProductOrderedId(String productOrderedId) {
	this.productOrderedId = productOrderedId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getProductDescription() {
	return productDescription;
}
public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}
public String getProductImage() {
	return productImage;
}
public void setProductImage(String productImage) {
	this.productImage = productImage;
}
public String getOrderPrice() {
	return orderPrice;
}
public void setOrderPrice(String orderPrice) {
	this.orderPrice = orderPrice;
}
public String get__v() {
	return __v;
}
public void set__v(String __v) {
	this.__v = __v;
}

}
