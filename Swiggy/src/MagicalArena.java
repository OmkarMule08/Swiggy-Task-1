package com.Swiggy;
import java.util.Random;

class Player {
    private int health;
    private int strength;
    private int attack;

    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    public void attack(Player opponent, Random dice) {
        int attackRoll = dice.nextInt(6) + 1;
        int damage = attackRoll * this.attack;

        int defenseRoll = dice.nextInt(6) + 1;
        int defense = defenseRoll * opponent.getStrength();

        int damageDealt = Math.max(0, damage - defense);
        opponent.setHealth(opponent.getHealth() - damageDealt);

        System.out.println("Player attacks with roll " + attackRoll + " and deals " + damageDealt + " damage.");
    }
}

public class MagicalArena {
    public static void main(String[] args) {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        Random dice = new Random();

        System.out.println("Player A Health: " + playerA.getHealth() + " | Player B Health: " + playerB.getHealth());

        while (playerA.getHealth() > 0 && playerB.getHealth() > 0) {
            if (playerA.getHealth() < playerB.getHealth()) {
                playerA.attack(playerB, dice);
            } else {
                playerB.attack(playerA, dice);
            }
            System.out.println("Player A Health: " + playerA.getHealth() + " | Player B Health: " + playerB.getHealth());
        }

        if (playerA.getHealth() <= 0) {
            System.out.println("Player B wins!");
        } else {
            System.out.println("Player A wins!");
        }
    }
}
