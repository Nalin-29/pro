import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $(function() {
      const text = $('.text');
      $(window).scroll(function() {
        const scroll = $(window).scrollTop();
        if (scroll >= 200) {
          text.removeClass('hidden');
        } else {
          text.addClass('hidden');
        }
      });
    });
    
  }

}
