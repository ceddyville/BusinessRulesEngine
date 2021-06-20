import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Unit test
 **/
public class BusinessRuleEngineUnitTest {
    private EngineRule engineRule = new EngineRule();

    @Before
    public void initiate() {
        engineRule.registerRule(new BookRules())
                .registerRule(new MembershipActivationRules())
                .registerRule(new MembershipUpgradeRules())
                .registerRule(new PhysicalProductRules())
                .registerRule(new VideoRules());

    }

    @Test
    public void TestBookProduct() {
        ProductType type = new ProductType();
        type.setTypeName(ProductType.TypeName.PHYSICAL.toString());

        ProductCategory category = new ProductCategory();
        category.setProductCategory(ProductCategory.ProductCategoryName.BOOK.toString());

        Product product = new Product();
        product.setName("Origin");
        product.setType(type);
        product.setCategory(category);

        Order order = new Order();
        order.setProduct(product);
        order.setStatus(Order.Status.UNPROCESSED.toString());

        engineRule.applyRule(order);

        assertEquals("PROCESSED", order.getStatus());

    }
}
