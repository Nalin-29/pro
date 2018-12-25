import {SelectionModel} from '@angular/cdk/collections';
import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource, MatPaginator} from '@angular/material';
import { Movie } from '../movie';
import { Hist } from '../history';
import { MovieserviceService } from '../movieservice.service';


@Component({
  selector: 'app-search-history',
  templateUrl: './search-history.component.html',
  styleUrls: ['./search-history.component.css']
})
export class SearchHistoryComponent implements OnInit {
  displayedColumns: string[] = ['select', 'position', 'name', 'weight', 'symbol'];
  todayMovie: Hist[];
  otherMovie: Hist[];
  dataSource = new MatTableDataSource<Hist>(this.todayMovie);
  dataSource1 = new MatTableDataSource<Hist>(this.otherMovie);
  selection = new SelectionModel<Hist>(true, []);
  selection1 = new SelectionModel<Hist>(true, []);
  movie: Movie;
  constructor(private service: MovieserviceService) { }

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatPaginator) paginator1: MatPaginator;

  ngOnInit() {
    this.getTodayHistory();
    this.getAllHistory();
    this.dataSource.paginator = this.paginator;
  }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  masterToggle() {
    this.isAllSelected() ?
        this.selection.clear() :
        this.dataSource.data.forEach(row => this.selection.select(row));
  }
  fn(){
    alert('called');
    console.log(this.selection.selected.length);
  }
  getTodayHistory(){
    this.service.getMySearchHistoryOfToday().subscribe(data=>{
      this.todayMovie = data;
      this.dataSource1 = new MatTableDataSource<Hist>(this.todayMovie);
    })
  }

  getAllHistory(){
    this.service.getMySearchHistory().subscribe(data=>{
      this.otherMovie = data;
      this.dataSource = new MatTableDataSource<Hist>(this.otherMovie);
    })
  }

  getMovieName(movieId){
    return 'Movie Name';
    // this.service.getMovieById(movieId).subscribe(data=>{
    //   return data.movieName;
    // })
  }
  clearOneHistory(searchObj){
    this.service.clearOneHistory(searchObj.searchId).subscribe(data=>{
      this.getTodayHistory();
    })
  }
  clearSelectedHistory(){
    // console.log(this.selection.selected);
    // console.log(this.selection.selected.length);
    for(let id = 0;id<this.selection.selected.length;id++){
      this.service.clearOneHistory(this.selection.selected[id].searchId).subscribe(data=>{
        console.log("Deleted" + this.selection.selected[id].searchId);
      })
    }
    this.getTodayHistory(); 
    this.getAllHistory();
  }
}
