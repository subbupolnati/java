import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
class Products implements Serializable{
	public int product_id;j
	public String name;
	public int category_id;
	public int avalible_quantity;
	public float price;
	public Products(int product_id, String name, int category_id, int avalible_quantity, float price) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.category_id = category_id;
		this.avalible_quantity = avalible_quantity;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", name=" + name + ", category_id=" + category_id
				+ ", avalible_quantity=" + avalible_quantity + ", price=" + price + "]";
	}
}
public class SerializationProduct  {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Products product;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		Statement stmt=con.createStatement();
		String sql="select * from product";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			File f=new File("G:/java1/"+rs.getInt(1)+".txt");
			f.createNewFile();
			FileOutputStream fout= new FileOutputStream(f);
			ObjectOutputStream out=new ObjectOutputStream(fout);
			product=new Products(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getFloat(5));
			out.writeObject(product);
			out.flush();
			out.close();
			System.out.println("created"+rs.getInt(1)+".txt");
		}
	}

}

