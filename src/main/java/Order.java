import org.sql2o.Connection;

public class Order extends Customer implements DatabaseManagement {

    private String name;
    private String type;

    public final static String NAME_CUSTOMER="Mark";
    public final static String PRODUCT_TYPE="Home-product";

    public Order(String name, String type) {
        super(name, type);
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
    @Override
    public void save() {
        if (this.name.equals("") || this.type.equals("")){
            throw new IllegalArgumentException("Fields cannot be Empty");
        }
        try (Connection con=DB.sql2o.open()){

            String sql ="INSERT INTO orders (name,type) VALUES (:name,:type)";

            this.id=(int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("type",this.type)

                    .executeUpdate()
                    .getKey();
        }

    }
}
