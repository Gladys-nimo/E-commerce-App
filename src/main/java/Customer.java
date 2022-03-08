import org.sql2o.Connection;

public class Customer implements DatabaseManagement {


    public int id;
    public String name;
    public String type;
    private String phone_number;
    private String order_number;
    public static final String PRODUCT_TYPE = "home-product";

    public Customer(int id, String name, String type, String phone_number, String order_number) {
        this.id = id;
        this.name = name;
        this.type = PRODUCT_TYPE;
        this.phone_number = phone_number;
        this.order_number = order_number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getOrder_number() {
        return order_number;
    }

    @Override
    public void save() {
        if (this.name.equals("") || this.type.equals(null) || this.type.equals(null)) {
            throw new IllegalArgumentException("fields cannot be empty");
        }
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO CUSTOMERS (name,type) VALUES (:name, :type)";

            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();

        }

    }

    @Override
    public void delete() {

    }
}
