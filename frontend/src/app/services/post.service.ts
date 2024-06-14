import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "../environment/environment";
import { Post, PostCreateInput } from "../data/post";
import { AbstractService } from "./abstract.service";

@Injectable()
export class PostService extends AbstractService<Post, PostCreateInput> {
  protected baseUrl = `${environment.apiUrl}api/posts`;

  constructor(protected override http: HttpClient) {
    super(http);
  }
}
