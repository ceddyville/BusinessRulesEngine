/*
* This is to be able to give the various products that are being sold
*
* */
public class ProductCategory {
    String productCategory;

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public enum ProductCategoryName{
        BOOK, VIDEO, MEMBERSHIP,MEMBERSHIP_UPGRADE
    }
}