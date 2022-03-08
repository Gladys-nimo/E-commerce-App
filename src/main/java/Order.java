public class Order {

    private String name;
    private String type;

    public final static String NAME_CUSTOMER="Mark";
    public final static String PRODUCT_TYPE="Home-product";

    public Order(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
