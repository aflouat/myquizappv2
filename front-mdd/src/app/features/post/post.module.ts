import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostListComponent } from './components/post-list/post-list.component';
import { PostRoutingModule } from './post-routing.module';
import { PostDetailComponent } from './components/post-detail/post-detail.component';
import { PostCreateComponent } from './components/post-create/post-create.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { MatGridListModule} from '@angular/material/grid-list'
import { CommentListComponent } from './components/comment-list/comment-list.component';



@NgModule({
  declarations: [PostListComponent,PostDetailComponent,PostCreateComponent,CommentListComponent],
  imports: [
    PostRoutingModule,CommonModule,SharedModule,MatGridListModule
  ],
  exports:[]
})
export class PostModule { }
