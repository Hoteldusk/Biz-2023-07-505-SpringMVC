package com.callor.todo.service;

import com.callor.todo.models.CategoryDto;

public interface CateService extends TodoGeneric<CategoryDto, String>{
	
	public void printCategory();
}
