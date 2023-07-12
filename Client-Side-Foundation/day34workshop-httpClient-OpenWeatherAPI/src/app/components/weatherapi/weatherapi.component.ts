import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable, Subscription, lastValueFrom, map } from 'rxjs';
import { WeatherData, apiKey, httpUrl } from 'src/app/models';
@Component({
  selector: 'app-weatherapi',
  templateUrl: './weatherapi.component.html',
  styleUrls: ['./weatherapi.component.scss']
})
export class WeatherapiComponent implements OnInit, OnDestroy {
  city: string = "";
  weatherData: any;
  form!: FormGroup;

  weather$!: Subscription
  weatherObs$!: Observable<WeatherData[]>
  weatherProm$!: Promise<WeatherData[]>

  result: WeatherData[] = []

  constructor(private fb: FormBuilder, private http: HttpClient) { }



  ngOnInit(): void {
    this.form = this.fb.group({
      city: ['', Validators.required]
    });
  }

  ngOnDestroy(): void {
    this.weather$.unsubscribe();
  }

  getWeatherWithPromise2() {
    this.weatherProm$ = lastValueFrom(this.getWeather());
  }

  getWeather() {
    const city = this.form.value['city'];

    const params = new HttpParams()
      .set('q', city)
      .set('units', 'metric')
      .set('appid', apiKey);

    return this.http.get<WeatherData>(httpUrl, { params }).pipe(
      map((v: any) => {
        //.main..temp
        const temp = v['main']['temp']
        //.weather
        const weather = v['weather'] as any[]
        return weather.map(w => {
          return {
            // .weather[*].main
            main: w['main'],
            // .weather[*].description
            description: w['description'],
            // .weather[*].icon,
            icon: w['icon'],
            temperature: temp
          } as WeatherData;
        })
      }))



    // fetch(`${httpUrl}?q=${this.city}&appid=${apiKey}`)
    //   .then(response => response.json());
  }
}
