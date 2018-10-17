/******************************************************************************\
 * Logic paradigm implementation in Java
 * Author: Daniel Amador Salas
 * Version: 1.0
 * Date: October 16th
\******************************************************************************/
package app.controller;

import app.view.GameView;
import app.view.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GameController implements ActionListener{
    private MainView mainView;
    private GameView game= new GameView();
    GameController(MainView mainView) {
        this.mainView=mainView;
        openGameView();
        
    }
    private void openGameView() {
      if(mainView.maze==null){
          JOptionPane.showMessageDialog(mainView, "¡Primero debe crear un laberinto!");
      }else{
      mainView.setVisible(false);
      game.setVisible(true);
      generateMatrix();
      game.btnBack.addActionListener(this);
      }
    }

    private void generateMatrix() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
               game.pnMaze.add(mainView.maze[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         JButton btnPussed = (JButton) e.getSource();
        if(btnPussed.getText().equals("Back"))
            goBack();
    }
    private void goBack() {
        mainView.setVisible(true);
        game.setVisible(false);
    }
}
