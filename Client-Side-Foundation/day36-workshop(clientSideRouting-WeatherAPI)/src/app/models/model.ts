export const apiKey = "d4aea52bfe8c4d52d3aab135e13a663a";
export const apiUrl = "https://api.openweathermap.org/data/2.5/weather";

export class Weather {
    constructor(
        public cityName:string,
        public temp:number,
        public pressure:number,
        public humidity:number,
        public description:string,
        // public imageUrl:string,
        public windSpeed:number,
        public windDegree:number
    ){}
}