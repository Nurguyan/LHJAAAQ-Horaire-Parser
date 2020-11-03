package ru.analyst.baltbet;

public class TeamStats {
    private String name;
    private int bp;
    private int bc;
    private double bpPercentage;
    private double bcPercentage;
    private double tirs;
    private double an;
    private double dn;
    private double pun;

    public TeamStats(String name, int bp, int bc, double bpPercentage, double bcPercentage, double tirs, double an, double dn, double pun) {
        this.name = name;
        this.bp = bp;
        this.bc = bc;
        this.bpPercentage = bpPercentage;
        this.bcPercentage = bcPercentage;
        this.tirs = tirs;
        this.an = an;
        this.dn = dn;
        this.pun = pun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBp() {
        return bp;
    }

    public void setBp(int bp) {
        this.bp = bp;
    }

    public int getBc() {
        return bc;
    }

    public void setBc(int bc) {
        this.bc = bc;
    }

    public double getBpPercentage() {
        return bpPercentage;
    }

    public void setBpPercentage(double bpPercentage) {
        this.bpPercentage = bpPercentage;
    }

    public double getBcPercentage() {
        return bcPercentage;
    }

    public void setBcPercentage(double bcPercentage) {
        this.bcPercentage = bcPercentage;
    }

    public double getTirs() {
        return tirs;
    }

    public void setTirs(double tirs) {
        this.tirs = tirs;
    }

    public double getAn() {
        return an;
    }

    public void setAn(double an) {
        this.an = an;
    }

    public double getDn() {
        return dn;
    }

    public void setDn(double dn) {
        this.dn = dn;
    }

    public double getPun() {
        return pun;
    }

    public void setPun(double pun) {
        this.pun = pun;
    }
}
