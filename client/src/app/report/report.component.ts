import { Component, OnInit } from '@angular/core';
import * as jspdf from 'jspdf';  
  
import html2canvas from 'html2canvas';  

import { Injectable } from '@angular/core';
import * as FileSaver from 'file-saver';
import * as XLSX from 'xlsx';

const EXCEL_TYPE = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8';

const EXCEL_EXTENSION = '.xlsx';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  arr = ["1","2","3","4","5","6","7"];
  data: any = [{
    eid: 'e101',
    ename: 'ravi',
    esal: 1000
    },{
    eid: 'e102',
    ename: 'ram',
    esal: 2000
    },{
    eid: 'e103',
    ename: 'rajesh',
    esal: 3000
    }];
  constructor() { }

  ngOnInit() {
  }
  exportAsXLSX():void {
    //this.exportAsExcelFile(this.data, 'sample');
 }

  
}
