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
import javax.swing.ImageIcon;

public class ConfigController {
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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mainView.maze[i][j] = new Cell();
                mainView.maze[i][j].setIcon(new ImageIcon("./src/app/util/wood.png"));
                createMaze.pnMaze.add(mainView.maze[i][j]);
            }
        }
    }
    
}
