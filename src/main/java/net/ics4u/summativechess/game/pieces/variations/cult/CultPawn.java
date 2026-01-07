/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.net.ics4u.summativechess.game.pieces.variations.cult;

import java.util.LinkedList;
import java.util.List;
import main.java.net.ics4u.summativechess.game.pieces.base.ActiveAbility;
import main.java.net.ics4u.summativechess.game.pieces.base.Pawn;
import main.java.net.ics4u.summativechess.game.pieces.moves.Move;
import main.java.net.ics4u.summativechess.util.BoardPos;

/**
 *
 * @author joshu
 */
public class CultPawn extends Pawn implements ActiveAbility {
    
    // The turn the pawn's move forwards ability is active
    public int abilityActive = -1;
    
    // The kill count of this pawn
    public int killCount = 0;
    
    // Whether or not this piece can activate their ability
    public boolean canActivateAbility = false;

    /*
     Creates a new cult pawn
    
     Post: Cult pawn is created
    */
    public CultPawn(BoardPos position, int owner) {
        super(position, owner);
        
        // Set the pawn's id to P(Pawn) C(Cult)
        id = "PC";
    }

    /*
     Activate the ability
    
     Post: Pawn can move multiple squares forwards for the turn
    */
    @Override
    public void activateAbility() {
        // If you can activate the ability
        if(canActivateAbility) {
            // Set the ability to be useable for this turn
            abilityActive = board.turn;
            
            // Reset the canActivateAbility
            canActivateAbility = false;
        }
    }
    
    /*
     Gets the available moves for the cultist pawn
    */
    @Override
    public List<Move> getMoves() {
        // The list of places the piece can go to
        LinkedList<Move> moves = new LinkedList<>();
        
        
        // Handle forwards movement
        // If the pawn can always move double or it's the first move for the pawn or the ability is active this turn
        if(board.variations.pawnsAlwaysMoveDouble || timesMoved == 0 || board.turn == abilityActive) {
            // Check the multi forwards move
            doubleForwardsMove(moves);
        } else {
            // Check the tile in front
            singleForwardsMove(moves);
        }
        
        // Handle diagonals
        getDiagonals(moves);
        
        return moves;
    }
    
    /*
     Handle stuff after moving
    
     Post: Increments the kill count if the move was a kill and checks if the kill count is 2 to allow for ability activation
    */
    @Override
    public void onMove(Move move) {
        // If the move was a take
        if(move.isTake) {
            // Increment the kill count
            killCount++;
            
            // If the kill count is 2
            if(killCount == 2) {
                // Reset it
                killCount = 0;
                
                // And make the ability possible to activate
                canActivateAbility = true;
            }
        }
    }
}
