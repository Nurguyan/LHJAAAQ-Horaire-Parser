package com.company;

public class MatchInfo {
    public TeamStats local;
    public TeamStats visitor;

    public MatchInfo(TeamStats local, TeamStats visitor) {
        this.local = local;
        this.visitor = visitor;
    }
}
