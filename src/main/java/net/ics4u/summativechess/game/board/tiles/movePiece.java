package main.java.net.ics4u.summativechess.game.PowerUpTile;

public class movePiece {

    PowerUpTile destinationTile;
    Piece piece;

    public void movePiece() {
        if (destinationTile instanceof PowerUpTile) {
            PowerUpTile pTile = (PowerUpTile) destinationTile;
            pTile.activate(piece);
        }
    }
}
