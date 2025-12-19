/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.net.ics4u.summativechess.game.end;

import main.java.net.ics4u.summativechess.game.board.Board;

/**
 *
 * @author joshu
 */
public abstract class VictoryCondition {
    public abstract VictoryState isEnded(Board board);
}
