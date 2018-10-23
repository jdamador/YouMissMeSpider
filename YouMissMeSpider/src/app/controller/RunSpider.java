/******************************************************************************\
 * Logic paradigm implementation in Java
 * Author: Daniel Amador Salas
 * Version: 1.0
 * Date: October 16th
 * Class: ConfigController -: this class manage the view components.
\******************************************************************************/
package app.controller;
import app.model.Cell;
import app.model.Connection;
import app.view.MainView;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class RunSpider implements Runnable{
    private Cell actual;
    private ArrayList<Cell> path;
    private MainView mainView;
    public boolean running=true;
    public RunSpider(MainView mainView, ArrayList<Cell> path) {
        this.mainView=mainView;
        this.path=path;
        this.actual=mainView.spider;
    }
    /***
     * This method is responsible for managing the movement of the bee
     * during the game
     * @throws InterruptedException 
     */
    public void StartMovement() throws InterruptedException{
        int index=0;
        while(running){
            if(index<path.size()){
                this.actual.setIcon(new ImageIcon("./src/app/util/wood.jpg"));
                this.actual=path.get(index); index++;
                setNewPosition(actual);
                Thread.sleep(500);
            }else{
                new Connection().clear();
                JOptionPane.showMessageDialog(null, "Bon Appétit!!!");
                running=false;
                break;
            }
        }
    }
    /***
     * This method is a default function to start the thread.
     */
    @Override
    public void run() {
        try {
            this.StartMovement();
        } catch (InterruptedException ex) {
           
        }
    }
    /***
     * This method is in charge of set the new icom image to a button.
     * @param actual 
     */
    private void setNewPosition(Cell actual) {
        actual.setIcon(new ImageIcon("./src/app/util/spider.png"));
        mainView.spider=actual;
    }
    
}
