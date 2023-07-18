import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { apiKey, apiUrl } from 'src/app/models/model';
@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.scss']
})
export class DisplayComponent implements OnInit {

  cityList: string[] = [
    "Singapore",
    "Kuala Lumpur",
    "Toyko",
    "Bangkok",
    "HongKong",
    "Beijing",
  ]; //list of cities

  form!: FormGroup;

  constructor(private router: Router, private http: HttpClient, private fb: FormBuilder) { }


  ngOnInit(): void {
    this.createForm();
  }

  addToList() {
    //check for duplicates before adding
    let titleCaseCity = this.form.value.city.charAt(0).toUpperCase() + this.form.value.city.slice(1).toLowerCase();
    if (this.cityList.includes(titleCaseCity)) {
      alert("City already exists in list!");
    }
    else
      this.cityList.push(titleCaseCity);
  }

  createForm() {
    this.form = this.fb.group({
      city: ['', Validators.required],
    });
  }

  printCity(button: HTMLDivElement) {
    console.log(button.innerHTML.trim());
  }
}

