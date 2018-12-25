import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { Movie } from '../movie';
import { MovieserviceService } from '../movieservice.service';

@Component({
  selector: 'app-home-navbar',
  templateUrl: './home-navbar.component.html',
  styleUrls: ['./home-navbar.component.css']
})
export class HomeNavbarComponent implements OnInit {
  title: string;
  movie : Movie[];
  constructor(private service : MovieserviceService) { }

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
  });
}
}
