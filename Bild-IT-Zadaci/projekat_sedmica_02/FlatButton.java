package projekat_sedmica_02;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 * @author AonoZan
 * Simple button class that utilize "Flat style".
 * 
 * <p>Made studying Kyle Dreger project "DregerButton.java"
 * <br><a href="https://gist.github.com/4646029">GitHub project</a>
 */
public class FlatButton extends JButton implements MouseListener{
	private static final long serialVersionUID = 1L;
	// set default font
	Font defaultFont = new Font("Gill Sans MT",Font.PLAIN,16);
    Color textColor;
    Color backgroundColor;
    Color hoverColor;
    // default constructor sets text to button
    public FlatButton() {
    	this("Button");
    }
    // constructor that sets default colors to white and res
    public FlatButton(String s) {
        this(s, Color.WHITE, Color.RED);
    }
    // constructor that creates everything else needed
    public FlatButton(String s, Color backgroundColor, Color hoverColor) {
        this.setFocusPainted(false);			// dont make 3D style when hovered over
        this.setText(s);						// set label on a button
        this.setBorder(null);					// destriy border so it's flat
        this.setBackground(backgroundColor);	// set background of a button
        this.backgroundColor = backgroundColor;	// set variable for background so it can be used later
        this.hoverColor = hoverColor;			// set for hover also
        this.setFont(defaultFont);				// set font to default one
        this.setOpaque(true);					// non transparent
        addMouseListener(this);					// add listener so we can change look every time we hover over burron
    }
    // must implement this events
    @Override public void mouseClicked(MouseEvent me) {}
    @Override public void mouseReleased(MouseEvent me) {}
    @Override public void mousePressed(MouseEvent me) {}
    // when mouse hovers over button set background to hover color
    @Override
    public void mouseEntered(MouseEvent e) { 
        if (e.getSource()==this) {  
            this.setBackground(this.hoverColor); 
        }
    }
    // when mouse escapes button set color to default one
    @Override
    public void mouseExited(MouseEvent e) { 
        if (e.getSource()==this) { 
            this.setBackground(this.backgroundColor); 
        }
    }
}
    