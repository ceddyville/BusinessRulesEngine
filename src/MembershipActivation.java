/*
 *
 * This codes sets the rules for when to activate/ upgrade the membership
 *
 * */
public class MembershipActivation {
    private Membership membership;
    private Payment payment;

    public MembershipActivation(Membership membership, Payment payment) {
        this.membership = membership;
        this.payment = payment;
    }

    public void activate() {
        membership.setActive();
    }
}
