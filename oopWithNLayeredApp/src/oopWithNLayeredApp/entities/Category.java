package oopWithNLayeredApp.entities;

public class Category {
private String categoryType;
private String categoryName;

public Category() {
	
}

public Category(String categoryType, String categoryName) {
	
	this.categoryType = categoryType;
	this.categoryName = categoryName;
}

public String getCategoryType() {
	return categoryType;
}

public void setCategoryType(String categoryType) {
	this.categoryType = categoryType;
}

public String getCategoryName() {
	return categoryName;
}

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}


}
