package main.java.net.ics4u.summativechess.game.PowerUpTile;

import main.java.net.ics4u.summativechess.game.board.tiles.Tile;
import main.java.net.ics4u.summativechess.game.pieces.base.Piece;

public class PowerUpTile extends Tile{
    
    private PowerUpType type;
    private boolean used;

    public PowerUpTile(int x, int y, PowerUpType type) {
        super();
        this.type = type;
        this.used = false;
    }

    public PowerUpType getType() {
        return type;
    }

    public boolean isUsed() {
        return used;
    }
    public void activate(Piece piece) {
        if(used) return;


        switch (type) {
            case EXTRA_MOVE:
                piece.setExtraMove(true);
                break;
            case SHIELD:
                piece.setShielded(true);
                break;
            case TELEPORT:
                piece.setCanTeleport(true);
                break;
        }
        used = true;
    }

    public enum PowerUpType {
        EXTRA_MOVE,
        TELEPORT,
        SHIELD
    }
}