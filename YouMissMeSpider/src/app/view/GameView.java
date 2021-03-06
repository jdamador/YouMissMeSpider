/******************************************************************************\
 * Logic paradigm implementation in Java
 * Author: Daniel Amador Salas
 * Version: 1.0
 * Date: October 16th
\******************************************************************************/
package app.view;

public class GameView extends javax.swing.JFrame {

    /**
     * Creates new form ConfigView
     */
    public GameView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMaze = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnStartGame = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GameView");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnMaze.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnMaze.setMaximumSize(new java.awt.Dimension(403, 403));
        pnMaze.setMinimumSize(new java.awt.Dimension(403, 403));
        pnMaze.setPreferredSize(new java.awt.Dimension(517, 517));
        pnMaze.setLayout(new java.awt.GridLayout(9, 9));
        getContentPane().add(pnMaze, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 117, 520, 530));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/util/bambu.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/util/MainViewTitle.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 80));

        btnStartGame.setBackground(new java.awt.Color(0, 153, 153));
        btnStartGame.setFont(new java.awt.Font("Hack", 1, 24)); // NOI18N
        btnStartGame.setForeground(new java.awt.Color(255, 255, 255));
        btnStartGame.setText("Start Game");
        getContentPane().add(btnStartGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 230, 40));

        btnChange.setBackground(new java.awt.Color(0, 153, 153));
        btnChange.setFont(new java.awt.Font("Hack", 1, 24)); // NOI18N
        btnChange.setForeground(new java.awt.Color(255, 255, 255));
        btnChange.setText("Change Target");
        getContentPane().add(btnChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 230, 40));

        btnBack.setBackground(new java.awt.Color(0, 153, 153));
        btnBack.setFont(new java.awt.Font("Hack", 1, 24)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 230, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/util/GameBackground.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBack;
    public javax.swing.JButton btnChange;
    public javax.swing.JButton btnStartGame;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JPanel pnMaze;
    // End of variables declaration//GEN-END:variables
}
