/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.net.ics4u.summativechess.game.board.tiles;

import main.java.net.ics4u.summativechess.game.pieces.base.Piece;
import main.java.net.ics4u.summativechess.game.pieces.moves.Move;

/**
 * A tile that will take any piece that lands on it, also removing itself in the process
 *
 * @author joshu
 */
public class MineHole extends Tile {
    /*
     Creates a new mine hole tile
    
     Post: A new mine hole tile is created 
    */
    public MineHole() {
        super();
        
        // Set the image to be the mine hole image
        setImage("variations/mine/mine_hole");
        
        // Set the mine tile's id to M
        id = "MH";
    }
}
