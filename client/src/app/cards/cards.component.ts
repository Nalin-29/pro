import { Component, OnInit, Input } from '@angular/core';
import * as $ from 'jquery';
import { Movie } from '../movie';
import { MovieserviceService } from '../movieservice.service';
import { Playlist } from '../playlist';
import { Playlistitem } from '../playlistitem';


@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent implements OnInit {
     
  myStyle: object = {};
  myParams: object = {};
  width:  100;
  height:  100;
  myPlayList : Playlist[];
  selectedPlayListId:number;
  myplayListItemsObj = new Playlistitem();

  @Input() resultMovie : Movie;
  constructor(private service: MovieserviceService) { 
    $('.flip').hover(function() {
      $(this).find('.card').toggleClass('flipped');

});
}

  ngOnInit() {

    this.service.getPlayList().subscribe(data=>{
      this.myPlayList = data;
    })
    this.myStyle = {
      'position': 'fixed',
      'width': '100%',
      'height': '100%',
      'z-index': -1,
      'top': 0,
      'left': 0,
      'right': 0,
      'bottom': 0,
  };
        this.myParams = {
          particles: {
              number: {
                  value: 200,
              },
              color: {
                  value: '#ff0000'
              },
              shape: {
                  type: 'triangle',
              },

      }
      };
  }
  addToFav(movie){
    this.service.addfavMovie(movie).subscribe(data=>{
      alert('Added');
    })
  }
  addPlayList(){
    console.log(this.resultMovie);
    this.myplayListItemsObj.movieId = this.resultMovie.movieId;
    this.myplayListItemsObj.playListId = this.selectedPlayListId;
    this.service.addToMyPlayListItems(this.myplayListItemsObj).subscribe(data=>{
      console.log(data);
    })
  }
}
