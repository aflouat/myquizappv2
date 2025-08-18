import { Component, OnInit } from '@angular/core';
import { QuizService } from '../../services/quiz.service';

@Component({
  selector: 'app-quiz',
  standalone: false,
  templateUrl: './quiz.component.html',
})
export class QuizComponent implements OnInit {
  quiz: any;
  id = 1;
  player = 'Omar';
  currentQuestionIndex: number = 0;
  answerStates: { [answerId: number]: boolean } = {};
  hasAnswered: boolean = false;
  score: number = 0; // 🔥 Nouveau : score du joueur

  constructor(private quizService: QuizService) {}

  ngOnInit() {
    this.quizService.getQuizById(this.id).subscribe(data => {
      this.quiz = data;
    });
  }

  checkAnswer(question: any, answerId: number) {
    const isCorrect = question.correctAnswerId === answerId;

    if (isCorrect) {
      alert('Bonne réponse 🎉');
      this.score += 10; // 🔥 Incrémentation du score
    } else {
      alert('Mauvaise réponse ❌');
    }

    this.answerStates[answerId] = isCorrect;
    this.hasAnswered = true;
    this.answerStates = { ...this.answerStates }; // Forcer la mise à jour
  }

  nextQuestion() {
    if (this.currentQuestionIndex < this.quiz.questions.length - 1) {
      this.currentQuestionIndex++;
      this.answerStates = {};
      this.hasAnswered = false;
    }
  }

  previousQuestion() {
    if (this.currentQuestionIndex > 0) {
      this.currentQuestionIndex--;
      this.answerStates = {};
    }
  }

  finishQuiz() {
    alert(`Quiz terminé ! 🎯 Score final : ${this.score}`);
    // Réinitialisations
    this.currentQuestionIndex = 0;
    this.answerStates = {};
    this.quiz = null;
    this.score = 0; // 🔥 Reset du score
  }
}
