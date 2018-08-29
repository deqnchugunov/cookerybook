package cookerybook.services.base;

import cookerybook.entities.Category;
import cookerybook.entities.Receipt;

import java.util.List;

public interface CategoriesService {
    List<Category> getAllCategories();
}
