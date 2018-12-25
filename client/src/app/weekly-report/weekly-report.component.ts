import { Component, OnInit } from '@angular/core';
import { ReportserviceService } from '../reportservice.service';
import * as $ from 'jquery';
import * as jsPDF from 'jspdf'
import { MovieView } from '../movie-view';
import { MovieserviceService } from '../movieservice.service';


@Component({
  selector: 'app-weekly-report',
  templateUrl: './weekly-report.component.html',
  styleUrls: ['./weekly-report.component.css']
})
export class WeeklyReportComponent implements OnInit {
  displayedColumns: string[] = ['movieId','movieName','movieReleaseYear', 'movieViews'];
  dataSource : MovieView[];
  movieView : MovieView[];
  constructor(private service : ReportserviceService,private movieService : MovieserviceService) { }

  ngOnInit() {

    this.service.getMovieView().subscribe(data=>{
      this.movieView= data;
      this.getMovieDetails();
      this.dataSource = this.movieView;
      console.log(this.dataSource);
    })
  }
  getMovieDetails(){
      for(let i = 0 ;i<this.movieView.length;i++){
         this.movieService.getMovieById(this.movieView[i].movieId).subscribe(data=>{
           this.movieView[i].movieName = data.movieName;
           this.movieView[i].movieReleaseDate = data.movieReleaseDate;
         })
      }
  }
  exportAsXLSX():void {
    this.service.exportAsExcelFile(this.movieView,'name');
    //this.service.exportAsExcelFile(ELEMENT_DATA, 'sample');
 }
 exportAsPDF():void{
   this.service.captureScreen();
 }

 fn(){
  alert("On Process");
  var table1 = this.tableToJson($('#contentToConvert').get(0)),
  cellWidth = 35,
  rowCount = 0,
  cellContents,
  leftMargin = 2,
  topMargin = 12,
  topMarginTable = 55,
  headerRowHeight = 13,
  rowHeight = 9,

   l = {
   orientation: 'l',
   unit: 'mm',
   format: 'a3',
   compress: true,
   fontSize: 8,
   lineHeight: 1,
   autoSize: false,
   printHeaders: true
  }

  var doc = new jsPDF(l, '', '', '');

    doc.setProperties({
        title: 'Test PDF Document',
        subject: 'This is the subject',
        author: 'author',
        keywords: 'generated, javascript, web 2.0, ajax',
        creator: 'author'
    });

    doc.cellInitialize();

   $.each(table1, function (i, row)
    {

        rowCount++;

        $.each(row, function (j, cellContent) {

            if (rowCount == 1) {
                doc.margins = 1;
                doc.setFont("helvetica");
                doc.setFontType("bold");
                doc.setFontSize(9);

                doc.cell(leftMargin, topMargin, cellWidth, headerRowHeight, cellContent, i)
            }
            else if (rowCount == 2) {
                doc.margins = 1;
                doc.setFont("times ");
                doc.setFontType("italic");  // or for normal font type use ------ doc.setFontType("normal");
                doc.setFontSize(8);                    

                doc.cell(leftMargin, topMargin, cellWidth, rowHeight, cellContent, i); 
            }
            else {

                doc.margins = 1;
                doc.setFont("courier ");
                doc.setFontType("bolditalic ");
                doc.setFontSize(6.5);                    

                doc.cell(leftMargin, topMargin, cellWidth, rowHeight, cellContent, i);  // 1st=left margin    2nd parameter=top margin,     3rd=row cell width      4th=Row height
            }
        })
    })

doc.save('sample Report.pdf');

}

  tableToJson(table) {
    var data = [];
    
    // first row needs to be headers
    var headers = [];
    for (var i=0; i<table.rows[0].cells.length; i++) {
        headers[i] = table.rows[0].cells[i].innerHTML.toLowerCase().replace(/ /gi,'');
    }
    
    // go through cells
    for (var i=1; i<table.rows.length; i++) {
    
        var tableRow = table.rows[i];
        var rowData = {};
    
        for (var j=0; j<tableRow.cells.length; j++) {
    
            rowData[ headers[j] ] = tableRow.cells[j].innerHTML;
    
        }
    
        data.push(rowData);
    }       
    
    return data; }
}

