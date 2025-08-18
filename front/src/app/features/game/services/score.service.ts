import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ScoreService {
  private score = 0;

  constructor() {
    const score = localStorage.getItem('score');
    if (score) {
      this.score = parseInt(score, 0);
    }
  }



  resetScore() {
    this.score = 0;
  }

  addPoints(points: number) {
    this.score += points;
  }

  getScore(): number {
    return this.score;
  }
  //save score to localStorage
  saveScore(score: string): void {
    localStorage.setItem('score', score);
  }
  //load score from localStorage
  loadScore(): void {
    const score = localStorage.getItem('score');
    if (score) {
      this.score = parseInt(score, 0);
    }
  }

  //clear score from localStorage
  clearScore(): void {
    localStorage.removeItem('score');
  }
  //increment score by 10
  incrementScore(): void {
    this.addPoints(10);
  }

}
