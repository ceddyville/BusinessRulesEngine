import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *Code for implementing video rules
 *
 * */
public class VideoRules implements  IRule<Order,Order>{

    private final Logger logger = LoggerFactory.getLogger(VideoRules.class);
    @Override
    public boolean matches(Order order) {
        return order.getProduct().getType().getTypeName().equals(ProductType.TypeName.PHYSICAL.toString())
                && order.getProduct().getCategory().getProductCategory().equals(ProductCategory.ProductCategoryName.VIDEO.toString());
    }

    @Override
    public Order process(Order order) {
        logger.info("******** Processing \"{}\" ********", order.getProduct().getName());
        logger.info("******** Generated a packing slip for shipping.");

        if(order.getProduct().getName().equals("Learning to Ski")) {
            logger.info("******** added a free \"First Aid\" video to the packing slip.");
        }

        order.setStatus(Order.Status.PROCESSED.toString());
        logger.info("******** Done ******** \n");
        return order;
    }
}
