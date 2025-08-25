import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormControl, FormGroup, NgForm, ReactiveFormsModule, Validators } from '@angular/forms';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'FeedbackForm';
  myFormReact!: FormGroup;
  onSubmitReact() {
    if(this.myFormReact.valid){
      alert('Thank you for your submission! We will get back to you soon.');
      console.log(this.myFormReact.valid);
      this.myFormReact.reset();
    }
    else{
      console.log("Form is invalid");
    }
    console.log(this.myFormReact.value)
  }
  ngOnInit(){
      this.myFormReact=new FormGroup(
        {
          name:new FormControl('',[Validators.required]),
          email:new FormControl('',[Validators.required,Validators.email]),
          subject:new FormControl('',[Validators.required, Validators.minLength(5),Validators.maxLength(40)]),
          comments:new FormControl('',[Validators.required,Validators.maxLength(350)]),
        }
      );
    }
  onSubmit(f: NgForm){
    console.log(f.value)
  }
}
