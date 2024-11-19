import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './shared/components/home/home.component';
import { LoginComponent } from './features/auth/components/login/login.component';
import { TopicsComponent } from './features/topic/components/topics/topics.component';
import { RegisterComponent } from './features/auth/components/register/register.component';
import { NgModule } from '@angular/core';

export const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' }, // Route par défaut
    { path: 'home', component: HomeComponent },
    {path:'login',component:LoginComponent},
    {path:'register', component:RegisterComponent},
    {path:'topics',component:TopicsComponent}


];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
  })
  export class AppRoutingModule {}