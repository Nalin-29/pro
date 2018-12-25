import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import { AdminserviceService } from '../adminservice.service';
import { Movie } from '../movie';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  movie : Movie[];
  oneMovie = new Movie();
  editMyMovie = new Movie();
  displayedColumns: string[] = ['movieId', 'movieName','movieDescription','view','edit','delete'];
  dataSource = new MatTableDataSource<Movie>(this.movie);
  @ViewChild(MatPaginator) paginator: MatPaginator;
  constructor(private service: AdminserviceService, private router: Router){
    if (localStorage.getItem('userType')!='admin') {
        this.router.navigate(['/welcome']);
    }
    this.getAllMovie();
  }
  ngOnInit() {
    this.dataSource.paginator = this.paginator;
  }
  getAllMovie(){
    this.dataSource.paginator = this.paginator;
    this.service.getAllMovie().subscribe(data =>{
      this.movie = data;
      this.updateDataSource();
      console.log(this.movie);
    });
  }
  updateDataSource(){
    this.dataSource = new MatTableDataSource<Movie>(this.movie);
  }
  deleteMovie(movieId){
    let really = confirm('Do You Really Want To Delete ?');
    if(really == true){
      this.service.deleteMovie(movieId).subscribe(data=>{
        if(data === 1){
          this.getAllMovie();
        }
      })
    }
  }
  viewOneMovie(viewMovie){
    this.oneMovie = viewMovie;
  }
  editOneMovie(editMovie){
    this.editMyMovie = editMovie;
    console.log(this.editMyMovie);
  }
  logout(){
    localStorage.removeItem('userId');
    localStorage.removeItem('userType');
    this.router.navigate(['/login']);
  }
}

