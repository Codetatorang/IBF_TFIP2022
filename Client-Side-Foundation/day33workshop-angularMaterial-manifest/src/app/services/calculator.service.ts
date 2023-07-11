import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  constructor() { }

  //addition
  add(num1: number, num2: number): number {
    return num1 + num2;
  }

  //subtraction
  subtract(num1: number, num2: number): number {
    return num1 - num2;
  }

  //multiplication
  multiply(num1: number, num2: number): number {
    return num1 * num2;
  }

  //division
  divide(num1: number, num2: number): number {
    return num1 / num2;
  }

  //square root
  squareRoot(num1: number): number {
    return Math.sqrt(num1);
  }

  //exponent
  exponent(num1: number, num2: number): number {
    return Math.pow(num1, num2);
  }

  //factorial
  factorial(num1: number): number {
    let result = 1;
    for (let i = 1; i <= num1; i++) {
      result = result * i;
    }
    return result;
  }
}
