package com.online.shopping.beans;

import java.util.ArrayList;

import javax.validation.Valid;

import com.online.shopping.domain.Category;
import com.online.shopping.domain.Product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Categories {

	private static final long serialVersionUID = 2L;
	@Valid
	private ArrayList<Category> categories;

}
