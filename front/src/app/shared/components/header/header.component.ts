import { Component, HostListener, OnInit } from '@angular/core';
import { SessionService } from '../../services/session.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
  standalone: false
})
export class HeaderComponent implements OnInit {
  showRightMenu: boolean = false;
  private subscription: Subscription = new Subscription();
  isMobile: boolean = false;
  score!: number; // Initialisation du score

  constructor(private sessionService: SessionService) { }


  ngOnInit(): void {
    this.subscription = this.sessionService.$isLogged().subscribe({
      next: (isLogged) => (this.showRightMenu = isLogged),
    });

    this.checkScreenSize();

    this.score = localStorage.getItem('score') ? parseInt(localStorage.getItem('score')!, 10) : 0;
    console.log('Score recupéré :', this.score);
    // Utilisez la valeur du score ici

  }

  // Écoute les changements de taille d'écran
  @HostListener('window:resize', [])
  onResize() {
    this.checkScreenSize();
  }

  // Détermine si l'écran est de type mobile
  private checkScreenSize() {
    this.isMobile = window.innerWidth <= 768; // Par exemple, 768px est la largeur max pour mobile
  }
}