import { Component, OnInit } from '@angular/core';
import { QuizService } from '../../services/quiz.service';

@Component({
  selector: 'app-quiz',
    standalone: false,
  templateUrl: './quiz.component.html',
})
export class QuizComponent implements OnInit {
  quiz: any;
  id = 1
  player = 'Omar';

  constructor(private quizService: QuizService) {}

  ngOnInit() {
    this.quizService.getQuizById(this.id).subscribe(data => {
      this.quiz = data;
    });
  }

  checkAnswer(question: any, answerId: number) {
    if (answerId === question.correctAnswerId) {
      alert('Bonne réponse 🎉');
    } else {
      alert('Mauvaise réponse ❌');
    }
  }
}
