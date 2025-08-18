import { Component, OnInit } from '@angular/core';
import { QuizService } from '../../services/quiz.service';
import { ScoreService } from '../../services/score.service';

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
  isCorrect: boolean = false;
  score: number = 0;
  isFinished: boolean = false;


  constructor(private quizService: QuizService, private scoreService: ScoreService) { }

  ngOnInit() {
    this.quizService.getQuizById(this.id).subscribe(data => {
      this.quiz = data;
    });
    this.score = this.scoreService.getScore(); // 🔥 Initialisation du score

  }

  checkAnswer(question: any, answerId: number) {
    this.isCorrect = question.correctAnswerId === answerId;

    if (this.isCorrect) {
      // alert('Bonne réponse 🎉');
      this.scoreService.incrementScore(); // 🔥 Incrémentation du score
      this.score = this.scoreService.getScore(); // 🔥 Mise à jour du score
    } else {
      //alert('Mauvaise réponse ❌');
    }

    this.answerStates[answerId] = this.isCorrect;
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
    this.isFinished = true;
  }
}
