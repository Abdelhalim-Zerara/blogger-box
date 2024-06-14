import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "../environment/environment";
import { Category, CategoryCreateInput, CategoryCreateInputWithIsActive } from "../data/category";
import { AbstractService } from "./abstract.service";
import { Observable} from "rxjs";


@Injectable()
export class CategoryService extends AbstractService<Category, CategoryCreateInput> {
  protected baseUrl = `${environment.apiUrl}api/categories`;

  constructor(protected override http: HttpClient) {
    super(http);
  }

  createWithIsActive(item: CategoryCreateInputWithIsActive): Observable<Category> {
    return this.http.post<Category>(this.baseUrl, item);
  }
}

