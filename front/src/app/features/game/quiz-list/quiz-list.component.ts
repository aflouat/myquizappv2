import { Component, OnInit } from '@angular/core';
import { QuizService } from 'src/app/features/game/services/quiz.service';
import { Quiz } from '../interfaces/quiz.interface';


@Component({
  selector: 'app-quiz-list',
  templateUrl: './quiz-list.component.html',
  styleUrl: './quiz-list.component.scss',
  standalone: false
})
export class QuizListComponent {
  quizList: Quiz[] = [];

  constructor(private quizService: QuizService) {}

  ngOnInit() {
    this.quizService.getQuiz().subscribe(data => {
      // get quiz list from the service
      this.quizList = data;

    });
    console.log("Liste des quiz : "+this.quizList);
  }
}

