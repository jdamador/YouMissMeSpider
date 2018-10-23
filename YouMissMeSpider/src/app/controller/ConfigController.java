/******************************************************************************\
 * Logic paradigm implementation in Java
 * Author: Daniel Amador Salas
 * Version: 1.0
 * Date: October 16th
 * Class: ConfigController -: this class manage the view components.
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
    /**
     * Controller: recibe an instance of mainView to work with their components.
     * @param mainView 
     */
    ConfigController(MainView mainView) {
        this.mainView=mainView;
        this.mainView.spider=null;
        this.mainView.wasp=null;
        generateMatrix();
        openCreateMaze();
        createMaze.btnBack.addActionListener(this);
    }
    /***
     * OpenCreateMaze: this method is in carge of change the view.
     */
    private void openCreateMaze() {
      mainView.setVisible(false);
      createMaze.setVisible(true);
    }
    /***
     * generateMatrix: this method is in charge to create the logic matrix for
     * the game. It create instances of Cell(class that extends from JButton) 
     * and add this new object into an array.
     */
    private void generateMatrix() {
        int name=0;
        mainView.maze=new Cell[9][9];
        mainView.wasp=null;
        mainView.spider=null;
        for (int i = 0; i < 9; i++) 
            for (int j = 0; j < 9; j++) {
                mainView.maze[i][j] = new Cell();
                //mainView.maze[i][j].setText(name+"");
                mainView.maze[i][j].name="cell"+name;name++;
                mainView.maze[i][j].setIcon(new ImageIcon("./src/app/util/wood.jpg"));
                mainView.maze[i][j].addActionListener((e) -> this.cellPressed(e));
                createMaze.pnMaze.add(mainView.maze[i][j]);
            }
    }
    /***
     * CellPressed: this method is an action listener. It is in charge of set 
     * the image acording with the radio button selected.
     * @param e 
     */
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
            btnPussed.setIcon(new ImageIcon("./src/app/util/stone.png"));
            btnPussed.allow=false;
        }
        else if(createMaze.rbnAddWasp.isSelected()){
            if(btnPussed.allow && mainView.wasp==null){
                btnPussed.setIcon(new ImageIcon("./src/app/util/wasp.png"));
                mainView.wasp=btnPussed;
            }
        }  
    }  
    /***
     * ActionPerformed: default method necesary if is implemented the class
     * ActionListener.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnPussed = (JButton) e.getSource();
        if(btnPussed.getText().equals("Back"))
            goBack();
    }
    /***
     * GoBack: this method is in charge of return to the last view.
     */
    private void goBack() {
        mainView.setVisible(true);
        createMaze.setVisible(false);
    }
         
}
