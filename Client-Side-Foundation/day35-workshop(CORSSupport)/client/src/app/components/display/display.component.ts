import { HttpClient } from '@angular/common/http';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { Games, apiUrl } from 'src/app/models';
@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.scss']
})

export class DisplayComponent implements OnInit, OnDestroy{  
  p: number = 1;
  pp:number = 5; //items per page 
  gameList:string[] = [];//list to store the games
  
  constructor(private http:HttpClient) { }


  ngOnInit(): void {
    lastValueFrom( this.http.get<any>(apiUrl)).then((result)=>{
      
      result.games.forEach((game: any) => {
        this.gameList.push(game.name);

        console.log(game.name);
      });
    }).catch(
      (err)=>{
        console.log("error occured: ",err);
      }
    )

    console.log(this.gameList);
  }

  ngOnDestroy(): void {
    //todo: to be implemented
    throw new Error('Method not implemented.');
  }
}
