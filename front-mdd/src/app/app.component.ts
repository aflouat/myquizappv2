import { Component } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';


@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    standalone: false
})
export class AppComponent {
  title = 'front-mdd';
  showHeader:boolean =true;
  constructor(private router:Router){
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        // Masquer le header uniquement pour la route '/home'
        this.showHeader = event.url !== '/';
      } 
    });
  }
}
