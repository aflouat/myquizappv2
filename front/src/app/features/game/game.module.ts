import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { GameRoutingModule } from './game-routing.module';
import {QuizComponent} from './components/quiz/quiz.component';

@NgModule({
  declarations: [QuizComponent],
  imports: [ReactiveFormsModule,CommonModule,GameRoutingModule], // Ajout de CommonModule
  exports: [QuizComponent],
})
export class GameModule {}
