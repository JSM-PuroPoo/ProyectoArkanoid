package interfaz;

import interfaz.paneles.PanelIMG;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class Charts extends javax.swing.JFrame {
    private PanelIMG chartsFondo = new PanelIMG();
    private PanelIMG chartsMarco = new PanelIMG();
    private PanelIMG chartsPanel = new PanelIMG();
    private JButton backButton = new JButton();
    private JLabel name1 = new JLabel();
    private JLabel name2 = new JLabel();
    private JLabel name3 = new JLabel();
    private JLabel name4 = new JLabel();
    private JLabel name5 = new JLabel();
    private JLabel score1 = new JLabel();
    private JLabel score2 = new JLabel();
    private JLabel score3 = new JLabel();
    private JLabel score4 = new JLabel();
    private JLabel score5 = new JLabel(); 
    
    private JButton closeButton = new JButton();
    private JButton minimizeButton = new JButton();
    Font text;
    
    /**
     * Creates new form Charts
     */
    public Charts() {
        this.setUndecorated(true);
        initComponents();
        
        this.setTitle("Ocaso Arkanoid");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon("recursos/logo.png").getImage());
        chartsFondo.setLayout(null);
        chartsFondo.setImage("recursos/inicioimg.jpg");
        chartsFondo.setBounds(0, 0, 1200, 675);
        this.getContentPane().add(chartsFondo);
        chartsMarco.setBounds(0, 0, 1200, 675);
        chartsMarco.setOpaque(false);
        chartsMarco.setImage("recursos/marco0.png");
        chartsMarco.setLayout(null);
        chartsFondo.add(chartsMarco);
        
        chartsPanel.setImage("recursos/chartsPanel.png");
        chartsPanel.scaleImage(900, 500);
        chartsPanel.setBounds(150, 55, 900, 500 );
        chartsPanel.setOpaque(false);
        chartsPanel.setLayout(null);
        chartsFondo.add(chartsPanel);
        
        
        backButton.setIcon(new ImageIcon("recursos/backButton.png"));
        backButton.setRolloverIcon(new ImageIcon("recursos/backButtonPressed.png"));
        backButton.setBounds(510, 555, 180, 100);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setOpaque(false);
        backButton.setLayout(null);
        chartsFondo.add(backButton);
        
        try {
            InputStream is = new BufferedInputStream(new FileInputStream("fonts/OCRA.TTF"));;
            text = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        name1.setBounds(142, 327, 185, 50);
        name1.setFont(text.deriveFont(Font.PLAIN, 20));
        name1.setHorizontalAlignment(SwingConstants.CENTER);
        name1.setVerticalAlignment(SwingConstants.CENTER);
        name1.setForeground(Color.white);
        name1.setLayout(null);
        name1.setOpaque(false);
        chartsPanel.add(name1);   
        
        score1.setBounds(142, 397, 185, 50);
        score1.setFont(text.deriveFont(Font.PLAIN, 20));
        score1.setHorizontalAlignment(SwingConstants.CENTER);
        score1.setVerticalAlignment(SwingConstants.CENTER);
        score1.setForeground(Color.white);
        score1.setLayout(null);
        score1.setOpaque(false);
        chartsPanel.add(score1);
              
        name2.setBounds(559, 130, 120, 50);
        name2.setFont(text.deriveFont(Font.PLAIN, 15));
        name2.setHorizontalAlignment(SwingConstants.CENTER);
        name2.setVerticalAlignment(SwingConstants.CENTER);
        name2.setForeground(Color.white);
        name2.setLayout(null);
        name2.setOpaque(false);
        chartsPanel.add(name2);  
        
        score2.setBounds(719, 130, 120, 50);
        score2.setFont(text.deriveFont(Font.PLAIN, 15));
        score2.setHorizontalAlignment(SwingConstants.CENTER);
        score2.setVerticalAlignment(SwingConstants.CENTER);
        score2.setForeground(Color.white);
        score2.setLayout(null);
        score2.setOpaque(false);
        chartsPanel.add(score2);
        
        name3.setBounds(559, 219, 120, 50);
        name3.setFont(text.deriveFont(Font.PLAIN, 15));
        name3.setHorizontalAlignment(SwingConstants.CENTER);
        name3.setVerticalAlignment(SwingConstants.CENTER);
        name3.setForeground(Color.white);
        name3.setLayout(null);
        name3.setOpaque(false);
        chartsPanel.add(name3);   
        
        score3.setBounds(719, 219, 120, 50);
        score3.setFont(text.deriveFont(Font.PLAIN, 15));
        score3.setHorizontalAlignment(SwingConstants.CENTER);
        score3.setVerticalAlignment(SwingConstants.CENTER);
        score3.setForeground(Color.white);
        score3.setLayout(null);
        score3.setOpaque(false);
        chartsPanel.add(score3);
       
        
        name4.setBounds(559, 307, 120, 50);
        name4.setFont(text.deriveFont(Font.PLAIN, 15));
        name4.setHorizontalAlignment(SwingConstants.CENTER);
        name4.setVerticalAlignment(SwingConstants.CENTER);
        name4.setForeground(Color.white);
        name4.setLayout(null);
        name4.setOpaque(false);
        chartsPanel.add(name4);        

        score4.setBounds(719, 307, 120, 50);
        score4.setFont(text.deriveFont(Font.PLAIN, 15));
        score4.setHorizontalAlignment(SwingConstants.CENTER);
        score4.setVerticalAlignment(SwingConstants.CENTER);
        score4.setForeground(Color.white);
        score4.setLayout(null);
        score4.setOpaque(false);
        chartsPanel.add(score4);

        name5.setBounds(559, 399, 120, 50);
        name5.setFont(text.deriveFont(Font.PLAIN, 15));
        name5.setHorizontalAlignment(SwingConstants.CENTER);
        name5.setVerticalAlignment(SwingConstants.CENTER);
        name5.setForeground(Color.white);
        name5.setLayout(null);
        name5.setOpaque(false);
        chartsPanel.add(name5);
        
        score5.setBounds(719, 399, 120, 50);
        score5.setFont(text.deriveFont(Font.PLAIN, 15));
        score5.setHorizontalAlignment(SwingConstants.CENTER);
        score5.setVerticalAlignment(SwingConstants.CENTER);
        score5.setForeground(Color.white);
        score5.setLayout(null);
        score5.setOpaque(false);
        chartsPanel.add(score5);
        
        closeButton.setIcon(new ImageIcon("recursos/closeButton.png"));
        closeButton.setRolloverIcon(new ImageIcon("recursos/closeButtonRed.png"));
        closeButton.setBounds(1173, 3, 24, 24);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setOpaque(false);
        closeButton.setLayout(null);
        chartsMarco.add(closeButton);

        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        minimizeButton.setIcon(new ImageIcon("recursos/MinimizeButton.png"));
        minimizeButton.setRolloverIcon(new ImageIcon("recursos/MinimizeButtonGray.png"));
        minimizeButton.setBounds(1135, 3, 24, 24);
        minimizeButton.setBorderPainted(false);
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.setOpaque(false);
        minimizeButton.setLayout(null);
        chartsMarco.add(minimizeButton);
        minimizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeButtonActionPerformed(evt);
            }
        });
    }

        private void closeButtonActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void minimizeButtonActionPerformed(ActionEvent evt) {
        this.setExtendedState(1);
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 675));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Charts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Charts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Charts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Charts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Charts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
