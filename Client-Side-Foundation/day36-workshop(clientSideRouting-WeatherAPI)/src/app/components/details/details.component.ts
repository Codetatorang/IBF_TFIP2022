import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Weather, apiKey } from 'src/app/models/model';
import { WeatherService } from 'src/app/services/weather.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent implements OnInit {
  params$!: Subscription;
  city!: string;
  model = new Weather(this.city, 0,0,0,'',0,0);
  
  constructor(private service: WeatherService, private router: Router, private activatedRoute: ActivatedRoute) { }


  ngOnInit(): void {
    this.params$ = this.activatedRoute.params.subscribe(
      (params) => {
        this.city = params['city'];
      }
    )
    this.getWeatherDetailsFromAPI(this.city);
  }

  getWeatherDetailsFromAPI(city: string) {
     this.service.getWeather(city,apiKey).then( (result) =>{
      console.log(result)
      // const cityObj = this.se/rvice.getCityUrl(city)
      this.model = new Weather(
        city,
        result.main.temp,
        result.main.pressure,
        result.main.humidity,
        result.weather[0].description,
        // cityObj!.imageUrl,
        result.wind.degree,
        result.wind.speed,
      )
    }).catch( (err) =>{
      console.log(err)//do not console log too many times, will slow down performance
      this.router.navigate([''])
    })
  }
}
