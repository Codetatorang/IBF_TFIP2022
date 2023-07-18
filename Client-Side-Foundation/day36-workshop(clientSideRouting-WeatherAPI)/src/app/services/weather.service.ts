import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { apiUrl } from '../models/model';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
  httpClient: any;

  constructor(private http:HttpClient) { }

  getWeather(city: string, apiKey: string): Promise<any> {
    const params = new HttpParams()
      .set("q", city)
      .set("appid", apiKey)
      .set("units", "metric");

    return lastValueFrom(
      this.httpClient.get(apiUrl, {params: params}));
  }

    
}
