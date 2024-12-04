import { Component, OnInit } from '@angular/core';
import { Post } from '../../interfaces/post.interface';
import { PostService } from '../../services/post.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-list',

  templateUrl: './post-list.component.html',
  styleUrl: './post-list.component.css'
})
export class PostListComponent implements OnInit{
  posts:Post[] =[];
  errorMessage: string = '';

  constructor(private postService: PostService, private router:Router) {}

  ngOnInit(): void {
this.getPosts();
}

  // Récupérer les topics
  getPosts(): void {
  
      this.postService.getPosts().subscribe({
        next: (posts) => (this.posts = posts),
        error: (err) => (this.errorMessage = 'Erreur lors du chargement des posts.'),
      });
   
  }


}
