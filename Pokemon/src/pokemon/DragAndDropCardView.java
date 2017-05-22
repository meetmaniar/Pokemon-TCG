package pokemon;




import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.TransferHandler;

public class DragAndDropCardView extends JFrame implements MouseMotionListener,
        MouseListener {

    private JPanel leftPanel = new JPanel(null);
    private JPanel rightPanel = new JPanel(null);
    //JLabel dropLabel;
    CardView p1 = new CardView("pikacu",50,20,20);
    
    
    
    
    

    public DragAndDropCardView() {
        this.setLayout(new GridLayout(1, 2));

        leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(leftPanel);
        this.add(rightPanel);
        leftPanel.addMouseListener(this);
        leftPanel.addMouseMotionListener(this);

        JTextArea area = new JTextArea();

        rightPanel.setLayout(new GridLayout(1, 1));
        rightPanel.add(area);


    	leftPanel.add(p1);
        p1.setTransferHandler(new TransferHandler("text"));

    }
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed" + e.getX() + e.getY());
        Dimension labelSize = p1.getPreferredSize();
        p1.setSize(labelSize);
        int x = e.getX() - labelSize.width / 2;
        int y = e.getY() - labelSize.height / 2;
        p1.setLocation(x, y);
        leftPanel.add(p1);



        repaint();

    }

    @Override
    public void mouseDragged(MouseEvent me) {
        System.out.println("mouseDragged");
            p1.getTransferHandler().exportAsDrag(p1, me,
                    TransferHandler.COPY);
            
            
       
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased" + e.getY() + e.getX());
        

    }

    @Override
    public void mouseEntered(MouseEvent e) {
 
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {

    	DragAndDropCardView frame = new DragAndDropCardView();
        frame.setVisible(true);
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}