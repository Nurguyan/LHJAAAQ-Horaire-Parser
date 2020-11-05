package ru.analyst.baltbet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MatchInfo {
    private LocalDate date;
    private TeamStats local;
    private TeamStats visitor;

    public MatchInfo(LocalDate date, TeamStats local, TeamStats visitor) {
        this.date = date;
        this.local = local;
        this.visitor = visitor;
    }

    public TeamStats getLocal() {
        return local;
    }

    public void setLocal(TeamStats local) {
        this.local = local;
    }

    public TeamStats getVisitor() {
        return visitor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setVisitor(TeamStats visitor) {
        this.visitor = visitor;
    }

    @Override
    public String toString() {
        char delimiter = ';';
        DateTimeFormatter numericFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(numericFormatter) + delimiter + local + delimiter + visitor;
    }
}
