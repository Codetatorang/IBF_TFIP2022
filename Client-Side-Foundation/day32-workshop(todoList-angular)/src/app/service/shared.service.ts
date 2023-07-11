import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  private tasklist: any[] = [];
  private formdataSubject = new BehaviorSubject<any[]>(this.tasklist);

  constructor() { }

  saveFormData(formData: any): Promise<any> {
    return new Promise((resolve, reject) => {
      // Simulating an asynchronous API call
      setTimeout(() => {
        this.tasklist.push(formData);
        this.formdataSubject.next(this.tasklist);
        resolve(formData);
      }, 150);
    });
  }

  getFormDataList(): Promise<any[]> {
    return new Promise((resolve) => {
      // Simulating an asynchronous API call
      setTimeout(() => {
        resolve(this.tasklist);
      }, 150);
    });
  }

  subscribeToFormDataList(callback: (formDataList: any[]) => void) {
    this.formdataSubject.subscribe(callback);
  }

  
}
