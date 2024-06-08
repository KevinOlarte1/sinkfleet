package com.grupo.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.grupo.engine.input.KeyboardManager;

public class NumericKeyboardManager extends KeyboardManager {
    private String posX;
    private String posY;
    private boolean isHorizontal;
    private boolean enterPressed;

    public NumericKeyboardManager(char upKey, char downKey, char leftKey, char rightKey, char fireKey, char jumpKey) {
        super(upKey, downKey, leftKey, rightKey, fireKey, jumpKey);
        posX = "";
        posY = "";
        isHorizontal = true;
    }

    public String getPosX() {
        if (posX == null || posX.isEmpty()) {
            return "0";
            
        }
        return posX;
    }

    public String getPosY() {
        if (posY == null || posY.isEmpty()) {
            return "0";
        }
        return posY;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public void clearPosX() {
        posX = "";
    }

    public void clearPosY() {
        posY = "";
    }

    public boolean isEnterPressed() {
        return enterPressed;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public void setEnterPressed(boolean enterPressed) {
        this.enterPressed = enterPressed;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (isDigit(c)) {
            if (posX.length() < 2) {
                posX += c;
            } else if (posY.length() < 2) {
                posY += c;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            isHorizontal = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            isHorizontal = true;
        } else if (key == KeyEvent.VK_BACK_SPACE) {
            if (posY.length() > 0) {
                posY = posY.substring(0, posY.length() - 1);
            } else if (posX.length() > 0) {
                posX = posX.substring(0, posX.length() - 1);
            }
        }else if (key == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        enterPressed = false;
    }
}