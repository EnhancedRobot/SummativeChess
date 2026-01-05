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

    /*
     Creates a new cult pawn
    
     Post: Cult pawn is created
    */
    public CultPawn(BoardPos position, int owner) {
        super(position, owner);
        
        // Set the pawn's id to P(Pawn) C(Cult)
        id = "P.C";
    }

    /*
     Activate the ability
    
     Post: Pawn can move multiple squares forwards for the turn
    */
    @Override
    public void activateAbility() {
        abilityActive = board.turn;
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
}
