import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../movie';
import { MovieserviceService } from '../movieservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-play-item-list',
  templateUrl: './play-item-list.component.html',
  styleUrls: ['./play-item-list.component.css']
})
export class PlayItemListComponent implements OnInit {

  constructor(private service : MovieserviceService,private router: Router) { }

@Input() movieList:Movie [];

  ngOnInit() {
  }
  isNotNull(movieArr){
    if(movieArr.length>0){
      return true;
    }
    return false;
  }
  removePlayListItem(playmovie){
    this.service.deleteToMyPlayListItems(playmovie.playListItemId).subscribe(data=>{
      if(data==1){
        this.router.navigate['/playlist'];
      }
    })
  }
}
