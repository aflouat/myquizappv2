import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { GameRoutingModule } from './game-routing.module';
import {QuizComponent} from './components/quiz/quiz.component';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {JwtInterceptor} from '../../interceptors/jwt.interceptor';
import {MatCardModule} from '@angular/material/card';
import {MatListModule} from '@angular/material/list';
import {MatButton} from '@angular/material/button';

@NgModule({
  declarations: [QuizComponent],
  imports: [ReactiveFormsModule, CommonModule, GameRoutingModule, MatCardModule, MatListModule, MatButton], // Ajout de CommonModule
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true,
    },
  ],
})
export class GameModule {}
