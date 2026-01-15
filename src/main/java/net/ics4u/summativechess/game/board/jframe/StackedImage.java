/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.net.ics4u.summativechess.game.board.jframe;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author joshu
 */
public class StackedImage extends ImageIcon {
    // The list of icons that make up the stacked image
    public ImageIcon[] icons;
    
    /*
     Draws the icon
    
     Post: Icon is drawn
    */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        // For every icon slot
        for (Icon icon : icons) {
            // If there is an icon in that slot
            if(icon != null) {
                // Get the centered x pos
                int xPos = x - (icon.getIconWidth() - getIconWidth()) / 2;
                // Get the centered y pos
                int yPos = y - (icon.getIconHeight() - getIconHeight()) / 2;
            
                // Draw the icon centered
                icon.paintIcon(c, g, xPos, yPos);
            }
        }
    }
    
    /*
     Gets the width of the icon
    
     Post: Returns the width of the largest image
    */
    @Override
    public int getIconWidth() {
        // Default width of 0
        int width = 0;
        // For every icon
        for (Icon icon : icons) {
            // If there is an icon in that slot
            if(icon != null) {
                // Set the width to the larger of the current width and the icon width
                width = Math.max(width, icon.getIconWidth());
            }
        }
        // Return the largest width
        return width;
    }

    /*
     Gets the height of the icon
    
     Post: Returns the height of the largest image
    */
    @Override
    public int getIconHeight() {
        // Default width of 0        
        int height = 0;
        
        // For every icon        
        for (Icon icon : icons) {
            // If there is an icon in that slot
            if(icon != null) {
                // Set the height to the larger of the current height and the icon height
                height = Math.max(height, icon.getIconHeight());
            }
        }
        
        // Return the largest height
        return height;
    }
}
