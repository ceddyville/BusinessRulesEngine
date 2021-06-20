
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
/*
Rules to indicate that a book is physical product and generating a duplicate packaging slip*/

public class BookRules implements IRule<Order, Order>{

    private final Logger logger = LoggerFactory.getLogger(BookRules.class);

    /**/
    @Override
    public boolean matches(Order order) {
        return order.getProduct().getType().getTypeName().equals(ProductType.TypeName.PHYSICAL.toString())
                && order.getProduct().getCategory().getProductCategory().equals(ProductCategory.ProductCategoryName.BOOK.toString());
    }

    @Override
    public Order process(Order order) {
        logger.info("******** Processing \"{}\" ********", order.getProduct().getName());
        logger.info("------> Generated a duplicate packing slip for the royalty department.");
        order.setStatus(Order.Status.PROCESSED.toString());
        logger.info("******** Done ******** \n");
        return order;
    }
}
