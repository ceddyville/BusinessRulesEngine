import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * This codes sets the rules for when to activate/ upgrade the membership
 *
 * */
public class MembershipUpgradeRules implements IRule<Order,Order> {

    private final Logger logger = LoggerFactory.getLogger(MembershipUpgradeRules.class);

    @Override
    public boolean matches(Order order) {
        return order.getProduct().getType().getTypeName().equals(ProductType.TypeName.NON_PHYSICAL.toString())
                && order.getProduct().getCategory().getProductCategory().equals(ProductCategory.ProductCategoryName.MEMBERSHIP_UPGRADE.toString());
    }

    @Override
    public Order process(Order order) {
        logger.info("******** Processing \"{}\" ********", order.getProduct().getName());
        logger.info("******** Upgraded membership.");
        logger.info("******** Sent an email of the upgraded membership notice.");
        order.setStatus(Order.Status.PROCESSED.toString());
        logger.info("******** Done ******** \n");
        return order;
    }
}
