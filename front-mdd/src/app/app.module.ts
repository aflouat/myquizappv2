import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import {  RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import {  provideHttpClient } from '@angular/common/http';
import { HeaderComponent } from './shared/components/header/header.component';


@NgModule({
  declarations: [AppComponent,HeaderComponent],
  imports: [BrowserModule, ReactiveFormsModule,RouterModule,CommonModule,AppRoutingModule,
    ],
  bootstrap: [AppComponent],
  providers:[provideHttpClient()]
})
export class AppModule {}


