# LHJAAAQ-Horaire-Parser

This program parser matches of Quebec Junior Hockey League (https://www.lhjaaaq.com) in the foloowing format:
| Field | Description |
| --- | --- |
| Date | Date of the match | 
| Location | Home or Away | 
| Team | Shortcut of team name | 
| GF | Total number of goals team scored in season (so far) | 
| GA | Total number of goals scored against the team in season (so far) |
| GF% | GF percentage | 
| GA% | GA percentage | 
| Sh% | Ratio of goals team scored compared to shots taken |
| Sv% | Ratio of goals allowed compared to shots stopped by goalie | 
| PP% | Power Play Success Rate. Ratio where team scored a goal while opposing team had one less man on the ice | 
| PK% | Power Kill Success Rate. Ratio of times team stopped opposing team from scoringwhile they were down a man due to a penalty | 
| PenaltyTime | Penalty time | 
| Final | Win or Loss | 
| Score | Number of goals team scored on that date | 

## Usage
### Input
Program requires 2 arguments:
1. URL to Horaire statistics page, for example: "https://www.lhjaaaq.com/fr/stats/horaire.html?season=2827&subSeason=2829&category=1093"
2. Output file name in .csv, for example: "LHJAAAQ_2019-2020.csv"

### Output
A CSV file containing parsed data.
