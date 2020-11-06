package ru.analyst.baltbet;

import java.util.ArrayList;
import java.util.List;

public class TeamStats {
    private final String date;
    private final String location;
    private final String name;
    private final String GF;
    private final String GA;
    private final String GFp;
    private final String GAp;
    private final String Shp;
    private final String Svp;
    private final String PPp;
    private final String PKp;
    private final String PUN;
    private final String result;
    private final String score;

    public TeamStats(String date, String location, String name, String GF, String GA, String GFp, String GAp, String shp, String svp, String PPp, String PKp, String PUN, String result, String score) {
        this.date = date;
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

    public String[] toStringArray() {
        List<String> list = new ArrayList<>(14);
        list.add(date);
        list.add(location);
        list.add(name);
        list.add(GF);
        list.add(GA);
        list.add(GFp);
        list.add(GAp);
        list.add(Shp);
        list.add(Svp);
        list.add(PPp);
        list.add(PKp);
        list.add(PUN);
        list.add(result);
        list.add(score);
        return list.toArray(new String[0]);
    }

    @Override
    public String toString() {
        return "TeamStats{" +
                "date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", GF='" + GF + '\'' +
                ", GA='" + GA + '\'' +
                ", GFp='" + GFp + '\'' +
                ", GAp='" + GAp + '\'' +
                ", Shp='" + Shp + '\'' +
                ", Svp='" + Svp + '\'' +
                ", PPp='" + PPp + '\'' +
                ", PKp='" + PKp + '\'' +
                ", PUN='" + PUN + '\'' +
                ", result='" + result + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
