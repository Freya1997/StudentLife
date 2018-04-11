package com.a_team.studentlife;

import android.content.Context;

import com.a_team.studentlife.Server.ServerResponse.ListLeagueNewsResponse;
import com.a_team.studentlife.adapter.leagues.LeaguesAdapter;
import com.a_team.studentlife.card_view_filling.LeagueListElement;
import com.a_team.studentlife.card_view_filling.NewsPost;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import  static org.junit.Assert.*;


public class MockitoTests {

    @Test
    public void NewsPost_IsCopiedCorrectly(){
        assertThat(NewsPost.newsPosts.size()==0,is(true));
    }


//_____________________________________________________________________________________________
    //??????????
    @Test
    public void getPostItems_CorrectPostItem_ReturnsTrue(){
   //     assertThat(NewsPost.getPostItems("","","","","",12,true,""),is(true));
    }

  /*  @Test
    public void getParticipants_IsCorrect(){
        assertThat(NewsPost.getPaticipants())
    }
*/


    @Test
    public void updateAllUserNews_IsDoneWell(){
   //     assertThat(NewsPost.updateAllUserNews(ArrayList<ListLeagueNewsResponse>, ArrayList<newsPosts> newsPosts), is(true));
    }

    @Test
    public void updateLeagueNews_IsDoneWell(){
    //    assertThat(NewsPost.updateLeagueNews(),is(true));//???????
    }

    //___________________________________________________________________________

    //_____leagueListElement_____________________
    @Test
    public void createdListOfLeagues(){
        assertTrue(LeagueListElement.leagueListElements.size()==0);
    }


    @Test
    public void LeagueListElements_isNonEmpty(){
        assertThat(LeagueListElement.class.getConstructors().length == 0,is(false));
    }



    //?????
    @Test
    public void getLeagueListElements_isRight(){
     //   assertThat(LeagueListElement.getLeagueListElements(1, 1, 1,11,123),is(true));
    }

    //__________________________________leaguesAdapter_________
    

}
