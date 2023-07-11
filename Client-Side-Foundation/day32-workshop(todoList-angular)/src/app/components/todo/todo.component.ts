import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { SharedService } from 'src/app/service/shared.service';
@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {
  form!: FormGroup;

  constructor(private fb: FormBuilder, private service: SharedService) { }

  ngOnInit(): void {
    this.createForm();
  }

  createForm() {
    this.form = this.fb.group({
      description: [''],
      priority: [''],
      due: ['']
    })
  }

  addtoTodo() {
    const formData = {
      description: this.form.get('description')?.value,
      priority: this.form.get('priority')?.value,
      due: this.form.get('due')?.value
    }

    this.service.saveFormData(formData).then((data: any) => {
      console.log(data.description);
      console.log(data.priority);
      console.log(data.due);
      this.service.getFormDataList().then((listdata: any) => {
        console.log(listdata);
      });
    }).catch(
      (error) => {
        console.error("error occured: ", error)
      }
    );
  }
}
