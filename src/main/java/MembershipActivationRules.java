import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
* This class is to activate membership
 *
* */
public class MembershipActivationRules implements IRule<Order,Order> {
    private final Logger logger = LoggerFactory.getLogger(MembershipActivationRules.class);

    @Override
    public boolean matches(Order order) {
        return order.getProduct().getType().getTypeName().equals(ProductType.TypeName.NON_PHYSICAL.toString())
                && order.getProduct().getCategory().getProductCategory().equals(ProductCategory.ProductCategoryName.MEMBERSHIP.toString());
    }

    @Override
    public Order process(Order order) {
        logger.info("******** Processing \"{}\" ********", order.getProduct().getName());
        logger.info("******** Activated membership.");
        logger.info("******** Sent an email of the activated membership notice.");
        order.setStatus(Order.Status.PROCESSED.toString());
        logger.info("******** Done ******** \n");
        return order;
    }
}
