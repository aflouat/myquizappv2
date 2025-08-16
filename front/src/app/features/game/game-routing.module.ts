import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {QuizComponent} from './components/quiz/quiz.component';



const routes: Routes = [
  { title: 'game', path: 'game', component: QuizComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GameRoutingModule { }
