import { Component, OnInit } from '@angular/core';
import { Movie } from '../movie';
import { MovieserviceService } from '../movieservice.service';
import * as $ from 'jquery';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  title: string;
  movie : Movie[];
  constructor(private service : MovieserviceService,private router : Router) { 
    if (!localStorage.getItem('userId')) {
        this.router.navigate(['/login']);
     }
  }

  ngOnInit() {
    $(document).ready(function(){
      $('a[href="home#search"]').on('click', function(event) {
        
        $('#search').addClass('open');
        $('#search > form > input[type="search"]').focus();
      });
      $('#search, #search button.close').on('click keyup', function(event) {
        if (event.target == this || event.target.className === 'close' || event.keyCode == 27) {
          $(this).removeClass('open');
        }
      });
    });
  }
  openNav() {
    document.getElementById('mySidenav').style.width = '250px';
    return true;
}
closeNav() {
    document.getElementById('mySidenav').style.width = '0';
    return true;
}


  searchMovie(){
    this.service.requestMovieList(this.title).subscribe(data=>{
    this.movie = data;
    this.movie = this.movie.slice(0,8);
    this.saveSearchHistory();
    });
    this.closeNav();
  }
  saveSearchHistory(){
    let count  = 0;
    this.movie.forEach(m =>{
      if(count<=2){
        count++;
        this.service.addSearch(m).subscribe(data=>{
          console.log(m);
        })
      }
    })
  }
addToPlayList(){
  
}
  logout(){
    localStorage.removeItem('userId');
    localStorage.removeItem('userType');
    this.router.navigate(['/login']);
  }
}
