import { Component, OnInit } from '@angular/core';
import { MovieserviceService } from '../movieservice.service';
import { Favourites } from '../favourites';
import { Router } from '@angular/router';

@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.css']
})
export class FavouritesComponent implements OnInit {
  data = ["1","2","3","4","5","6","7","8"];
  fav: Favourites[];
  constructor(private service : MovieserviceService,private router: Router) { 
  }

  ngOnInit() {
    this.getAllFav();
  }
  
  getAllFav(){
    this.service.getFavList().subscribe(data=>{
      this.fav = data;
      console.log("Vib" + this.fav);
      this.filterFav();
    })
  }
   filterFav(){
     this.fav = this.fav;
   }
   deleteFav(favr){
     this.service.requestFavouriteDelete(favr).subscribe(data=>{
       if(data==1){
         this.getAllFav();
       }
     })
   }
}
