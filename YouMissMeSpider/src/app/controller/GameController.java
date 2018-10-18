/******************************************************************************\
 * Logic paradigm implementation in Java
 * Author: Daniel Amador Salas
 * Version: 1.0
 * Date: October 16th
\******************************************************************************/
package app.controller;

import app.model.Cell;
import app.model.Connection;
import app.view.GameView;
import app.view.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GameController implements ActionListener{
    private MainView mainView;
    private RunSpider runSpider;
    private Connection connect;
    private Thread thread;
    private GameView game= new GameView();
    GameController(MainView mainView) {
        this.mainView=mainView;
        connect = new Connection(mainView);
        openGameView();
        
        
    }
    private void openGameView() {
      if(mainView.maze==null||mainView.spider==null||mainView.wasp==null){
          JOptionPane.showMessageDialog(mainView, "¡Primero debe crear un laberinto!");
      }else{
      mainView.setVisible(false);
      game.setVisible(true);
      generateMatrix();
      game.btnBack.addActionListener(this);
      game.btnChange.addActionListener(this);
      game.btnStartGame.addActionListener(this);
      }
    }

    private void generateMatrix() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               mainView.maze[i][j].addActionListener(null);
               game.pnMaze.add(mainView.maze[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         JButton btnPussed = (JButton) e.getSource();
        if(btnPussed.getText().equals("Back"))
            goBack();
        else if(btnPussed.getText().equals("Start Game"))
            startGame();
        else if(btnPussed.getText().equals("Change Target"))
            changeTarget();
    }
    private void goBack() {
        mainView.setVisible(true);
        game.setVisible(false);
    }

    private void startGame() {
        
        String[] path= connect.getPath();
        runSpider= new RunSpider(mainView, searchButtons(path));
        runSpider.running=true;
        new Thread(runSpider).start();
    }

    private void changeTarget() {
        boolean flag =true;
        Random random = new Random();
        while(flag){
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            if(mainView.maze[row][col].allow && mainView.maze[row][col]!=mainView.spider &&
                    mainView.maze[row][col]!=mainView.wasp)
            {
                mainView.wasp.setIcon(new ImageIcon("./src/app/util/wood.jpg"));
                mainView.wasp=mainView.maze[row][col];
                mainView.wasp.setIcon(new ImageIcon("./src/app/util/wasp.png")); 
                flag=false;
            }
        }
        runSpider.running=false;
        startGame();
    }
    private ArrayList<Cell> searchButtons(String[] path) {
        ArrayList<Cell> buttons= new ArrayList<Cell>();
        for (int k = 0; k < path.length; k++) 
            for (int i = 0; i < 9; i++) 
                for (int j = 0; j < 9; j++) 
                    if(mainView.maze[i][j].name.equals(path[k]))
                        buttons.add(mainView.maze[i][j]);
        return buttons;
    }
}
