import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class WhatsApp extends JFrame {
    private final JFileChooser fileChooser = new JFileChooser();

    private JButton button;

    private String filePath;
    private JLabel label;

    private WhatsApp(){
        initComponents();
    }

    private void initComponents(){
        this.filePath = "/Users/michael/Downloads/_chat.txt";

        this.label = new JLabel(this.filePath);

        this.setTitle("WhatsApp Chat View");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().add(label);

        this.pack();
    }

    public static void main(String[] args){
        new Parser("/Users/michael/Downloads/_chat.txt").parse();
        // SwingUtilities.invokeLater(() -> {
        //     new WhatsApp().setVisible(true);
        // });
    }
}