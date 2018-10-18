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
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ConfigController implements ActionListener {
    private MainView mainView;
    private CreateMazeView createMaze= new CreateMazeView();
    ConfigController(MainView mainView) {
        this.mainView=mainView;
        generateMatrix();
        openCreateMaze();
        createMaze.btnBack.addActionListener(this);
    }

    private void openCreateMaze() {
      mainView.setVisible(false);
      createMaze.setVisible(true);
    }

    private void generateMatrix() {
        int name=0;
        mainView.maze=new Cell[7][7];
        mainView.wasp=null;
        mainView.spider=null;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                mainView.maze[i][j] = new Cell();
                mainView.maze[i][j].setText(""+name);
                mainView.maze[i][j].name="Cell"+name;name++;
                //mainView.maze[i][j].setIcon(new ImageIcon("./src/app/util/wood.jpg"));
                mainView.maze[i][j].addActionListener((e) -> this.cellPressed(e));
                createMaze.pnMaze.add(mainView.maze[i][j]);
            }
        }
    }
    public void cellPressed(ActionEvent e) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnPussed = (JButton) e.getSource();
        if(btnPussed.getText().equals("Back"))
            goBack();
    }

    private void goBack() {
         mainView.setVisible(true);
      createMaze.setVisible(false);
    }
         
}
