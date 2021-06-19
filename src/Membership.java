/*
* This class is to check if the membership is active or need to be activated
* */
public class Membership {

    private boolean active;

    //check if membership is active
    public boolean isActive() {
        return active;
    }

    //Activate a membership is not active
    public void setActive(boolean active) {
        this.active = active;
    }
}
