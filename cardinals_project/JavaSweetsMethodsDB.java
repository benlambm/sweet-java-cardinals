package cardinals_project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaSweetsMethodsDB {
	private static Connection con;
	private static Statement stmt;

	public Connection createConnection() {
		con = null;
		String name = "cardinals220";
		String url = "jdbc:mysql://localhost:3306/" + name;
		String uid = "itp220";
		String pass = "itp220";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		try {
			con = DriverManager.getConnection(url, uid, pass);
			System.out.println("Connection successful!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("A new connection was made");
		return con;
	}

    public void createNewCustomer(String name, String pswd) {
        try {
            CallableStatement ca;
            String storedProcedure = "call sp_adduser(\'" + name + "\', \'" + pswd + "\')";
            ca = con.prepareCall(storedProcedure);
            ca.executeQuery();
            System.out.println("Adding user...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<User> loadSampleUsers(Connection con) {
        String query = "SELECT * FROM users";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        ArrayList<User> users = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(rs.next()) {
                String uname = rs.getString(1);
                String pword = rs.getString(2);
                boolean own = rs.getBoolean(3);
                if(own) {
                    users.add(new Owner(uname, pword));
                } else {
                    users.add(new Customer(uname, pword));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    
    public ArrayList<Inventory> loadSampleSweets(Connection con) {
        String query = "SELECT * FROM desserts";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }       
        ArrayList<Inventory> inv = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(1);
                String itemName = rs.getString(2);
                double cost = rs.getDouble(3);
                int num = rs.getInt(4);
                LocalDate date = rs.getDate(5).toLocalDate();
                inv.add(new Inventory(id, itemName, cost, num, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inv;
    }
	
	public void viewInventory() {
		try {
			stmt = con.createStatement();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		  
		String query = "select * from inventory";
	        
		try {
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				System.out.println(" ");
				System.out.println("Inventory: ");
				ResultSetMetaData meta = rs.getMetaData();
				int columns = meta.getColumnCount();
				
				while (rs.next()) {
					for (int i=1;i<columns+1;i++) {
						String s = rs.getString(i);
						System.out.print(s + "  " );
					}
					System.out.println("");
				}        
			} catch (SQLException e2) {
	            e2.printStackTrace();
	        }
	}

	public void searchInventory() {
		try {
			stmt = con.createStatement();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("What are you looking for?");
		String item = scan.next();

		String query = "Select * from inventory where name = " + item;
		try {
			ResultSet rs = stmt.executeQuery(query);
			if (rs != null) {
				rs.next();
				Inventory invent = new Inventory(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), LocalDate.of(0, 0, 0));
				// I am not sure that getLocalDate is correct here
				System.out.println(invent.toString());
			} else {
				System.out.println("That item does not exist");
			}
		} catch (SQLException e) {
			System.out.println("That item does not exist");
		}
	}

	public void addInventory() {

		try {
			stmt = con.createStatement();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the name of the new item?");
		String name = scan.nextLine();
		System.out.println("What is the price of the new item?");
		double cost = scan.nextDouble();
		System.out.println("What is the quantity in stock?");
		int num = scan.nextInt();
		System.out.println("What is the expiration year?");
		int year = scan.nextInt();
		System.out.println("What is the expiration month?");
		int mo = scan.nextInt();
		System.out.println("What is the expiration day?");
		int day = scan.nextInt();
		LocalDate date = LocalDate.of(year, mo, day);
		// How to handle a local date here?
		System.out.println("System Confirmation: New Item has been added.");

		try {
			stmt.executeUpdate(
					"insert into inventory " + "values('" + name + "','" + cost + "','" + num + "','" + date + "')");
			// LocalDate needs to be checked and how to handle local date
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeItem() {
    Scanner scan = new Scanner(System.in);
	
		try {
			stmt = con.createStatement();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		System.out.println("What is the ID# of the item to be removed? ");
        int idNum = scan.nextInt();
        try {
    		stmt.executeUpdate("delete from inventory " + "wehre id = "+idNum);
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	public void updatePrice(){
	    Scanner scan = new Scanner(System.in);
	    try {
			stmt = con.createStatement();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
    	System.out.println("Enter the item ID number: ");
        int idNo = scan.nextInt();
    
    	System.out.println("What is the new price of the item? ");
        double newCost = scan.nextDouble();
        try {
    		stmt.executeUpdate("update inventory set cost = "+newCost+" where itemId= "+idNo);
    			
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
        
	}

	public void viewOrders() {
    	try {
			stmt = con.createStatement();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		  
		String query = "select * from orders";
	        
		try {
			stmt = con.createStatement();					
	
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(" ");
			System.out.println("All Orders: ");
			ResultSetMetaData meta = rs.getMetaData();
			int columns = meta.getColumnCount();
			
			while (rs.next()){
				for (int i=1;i<columns+1;i++) {
					String s = rs.getString(i);
					System.out.print(s + "  " );
				}
				System.out.println("");
			}
		} catch (SQLException e2) {
            e2.printStackTrace();
        }
    }
}
