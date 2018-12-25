import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-movie-header',
  templateUrl: './movie-header.component.html',
  styleUrls: ['./movie-header.component.css']
})
export class MovieHeaderComponent implements OnInit {

  constructor(private router: Router) {
    if (localStorage.getItem('userId')) {
      if(localStorage.getItem('userType')==='admin'){
        this.router.navigate(['/adminhome']);
      }
      else if(localStorage.getItem('userType')=='user'){
        this.router.navigate(['/home']);
      }
     }
   }

  ngOnInit() {
  }
  openNav() {
    document.getElementById('mySidenav').style.width = '250px';
    return true;
}
closeNav() {
    document.getElementById('mySidenav').style.width = '0';
    return true;
}

}
