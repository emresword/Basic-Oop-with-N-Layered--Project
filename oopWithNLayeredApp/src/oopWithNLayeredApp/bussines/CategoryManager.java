package oopWithNLayeredApp.bussines;

import java.util.ArrayList;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccess.CategoryDao;
import oopWithNLayeredApp.entities.Category;
import oopWithNLayeredApp.tools.Orm;

public class CategoryManager {
private CategoryDao categoryDao;
private ArrayList<Logger>loggers;
private ArrayList<Category>categories;
private Orm orm;
public CategoryManager(CategoryDao categoryDao ,ArrayList<Logger>loggers ,ArrayList<Category>categories ,Orm orm) {
	this.categoryDao=categoryDao;
	this.loggers=loggers;
	this.orm=orm;
	this.categories=categories;
}
//instructor classına uygulanan add delete ve udate metotdalarını aynı şekilde burayada uygulanır
public void add(Category category) throws Exception {
	for(Category category2:categories) {
		if(category2.getCategoryName()==category.getCategoryName()) {
			throw new Exception("this category was already added");
		}
	}
		orm.add();
		categoryDao.add(category);
		categories.add(category);
	
	for(Logger logger:loggers) {
		logger.log(category.getCategoryName());
	}
}
public void delete(Category category) {
	for(Category category2:categories) {
		if(category2.getCategoryName()==category.getCategoryName()) {
			categoryDao.delete(category);
			categories.remove(category);
			break;
		}
		
	}
}


}
