package co.istad.chhaya.ecommerce.features.category;

import co.istad.chhaya.ecommerce.features.category.dto.CategoryResponse;
import co.istad.chhaya.ecommerce.features.category.dto.CreateCategoryRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category categoryRequestToCategory(CreateCategoryRequest categoryRequest);

    CategoryResponse categoryToCategoryResponse(Category category);

}
