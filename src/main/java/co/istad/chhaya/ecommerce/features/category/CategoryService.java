package co.istad.chhaya.ecommerce.features.category;

import co.istad.chhaya.ecommerce.features.category.dto.CategoryResponse;
import co.istad.chhaya.ecommerce.features.category.dto.CreateCategoryRequest;

public interface CategoryService {

    CategoryResponse createNew(CreateCategoryRequest createCategoryRequest);

}
