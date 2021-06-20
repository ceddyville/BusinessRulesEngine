/*
 *
 *Set of rules that should be to be followed
 * */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class EngineRule {

    private final Logger logger = LoggerFactory.getLogger(EngineRule.class.getName());
    List<IRule<Order, Order>> rules = new ArrayList<>();

    // TODO apply multiple rules
    public Order applyRule(Order order) {
        long matchedCount = rules.stream()
                .filter(rule -> rule.matches(order))
                .map(rule -> rule.process(order)).count();
        if(matchedCount == 0) {
            logger.error("No Matching rule found for order - \"{}\"!\n", order.getProduct().getName());
        }
        return order;
    }

    public EngineRule registerRule(IRule<Order, Order> rule) {
        rules.add(rule);
        return this;
    }
}
