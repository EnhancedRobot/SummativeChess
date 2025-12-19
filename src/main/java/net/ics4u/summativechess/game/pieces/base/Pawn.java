/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.net.ics4u.summativechess.game.pieces.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import main.java.net.ics4u.summativechess.game.board.Board;
import main.java.net.ics4u.summativechess.util.BoardPos;

/**
 *
 * @author joshu
 */
public class Pawn extends Piece {
    
    public int firstTurnMoveDistance = 2;
    public boolean canTakeForwards = false;
    public boolean canMoveDiagonal = false;
    

    public Pawn(BoardPos position, int owner) {
        super(position, owner);
                
        // Set the pawn's id to P
        id = "P";
    }
    
    @Override
    /* 
     Gets the places the piece can move
     Post: Returns the list of places the piece can move to based on the current board state
    */
    public List<BoardPos> getMoves(Board board) {
        // The list of places the piece can go to
        LinkedList<BoardPos> moves = new LinkedList<>();
        
        
        // Handle forwards movement
        // If it's the first turn for the player
        if(board.turn < board.numPlayers) {
            
            BoardPos check = new BoardPos(position);
            for(int i = 0; i < firstTurnMoveDistance; i++) {
                // Step forwards once in the facing direction of the player
                check.add(board.getFacingDirection(player));
                
                // Check if we can move to the position
                if(canMoveToPosition(check, board, canTakeForwards, false)) {
                    // Add the location we are checking 
                    moves.add(new BoardPos(check));
                    
                    // If there is a piece there, then break because we've encountered something that blocks us
                    if (board.getPiece(check) != null) {
                        break;
                    }
                } else {
                    // We've encountered something that blocks us
                    break;
                }
            }
        } else {
            // Get the square in front
            BoardPos check = board.getFacingDirection(player).add(position);
            
            // If we can move to the square in front
            if(canMoveToPosition(check, board, canTakeForwards, false)) {
                // Add the location we are checking 
                moves.add(new BoardPos(check));
            }
        }
        
        // Handle diagonals
        BoardPos forwards = board.getFacingDirection(player);
        
        // If we are going on the y axis
        if(forwards.x == 0) {
            // Get the left diagonal
            BoardPos left = new BoardPos(forwards);
            left.x += -1;
            
            // Get the right diagonal
            BoardPos right = new BoardPos(forwards);
            right.x += 1;
            
            // If we can move to the diagonal left
            if(canMoveToPosition(left, board, true, false, !canMoveDiagonal)) {
                
            }
        }
        
        // If we are going on the x axis
        if(forwards.y == 0) {
            // Get the left diagonal
            BoardPos left = new BoardPos(forwards);
            left.y += -1;
            
            // Get the right diagonal
            BoardPos right = new BoardPos(forwards);
            right.y += 1;
        }
        
        return moves;
    }
    
    @Override
    public void onMoveTo(BoardPos position, Board board) {
        /*
        // If there is a piece in the en passant 
        if(board.enPassantPieces.containsKey(position)) {
            //Get the piece in the en passant
            ArrayList<Arraylist<Piece>> pieces = board.enPassantPieces.get(position);
            
            for (ArrayList<Piece> piece : pieces) {
                // If the piece is a pawn
                if(piece instanceof Pawn) {
                    // En passant that pawn!
                    piece.take();
                }
            }
        }
        */
        
        // Subtract the original position from the new position to get the relative position
        BoardPos moved = new BoardPos(position).subtract(this.position);
        
        // Get the distance travelled
        int distance = Math.max(Math.abs(moved.x), Math.abs(moved.y));
        
        // If the pawn moved more than one square in the facing direction   
        if(distance > 1 && moved.equals(board.getFacingDirection(player).multiply(distance))) {
            // Go forwards until you reach the end
            for(int i = 0; i < distance; i++) {
                // Add the point it passed
                //board.enPassantPieces.put(board.getFacingDirection(player).multiply(i).add(this.position), this);
            }
        }
    }
}
