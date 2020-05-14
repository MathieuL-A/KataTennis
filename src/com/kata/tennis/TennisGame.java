package com.kata.tennis;

public class TennisGame {

    private String player1Name = "Player 1";
    private String player2Name = "Player 2";
    private int player1points = 0;
    private int player2points = 0;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void addPointsToPlayer1() {
        this.player1points++;
    }

    public void addPointsToPlayer2() {
        this.player2points++;
    }

    public boolean hasWinner() {

        if (player1points >= 4 && player1points >= player2points + 2) {
            return true;
        }

        if (player2points >= 4 && player2points >= player1points + 2) {
            return true;
        }

        return false;
    }

    private String bestPlayer() {

        if (player1points > player2points) {
            return player1Name;
        } else {
            return player2Name;
        }

    }

    private boolean hasAdvantage() {

        if (player1points >= 4 && player1points == player2points + 1) {
            return true;
        }

        if (player2points >= 4 && player2points == player1points + 1) {
            return true;
        }

        return false;
    }

    private boolean hasDeuce() {

        if (player1points >= 3 && player1points == player2points) {
            return true;
        }

        return false;
    }

    private String renderPoints(int playerPoints) {

        switch (playerPoints) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                throw new IllegalArgumentException("Illegal points: " + playerPoints);
        }

    }

    public String showPoints() {

        if (hasWinner()) {
            return bestPlayer() + " wins";
        }

        if (hasAdvantage()) {
            return "Advantage " + bestPlayer();
        }

        if (hasDeuce()) {
            return "Deuce";
        }

        return renderPoints(player1points) + " - " + renderPoints(player2points);

    }

    public String introducePlayers() {
        return player1Name + " vs " + player2Name;
    }

    public static void main(String[] arg) {
        TennisGame tennisGame = new TennisGame("John", "Jane");
        System.out.println(tennisGame.introducePlayers());

        while (!tennisGame.hasWinner()) {
            System.out.println(tennisGame.showPoints());

            if (Math.random() < 0.5) {
                tennisGame.addPointsToPlayer1();
            } else {
                tennisGame.addPointsToPlayer2();
            }
        }

        System.out.println(tennisGame.showPoints());
    }
}
