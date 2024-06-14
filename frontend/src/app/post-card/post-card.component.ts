import { Component,Input } from "@angular/core";
import { Post } from "../data/post";

@Component({
  selector: 'app-post-card',
  templateUrl: './post-card.component.html',
  styleUrls: ['./post-card.component.css']
})

export class PostCardComponent{
  @Input()
  post!: Post;
}