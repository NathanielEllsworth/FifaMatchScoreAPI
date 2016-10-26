package com.ironyard.data;

/**
 * Created by nathanielellsworth on 10/26/16.
 */
public class FifaMatch {

    private int id;
    private String country;
    private String alternate_name;
    private String fifa_code;
    private int group_id;
    private String group_letter;
    private int wins;
    private int draws;
    private int losses;
    private int games_played;
    private int points;
    private int goals_for;
    private int goals_against;
    private int goal_differential;

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public String getCountry() {return country;}

    public void setCountry(String country) {this.country = country;}

    public String getAlternate_name() {return alternate_name;}

    public void setAlternate_name(String alternate_name) {this.alternate_name = alternate_name;}

    public String getFifa_code() {return fifa_code;}

    public void setFifa_code(String fifa_code) {this.fifa_code = fifa_code;}

    public int getGroup_id() {return group_id;}

    public void setGroup_id(int group_id) {this.group_id = group_id;}

    public String getGroup_letter() {return group_letter;}

    public void setGroup_letter(String group_letter) {this.group_letter = group_letter;}

    public int getWins() {return wins;}

    public void setWins(int wins) {this.wins = wins;}

    public int getDraws() {return draws;}

    public void setDraws(int draws) {this.draws = draws;}

    public int getLosses() {return losses;}

    public void setLosses(int losses) {this.losses = losses;}

    public int getGames_played() {return games_played;}

    public void setGames_played(int games_played) {this.games_played = games_played;}

    public int getPoints() {return points;}

    public void setPoints(int points) {this.points = points;}

    public int getGoals_for() {return goals_for;}

    public void setGoals_for(int goals_for) {this.goals_for = goals_for;}

    public int getGoals_against() {return goals_against;}

    public void setGoals_against(int goals_against) {this.goals_against = goals_against;}

    public int getGoal_differential() {return goal_differential;}

    public void setGoal_differential(int goal_differential) {this.goal_differential = goal_differential;}
}
