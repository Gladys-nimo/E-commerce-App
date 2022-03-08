import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.Objects;

public class Customer implements DatabaseManagement {


    public int id;
    public String name;
    public String type;
    private String phone_number;
    private String order_number;
    public static final String PRODUCT_TYPE = "home-product";

    public Customer(String name, String type) {
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

    public static Customer find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM customer WHERE id=:id";
            Customer customer
                    = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Customer.class);
            return customer;

        }
    }

    @Override
    public void delete() {

        try (Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM customer";
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name) && Objects.equals(type, customer.type) && Objects.equals(phone_number, customer.phone_number) && Objects.equals(order_number, customer.order_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, phone_number, order_number);
    }
}

