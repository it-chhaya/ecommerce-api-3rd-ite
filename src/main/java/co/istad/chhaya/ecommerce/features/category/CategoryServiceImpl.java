package co.istad.chhaya.ecommerce.features.category;

import co.istad.chhaya.ecommerce.features.category.dto.CategoryResponse;
import co.istad.chhaya.ecommerce.features.category.dto.CreateCategoryRequest;
import co.istad.chhaya.ecommerce.features.category.dto.UpdateCategoryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest) {
        log.info("createCategory: {}", createCategoryRequest);

        if (categoryRepository.existsByName(createCategoryRequest.name())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category is existed!");
        }

        Category category = categoryMapper.categoryRequestToCategory(createCategoryRequest);

        category = categoryRepository.save(category);

        return categoryMapper.categoryToCategoryResponse(category);
    }

    @Override
    public Page<CategoryResponse> findCategories(int pageNumber, int pageSize) {
        Sort sortById = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sortById);
        return categoryRepository
                .findAll(pageRequest)
                .map(categoryMapper::categoryToCategoryResponse);
    }

    @Override
    public CategoryResponse findCategoryById(Integer categoryId) {
        return categoryRepository
                .findById(categoryId)
                .map(categoryMapper::categoryToCategoryResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found!"));
    }

    @Override
    public CategoryResponse updateCategory(Integer id, UpdateCategoryRequest updateCategoryRequest) {
        log.info("updateCategory: {}", updateCategoryRequest);

        if (categoryRepository.existsByName(updateCategoryRequest.name())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category is existed!");
        }

        Category checkedCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found!"));

        checkedCategory.setName(updateCategoryRequest.name());
        checkedCategory.setIsDeleted(updateCategoryRequest.isDeleted());

        checkedCategory = categoryRepository.save(checkedCategory);

        return categoryMapper.categoryToCategoryResponse(checkedCategory);
    }


    @Override
    public void deleteCategory(Integer categoryId) {
        log.info("deleteCategory: {}", categoryId);
        Category checkedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found!"));
        categoryRepository.delete(checkedCategory);
    }
}
