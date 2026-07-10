package co.istad.chhaya.ecommerce.features.category;

import co.istad.chhaya.ecommerce.features.category.dto.CategoryResponse;
import co.istad.chhaya.ecommerce.features.category.dto.CreateCategoryRequest;
import co.istad.chhaya.ecommerce.features.category.dto.UpdateCategoryRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CategoryResponse createNew(@Valid @RequestBody CreateCategoryRequest createCategoryRequest) {
        return categoryService.createCategory(createCategoryRequest);
    }

    @GetMapping
    public Page<CategoryResponse> findCategories(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "25") int pageSize
    ) {
        return categoryService.findCategories(pageNumber, pageSize);
    }


    @GetMapping("/{id}")
    public CategoryResponse findCategoryById(@PathVariable Integer id) {
        return categoryService.findCategoryById(id);
    }


    @PutMapping("/{id}")
    public CategoryResponse updateCategory(@PathVariable Integer id, @Valid @RequestBody UpdateCategoryRequest updateCategoryRequest) {
        return categoryService.updateCategory(id, updateCategoryRequest);
    }


    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }

}
