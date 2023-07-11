import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CalculatorService } from 'src/app/services/calculator.service';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent implements OnInit{

  inputForm!:FormGroup;
  result!:number;
  isPristine:boolean = true;

  constructor(private fb:FormBuilder ,private calcService:CalculatorService) { }
  
  ngOnInit(): void {
    this.createInputForm();
  }

  createInputForm():void{
    this.inputForm = this.fb.group({
      num1: ['',[Validators.required]],
      sign: ['',[Validators.required, Validators.pattern('[+\\-*/√^!]')]],
      num2: ['',[Validators.required]],
    });
  }

  onSubmit():void{
    if(this.inputForm.valid){
      this.isPristine = false;
      let num1 = this.inputForm.get('num1')?.value;
      let num2 = this.inputForm.get('num2')?.value;
      let sign = this.inputForm.get('sign')?.value;
      switch(sign){
        case '+':
          this.result = this.calcService.add(num1,num2);
          break;
        case '-':
          this.result = this.calcService.subtract(num1,num2);
          break;
        case '*':
          this.result = this.calcService.multiply(num1,num2);
          break;
        case '/':
          this.result = this.calcService.divide(num1,num2);
          break;
        case '√':
          this.result = this.calcService.squareRoot(num1);
          break;
        case '^':
          this.result = this.calcService.exponent(num1,num2);
          break;
        case '!':
          this.result = this.calcService.factorial(num1);
          break;
      }
      // button.disabled = true;
      console.log("result:", this.result);

    }
  }

  checkPristine():boolean{
    return this.inputForm.pristine;
  }
}
