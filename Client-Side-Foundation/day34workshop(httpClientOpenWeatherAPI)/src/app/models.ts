//constants

export const httpUrl:string=" http://api.openweathermap.org/data/2.5/weather/";
export const apiKey:string="d4aea52bfe8c4d52d3aab135e13a663a";
export const geoLocUrl:string="http://api.openweathermap.org/geo/1.0/direct?";
export interface WeatherData {
    main:string;
    description:string;
    icon:string;
    temperature:number;
}