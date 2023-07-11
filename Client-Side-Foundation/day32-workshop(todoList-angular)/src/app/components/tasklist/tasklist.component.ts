import { Component, OnInit } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { TodoData } from 'src/app/models/models';
import { SharedService } from 'src/app/service/shared.service';

@Component({
  selector: 'app-tasklist',
  templateUrl: './tasklist.component.html',
  styleUrls: ['./tasklist.component.scss']
})
export default class TasklistComponent implements OnInit{

  taskList!:Promise<any[]>;
  constructor(private service: SharedService) { }

  todoData!: TodoData;

  ngOnInit(): void {
    this.taskList = this.service.getFormDataList();
    (this.taskList).then((data: any) => {
      //todo implement for loop method
    });
  }

}
