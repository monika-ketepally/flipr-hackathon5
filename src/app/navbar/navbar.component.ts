import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
name : any;
user : any;
password : any;
userr : any;

  constructor(private service : ServiceService) {
    this.user = {email : '' , password : ''};
    this.userr = {email : '' , password : ''};
   }

  ngOnInit(): void {
  }
  loginck():any{
    if(this.service.name != null){
      this.name = this.service.name; 
      return true;
    }
    else{
      return false;
    }
  }

  logout():any{
    this.service.name = '';
  }
  login(form : any):any{
    this.service.loginCust(this.user.email,this.user.password).subscribe((result:any)=>{
    if(result!=null){
      this.service.name = result.email;
      console.log(result)
  }
    else{
      alert('Invalid credentials');
    }
  });
  }
  register(form : any):any{
    if(this.userr.password === this.password){
      this.service.registerCust(this.userr).subscribe((result:any)=>{console.log(result)});
      alert('registerd successfully');
    }
    else{
      alert("password doesn't match");
    }

  }
}
