package com.namoo.club.dao.sqlmap.mapper;

import java.util.List;

import com.namoo.club.dto.Category;

public interface CategoryMapper {

	List<Category> selectCategoriesByCommunityNo(int communityNo);

	void createCategory(Category category);

	void deleteCategory(int categoryNo);
}