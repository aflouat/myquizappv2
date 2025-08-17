import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment';
import { HttpHeadersService } from '../../../shared/services/http.headers.service';
import { Topic } from '../../topic/interfaces/topic.interface';
import { Quiz } from '../interfaces/quiz.interface';
@Injectable({
  providedIn: 'root'
})

export class QuizService {
  private baseUrl = environment.baseUrl;

  private pathModule = `${this.baseUrl}/quiz`;
  constructor(private httpClient: HttpClient, private httpHeadersService: HttpHeadersService) { }

  getQuizById(id: number): Observable<Quiz> {
    return this.httpClient.get<Quiz>(`${this.pathModule}/${id}`, { headers: this.httpHeadersService.getHeaders() });
  }

  // Liste des quiz (GET)
  getQuiz(): Observable<Quiz[]> {
    return this.httpClient.get<Quiz[]>(this.pathModule, { headers: this.httpHeadersService.getHeaders() });


  }


}
