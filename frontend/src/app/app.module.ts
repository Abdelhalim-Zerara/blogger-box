import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {NavBarComponent} from './nav-bar/nav-bar.component';
import { HttpClientModule } from '@angular/common/http';
import { PostService } from './services/post.service';
import { PostListComponent } from './post-list/post-list.component';
import { PostCardComponent } from './post-card/post-card.component';
import { AddPostFormComponent } from './add-post-form/add-post-form.component';
import {ReactiveFormsModule} from "@angular/forms";
import { CategoryService } from './services/category.service';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    PostListComponent,
    PostCardComponent,
    AddPostFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [
    PostService,
    CategoryService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }