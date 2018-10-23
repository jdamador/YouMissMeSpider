/******************************************************************************\
 * Logic paradigm implementation in Java
 * Author: Daniel Amador Salas
 * Version: 1.0
 * Date: October 16th
\******************************************************************************/
package app.controller;

import app.view.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MainViewController implements ActionListener{
    private MainView mainView;
    public MainViewController(MainView mainView) {
        this.mainView=mainView;
        addActionListener();
    }
    /**************************************************************************\
     * Add Action Listener
    \**************************************************************************/
    public void addActionListener(){
        mainView.btnCreateMaze.addActionListener(this);
        mainView.btnStartGame.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnPressed = (JButton) e.getSource();
        if(btnPressed.getText().equals("Create Maze"))
            openCreateMaze();
        else
            openGame();
    }
    /**************************************************************************\
     * Open Create Maze View
    \**************************************************************************/
    private void openCreateMaze() {
        ConfigController mazeController= new ConfigController(mainView);
    }
    /**************************************************************************\
     * Open Game View
    \**************************************************************************/
    private void openGame() {
        GameController gameController= new GameController(mainView);
    }

    
}
