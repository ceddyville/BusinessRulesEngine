/*
*
*This is to differentiate between physical and non physical products
*
*/
public class ProductType {

    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public enum TypeName{
        PHYSICAL, NON_PHYSICAL
    }

}