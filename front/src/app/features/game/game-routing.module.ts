import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuizComponent } from './components/quiz/quiz.component';
import { QuizListComponent } from './quiz-list/quiz-list.component';



const routes: Routes = [
  { title: 'quiz-detail', path: 'quiz/:id', component: QuizComponent },
  { title: 'quiz-list', path: 'quiz', component: QuizListComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GameRoutingModule { }
