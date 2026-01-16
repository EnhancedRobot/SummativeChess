/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.net.ics4u.summativechess.game.pieces.base;

/**
 * Implementing this class adds an active ability to the piece
 *
 * @author joshu
 */
public interface ActiveAbility {
    void activateAbility();
    public String getAbilityDescription();
}
