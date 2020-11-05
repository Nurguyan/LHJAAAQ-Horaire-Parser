package ru.analyst.baltbet;

public class TeamStatsBuilder {
    private String location;
    private String name;
    private int gf;
    private int ga;
    private double gFp;
    private double gAp;
    private double shp;
    private double svp;
    private double pPp;
    private double pKp;
    private int pun;
    private String result;
    private int score;

    public TeamStatsBuilder setLocation(String location) {
        this.location = location;
        return this;
    }

    public TeamStatsBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TeamStatsBuilder setGF(int gf) {
        this.gf = gf;
        return this;
    }

    public TeamStatsBuilder setGA(int ga) {
        this.ga = ga;
        return this;
    }

    public TeamStatsBuilder setGFPercentage(double gFp) {
        this.gFp = gFp;
        return this;
    }

    public TeamStatsBuilder setGAPercentage(double gAp) {
        this.gAp = gAp;
        return this;
    }

    public TeamStatsBuilder setShotsPercentage(double shp) {
        this.shp = shp;
        return this;
    }

    public TeamStatsBuilder setSavesPercentage(double svp) {
        this.svp = svp;
        return this;
    }

    public TeamStatsBuilder setPowerPlaysPercentage(double pPp) {
        this.pPp = pPp;
        return this;
    }

    public TeamStatsBuilder setPowerKillsPercentage(double pKp) {
        this.pKp = pKp;
        return this;
    }

    public TeamStatsBuilder setPenaltyTime(int pun) {
        this.pun = pun;
        return this;
    }

    public TeamStatsBuilder setResult(String result) {
        this.result = result;
        return this;
    }

    public TeamStatsBuilder setScore(int score) {
        this.score = score;
        return this;
    }

    public TeamStats createTeamStats() {
        return new TeamStats(location, name, gf, ga, gFp, gAp, shp, svp, pPp, pKp, pun, result, score);
    }
}