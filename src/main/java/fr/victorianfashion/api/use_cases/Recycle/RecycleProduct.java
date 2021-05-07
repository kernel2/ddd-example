package fr.victorianfashion.api.use_cases.Recycle;

import fr.victorianfashion.api.domain.Recycle.Recycling;
import fr.victorianfashion.api.domain.product.Product;
import fr.victorianfashion.api.use_cases.ProductsRepository;

import java.util.List;

public class RecycleProduct {
    private RecycleRepository recyclings;
    private ProductsRepository products;

    public RecycleProduct(RecycleRepository recyclings, ProductsRepository products) {
        this.recyclings = recyclings;
        this.products = products;
    }

    public Recycling recyle( List<Long> productIDs){
        Recycling recycling = new Recycling();
        for(Long currentId : productIDs){
            recycling.addProduct(products.findProductById(currentId));
        }

        return recycling;
    }

}
