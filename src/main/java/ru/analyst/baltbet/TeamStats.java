package ru.analyst.baltbet;

import java.time.format.DateTimeFormatter;

public class TeamStats {
    private String location;
    private String name;
    private int GF;
    private int GA;
    private double GFp;
    private double GAp;
    private double Shp;
    private double Svp;
    private double PPp;
    private double PKp;
    private int PUN;

    public TeamStats(String location, String name, int GF, int GA, double GFp, double GAp, double shp, double svp, double PPp, double PKp, int PUN, String result, int score) {
        this.location = location;
        this.name = name;
        this.GF = GF;
        this.GA = GA;
        this.GFp = GFp;
        this.GAp = GAp;
        Shp = shp;
        Svp = svp;
        this.PPp = PPp;
        this.PKp = PKp;
        this.PUN = PUN;
        this.result = result;
        this.score = score;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private String result;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        char delimiter = ';';
        return  location + delimiter +
                name + delimiter +
                GF + delimiter +
                GA + delimiter +
                GFp + delimiter +
                GAp + delimiter +
                Shp + delimiter +
                Svp + delimiter +
                PPp + delimiter +
                PKp + delimiter +
                PUN + delimiter +
                result + delimiter +
                score;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getGF() {
        return GF;
    }

    public void setGF(int GF) {
        this.GF = GF;
    }

    public int getGA() {
        return GA;
    }

    public void setGA(int GA) {
        this.GA = GA;
    }

    public double getGFp() {
        return GFp;
    }

    public void setGFp(double GFp) {
        this.GFp = GFp;
    }

    public double getGAp() {
        return GAp;
    }

    public void setGAp(double GAp) {
        this.GAp = GAp;
    }

    public double getShp() {
        return Shp;
    }

    public void setShp(double shp) {
        Shp = shp;
    }

    public double getSvp() {
        return Svp;
    }

    public void setSvp(double svp) {
        Svp = svp;
    }

    public double getPPp() {
        return PPp;
    }

    public void setPPp(double PPp) {
        this.PPp = PPp;
    }

    public double getPKp() {
        return PKp;
    }

    public void setPKp(double PKp) {
        this.PKp = PKp;
    }

    public int getPUN() {
        return PUN;
    }

    public void setPUN(int PUN) {
        this.PUN = PUN;
    }
}
