import { Component, OnInit } from '@angular/core';
import { TopicService } from '../../services/topic.service';
import { Topic } from '../../interfaces/topic.interface';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule, NgFor } from '@angular/common';


@Component({
  selector: 'app-topics',
  templateUrl: './topics.component.html',
  styleUrl: './topics.component.css'
})
export class TopicsComponent implements OnInit {
  topics: Topic[] = []; // Liste des topics
  form: FormGroup; // Formulaire pour créer un topic
  errorMessage: string = '';

  constructor(private topicService: TopicService, private fb: FormBuilder) {
    this.getTopics();

    // Initialisation du formulaire
    this.form = this.fb.group({
      subject: ['', Validators.required],
      description: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.getTopics();
  }

  // Récupérer les topics
  getTopics(): void {
    console.log('list topics call.....')
    this.topicService.getTopics().subscribe({
      next: (topics) => (this.topics = topics),
      error: (err) => (this.errorMessage = 'Erreur lors du chargement des topics.'),
    });
  }

  // Créer un topic
  createTopic(): void {
    if (this.form.valid) {
      const newTopic: Topic = this.form.value;
      this.topicService.createTopic(newTopic).subscribe({
        next: (topic) => {
          this.topics.push(topic); // Ajouter le nouveau topic à la liste
          this.form.reset(); // Réinitialiser le formulaire
        },
        error: (err) => (this.errorMessage = 'Erreur lors de la création du topic.'),
      });
    }
  }
}
