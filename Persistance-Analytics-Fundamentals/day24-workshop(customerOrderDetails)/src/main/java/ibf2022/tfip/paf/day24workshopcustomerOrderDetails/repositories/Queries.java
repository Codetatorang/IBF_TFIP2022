package ibf2022.tfip.paf.day24workshopcustomerOrderDetails.repositories;

public class Queries {

    public final static String INSERT_ORDER = """
            insert into orders(order_date,customer_name,ship_address,notes)
            values(?, ?, ? , ?)
            """;

    public final static String INSERT_ORDER_DETAILS = """
            insert into order_details(order_id,product,unit_price,discount,quantity)
            values (?,?,?,?,?)
            """;

    public final static String GET_ALL_ORDERS = """
            select * from orders where order_id = ?
            """;
}
