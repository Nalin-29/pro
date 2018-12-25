import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import * as jsPDF from 'jspdf'
import { ReportserviceService } from '../reportservice.service';
import { UserserviceService } from '../userservice.service';
import { MovieUserView } from '../movie-user-view';
import { MovieserviceService } from '../movieservice.service';

@Component({
  selector: 'app-weekly-user-report',
  templateUrl: './weekly-user-report.component.html',
  styleUrls: ['./weekly-user-report.component.css']
})
export class WeeklyUserReportComponent implements OnInit {

  displayedColumns: string[] = ['movieId','movieName','userName', 'gender','age','pincode'];
  dataSource : MovieUserView[];
  movieUserView : MovieUserView[];
  constructor(private service : ReportserviceService, 
    private userService: UserserviceService,
    private movieService: MovieserviceService) { }

  ngOnInit() {
    this.service.getCity().subscribe(data=>{
      console.log(data);
    })
    this.service.getMovieUserView().subscribe(data=>{
      this.movieUserView = data;
      this.getOtherDetails();
      this.dataSource = this.movieUserView;
      console.log(this.dataSource);
    })
  }
  getOtherDetails(){
    for(let i = 0 ;i<this.movieUserView.length;i++){
      this.movieService.getMovieById(this.movieUserView[i].movieId).subscribe(data=>{
        this.movieUserView[i].movieName = data.movieName;
      })
      this.userService.getUserDetails(this.movieUserView[i].userId).subscribe(data=>{
        this.movieUserView[i].userName = data.firstName;
        this.movieUserView[i].dateOfBirth = data.dateOfBirth;
        this.movieUserView[i].gender = data.gender;
        this.movieUserView[i].pincode = data.pincode;
      })
   }
  }
  exportAsXLSX():void {
    this.service.exportAsExcelFile(this.movieUserView,'name');
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
        title: 'Result PDF',
        subject: 'Generated Weekly Report',
        author: 'IAmAlmersto',
        keywords: 'Movie Application',
        creator: 'Vibhanshu'
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
