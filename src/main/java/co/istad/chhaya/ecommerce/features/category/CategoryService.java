package co.istad.chhaya.ecommerce.features.category;

import co.istad.chhaya.ecommerce.features.category.dto.CategoryResponse;
import co.istad.chhaya.ecommerce.features.category.dto.CreateCategoryRequest;
import co.istad.chhaya.ecommerce.features.category.dto.UpdateCategoryRequest;
import org.springframework.data.domain.Page;

public interface CategoryService {

    /**
     * Create category based on category request
     */
    CategoryResponse createCategory(CreateCategoryRequest categoryRequest);


    /**
     * Find categories from database by pagination
     */
    Page<CategoryResponse> findCategories(int pageNumber, int pageSize);


    /**
     * Find category by ID
     */
    CategoryResponse findCategoryById(Integer categoryId);


    /**
     * Update category by ID based on category request
     */
    CategoryResponse updateCategory(Integer id, UpdateCategoryRequest updateCategoryRequest);


    /**
     * Delete category by ID
     */
    void deleteCategory(Integer categoryId);

}
