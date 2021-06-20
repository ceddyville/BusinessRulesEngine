/*
 *This code is to create the various product so as to be able to categorise them
 *
 * */
public class Product {

    private final ProductType productType = new ProductType();
    private final ProductCategory productCategory = new ProductCategory();
    private String name;

    private ProductType type;

    private ProductCategory category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }


}
