import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostListComponent } from './components/post-list/post-list.component';
import { PostRoutingModule } from './post-routing.module';
import { PostDetailComponent } from './components/post-detail/post-detail.component';



@NgModule({
  declarations: [PostListComponent,PostDetailComponent],
  imports: [
    PostRoutingModule,CommonModule
  ],
  exports:[]
})
export class PostModule { }
