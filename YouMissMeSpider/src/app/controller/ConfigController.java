/******************************************************************************\
 * Logic paradigm implementation in Java
 * Author: Daniel Amador Salas
 * Version: 1.0
 * Date: October 16th
\******************************************************************************/
package app.controller;

import app.model.Cell;
import app.view.CreateMazeView;
import app.view.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ConfigController implements ActionListener {
    private MainView mainView;
    private CreateMazeView createMaze= new CreateMazeView();
    ConfigController(MainView mainView) {
        this.mainView=mainView;
        generateMatrix();
        openCreateMaze();
    }

    private void openCreateMaze() {
      mainView.setVisible(false);
      createMaze.setVisible(true);
    }

    private void generateMatrix() {
        mainView.maze=new Cell[8][8];
        mainView.wasp=null;
        mainView.spider=null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mainView.maze[i][j] = new Cell();
                mainView.maze[i][j].setIcon(new ImageIcon("./src/app/util/wood.jpg"));
                mainView.maze[i][j].addActionListener(this);
                createMaze.pnMaze.add(mainView.maze[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cell btnPussed = (Cell) e.getSource();
        if(createMaze.rbnAddFloor.isSelected()){
            if(btnPussed.equals(mainView.wasp))
                mainView.wasp=null;
            else if(btnPussed.equals(mainView.spider))
                mainView.spider=null;
            btnPussed.setIcon(new ImageIcon("./src/app/util/wood.jpg"));
            btnPussed.allow=true;
        }
        else if(createMaze.rbnAddSpider.isSelected()){
           if(btnPussed.allow && mainView.spider==null){
                btnPussed.setIcon(new ImageIcon("./src/app/util/spider.png"));
                mainView.spider=btnPussed;
            }
        }
        else if(createMaze.rbnAddStone.isSelected()){
            if(btnPussed.equals(mainView.wasp))
                mainView.wasp=null;
            else if(btnPussed.equals(mainView.spider))
                mainView.spider=null;
            btnPussed.setIcon(new ImageIcon("./src/app/util/stone.jpg"));
            btnPussed.allow=false;
        }
        else if(createMaze.rbnAddWasp.isSelected()){
            if(btnPussed.allow && mainView.wasp==null){
                btnPussed.setIcon(new ImageIcon("./src/app/util/wasp.png"));
                 mainView.wasp=btnPussed;
            }
        }
    }  
}
