import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from '../../services/session.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit{
  showRightMenu:boolean =false;
  private subscription: Subscription = new Subscription();

  constructor(    private sessionService: SessionService  ){}
  ngOnInit(): void {
    this.subscription = this.sessionService.$isLogged().subscribe((isLogged) => {
      this.showRightMenu = isLogged;
    });
 
  }



}
