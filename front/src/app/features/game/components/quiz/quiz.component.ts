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
  currentQuestionIndex: number = 0;
  answerStates: { [answerId: number]: boolean } = {};

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

  nextQuestion() {
    if (this.currentQuestionIndex < this.quiz.questions.length - 1) {
      this.currentQuestionIndex++;
      this.answerStates = {}; // Réinitialiser les états pour la nouvelle question
    }
  }
  previousQuestion() {
    if (this.currentQuestionIndex > 0) {
      this.currentQuestionIndex--;
      this.answerStates = {}; // Réinitialiser les états pour la nouvelle question
    }
  }
  finishQuiz() {
    alert('Quiz terminé ! Merci d\'avoir joué.');
    // Logique pour terminer le quiz, par exemple, rediriger vers une autre page ou afficher un score
    this.currentQuestionIndex = 0; // Réinitialiser l'index de la question
    this.answerStates = {}; // Réinitialiser les états des réponses
    this.quiz = null; // Réinitialiser le quiz

    }

}
