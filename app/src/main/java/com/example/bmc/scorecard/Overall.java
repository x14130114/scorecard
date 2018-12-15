package com.example.bmc.scorecard;

public class Overall {
    private int id;
    private String player1;
    private String player2;
    private String result;
    private String result2;
    private String course;

    public Overall() {
    }

    public Overall(String player1, String player2, String result, String result2, String course) {
        this.player1 = player1;
        this.player2 = player2;
        this.result = result;
        this.result2 = result2;
        this.course = course;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult2() {
        return result2;
    }

    public void setResult2(String result2) {
        this.result2 = result2;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Scoreboard{" +
                "id=" + id +
                ", player1='" + player1 + '\'' +
                ", player2='" + player2 + '\'' +
                ", result=" + result + '\'' +
                ", result2=" + result2 + '\'' +
                ", course='" + course +
                '}';
    }
}
