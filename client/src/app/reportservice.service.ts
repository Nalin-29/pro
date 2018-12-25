import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClientModule,HttpClient } from '@angular/common/http';
import * as jspdf from 'jspdf';  
  
import html2canvas from 'html2canvas';  

import * as FileSaver from 'file-saver';
import * as XLSX from 'xlsx';
import { MovieView } from './movie-view';
import { MovieUserView } from './movie-user-view';

const EXCEL_TYPE = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8';

const EXCEL_EXTENSION = '.xlsx';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ReportserviceService {

  constructor(private http: HttpClient) { }
  private baseUrl1 = 'http://localhost:8765';

  public getCity(){
    return this.http.get('http://postalpincode.in/api/pincode/110001');
  }

  public getMovieView(){
    return this.http.get<MovieView[]>('http://localhost:8020/getViewsByMovie');
  }
  public getMovieUserView(){
    return this.http.get<MovieUserView[]>('http://localhost:8020/getUserViewMovie');
  }
  public captureScreen()  
  {  
    var data = document.getElementById('contentToConvert');  
    html2canvas(data).then(canvas => {  
      // Few necessary setting options  
      var imgWidth = 208;   
      var pageHeight = 295;    
      var imgHeight = canvas.height * imgWidth / canvas.width;  
      var heightLeft = imgHeight;  
  
      const contentDataURL = canvas.toDataURL('image/png')  
      let pdf = new jspdf('p', 'mm', 'a4'); // A4 size page of PDF  
      var position = 0;  
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight)  
      pdf.save('MYPdf.pdf'); // Generated PDF   
    });  
  }
  
  public exportAsExcelFile(json: any[], excelFileName: string): void {
    alert("Called");
    const worksheet: XLSX.WorkSheet = XLSX.utils.json_to_sheet(json);
    const workbook: XLSX.WorkBook = { Sheets: { 'data': worksheet }, SheetNames: ['data'] };
    const excelBuffer: any = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' });
    this.saveAsExcelFile(excelBuffer, excelFileName);
  }

  private saveAsExcelFile(buffer: any, fileName: string): void {
    const data: Blob = new Blob([buffer], {type: EXCEL_TYPE});
    FileSaver.saveAs(data, fileName + '_export_' + new  Date().getTime() + EXCEL_EXTENSION);
 }

}
