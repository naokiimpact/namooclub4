package com.namoo.club.dao.sqlmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.dao.CategoryDao;
import com.namoo.club.dao.sqlmap.mapper.CategoryMapper;
import com.namoo.club.dto.Category;

@Repository
public class CategoryDaoSqlMap implements CategoryDao {

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> readCategoriesByCommunityNo(int communityNo) {
		//
		return categoryMapper.selectCategoriesByCommunityNo(communityNo);
	}

	@Override
	public void createCategory(Category category) {
		//
		categoryMapper.createCategory(category);
	}

	@Override
	public void deleteCategory(int categoryNo) {
		//
		categoryMapper.deleteCategory(categoryNo);
	}
}