import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShoppingcartService {

  constructor() { }

  private _changeDetection!: boolean;
  
  public get changeDetection(): boolean {
    return this._changeDetection;
  }
  public set changeDetection(value: boolean) {
    this._changeDetection = value;
  }


}
