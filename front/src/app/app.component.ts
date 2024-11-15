import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  showHeader: boolean = true;

  title = 'MDD';
  constructor(private router: Router) {
    // Abonnez-vous aux changements de route
    this.router.events.subscribe(() => {
      // Vérifiez si la route correspond à votre page landing
      this.showHeader = !this.router.url.includes('/home');
    });
  }
}
