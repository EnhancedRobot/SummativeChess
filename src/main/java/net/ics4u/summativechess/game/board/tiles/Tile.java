/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.net.ics4u.summativechess.game.board.tiles;

import javax.swing.ImageIcon;
import main.java.net.ics4u.summativechess.util.BoardPos;

/**
 *
 * @author joshu
 */
public abstract class Tile {
    public boolean isTraversable = true;
    public ImageIcon image;
    
    public void onMoveTo() {};
    
    public static Tile getTile(String tileString, BoardPos position) {
        // If it's trying to get an empty string, return nothing
        if(tileString.equals("")) {
            return null;
        }
        
        Tile created;
                
        // Get the tile based on the given id
        switch(tileString) {
            default -> {
                created = null;
                System.out.println("Invalid piece: " + tileString + " at " + position.toString());
            }
        }
        
        return created;
    }
}
