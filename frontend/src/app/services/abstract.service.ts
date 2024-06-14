import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, catchError, of } from "rxjs";

@Injectable()
export abstract class AbstractService<T, TCreateInput> {
  protected abstract baseUrl: string;

  constructor(protected http: HttpClient) {}

  getAll(): Observable<T[]> {
    return this.http.get<T[]>(this.baseUrl).pipe(catchError(this.handleError<T[]>('getAll')));
  }

  create(item: TCreateInput): Observable<T> {
    return this.http.post<T>(this.baseUrl, item);
  }

  update(item: T): Observable<T> {
    return this.http.put<T>(`${this.baseUrl}/${(item as any).id}`, item).pipe(
      catchError(this.handleError<T>('update', item))
    );
  }

  delete(item: T): Observable<boolean> {
    return this.http.delete<boolean>(`${this.baseUrl}/${(item as any).id}`);
  }

  protected handleError<U>(operation = 'operation', result?: U) {
    return (error: any): Observable<U> => {
      console.error(`${operation} failed: ${error.message}`, error);
      return of(result as U);
    };
  }
}
