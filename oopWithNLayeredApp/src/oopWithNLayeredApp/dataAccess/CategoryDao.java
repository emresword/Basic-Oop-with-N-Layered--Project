package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Category;

public class CategoryDao {
public void add(Category category) {
	System.out.println(category.getCategoryName()+" category was added");
}
public void delete(Category category) {
	System.out.println(category.getCategoryName()+" category was deleted");
}
public void update(Category category) {
	System.out.println(category.getCategoryName()+" category was updated");
}
}
