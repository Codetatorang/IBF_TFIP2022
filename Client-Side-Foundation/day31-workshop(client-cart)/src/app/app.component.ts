import { Component, Input, OnInit } from '@angular/core';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'day31-workshop-client-cart';
  
  // taking @output from inventory component to parse to shoppingcart component
  fruit!:string;


  ngOnInit(): void {
  }

  transferFruit(transferfruit: string) {
    this.fruit = transferfruit; 
  }
}
