import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../../app-routing.module';
import { AuthRoutingModule } from './auth-routing.module';


@NgModule({
  declarations: [
    RegisterComponent,
    LoginComponent,
    ProfileComponent
  ],
  imports: [
    ReactiveFormsModule,CommonModule,AuthRoutingModule
  ],
})
export class AuthModule { }
import { AbstractControl, ValidationErrors } from '@angular/forms';
import { ProfileComponent } from './components/profile/profile.component';

export function passwordValidator(control: AbstractControl): ValidationErrors | null {
  const password = control.value;

  if (!password) {
    return { required: true };
  }

  // Vérifie si le mot de passe respecte les conditions
  const hasMinLength = password.length >= 8;
  const hasUpperCase = /[A-Z]/.test(password);
  const hasLowerCase = /[a-z]/.test(password);
  const hasNumber = /\d/.test(password);
  const hasSpecialChar = /[\W_]/.test(password);

  const isValid = hasMinLength && hasUpperCase && hasLowerCase && hasNumber && hasSpecialChar;

  return isValid
    ? null
    : {
        passwordStrength: {
          hasMinLength,
          hasUpperCase,
          hasLowerCase,
          hasNumber,
          hasSpecialChar,
        },
      };
}
