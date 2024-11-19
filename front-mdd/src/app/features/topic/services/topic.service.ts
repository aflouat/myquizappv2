import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Topic } from '../interfaces/topic.interface';

@Injectable({
  providedIn: 'root',
})
export class TopicService {
  private apiUrl = 'http://localhost:3001/api/topic'; // URL de l'API backend

  constructor(private http: HttpClient) {}

  // Obtenir le token Bearer
  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('token'); // Remplacez par la méthode d'accès au token
    return new HttpHeaders({
      Authorization: `Bearer ${token}`,
      'Content-Type': 'application/json',
    });
  }

  // Liste des topics (GET)
  getTopics(): Observable<Topic[]> {
    return this.http.get<Topic[]>(this.apiUrl, { headers: this.getHeaders() });
  }

  // Création d'un topic (POST)
  createTopic(topic: Topic): Observable<Topic> {
    return this.http.post<Topic>(this.apiUrl, topic, { headers: this.getHeaders() });
  }
}
