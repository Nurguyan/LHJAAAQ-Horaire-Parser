package com.company;

public class TeamStatsBuilder {
    private String date;
    private String location;
    private String name;
    private String gf;
    private String ga;
    private String gFp;
    private String gAp;
    private String shp;
    private String svp;
    private String pPp;
    private String pKp;
    private String pun;
    private String result;
    private String score;

    public TeamStatsBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public TeamStatsBuilder setLocation(String location) {
        this.location = location;
        return this;
    }

    public TeamStatsBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TeamStatsBuilder setGF(String gf) {
        this.gf = gf;
        return this;
    }

    public TeamStatsBuilder setGA(String ga) {
        this.ga = ga;
        return this;
    }

    public TeamStatsBuilder setGFp(String gFp) {
        this.gFp = gFp;
        return this;
    }

    public TeamStatsBuilder setGAp(String gAp) {
        this.gAp = gAp;
        return this;
    }

    public TeamStatsBuilder setShp(String shp) {
        this.shp = shp;
        return this;
    }

    public TeamStatsBuilder setSvp(String svp) {
        this.svp = svp;
        return this;
    }

    public TeamStatsBuilder setPPp(String pPp) {
        this.pPp = pPp;
        return this;
    }

    public TeamStatsBuilder setPKp(String pKp) {
        this.pKp = pKp;
        return this;
    }

    public TeamStatsBuilder setPUN(String pun) {
        this.pun = pun;
        return this;
    }

    public TeamStatsBuilder setResult(String result) {
        this.result = result;
        return this;
    }

    public TeamStatsBuilder setScore(String score) {
        this.score = score;
        return this;
    }

    public TeamStats createTeamStats() {
        return new TeamStats(date, location, name, gf, ga, gFp, gAp, shp, svp, pPp, pKp, pun, result, score);
    }
}