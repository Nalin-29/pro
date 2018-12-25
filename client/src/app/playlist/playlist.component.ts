import { Component, OnInit } from '@angular/core';
import { Playlist } from '../playlist';
import { Movie } from '../movie';
import { MovieserviceService } from '../movieservice.service';
import { validateConfig } from '@angular/router/src/config';
import { Playlistitem } from '../playlistitem';
import { ItemObject } from '../item-object';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {

  constructor(private service:MovieserviceService) { }

playlist:Playlist[];
playmovie = [];
item:Playlistitem[];
play:Playlist=new Playlist();
playListName:String;
showMe = false;
flag = 0;
playBean : ItemObject;



  ngOnInit() {
    this.getPlayList();
  }

  addPlayList(){
    this.service.addPlayList(this.playListName).subscribe(data=>{
      this.getPlayList();
    })

  }
  getMovies(playlist,i){
   this.showMe = true;
   this.flag = i;
   this.service.getMyPlayListItems(playlist.playListId).subscribe(data=>{
     this.item = data;
     this.setMovies();
   })
  }
setMovies(){
  var i;
  this.playmovie = [];
  console.log(this.item);
    for(i=0;i<this.item.length;i++){
      let playBean  = new ItemObject;
      playBean.playListItemId = this.item[i].playListItemId;
      this.service.getMovieById(this.item[i].movieId).subscribe(data=>{
         playBean.movieId = data.movieId;
         playBean.movieName = data.movieName;
         playBean.movieDescription = data.movieDescription;
         this.playmovie.push(playBean);
      });
    }
    console.log(this.playmovie);
}
deletePlayList(list){
  console.log(list);
  let is = confirm("Do You Want to delete this play list ?");
  if(is==true){
    this.service.deleteToMyPlayList(list.playListId).subscribe(data=>{
      if(data==1){ 
        this.getPlayList();
      }
    })
  }
}

getPlayList(){
  this.service.getPlayList().subscribe(data=>{
    this.playlist = data;
  }) 
}

  // playlisting(){
  //   this.service.requestPlayList("1").subscribe(data=>{
  //     console.log("Vibhanshu");
  //       this.playlist=data;
  //   },
  //   error=>{
  //     console.log("Error" + error);
  //   });
  // }

  // movieListing(playmovieId){
  //   this.service.requestPlayMovieId(playmovieId).subscribe(data=>{
  //       this.item=data;
  //   });

  //   var i;
  //   for(i=0;i<this.item.length;i++){
  //     this.service.getMovieById(this.item[i].movieId).subscribe(data=>{
  //         this.playmovie[i]=data;
  //     });
  //   }
  // }

  // deletingPlayId(playId){
  //   this.service.requestDeletePlayList(playId).subscribe(data=>{
  //       if(data!=null){
  //         alert("deleted!");
  //       }
  //   });
  // }

  // deletingMovie(playitemid){
  //   this.service.requestDeleteMovieById(playitemid).subscribe(data=>{
  //     if(data!=null){
  //       alert("deleted!");
  //     }
  //   });
  // }

  // addPlayList(){

  //   this.service.requestAddPlayList(this.playListName).subscribe(data=>{
  //       alert("success");
  //  });
  // }

  // addPlayItem(){
  //   //this.service.requestAddPlayList().subscribe(data=>{

  // //  });
  // }

}
