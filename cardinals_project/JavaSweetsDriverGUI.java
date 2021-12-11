package cardinals_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


@SuppressWarnings("serial")
public class JavaSweetsDriverGUI extends JPanel implements MouseListener {
    JavaSweetsDBEngine DB_ENGINE = new JavaSweetsDBEngine();
    
    private final static Rectangle CONNECT_BUTTON = new Rectangle(180, 125, 245, 30);
    private final static Rectangle LOGIN_BUTTON = new Rectangle(450, 125, 100, 30);
    private final static Rectangle NEW_BUTTON = new Rectangle(180, 225, 245, 30);
    private final static Rectangle EXIT_BUTTON = new Rectangle(450, 225, 100, 30);
    private static Graphics graphics; 
    private boolean restart = true;
    
    public JavaSweetsDriverGUI() {
        addMouseListener(this);
    }  
   
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(JavaSweetsDriverGUI::createAndShowGUI);
    }
    
    private static void createAndShowGUI() {
        // Create and set up the window
        JFrame frame = new JFrame("JavaSweets");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane
        JavaSweetsDriverGUI newContentPane = new JavaSweetsDriverGUI();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        
        // Display the window
        frame.setSize(800, 600);
        frame.setVisible(true);             
    }
    
    private static void paintStartButtons(Graphics g) {
        //draw Connect Button
        g.setColor(Color.BLACK);
        paintBorder(CONNECT_BUTTON, 3, g);
        g.setColor(Color.PINK);
        paintRectangle(CONNECT_BUTTON, g);
        paintStringInRectangle("Connect to database", 250, 125, 100, 30, g);
        
        //draw Login Button
        g.setColor(Color.BLACK);
        paintBorder(LOGIN_BUTTON, 3, g);
        g.setColor(Color.PINK);
        paintRectangle(LOGIN_BUTTON, g);
        paintStringInRectangle("Login", 450, 125, 100, 30, g);
        
        //draw New Customer Button
        g.setColor(Color.BLACK);
        paintBorder(NEW_BUTTON, 3, g);
        g.setColor(Color.PINK);
        paintRectangle(NEW_BUTTON, g);
        paintStringInRectangle("Create New Customer", 250, 225, 100, 30, g);
        
        //draw Exit Button
        g.setColor(Color.BLACK);
        paintBorder(EXIT_BUTTON, 3, g);
        g.setColor(Color.PINK);
        paintRectangle(EXIT_BUTTON, g);
        paintStringInRectangle("Exit", 450, 225, 100, 30, g);
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (restart) {
            if (this.CONNECT_BUTTON.contains(e.getPoint())) {
                DB_ENGINE.connectToDatabase();       
            }
            if (this.LOGIN_BUTTON.contains(e.getPoint())) {
                DB_ENGINE.login();                
            }
            if (this.NEW_BUTTON.contains(e.getPoint())) {
                DB_ENGINE.createNewCustomer();
            }
            if (this.EXIT_BUTTON.contains(e.getPoint())) {
                System.exit(0);
            }
        }
        repaint();      
    }
    
    @Override
    public void paintComponent(Graphics g) {
        this.graphics = g;
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        String message = "Cardinals JavaSweets Start Menu";        
        if (restart) {
            paintMessage(message, g);
            paintStartButtons(g);
        }
    } 
    
    private static void paintRectangle(Color color, String str, Rectangle rect) {
        String abbrv = "";
        graphics.setColor(color);
        graphics.fillRect(rect.x, rect.y, rect.width, rect.height);
        //paint string
        graphics.setColor(Color.BLACK);
        int fontSize = rect.height > 50 ? 36 : 18;
        graphics.setFont(new Font("Verdana", Font.BOLD, fontSize));
        FontMetrics fm = graphics.getFontMetrics();
        int strX = rect.x + 14;
        int strY = rect.y + rect.height - 16;
        graphics.drawString(abbrv, strX, strY);
    }

    public static void paintStringInRectangle(String str, int x, int y, int width, int height, Graphics g) {
        g.setColor(Color.BLACK);
        int fontSize = (height >= 40) ? 36 : 18;
        g.setFont(new Font("Verdana", Font.BOLD, fontSize));
        FontMetrics fm = g.getFontMetrics();
        int strXCoord = x + width / 2 - fm.stringWidth(str) / 2;
        int strYCoord = y + height / 2 + fontSize / 2 - 4;
        g.drawString(str, strXCoord, strYCoord);
    }

    public static void paintMessage(String message, Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Verdana", Font.BOLD, 36));
        FontMetrics fm = g.getFontMetrics();
        int strXCoord = 400 - fm.stringWidth(message) / 2;
        int strYCoord = 50;
        g.drawString(message, strXCoord, strYCoord);
    }



    //two helper methods
    public static void paintBorder(Rectangle r, int thickness, Graphics g) {
        g.fillRect(r.x - thickness, r.y - thickness, r.width + (2 * thickness), r.height + (2 * thickness));
    }

    public static void paintRectangle(Rectangle r, Graphics g) {
        g.fillRect(r.x, r.y, r.width, r.height);
    }
      
    //the following methods are not implemented in this class
    @Override
    public void mousePressed(MouseEvent e) {
     
    }

    @Override
    public void mouseReleased(MouseEvent e) {
     
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
 
    }

}
