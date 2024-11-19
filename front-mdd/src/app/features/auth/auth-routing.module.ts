import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ProfileComponent } from './components/profile/profile.component';
import { AuthGuard } from '../../guards/auth.guard';


const routes: Routes = [
  { title: 'Login', path: 'login', component: LoginComponent },
  { title: 'Register', path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent,canActivate: [AuthGuard]},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
