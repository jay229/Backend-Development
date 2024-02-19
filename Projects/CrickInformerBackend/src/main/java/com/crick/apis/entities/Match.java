package com.crick.apis.entities;

import com.crick.apis.enums.MatchStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "cricket_match")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;

    private String teamHeading;
    private String matchNumberVenue;
    private String battingTeam;
    private String battingTeamScore;
    private String bollTeam;
    private String bollTeamScore;
    private String liveText;
    private String matchLink;
    private String textComplete;
    @Enumerated(value = EnumType.STRING)
    private MatchStatus status;
    private Date date=new Date();


    public void setMatchStatus(){
        if(textComplete.isBlank()){
            this.status=MatchStatus.LIVE;
        }
        else{
            this.status=MatchStatus.COMPLETED;
        }
    }



}
