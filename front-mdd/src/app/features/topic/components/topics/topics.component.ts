import { Component, Input, OnInit } from '@angular/core';
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
  @Input() showSubscribedOnly: boolean = false; // Détermine le type de topics à afficher


  constructor(private topicService: TopicService, private fb: FormBuilder) {
 
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
    if (this.showSubscribedOnly) {
      this.topicService.getSubscribedTopics().subscribe({
        next: (topics) => (this.topics = topics),
        error: (err) => (this.errorMessage = 'Erreur lors du chargement des topics.'),
      });
    } else {
      this.topicService.getTopics().subscribe({
        next: (topics) => (this.topics = topics),
        error: (err) => (this.errorMessage = 'Erreur lors du chargement des topics.'),
      });
    }
  }

subscribe(idTopic: number): void {

  this.topicService.subscribeUserToTopic(idTopic).subscribe({
    next: () => {
      // Mettez à jour l'état local
      const topic = this.topics.find(t => t.id === idTopic);
      if (topic) {
        topic.userSubscribed = true; // Marque le topic comme abonné
      }
      ;
    },
    error: (err) => {
      console.error('Erreur lors de l\'abonnement :', err);
      alert(`Erreur : ${err.status} - ${err.message}`);
    },

  });

}
}
